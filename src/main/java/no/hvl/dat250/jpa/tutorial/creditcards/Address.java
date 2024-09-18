package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> residents;

    public Address() {
    }

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    public Address(String street, Integer number, Set<Customer> residents) {
        this.street = street;
        this.number = number;
        this.residents = residents;
    }

    public Long getId() {

        return id;
    }

    public String getStreet() {

        return street;
    }

    public Integer getNumber() {

        return number;
    }

    public Set<Customer> getOwners() {

        return residents;
    }

    public void setStreet(String street2) {
        street = street2;
    }

    public void setNumber(int i) {
        number = i;
    }
}
