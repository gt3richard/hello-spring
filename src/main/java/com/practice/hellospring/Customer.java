package com.practice.hellospring;

public class Customer {

    private long id;
    private String firstName;
    private String lastName;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
