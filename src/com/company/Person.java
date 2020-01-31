package com.company;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int age;
    List<Pet> pets = new ArrayList<>();

    public Person(String name) {
        this.name = name;
        this.age =(int) (Math.random() * 33) + 18;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void addPet(List<Pet> pet){
            pets.addAll(pet);
    }
    public String getPets(){
        return pets.toString();
    }
}
