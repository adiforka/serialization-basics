package com.adison.serialization_basics;

import com.adison.serialization_basics.pojos.Beer;
import com.adison.serialization_basics.pojos.Coffee;
import com.adison.serialization_basics.pojos.Dude;
import com.adison.serialization_basics.pojos.OrangeJuice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppMain {
    public static void main(String[] args) {

        Dude d1 = Dude.builder()
                .firstName("Charlie")
                .lastName("Sheen")
                .nickName("Wild Dog")
                .occupation("Self-entertainer")
                .favoriteDrink(new Beer())
                .build();

        Dude d2 = Dude.builder()
                .firstName("Jimmy")
                .lastName("Carter")
                .nickName("The Missle")
                .occupation("Ex president")
                .favoriteDrink(new Coffee())
                .build();

        Dude d3 = Dude.builder()
                .firstName("Amanda")
                .lastName("Jackson")
                .nickName("The Loner")
                .occupation("Accountant")
                .favoriteDrink(new OrangeJuice())
                .build();

        List<Dude> dudes = new ArrayList<>();
        dudes.add(d1);
        dudes.add(d2);
        dudes.add(d3);

        //passing the file path to the object handling all serialization and deserialization
        SerializationEngine engine = new SerializationEngine("objects.dat");

        //serialize
        engine.serialize(dudes);

        //deserialize
        List<Dude> dudes2 = null;
        Optional<List<Dude>> optionalDudes = engine.deserialize();
        if (optionalDudes.isPresent())
            dudes2 = optionalDudes.get();

        //use deserialized
        dudes2.forEach(System.out::println);
    }
}
