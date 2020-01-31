package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    List<Person> persons = new ArrayList<>();
    List<Pet> pets;
    Scanner scan = new Scanner(System.in);


    public Program() throws IOException {
        NameGenerator nameGenerator = new NameGenerator();
        for (String n: nameGenerator.names) {
            Person p = new Person(n);
            persons.add(p);
        }
        show();
    }

    private void show() throws IOException {
        System.out.println("[1] show pet owners\n" +
                "[2] sell pets");
        int menuChoice = scan.nextInt();
        if (menuChoice == 1) {
            printPetOwners();
            show();
        } else if ( menuChoice == 2) {
            sellPets();
            show();
        }
    }

    private void printPetOwners() {
        persons.stream()
            .sorted((a,b) -> b.name.compareTo(a.name))
            .collect(Collectors.toList())
            .forEach(s -> System.out.printf("Name: %s (%s) owns the animals: %s\n", s.getName(), s.getAge(), s.getPets()));
    }

    private void sellPets() throws IOException {
        pets = new ArrayList<>();
        for (Person person: persons) {
            for(int i = 0; i < (int)(Math.random() * 5); i++){
                Pet pet = new Pet();
                pets.add(pet);
            }
            person.addPet(pets);
        }
    }
}
