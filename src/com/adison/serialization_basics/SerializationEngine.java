package com.adison.serialization_basics;

import com.adison.serialization_basics.pojos.Dude;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class SerializationEngine {

    private final File file;

    public SerializationEngine(String path) {
        this.file = new File(path);
    }

    public File getFile() {
        return file;
    }

    public void serialize(List<Dude> dudes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(dudes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<List<Dude>> deserialize() {

        List<Dude> dudes = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            dudes = (List<Dude>)ois.readObject();

        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //decided on optional to make client aware that deserialization might fail on a
        //number of counts but we don't want it to crash the app
        return Optional.of(dudes);
    }
}
