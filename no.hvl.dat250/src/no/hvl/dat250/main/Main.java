package no.hvl.dat250.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import no.hvl.dat250.model.Adress;
import no.hvl.dat250.model.Bank;
import no.hvl.dat250.model.CreditCard;
import no.hvl.dat250.model.Person;
import no.hvl.dat250.model.Pincode;


public class Main {
	
	 private static final String PERSISTENCE_UNIT_NAME = "creditcard";
	    private static EntityManagerFactory factory;

	    public static void main(String[] args) {
	    	 EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	         EntityManager em = factory.createEntityManager();
	         em.clear();

	         em.getTransaction().begin();

	         Person person = new Person();
	         Adress adress = createAddress(person);
	         person.getAdressList().add(adress);
	         Pincode pincode = createPincode();
	         Bank bank = createBank();
	         CreditCard creditCard = createCreditcard(bank, pincode, person);

	         person.getCreditCardList().add(creditCard);

	         em.persist(person);
	         em.persist(creditCard);
	         em.persist(pincode);
	         em.persist(adress);
	         em.persist(bank);

	         em.getTransaction().commit();
	         em.close();
	     }

	     public static CreditCard createCreditcard(Bank bank, Pincode pincode, Person person) {
	         CreditCard creditCard = new CreditCard();
	         creditCard.setNumber(123456);
	         creditCard.setBank(bank);
	         creditCard.setBalance(1000000);
	         creditCard.setLimit(2000);
	         creditCard.setPincode(pincode);      
	         return creditCard;
	     }

	     public static Adress createAddress(Person person) {
	         Adress address = new Adress();
	         address.setNumber(28);
	         address.setStreet("Fabrikkgaten");
	         return address;
	     }

	     public static Pincode createPincode() {
	         Pincode pincode = new Pincode();
	         pincode.setCount(1);
	         pincode.setPincode("3456");
	         return pincode;
	     }

	     public static Bank createBank() {
	         Bank bank = new Bank();
	         bank.setName("Spareskillingsbanken");
	         return bank;
	     }

}
