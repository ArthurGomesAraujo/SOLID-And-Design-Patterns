package com.creational.builder;

import java.time.LocalDate;

public interface UserDTOBuilder {

    //Methods for building parts
    UserDTOBuilder withFirstName(String firstName);
    UserDTOBuilder withLastName(String lastName);
    UserDTOBuilder withBirthday(LocalDate date);
    UserDTOBuilder withAddress(Address address);

    //Method of "assembling" the final product
    UserDTO build();

    //(optional) method to fetch the built object
    UserDTO getUserDTO();
}
