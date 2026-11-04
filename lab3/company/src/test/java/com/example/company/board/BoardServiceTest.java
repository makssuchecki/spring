package com.example.company.board;

import com.example.company.domain.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardServiceTest {

    @Test
    void returnsInjectedBoardMembers() {
        Person prezes = new Person("1", "Jan", "Kowalski", "jan@example.com", 1980);
        Person wiceprezes = new Person("2", "Ewa", "Nowak", "ewa@example.com", 1985);
        Person sekretarz = new Person("3", "Adam", "Mazur", "adam@example.com", 1990);

        BoardService service = new BoardService(prezes, wiceprezes, sekretarz);

        assertThat(service.getPrezes()).isSameAs(prezes);
        assertThat(service.getWiceprezes()).isSameAs(wiceprezes);
        assertThat(service.getSekretarz()).isSameAs(sekretarz);
    }
}