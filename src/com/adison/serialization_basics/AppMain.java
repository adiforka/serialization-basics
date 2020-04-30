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

        Dude d1 = new Dude("Jimmy", "Carter", new Beer());
        Dude d2 = new Dude("Steve", "McGregor", new OrangeJuice());
        Dude d3 = new Dude("Sammy", "Hagar", new Coffee());

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
