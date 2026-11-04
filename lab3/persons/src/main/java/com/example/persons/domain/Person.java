package com.example.persons.domain;

public class Person {
    private final String id;
    private final String imie;
    private final String nazwisko;
    private final String email;
    private final int rokUrodzenia;

    public Person(String id, String imie, String nazwisko, String email, int rokUrodzenia) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.rokUrodzenia = rokUrodzenia;
    }

    public String getId() { return id; }
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public String getEmail() { return email; }
    public int getRokUrodzenia() { return rokUrodzenia; }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", rokUrodzenia=" + rokUrodzenia +
                '}';
    }
}