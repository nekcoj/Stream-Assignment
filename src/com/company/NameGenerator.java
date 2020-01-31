package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameGenerator {
    Stream<String> petNamesFromFile = Files.lines(Paths.get("pet-names-4.txt"));
    List<String> petNames;
    List<String> availablePetNames;
    List<String> names = Arrays.asList("Raffe", "Hang", "Sofia", "Alexandra", "Michelle", "Joacim", "Janis", "Petru", "Anton", "Tien"
            , "Alexander", "Calle", "Magnus", "Markus", "David", "Daniel");


    public NameGenerator() throws IOException {
        petNames = new ArrayList<>(getPetNamesFromFile());
        availablePetNames = petNames;
    }

    private List<String> getPetNamesFromFile() {
        return Arrays.asList(petNamesFromFile.map(s -> s.replaceAll("\\s", "")
                .replaceAll("\\d+.", " ")
                .replaceAll("\"", "")
                .replaceAll(",", "")
                .strip())
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining()).split("\\s"));
    }

    public void printPetNames(List<String> printList){
        printList.forEach(s -> System.out.printf("%s\n", s));
    }

    public String getPetName(){
        String petName  = availablePetNames.get((int)(Math.random() * availablePetNames.size()));
        availablePetNames.remove(petName);
        return petName;
    }
}
