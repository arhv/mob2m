//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_company_names")
@Table(schema = "hairdressing_master")
public class CompanyNames implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_name", unique = true)
	private String companyName;

	@Column(name = "email_master", unique = true)
	private String emailMaster;

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
		if (!(obj instanceof CompanyNames)) {
		return false;
		}
		CompanyNames other = (CompanyNames) obj;
		if (companyName == null) {
		if (other.companyName != null) {
		return false;
		}
		} else if (!companyName.equals(other.companyName)) {
		return false;
		}
		if (emailMaster == null) {
		if (other.emailMaster != null) {
		return false;
		}
		} else if (!emailMaster.equals(other.emailMaster)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @return the emailMaster
	 */
	public String getEmailMaster() {
		return emailMaster;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((emailMaster == null) ? 0 : emailMaster.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @param emailMaster the emailMaster to set
	 */
	public void setEmailMaster(String emailMaster) {
		this.emailMaster = emailMaster;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyNames [id=" + id + ", companyName=" + companyName + ", emailMaster=" + emailMaster + ", getId()=" + getId()
		+ ", getCompanyName()=" + getCompanyName() + ", getEmailMaster()=" + getEmailMaster() + ", hashCode()=" + hashCode() + ", getClass()="
		+ getClass() + ", toString()=" + super.toString() + "]";
	}


}

