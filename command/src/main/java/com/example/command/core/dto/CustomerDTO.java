package com.example.command.core.dto;

import com.example.command.core.entity.Customer;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public static CustomerDTO of(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public static CustomerDTO emptyCustomerDTO() {
        return CustomerDTO.builder().build();
    }

}