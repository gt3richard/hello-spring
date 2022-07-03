package com.practice.hellospring;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Spring") String name) {
        List<Customer> customers = repository.queryCustomerByFirstName(name);
        String names = customers.stream().map(c -> String.format(template, c.getFullName())).reduce("", (a, b) -> a + " and " + b);
        return new Greeting(counter.incrementAndGet(), String.format(template, names));
    }
}
