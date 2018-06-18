//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

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

	@Column(name = "state_name_id")
	private int state_name_id;

	@Column(name = "city_name_id")
	private int city_name_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_name")

	private Cities cities1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_name")
	private States states1;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	private Set<ComandasMaster> comandasMaster = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	private Set<ComandasExpensesServices> comandasExepenses = new HashSet<>(0);

	public Customers() {

	}



	public Customers(Long id, CompanySubsidiaries companySubsidiaries, String customer_name, String phone_number,
			String email, String address, String zip_code, int state_name_id, int city_name_id, Cities cities1,
			States states1, Set<ComandasMaster> comandasMaster, Set<ComandasExpensesServices> comandasExepenses) {
		super();
		this.id = id;
		this.companySubsidiaries = companySubsidiaries;
		this.customer_name = customer_name;
		this.phone_number = phone_number;
		this.email = email;
		this.address = address;
		this.zip_code = zip_code;
		this.state_name_id = state_name_id;
		this.city_name_id = city_name_id;
		this.cities1 = cities1;
		this.states1 = states1;
		this.comandasMaster = comandasMaster;
		this.comandasExepenses = comandasExepenses;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
		return true;
		}
		if (obj == null) {
		return false;
		}
		if (getClass() != obj.getClass()) {
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
		if (cities1 == null) {
		if (other.cities1 != null) {
		return false;
		}
		} else if (!cities1.equals(other.cities1)) {
		return false;
		}
		if (city_name_id != other.city_name_id) {
		return false;
		}
		if (comandasExepenses == null) {
		if (other.comandasExepenses != null) {
		return false;
		}
		} else if (!comandasExepenses.equals(other.comandasExepenses)) {
		return false;
		}
		if (comandasMaster == null) {
		if (other.comandasMaster != null) {
		return false;
		}
		} else if (!comandasMaster.equals(other.comandasMaster)) {
		return false;
		}
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
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
		if (state_name_id != other.state_name_id) {
		return false;
		}
		if (states1 == null) {
		if (other.states1 != null) {
		return false;
		}
		} else if (!states1.equals(other.states1)) {
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
		return cities1;
	}

	/**
	 * @return the cities1
	 */
	public Cities getCities1() {
		return cities1;
	}

	/**
	 * @return the city_name_id
	 */
	public int getCity_name_id() {
		return city_name_id;
	}

	/**
	 * @return the comandasMaster
	 */
	public Set<ComandasMaster> getComandasMaster() {
		return comandasMaster;
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
	 * @return the state_name_id
	 */
	public int getState_name_id() {
		return state_name_id;
	}

	/**
	 * @return the states
	 */
	public States getStates() {
		return states1;
	}

	/**
	 * @return the states1
	 */
	public States getStates1() {
		return states1;
	}

	/**
	 * @return the zip_code
	 */
	public String getZip_code() {
		return zip_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		//result = prime * result + ((cities1 == null) ? 0 : cities1.hashCode());
		result = prime * result + city_name_id;
		//result = prime * result + ((comandasExepenses == null) ? 0 : comandasExepenses.hashCode());
		result = prime * result + ((comandasMaster == null) ? 0 : comandasMaster.hashCode());
		result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
		result = prime * result + state_name_id;
		//result = prime * result + ((states1 == null) ? 0 : states1.hashCode());
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
		this.cities1 = cities;
	}

	/**
	 * @param cities1 the cities1 to set
	 */
	public void setCities1(Cities cities1) {
		this.cities1 = cities1;
	}

	/**
	 * @param city_name_id the city_name_id to set
	 */
	public void setCity_name_id(int city_name_id) {
		this.city_name_id = city_name_id;
	}

	/**
	 * @param comandasMaster the comandasMaster to set
	 */
	public void setComandasMaster(Set<ComandasMaster> comandasMaster) {
		this.comandasMaster = comandasMaster;
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
	 * @param state_name_id the state_name_id to set
	 */
	public void setState_name_id(int state_name_id) {
		this.state_name_id = state_name_id;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(States states) {
		this.states1 = states;
	}

	/**
	 * @param states1 the states1 to set
	 */
	public void setStates1(States states1) {
		this.states1 = states1;
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
		return "Customers [id=" + id + ", customer_name=" + customer_name + ", phone_number=" + phone_number + ", email=" + email + ", address="
				+ address + ", zip_code=" + zip_code + ", cities=" + cities + ", states=" + states + ", comandasMaster=" + comandasMaster
				+ ", getAddress()=" + getAddress() + ", getCities()=" + getCities() + ", getComandasMaster()=" + getComandasMaster()
				+ ", getCustomer_name()=" + getCustomer_name() + ", getEmail()=" + getEmail() + ", getId()=" + getId() + ", getPhone_number()="
				+ getPhone_number() + ", getStates()=" + getStates() + ", getZip_code()=" + getZip_code() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	 */

}

