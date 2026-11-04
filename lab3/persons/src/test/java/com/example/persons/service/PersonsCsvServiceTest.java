package com.example.persons.service;

import com.example.persons.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonCsvServiceTest {

    private static final String VALID = "valid.csv";
    private static final String BAD_YEAR = "bad-year.csv";
    private static final String MISSING_COLUMNS = "missing-columns.csv";

    private PersonCsvService service;

    @BeforeEach
    void setUp() {
        service = new PersonCsvService();
    }


    @Test
    void valid_loadsAllRows() {
        assertThat(service.loadFromResource(VALID)).hasSize(3);
    }

    @Test
    void valid_mapsAllFieldsCorrectly() {
        Person p = service.loadFromResource(VALID).get("id-1");

        assertThat(p.getImie()).isEqualTo("Anna");
        assertThat(p.getNazwisko()).isEqualTo("Kowalska");
        assertThat(p.getEmail()).isEqualTo("anna@example.com");
        assertThat(p.getRokUrodzenia()).isEqualTo(1998);
    }


    @Test
    void valid_preservesFileOrder() {
        Map<String, Person> persons = service.loadFromResource(VALID);

        assertThat(persons.keySet()).containsExactly("id-1", "id-2", "id-3");
    }

    @Test
    void valid_getPersonsReturnsLoadedData() {
        Map<String, Person> loaded = service.loadFromResource(VALID);

        assertThat(service.getPersons()).isEqualTo(loaded);
    }


    @Test
    void badYear_throwsNumberFormatException() {
        assertThatThrownBy(() -> service.loadFromResource(BAD_YEAR))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("abc");
    }



    @Test
    void missingFile_throwsIllegalArgumentException() {
        assertThatThrownBy(() -> service.loadFromResource("csv/does-not-exist.csv"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does-not-exist.csv");
    }
}