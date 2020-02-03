package com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public List<Person> persons = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    public Program() throws IOException {
        new NameGenerator();
        new PetStore();
        for (String n : NameGenerator.getNames()) {
            Person p = new Person(n);
            persons.add(p);
        }
        show();
    }

    private void show() {
        System.out.println("[1] show pet owners\n" +
                "[2] sell pets\n" +
                "[3] print pets");
        int menuChoice = scan.nextInt();
        if (menuChoice == 1) {
            printResult1();
            show();
        } else if (menuChoice == 2) {
            PetStore.sellPets(persons);
            show();
        } else if (menuChoice == 3) {
            printResult2();
            show();
        }
    }

    private void printResult1() {
        persons.stream()
                .sorted((a, b) -> b.name.compareTo(a.name))
//                .filter(s -> !(s.getPetListFromPerson().isEmpty()))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.toString()));
    }


    private void printResult2() {
        Comparator<Person> comparePetListLength = Comparator.comparing(a -> a.getPetListFromPerson().size());
        Comparator<Person> compareName = Comparator.comparing(Person::getName);

        persons.stream()
                .sorted(comparePetListLength.thenComparing(compareName))
                .filter(s -> !(s.getPetListFromPerson().isEmpty()))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.toString()));
    }
}