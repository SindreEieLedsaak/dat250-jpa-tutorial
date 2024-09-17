package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bank")
    private Collection<CreditCard> ownedCards;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public Bank(String name, Collection<CreditCard> ownedCards) {
        this.name = name;
        this.ownedCards = ownedCards;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        // TODO: implement method!
        return name;
    }

    public Collection<CreditCard> getOwnedCards() {
        // TODO: implement method!
        return ownedCards;
    }
}
