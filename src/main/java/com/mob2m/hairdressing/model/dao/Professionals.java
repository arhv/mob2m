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

@Entity(name = "tbl_professionals")
@Table(schema = "hairdressing_master")
public class Professionals implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username_code")
	private String username_code;

	/*@Column(name = "company_subsidiary_id")
	private int company_subsidiary_id;*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionals")
	private Set<ComandasDetails> comandasDetails = new HashSet<>(0);


	public Professionals() {

	}

	public Professionals(Long id, String username_code, CompanySubsidiaries companySubsidiaries, Set<ComandasDetails> comandasDetails) {
		super();
		this.id = id;
		this.username_code = username_code;
		this.companySubsidiaries = companySubsidiaries;
		this.comandasDetails = comandasDetails;
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
		if (!(obj instanceof Professionals)) {
		return false;
		}
		Professionals other = (Professionals) obj;
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (username_code == null) {
		if (other.username_code != null) {
		return false;
		}
		} else if (!username_code.equals(other.username_code)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the comandasDetails
	 */
	public Set<ComandasDetails> getComandasDetails() {
		return comandasDetails;
	}

	/**
	 * @return the companySubsidiaries
	 */
	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @return the username_code
	 */
	public String getUsername_code() {
		return username_code;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username_code == null) ? 0 : username_code.hashCode());
		return result;
	}


	/**
	 * @param comandasDetails the comandasDetails to set
	 */
	public void setComandasDetails(Set<ComandasDetails> comandasDetails) {
		this.comandasDetails = comandasDetails;
	}


	/**
	 * @param companySubsidiaries the companySubsidiaries to set
	 */
	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @param username_code the username_code to set
	 */
	public void setUsername_code(String username_code) {
		this.username_code = username_code;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Professionals [id=" + id + ", username_code=" + username_code + ", companySubsidiaries=" + companySubsidiaries + ", comandasDetails="
				+ comandasDetails + ", getComandasDetails()=" + getComandasDetails() + ", getCompanySubsidiaries()=" + getCompanySubsidiaries()
				+ ", getId()=" + getId() + ", getUsername_code()=" + getUsername_code() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}


}

