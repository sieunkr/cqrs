package com.example.command.service;

import com.example.command.core.dto.CustomerDTO;
import com.example.command.core.entity.Customer;
import com.example.command.core.repository.CustomerRepository;
import com.example.command.core.event.CustomerChangedEvent;
import com.example.command.exception.ApiRuntimeException;
import com.example.command.exception.ExceptionMessage;
import com.example.command.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.command.exception.ExceptionMessage.INTERNAL_API_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final ModelMapper modelMapper;

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(c -> CustomerDTO.builder()
                        .firstName(c.getFirstName())
                        .lastName(c.getLastName())
                        .id(c.getId())
                        .email(c.getEmail())
                        .phone(c.getPhone())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeFullName(long customerId, String firstName, String lastName) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> {
            throw new ApiRuntimeException(INTERNAL_API_ERROR);
        });
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        eventPublisher.publishEvent(new CustomerChangedEvent(customerId));
    }











    //아래 소스 코드는, Optional 연습을 위해 작성한 임시 코드..




    public CustomerDTO findByEmail(final String email) {

        //return CustomerDTO.of(customerRepository.findByEmail(email));



        /* Optional 사용 안한 경우
        */
        /*
        if(ObjectUtils.isEmpty(customerRepository.findByEmail(email))) {
            //return CustomerDTO.emptyCustomerDTO();
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND, email);
        }
        return modelMapper.map(customerRepository.findByEmail(email), CustomerDTO.class);
        */


        //요렇게 사용하면 안됨. Item 2
        //return modelMapper.map(customerRepository.findByEmail(email).get(), CustomerDTO.class);


        /*
        //isPresent 구문 보다는, orElse, orElseGet, map, orElseThrow.. 등을 사용하는게 좋음
        Optional<Customer> optCustomer = customerRepository.findByEmail(email);
        if(optCustomer.isPresent()) {
            return modelMapper.map(optCustomer.get(), CustomerDTO.class);
        } else {
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND, email);
        }
         */


        /*
        //Item 3
        return customerRepository.findByEmail(email)
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .orElseGet(CustomerDTO::emptyCustomerDTO);  //Item 4
         */

        /* Item 10
        return customerRepository.findByEmail(email)
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .or(() -> Optional.of(CustomerDTO.emptyCustomerDTO()));
         */


        /*
        return customerRepository.findByEmail(email)
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .orElseThrow(); //Item 5
         */




        Optional<Customer> optCustomer = customerRepository.findByEmail(email);
        return optCustomer.map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND, email));



        /*
        Optional<Customer> optCustomer = customerRepository.findByEmail(email);
        //return !mayCustomer.isPresent() ? CustomerDTO.emptyCustomerDTO() : CustomerDTO.of(mayCustomer.get());
        return optCustomer.isEmpty() ? CustomerDTO.emptyCustomerDTO() : CustomerDTO.of(optCustomer.get());


         */


        /*
        Optional<CustomerDTO> optCustomer = customerRepository.findByEmail(email)
                .map(customer -> modelMapper.map(customer, CustomerDTO.class));

        if(optCustomer.isPresent()) {
            return optCustomer.get();
        } else {
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND, email);  //Item 6
        }
         */



        /*
        Optional<Customer> optCustomer = customerRepository.findByEmail(email);
        //return optCustomer.map(CustomerDTO::of).orElseThrow(() -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND, email));
        return optCustomer.map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND, email));
         */



        /*
        return modelMapper.map(
                customerRepository.findByEmail(email)
                        .orElseThrow(() -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND, email)),
                CustomerDTO.class);

         */
    }

    public long countByLastName(final String lastName) {

        return customerRepository.findAll().stream()
                //.filter(c -> Optional.ofNullable(c.getLastName()).orElse("unknown").equals(lastName))   //Item 12
                .filter(c -> c.getLastName() != null && c.getLastName().equals(lastName))
                .count();
    }


    public void printPhoneNumber(final String email) {

        //TODO: 에러
        //log.info(customerRepository.findByEmail(email).get().getPhone());


        Optional<Customer> optCustomer = customerRepository.findByEmail(email);

        //Avoid
        if(optCustomer.isPresent()) {
            log.info(optCustomer.get().getPhone());
        }

        //Good
        optCustomer.ifPresent(customer -> log.info(customer.getPhone()));       //Item 8

        optCustomer.ifPresentOrElse(
                customer -> log.info(customer.getPhone()),                      //Item 9
                () -> log.warn("customer not found"));

    }
}