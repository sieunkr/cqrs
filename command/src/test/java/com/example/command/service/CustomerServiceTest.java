package com.example.command.service;

import com.example.command.core.dto.CustomerDTO;
import com.example.command.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("h2")
@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void testPrintPhoneNumber() {
        customerService.printPhoneNumber("sieunkr@gmail.com");
        customerService.printPhoneNumber("test@gmail.com");
    }

    @Test
    void testGetFullName() {

        //given
        String email = "sieunkr@gmail.com";
        String expectedFullName = "eddy kim";

        //when
        String actualFullName = customerService.getFullName(email);

        //then
        assertEquals(actualFullName, expectedFullName);
    }


    @Test
    void givenNonExistentMember_whenGetFullName_thenUnknown() {

        //given
        String email = "test@gmail.com";
        String expectedFullName = "UNKNOWN";

        //when
        String actualFullName = customerService.getFullName(email);

        //then
        assertEquals(actualFullName, expectedFullName);
    }


    @Test
    void givenNonExistentMember_whenGetFullName_thenResourceNotFoundException() {

        //given
        String email = "test@gmail.com";

        //when
        assertThrows(ResourceNotFoundException.class, () -> customerService.getFullName(email));

    }



    @Test
    void testCountByLastName() {

        //given
        String lastName = "kim";
        long expectedCount = 1;

        //when
        long actualCount = customerService.countByLastName(lastName);

        //then
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testFindByEmail() {

        //given
        String email = "sieunkr@gmail.com";

        //when
        CustomerDTO customerDTO = customerService.findByEmail(email);

        //then
        assertEquals("eddy", customerDTO.getFirstName());

    }

    /*
    @Test
    void givenNonExistentMember_whenFindByEmail_thenEmptyObject() {

        //given
        String email = "test@gmail.com";

        //when
        CustomerDTO actualCustomerDTO = customerService.findByEmail(email);

        //then
        assertNotNull(actualCustomerDTO);
        assertNull(actualCustomerDTO.getEmail());
    }
     */


    /*
    @Test
    void givenNonExistentMember_whenFindByEmail_thenNoSuchElementException() {

        //given
        String email = "test@gmail.com";

        //when, then
        assertThrows(NoSuchElementException.class, () -> customerService.findByEmail(email));
    }

     */


    @Test
    void givenNonExistentMember_whenFindByEmail_thenResourceNotFoundException() {

        //given
        String email = "test@gmail.com";

        //when, then
        assertThrows(ResourceNotFoundException.class, () -> customerService.findByEmail(email));
    }
}