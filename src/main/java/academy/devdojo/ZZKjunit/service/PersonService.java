package academy.devdojo.ZZKjunit.service;

import academy.devdojo.ZZKjunit.dominio.Person;

import java.util.List;
import java.util.Objects;

public class PersonService {

    public boolean isAdult (Person person) {
        if (person == null) {
            throw new IllegalArgumentException();
        }
        return person.getAge() >= 18;
    }

    public List<Person> removeNotAdult (List<Person> personList) {
        return personList.stream().filter(this::isAdult).toList();
    }
}
