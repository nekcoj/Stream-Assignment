package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pet {
    List<String> petTypes = Arrays.asList("Snake", "Pig", "Dog", "Cat", "Spider");
    String petType = "";
    String petName;

    public Pet() throws IOException {
        NameGenerator getPetName = new NameGenerator();
        petName = getPetName.getPetName();
        if(!petName.equals(""))
        this.petType = petTypes.get((int)(Math.random() * 4));
    }

    public String listPets(List<Pet> pets){
        return pets.toString();
    }
}
