package com.example.company.board;

import com.example.company.domain.Person;
import com.example.company.loader.PersonCsvService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    private static final String PREZES_ID     = "58b6a8cd-ec64-4e77-95ee-3be1a164c96f";
    private static final String WICEPREZES_ID = "3f2b9c1e-7a4d-4c8b-9e21-5d6f7a8b9c0d";
    private static final String SEKRETARZ_ID  = "a1c4e7f2-1b3d-4e5f-8a6b-7c8d9e0f1a2b";

    @Bean
    public Person prezes(PersonCsvService csv) {
        return csv.getPersons().get(PREZES_ID);
    }

    @Bean
    public Person wiceprezes(PersonCsvService csv) {
        return csv.getPersons().get(WICEPREZES_ID);
    }

    @Bean
    public Person sekretarz(PersonCsvService csv) {
        return csv.getPersons().get(SEKRETARZ_ID);
    }
}