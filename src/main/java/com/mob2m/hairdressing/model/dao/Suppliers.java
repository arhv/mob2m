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

@Entity(name = "tbl_suppliers")
@Table(schema = "hairdressing_master")
public class Suppliers implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "supplier_name")
	private String supplier_name;

	@Column(name = "contact_name")
	private String contact_name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number_1")
	private String phone_number_1;

	@Column(name = "phone_number_2")
	private String phone_number_2;

	@Column(name = "cpf_cnpj")
	private String cpf_cnpj;

	@Column(name = "adress")
	private String adress;

	@Column(name = "supplier_state_id")
	private int supplier_state_id;

	@Column(name = "supplier_city_id")
	private int supplier_city_id;

	@Column(name = "cpf_cnpj_select")
	private String cpf_cnpj_select;

	@Column(name = "zip_code")
	private int zipCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_city")
	private Cities cities;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_state")
	private States states;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_subsidiary_supplier")
	private CompanySubsidiaries companySubsidiaries;

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<Products> products = new HashSet<>(0);*/


	public Suppliers() {

	}


	public Suppliers(Long id, String supplier_name, String contact_name, String email, String phone_number_1, String phone_number_2, String cpf_cnpj,
			String adress, int supplier_state_id, int supplier_city_id, String cpf_cnpj_select, int zipCode, Cities cities, States states,
			CompanySubsidiaries companySubsidiaries) {
		super();
		this.id = id;
		this.supplier_name = supplier_name;
		this.contact_name = contact_name;
		this.email = email;
		this.phone_number_1 = phone_number_1;
		this.phone_number_2 = phone_number_2;
		this.cpf_cnpj = cpf_cnpj;
		this.adress = adress;
		this.supplier_state_id = supplier_state_id;
		this.supplier_city_id = supplier_city_id;
		this.cpf_cnpj_select = cpf_cnpj_select;
		this.zipCode = zipCode;
		this.cities = cities;
		this.states = states;
		this.companySubsidiaries = companySubsidiaries;
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
		if (!(obj instanceof Suppliers)) {
		return false;
		}
		Suppliers other = (Suppliers) obj;
		if (adress == null) {
		if (other.adress != null) {
		return false;
		}
		} else if (!adress.equals(other.adress)) {
		return false;
		}
		if (cities == null) {
		if (other.cities != null) {
		return false;
		}
		} else if (!cities.equals(other.cities)) {
		return false;
		}
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (contact_name == null) {
		if (other.contact_name != null) {
		return false;
		}
		} else if (!contact_name.equals(other.contact_name)) {
		return false;
		}
		if (cpf_cnpj == null) {
		if (other.cpf_cnpj != null) {
		return false;
		}
		} else if (!cpf_cnpj.equals(other.cpf_cnpj)) {
		return false;
		}
		if (cpf_cnpj_select == null) {
		if (other.cpf_cnpj_select != null) {
		return false;
		}
		} else if (!cpf_cnpj_select.equals(other.cpf_cnpj_select)) {
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
		if (phone_number_1 == null) {
		if (other.phone_number_1 != null) {
		return false;
		}
		} else if (!phone_number_1.equals(other.phone_number_1)) {
		return false;
		}
		if (phone_number_2 == null) {
		if (other.phone_number_2 != null) {
		return false;
		}
		} else if (!phone_number_2.equals(other.phone_number_2)) {
		return false;
		}
		if (states == null) {
		if (other.states != null) {
		return false;
		}
		} else if (!states.equals(other.states)) {
		return false;
		}
		if (supplier_city_id != other.supplier_city_id) {
		return false;
		}
		if (supplier_name == null) {
		if (other.supplier_name != null) {
		return false;
		}
		} else if (!supplier_name.equals(other.supplier_name)) {
		return false;
		}
		if (supplier_state_id != other.supplier_state_id) {
		return false;
		}
		if (zipCode != other.zipCode) {
		return false;
		}
		return true;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @return the cities
	 */
	public Cities getCities() {
		return cities;
	}

	/**
	 * @return the companySubsidiaries
	 */
	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}

	/**
	 * @return the contact_name
	 */
	public String getContact_name() {
		return contact_name;
	}

	/**
	 * @return the cpf_cnpj
	 */
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	/**
	 * @return the cpf_cnpj_select
	 */
	public String getCpf_cnpj_select() {
		return cpf_cnpj_select;
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
	 * @return the phone_number_1
	 */
	public String getPhone_number_1() {
		return phone_number_1;
	}

	/**
	 * @return the phone_number_2
	 */
	public String getPhone_number_2() {
		return phone_number_2;
	}

	/**
	 * @return the states
	 */
	public States getStates() {
		return states;
	}

	/**
	 * @return the supplier_city_id
	 */
	public int getSupplier_city_id() {
		return supplier_city_id;
	}

	/**
	 * @return the supplier_name
	 */
	public String getSupplier_name() {
		return supplier_name;
	}

	/**
	 * @return the supplier_state_id
	 */
	public int getSupplier_state_id() {
		return supplier_state_id;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		//result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((contact_name == null) ? 0 : contact_name.hashCode());
		result = prime * result + ((cpf_cnpj == null) ? 0 : cpf_cnpj.hashCode());
		result = prime * result + ((cpf_cnpj_select == null) ? 0 : cpf_cnpj_select.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phone_number_1 == null) ? 0 : phone_number_1.hashCode());
		result = prime * result + ((phone_number_2 == null) ? 0 : phone_number_2.hashCode());
		result = prime * result + ((states == null) ? 0 : states.hashCode());
		result = prime * result + supplier_city_id;
		result = prime * result + ((supplier_name == null) ? 0 : supplier_name.hashCode());
		result = prime * result + supplier_state_id;
		result = prime * result + zipCode;
		return result;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(Cities cities) {
		this.cities = cities;
	}

	/**
	 * @param companySubsidiaries the companySubsidiaries to set
	 */
	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}

	/**
	 * @param contact_name the contact_name to set
	 */
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	/**
	 * @param cpf_cnpj the cpf_cnpj to set
	 */
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	/**
	 * @param cpf_cnpj_select the cpf_cnpj_select to set
	 */
	public void setCpf_cnpj_select(String cpf_cnpj_select) {
		this.cpf_cnpj_select = cpf_cnpj_select;
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
	 * @param phone_number_1 the phone_number_1 to set
	 */
	public void setPhone_number_1(String phone_number_1) {
		this.phone_number_1 = phone_number_1;
	}

	/**
	 * @param phone_number_2 the phone_number_2 to set
	 */
	public void setPhone_number_2(String phone_number_2) {
		this.phone_number_2 = phone_number_2;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(States states) {
		this.states = states;
	}

	/**
	 * @param supplier_city_id the supplier_city_id to set
	 */
	public void setSupplier_city_id(int supplier_city_id) {
		this.supplier_city_id = supplier_city_id;
	}

	/**
	 * @param supplier_name the supplier_name to set
	 */
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	/**
	 * @param supplier_state_id the supplier_state_id to set
	 */
	public void setSupplier_state_id(int supplier_state_id) {
		this.supplier_state_id = supplier_state_id;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "Suppliers [id=" + id + ", supplier_name=" + supplier_name + ", contact_name=" + contact_name + ", email=" + email
				+ ", phone_number_1=" + phone_number_1 + ", phone_number_2=" + phone_number_2 + ", cpf_cnpj=" + cpf_cnpj + ", adress=" + adress
				+ ", supplier_city_id=" + supplier_city_id + ", supplier_state_id=" + supplier_state_id + ", cities=" + cities + ", states=" + states
				+ ", companySubsidiaries=" + companySubsidiaries + ", getId()=" + getId() + ", getSupplier_name()=" + getSupplier_name()
				+ ", getContact_name()=" + getContact_name() + ", getEmail()=" + getEmail() + ", getPhone_number_1()=" + getPhone_number_1()
				+ ", getPhone_number_2()=" + getPhone_number_2() + ", getCpf_cnpj()=" + getCpf_cnpj() + ", getAdress()=" + getAdress()
				+ ", getSupplier_city_id()=" + getSupplier_city_id() + ", getSupplier_state_id()=" + getSupplier_state_id() + ", getCities()="
				+ getCities() + ", getStates()=" + getStates() + ", getCompanySubsidiaries()=" + getCompanySubsidiaries() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/

}

