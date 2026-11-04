package com.example.persons.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void toStringZawieraWszystkiePola() {
        Person p = new Person("id-1", "Anna", "Kowalska", "anna@example.com", 1998);

        assertThat(p.toString())
                .contains("id-1", "Anna", "Kowalska", "anna@example.com", "1998");
    }
}