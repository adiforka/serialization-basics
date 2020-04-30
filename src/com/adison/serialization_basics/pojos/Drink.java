package com.adison.serialization_basics.pojos;

import java.io.Serializable;

public abstract class Drink implements Serializable {

    private static final long serialVersionUID = -3501513589415185704L;

    protected String drinkName;

    public Drink(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkName() {
        return drinkName;
    }

    @Override
    public String toString() {
        return drinkName;
    }
}
