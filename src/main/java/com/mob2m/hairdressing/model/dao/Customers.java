//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "tbl_customers")
@Table(schema = "hairdressing_master")
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_name")
	private String customer_name;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "email")
	private String email;

	@Column (name = "address")
	private String address;

	@Column(name = "zip_code")
	private String zip_code;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_name")
	private Cities cities;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_name")
	private States states;

	public Customers() {

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
		return true;
		}
		if (obj == null) {
		return false;
		}
		if (!(obj instanceof Customers)) {
		return false;
		}
		Customers other = (Customers) obj;
		if (address == null) {
		if (other.address != null) {
		return false;
		}
		} else if (!address.equals(other.address)) {
		return false;
		}
		if (cities == null) {
		if (other.cities != null) {
		return false;
		}
		} else if (!cities.equals(other.cities)) {
		return false;
		}
		if (customer_name == null) {
		if (other.customer_name != null) {
		return false;
		}
		} else if (!customer_name.equals(other.customer_name)) {
		return false;
		}
		if (email == null) {
		if (other.email != null) {
		return false;
		}
		} else if (!email.equals(other.email)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (phone_number == null) {
		if (other.phone_number != null) {
		return false;
		}
		} else if (!phone_number.equals(other.phone_number)) {
		return false;
		}
		if (states == null) {
		if (other.states != null) {
		return false;
		}
		} else if (!states.equals(other.states)) {
		return false;
		}
		if (zip_code == null) {
		if (other.zip_code != null) {
		return false;
		}
		} else if (!zip_code.equals(other.zip_code)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the cities
	 */
	public Cities getCities() {
		return cities;
	}

	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @return the states
	 */
	public States getStates() {
		return states;
	}

	/**
	 * @return the zip_code
	 */
	public String getZip_code() {
		return zip_code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
		//result = prime * result + ((states == null) ? 0 : states.hashCode());
		result = prime * result + ((zip_code == null) ? 0 : zip_code.hashCode());
		return result;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(Cities cities) {
		this.cities = cities;
	}

	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(States states) {
		this.states = states;
	}

	/**
	 * @param zip_code the zip_code to set
	 */
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_name=" + customer_name + ", phone_number=" + phone_number + ", email=" + email + ", address="
				+ address + ", zip_code=" + zip_code + ", cities=" + cities + ", states=" + states + ", getId()=" + getId() + ", getCustomer_name()="
				+ getCustomer_name() + ", getPhone_number()=" + getPhone_number() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getZip_code()=" + getZip_code() + ", getCities()=" + getCities() + ", getStates()=" + getStates() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/

}

