package com.example.demo.service;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.event.ReservationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void changeName(long customerId, String firstName, String lastName) {

        Customer customer = customerRepository.findById(customerId).get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        eventPublisher.publishEvent(new ReservationEvent(customerId));
    }
}