package com.ksk;

import com.ksk.entity.Customer;
import com.ksk.enums.CustomerType;
import com.ksk.repo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan("com.ksk")
@Slf4j
public class UsersApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class);
    }

    private CustomerRepository customerRepository;

    @Autowired
    public UsersApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Saving users. Current user count is {}.", customerRepository.count());
        for (int i=0;i<100;i++){
            Customer customer = new Customer();
            customer.setCustomerType(i%2==0? CustomerType.PREMIUM :CustomerType.REGULAR);
            customer.setEmail("abc@gmail.com");
            customer.setFirstName("Hello"+ i);
            customer.setLastName("There" +i);
            customer.setPhoneNumber("1234567"+i);
            customerRepository.save(customer);
        }

        log.info("Done saving users. Data: {}.", customerRepository.findAll());
    }
}