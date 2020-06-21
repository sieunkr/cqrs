package com.example.command.service;

import com.example.command.core.dto.CustomerDTO;
import com.example.command.core.entity.Customer;
import com.example.command.core.repository.CustomerRepository;
import com.example.command.core.event.CustomerChangedEvent;
import com.example.command.exception.ApiRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.command.exception.ExceptionMessage.INTERNAL_API_ERROR;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ApplicationEventPublisher eventPublisher;

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
}