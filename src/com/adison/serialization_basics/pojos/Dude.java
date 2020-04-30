package com.adison.serialization_basics.pojos;

import java.io.Serializable;

public class Dude implements Serializable {

    private static final long serialVersionUID = 5707065612558422069L;
    private static Long baseId = 0L;
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final String occupation;
    private final Drink favoriteDrink;

    public Dude(DudeBuilder builder) {
        id = ++baseId;
        this.nickName = builder.nickName;
        this.occupation = builder.occupation;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.favoriteDrink = builder.favoriteDrink;
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

    public String getNickName() {
        return nickName;
    }

    public String getOccupation() {
        return occupation;
    }

    public Drink getFavoriteDrink() {
        return favoriteDrink;
    }

    public String toString() {
        return "Dude={id: " + id + ", first name: " + firstName + ", last name: " + lastName + ", " +
                "favorite drink: " + favoriteDrink.getDrinkName() + "}";
    }

    public static DudeBuilder builder() {
        return new DudeBuilder();
    }

    public static class DudeBuilder {

        private String firstName;
        private String lastName;
        private String nickName;
        private String occupation;
        private Drink favoriteDrink;

        public DudeBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DudeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DudeBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public DudeBuilder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public DudeBuilder favoriteDrink(Drink favoriteDrink) {
            this.favoriteDrink = favoriteDrink;
            return this;
        }

        public Dude build() {
            return new Dude(this);
        }
    }
}
