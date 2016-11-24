package boots.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="employers")
public class Employer implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=150)
	private String name;
	@Column(length=150)
	private String street;
	@Column(length=150)
	private String city;
	@Column(length=150)
	private String state;
	@Column(length=150)
	private String country;
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	public Employer(String name, String street, String city, String state, String country, Date date) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.date = date;
	}

	public Employer() {
		this("","","","","", new Date());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", date=" + date + "]";
	}
}
