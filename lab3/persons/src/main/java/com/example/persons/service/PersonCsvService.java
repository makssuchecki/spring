package com.example.persons.service;

import com.example.persons.domain.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class PersonCsvService{
    private final Map<String, Person> persons = new LinkedHashMap<>();

    public Map<String, Person> loadFromResource(String resourceName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(resourceName);
        if (is == null) {
            throw new IllegalArgumentException("Nie znaleziono pliku: " + resourceName);
        }
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setTrim(true)
                .build();

        try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
             CSVParser parser = format.parse(reader)) {

            for (CSVRecord r : parser) {
                Person p = new Person(
                        r.get("id"),
                        r.get("imie"),
                        r.get("nazwisko"),
                        r.get("email"),
                        Integer.parseInt(r.get("rok_urodzenia"))
                );
                persons.put(p.getId(), p);
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Błąd odczytu CSV", e);
        }
        return persons;
    }
    public Map<String, Person> getPersons() {
        return persons;
    }
}
