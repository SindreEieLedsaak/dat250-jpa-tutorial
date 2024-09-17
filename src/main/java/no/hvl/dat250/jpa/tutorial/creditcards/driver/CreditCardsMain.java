package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Collection<Customer> owners = new HashSet<>();
    Collection<Address> addresses = new HashSet<>();
    Collection<CreditCard> creditCards = new HashSet<>();
    Collection<CreditCard> bankCards = new HashSet<>();

    // Create Pincode
    Pincode commonPincode = new Pincode("123", 1);

    // Create Bank
    Bank pengeBank = new Bank("Pengebank", bankCards);

    // Create CreditCards
    CreditCard card1 = new CreditCard(12345, -5000, -10000, commonPincode, pengeBank);
    CreditCard card2 = new CreditCard(123, 1, 2000, commonPincode, pengeBank);

    // Add cards to the collections
    creditCards.add(card1);
    creditCards.add(card2);
    bankCards.add(card1);
    bankCards.add(card2);

    // Create Address
    Address inndalsveien = new Address("Inndalsveien", 28, owners);

    // Create Customer
    Customer maxMustermann = new Customer("Max Mustermann", addresses, creditCards);

    // Add customer to the address and add address to customer
    owners.add(maxMustermann);
    addresses.add(inndalsveien);
    System.out.println(creditCards);
    // Persist all entities

    em.persist(pengeBank); // Persist bank, cascading the cards
    em.persist(inndalsveien); // Persist address
    em.persist(maxMustermann); // Persist customer, cascading the credit cards

  }
}
