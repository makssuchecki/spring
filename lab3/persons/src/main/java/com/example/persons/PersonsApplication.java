package com.example.persons;

import com.example.persons.domain.Person;
import com.example.persons.service.PersonCsvService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class PersonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonsApplication.class, args);

        PersonCsvService service = new PersonCsvService();
        Map<String, Person> persons = service.loadFromResource("data.csv");

        persons.values().forEach(System.out::println);
    }
}