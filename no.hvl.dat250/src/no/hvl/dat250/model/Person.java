package no.hvl.dat250.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private String name;

	private List<CreditCard> creditCardList = new ArrayList<CreditCard>();
	private List<Adress> adressList = new ArrayList<Adress>();
	
	public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	public List<CreditCard> getCreditCardList() {
		return creditCardList;
	}

	public void setCreditCardList(List<CreditCard> creditCardList) {
		this.creditCardList = creditCardList;
	}

	@ManyToMany
	public List<Adress> getAdressList() {
		return adressList;
	}

	public void setAdressList(List<Adress> adressList) {
		this.adressList = adressList;
	}

}