package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private Collection<Customer> owners;

    public Address() {
    }

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    public Address(String street, Integer number, Collection<Customer> owners) {
        this.street = street;
        this.number = number;
        this.owners = owners;
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

    public Collection<Customer> getOwners() {

        return owners;
    }

    public void setStreet(String street2) {
        street = street2;
    }

    public void setNumber(int i) {
        number = i;
    }
}
