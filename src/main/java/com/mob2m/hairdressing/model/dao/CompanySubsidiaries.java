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

@Entity(name = "tbl_company_subsidiaries")
@Table(schema = "hairdressing_master")
public class CompanySubsidiaries implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_subsidiary_name")
	private String companySubsidiaryName;

	@Column(name = "company_subsidiary_type")
	private String companySubsidiaryType;

	@Column(name = "company_subsidiary_cnpj")
	private String companySubsidiaryCnpj;

	@Column(name = "company_subsidiary_address")
	private String companySubsidiaryAddress;

	@Column(name = "company_subsidiary_cep")
	private String companySubsidiaryCep;

	@Column(name = "company_subsidiary_state")
	private int companySubsidiaryState;

	@Column(name = "company_subsidiary_city")
	private int companySubsidiaryCity;

	@Column(name = "company_name_id")
	private Long companyNameId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_cidades")
	private Cities cities;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_estados")
	private States states;

	public CompanySubsidiaries() {}

	public CompanySubsidiaries(Long id, String companySubsidiaryName, String companySubsidiaryType, String companySubsidiaryCnpj,
			String companySubsidiaryAddress, String companySubsidiaryCep, int companySubsidiaryState, int companySubsidiaryCity, Long companyNameId,
			Cities cities, States states) {
		super();
		this.id = id;
		this.companySubsidiaryName = companySubsidiaryName;
		this.companySubsidiaryType = companySubsidiaryType;
		this.companySubsidiaryCnpj = companySubsidiaryCnpj;
		this.companySubsidiaryAddress = companySubsidiaryAddress;
		this.companySubsidiaryCep = companySubsidiaryCep;
		this.companySubsidiaryState = companySubsidiaryState;
		this.companySubsidiaryCity = companySubsidiaryCity;
		this.companyNameId = companyNameId;
		this.cities = cities;
		this.states = states;
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
		if (!(obj instanceof CompanySubsidiaries)) {
		return false;
		}
		CompanySubsidiaries other = (CompanySubsidiaries) obj;
		if (cities == null) {
		if (other.cities != null) {
		return false;
		}
		} else if (!cities.equals(other.cities)) {
		return false;
		}
		if (companyNameId == null) {
		if (other.companyNameId != null) {
		return false;
		}
		} else if (!companyNameId.equals(other.companyNameId)) {
		return false;
		}
		if (companySubsidiaryAddress == null) {
		if (other.companySubsidiaryAddress != null) {
		return false;
		}
		} else if (!companySubsidiaryAddress.equals(other.companySubsidiaryAddress)) {
		return false;
		}
		if (companySubsidiaryCep == null) {
		if (other.companySubsidiaryCep != null) {
		return false;
		}
		} else if (!companySubsidiaryCep.equals(other.companySubsidiaryCep)) {
		return false;
		}
		if (companySubsidiaryCity != other.companySubsidiaryCity) {
		return false;
		}
		if (companySubsidiaryCnpj == null) {
		if (other.companySubsidiaryCnpj != null) {
		return false;
		}
		} else if (!companySubsidiaryCnpj.equals(other.companySubsidiaryCnpj)) {
		return false;
		}
		if (companySubsidiaryName == null) {
		if (other.companySubsidiaryName != null) {
		return false;
		}
		} else if (!companySubsidiaryName.equals(other.companySubsidiaryName)) {
		return false;
		}
		if (companySubsidiaryState != other.companySubsidiaryState) {
		return false;
		}
		if (companySubsidiaryType == null) {
		if (other.companySubsidiaryType != null) {
		return false;
		}
		} else if (!companySubsidiaryType.equals(other.companySubsidiaryType)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (states == null) {
		if (other.states != null) {
		return false;
		}
		} else if (!states.equals(other.states)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the cities
	 */
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "cod_cidades")
	public Cities getCities() {
		return cities;
	}


	/**
	 * @return the companyNameId
	 */
	public Long getCompanyNameId() {
		return companyNameId;
	}

	/**
	 * @return the companySubsidiaryAddress
	 */
	public String getCompanySubsidiaryAddress() {
		return companySubsidiaryAddress;
	}

	/**
	 * @return the companySubsidiaryCep
	 */
	public String getCompanySubsidiaryCep() {
		return companySubsidiaryCep;
	}

	/**
	 * @return the companySubsidiaryCity
	 */
	public int getCompanySubsidiaryCity() {
		return companySubsidiaryCity;
	}

	/**
	 * @return the companySubsidiaryCnpj
	 */
	public String getCompanySubsidiaryCnpj() {
		return companySubsidiaryCnpj;
	}

	/**
	 * @return the companySubsidiaryName
	 */
	public String getCompanySubsidiaryName() {
		return companySubsidiaryName;
	}

	/**
	 * @return the companySubsidiaryState
	 */
	public int getCompanySubsidiaryState() {
		return companySubsidiaryState;
	}

	/**
	 * @return the companySubsidiaryType
	 */
	public String getCompanySubsidiaryType() {
		return companySubsidiaryType;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the states
	 */
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "cod_estados")
	public States getStates() {
		return states;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((companyNameId == null) ? 0 : companyNameId.hashCode());
		result = prime * result + ((companySubsidiaryAddress == null) ? 0 : companySubsidiaryAddress.hashCode());
		result = prime * result + ((companySubsidiaryCep == null) ? 0 : companySubsidiaryCep.hashCode());
		result = prime * result + companySubsidiaryCity;
		result = prime * result + ((companySubsidiaryCnpj == null) ? 0 : companySubsidiaryCnpj.hashCode());
		result = prime * result + ((companySubsidiaryName == null) ? 0 : companySubsidiaryName.hashCode());
		result = prime * result + companySubsidiaryState;
		result = prime * result + ((companySubsidiaryType == null) ? 0 : companySubsidiaryType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((states == null) ? 0 : states.hashCode());
		return result;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(Cities cities) {
		this.cities = cities;
	}

	/**
	 * @param companyNameId the companyNameId to set
	 */
	public void setCompanyNameId(Long companyNameId) {
		this.companyNameId = companyNameId;
	}

	/**
	 * @param companySubsidiaryAddress the companySubsidiaryAddress to set
	 */
	public void setCompanySubsidiaryAddress(String companySubsidiaryAddress) {
		this.companySubsidiaryAddress = companySubsidiaryAddress;
	}

	/**
	 * @param companySubsidiaryCep the companySubsidiaryCep to set
	 */
	public void setCompanySubsidiaryCep(String companySubsidiaryCep) {
		this.companySubsidiaryCep = companySubsidiaryCep;
	}

	/**
	 * @param companySubsidiaryCity the companySubsidiaryCity to set
	 */
	public void setCompanySubsidiaryCity(int companySubsidiaryCity) {
		this.companySubsidiaryCity = companySubsidiaryCity;
	}

	/**
	 * @param companySubsidiaryCnpj the companySubsidiaryCnpj to set
	 */
	public void setCompanySubsidiaryCnpj(String companySubsidiaryCnpj) {
		this.companySubsidiaryCnpj = companySubsidiaryCnpj;
	}

	/**
	 * @param companySubsidiaryName the companySubsidiaryName to set
	 */
	public void setCompanySubsidiaryName(String companySubsidiaryName) {
		this.companySubsidiaryName = companySubsidiaryName;
	}

	/**
	 * @param companySubsidiaryState the companySubsidiaryState to set
	 */
	public void setCompanySubsidiaryState(int companySubsidiaryState) {
		this.companySubsidiaryState = companySubsidiaryState;
	}

	/**
	 * @param companySubsidiaryType the companySubsidiaryType to set
	 */
	public void setCompanySubsidiaryType(String companySubsidiaryType) {
		this.companySubsidiaryType = companySubsidiaryType;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(States states) {
		this.states = states;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanySubsidiaries [id=" + id + ", companySubsidiaryName=" + companySubsidiaryName + ", companySubsidiaryType="
				+ companySubsidiaryType + ", companySubsidiaryCnpj=" + companySubsidiaryCnpj + ", companySubsidiaryAddress="
				+ companySubsidiaryAddress + ", companySubsidiaryCep=" + companySubsidiaryCep + ", companySubsidiaryState=" + companySubsidiaryState
				+ ", companySubsidiaryCity=" + companySubsidiaryCity + ", companyNameId=" + companyNameId + ", cities=" + cities + ", states="
				+ states + ", getStates()=" + getStates() + ", getId()=" + getId() + ", getCompanySubsidiaryName()=" + getCompanySubsidiaryName()
				+ ", getCompanySubsidiaryType()=" + getCompanySubsidiaryType() + ", getCompanySubsidiaryCnpj()=" + getCompanySubsidiaryCnpj()
				+ ", getCompanySubsidiaryAddress()=" + getCompanySubsidiaryAddress() + ", getCompanySubsidiaryCep()=" + getCompanySubsidiaryCep()
				+ ", getCompanySubsidiaryState()=" + getCompanySubsidiaryState() + ", getCompanySubsidiaryCity()=" + getCompanySubsidiaryCity()
				+ ", getCompanyNameId()=" + getCompanyNameId() + ", getCities()=" + getCities() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}


}

