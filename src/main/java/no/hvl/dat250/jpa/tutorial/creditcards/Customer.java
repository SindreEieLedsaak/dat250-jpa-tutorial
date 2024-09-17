package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Address> addresses;

    @ManyToMany(mappedBy = "owners")
    private Collection<CreditCard> creditCards;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, Collection<Address> addresses, Collection<CreditCard> creditCards) {
        this.name = name;
        this.addresses = addresses;
        this.creditCards = creditCards;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        // TODO: implement method!
        return name;
    }

    public Collection<Address> getAddresses() {
        // TODO: implement method!
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        // TODO: implement method!
        return creditCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

}
