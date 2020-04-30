package com.adison.serialization_basics.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** to instantiate, use inner builder class. to use builder, get a builder instance with Dude.builder()
 * and then chain the setter methods until the desired properties for Dude object have been set, then
 * invoke build() to have an instnce of Dude created*/
public class Dude implements Serializable {

    private static final long serialVersionUID = 5707065612558422069L;
    private static Long baseId = 0L;
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final String occupation;
    private final List<Drink> favoriteDrinks;

    //made this private, forcing the client to use the builder, which may not be OK
    //alternatively I could either provide a no-arg constructor and make fields non-final
    //or write out a big constructor with all the field values passed as arguments, which the client
    //would have to provide, but that's what I wanted to avoid making them do
    private Dude(DudeBuilder builder) {
        id = ++baseId;
        this.nickName = builder.nickName;
        this.occupation = builder.occupation;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.favoriteDrinks = builder.favoriteDrinks;
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

    public List<Drink> getFavoriteDrinks() {
        return favoriteDrinks;
    }

    public void addDrink(Drink drink) {
        favoriteDrinks.add(drink);
    }

    public boolean removeDrink(Drink drink) {
        if (favoriteDrinks.contains(drink)) {
            favoriteDrinks.remove(drink);
            return true;
        } else return false;
    }


    public String toString() {
        return "Dude={id: " + id + ", first name: " + firstName + ", last name: " + lastName + ", " +
                "nickname: " + nickName + ", occupation: " + occupation +
                ", favorite drinks: " + favoriteDrinks + "}";
    }

    public static DudeBuilder builder() {
        return new DudeBuilder();
    }

    public static class DudeBuilder {

        private String firstName;
        private String lastName;
        private String nickName;
        private String occupation;
        private final List<Drink> favoriteDrinks = new ArrayList<>();

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

        public DudeBuilder addFavoriteDrink(Drink favoriteDrink) {
            favoriteDrinks.add(favoriteDrink);
            return this;
        }

        public Dude build() {
            return new Dude(this);
        }
    }
}
