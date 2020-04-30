package com.adison.serialization_basics.pojos;

import java.io.Serializable;

public class Dude implements Serializable {

    private static final long serialVersionUID = 5707065612558422069L;
    private static Long baseId = 0L;
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Drink favoriteDrink;

    public Dude(String firstName, String lastName, Drink favoriteDrink) {
        id = ++baseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteDrink = favoriteDrink;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Drink getFavoriteDrink() {
        return favoriteDrink;
    }

    public String toString() {
        return "Dude={id: " + id + ", first name: " + firstName + ", last name: " + lastName + ", " +
                "favorite drink: " + favoriteDrink.getDrinkName() + "}";
    }
}
