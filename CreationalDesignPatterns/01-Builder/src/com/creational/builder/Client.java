package com.creational.builder;

import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {

    }

    public static User createUser() {
        User user = new User();
        user.setBirthday(LocalDate.of(1960, 5, 6));
        user.setFirstName("Ron");
        user.setLastName("Swanson");

        Address address = new Address();
        address.setHouseNumber("100");
        address.setStreet("State Street");
        address.setCity("Pawnee");
        address.setState("Indiana");
        address.setZipcode("47998");

        user.setAddress(address);

        return user;
    }
}
