package com.creational.builder;

import java.time.LocalDate;

public class UserWebDTOBuilder implements UserDTOBuilder {

    private String firstName;
    private String lastName;
    private LocalDate date;

    @Override
    public UserDTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserDTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        return null;
    }

    @Override
    public UserDTO build() {
        return null;
    }

    @Override
    public UserDTO getUserDTO() {
        return null;
    }
}
