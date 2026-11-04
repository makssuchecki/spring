package com.example.company.loader;

import com.example.company.domain.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class PersonCsvService {

    private final Map<String, Person> persons = new LinkedHashMap<>();

    public PersonCsvService(@Value("${persons.csv}") Resource resource) {
        load(resource);
    }

    private void load(Resource resource) {
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setTrim(true)
                .build();

        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
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
    }

    public Map<String, Person> getPersons() {
        return persons;
    }
}