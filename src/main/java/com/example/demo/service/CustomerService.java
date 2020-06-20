package com.example.demo.service;

import com.example.demo.core.dto.CustomerDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.event.ReservationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

        Customer customer = customerRepository.findById(customerId).get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        eventPublisher.publishEvent(new ReservationEvent(customerId));
    }
}