package com.example.company.loader;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonCsvServiceTest {

    @Test
    void loadsAllPersonsFromCsv() {
        PersonCsvService service = new PersonCsvService(new ClassPathResource("data.csv"));

        assertThat(service.getPersons()).hasSize(15);
        assertThat(service.getPersons().get("58b6a8cd-ec64-4e77-95ee-3be1a164c96f").getNazwisko())
                .isEqualTo("Suchecki");
    }

    @Test
    void missingResourceThrowsException() {
        assertThatThrownBy(() -> new PersonCsvService(new ClassPathResource("does-not-exist.csv")))
                .isInstanceOf(UncheckedIOException.class);
    }
}