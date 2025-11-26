package academy.devdojo.ZZKjunit.service;

import academy.devdojo.ZZKjunit.dominio.Person;

import java.util.Objects;

public class PersonService {

    public boolean isAdult (Person person) {
        Objects.requireNonNull(person, "Person cannot be null");
        return person.getAge() >= 18;
    }
}
