package no.hvl.dat250.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String street;
	private int number; 

	@ManyToMany(mappedBy = "adressList")
	private final List<Person> persons = new ArrayList<Person>();
	
	
	
	

	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adress(String street, int number) {
		super();
		this.street = street;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Person> getPersons() {
		return persons;
	}

	

}
