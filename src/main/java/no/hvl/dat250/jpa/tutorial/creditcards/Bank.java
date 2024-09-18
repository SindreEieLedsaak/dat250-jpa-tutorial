package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bank")
    private Set<CreditCard> ownedCards;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public Bank(String name, Set<CreditCard> ownedCards) {
        this.name = name;
        this.ownedCards = ownedCards;
    }

    public Long getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public Set<CreditCard> getOwnedCards() {

        return ownedCards;
    }
}
