package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Set;

import jakarta.persistence.*;

@Entity(name = "CreditCard")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToMany(mappedBy = "creditCards")
    private Set<Customer> owners;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pincode pincode;

    @ManyToOne
    private Bank bank;

    public CreditCard(Integer number, Integer balance, Integer creditLimit, Pincode pincode, Bank bank) {
        this.number = number;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.pincode = pincode;
        this.bank = bank;
    }

    public CreditCard() {

    }

    public Integer getNumber() {
        // TODO: implement method!
        return number;
    }

    public Integer getBalance() {
        // TODO: implement method!
        return balance;
    }

    public Integer getCreditLimit() {
        // TODO: implement method!
        return creditLimit;
    }

    public Pincode getPincode() {
        // TODO: implement method!
        return pincode;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return bank;
    }

    public Set<Customer> getOwners() {
        return owners;
    }

    public void setNumber(int i) {

        number = i;
    }

    public void setBalance(int i) {

        balance = i;
    }

    public void setCreditLimit(int i) {

        creditLimit = i;
    }

    public void setBank(Bank bank2) {

        bank = bank2;
    }

    public void setPincode(Pincode pincode2) {

        pincode = pincode2;
    }
}