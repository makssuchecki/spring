package com.example.company.board;

import com.example.company.domain.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final Person prezes;
    private final Person wiceprezes;
    private final Person sekretarz;

    public BoardService(@Qualifier("prezes") Person prezes,
                        @Qualifier("wiceprezes") Person wiceprezes,
                        @Qualifier("sekretarz") Person sekretarz) {
        this.prezes = prezes;
        this.wiceprezes = wiceprezes;
        this.sekretarz = sekretarz;
    }

    public Person getPrezes() { return prezes; }
    public Person getWiceprezes() { return wiceprezes; }
    public Person getSekretarz() { return sekretarz; }

    public void printBoard() {
        System.out.println("Prezes:     " + prezes);
        System.out.println("Wiceprezes: " + wiceprezes);
        System.out.println("Sekretarz:  " + sekretarz);
    }
}