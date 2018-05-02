//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String companySubsidiaryState;

	@Column(name = "company_subsidiary_city")
	private String companySubsidiaryCity;

	@Column(name = "company_name_id")
	private Long companyNameId;

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
		if (companySubsidiaryCity == null) {
		if (other.companySubsidiaryCity != null) {
		return false;
		}
		} else if (!companySubsidiaryCity.equals(other.companySubsidiaryCity)) {
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
		if (companySubsidiaryState == null) {
		if (other.companySubsidiaryState != null) {
		return false;
		}
		} else if (!companySubsidiaryState.equals(other.companySubsidiaryState)) {
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
		return true;
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
	public String getCompanySubsidiaryCity() {
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
	public String getCompanySubsidiaryState() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyNameId == null) ? 0 : companyNameId.hashCode());
		result = prime * result + ((companySubsidiaryAddress == null) ? 0 : companySubsidiaryAddress.hashCode());
		result = prime * result + ((companySubsidiaryCep == null) ? 0 : companySubsidiaryCep.hashCode());
		result = prime * result + ((companySubsidiaryCity == null) ? 0 : companySubsidiaryCity.hashCode());
		result = prime * result + ((companySubsidiaryCnpj == null) ? 0 : companySubsidiaryCnpj.hashCode());
		result = prime * result + ((companySubsidiaryName == null) ? 0 : companySubsidiaryName.hashCode());
		result = prime * result + ((companySubsidiaryState == null) ? 0 : companySubsidiaryState.hashCode());
		result = prime * result + ((companySubsidiaryType == null) ? 0 : companySubsidiaryType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
	public void setCompanySubsidiaryCity(String companySubsidiaryCity) {
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
	public void setCompanySubsidiaryState(String companySubsidiaryState) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanySubsidiaries [id=" + id + ", companySubsidiaryName=" + companySubsidiaryName + ", companySubsidiaryType="
				+ companySubsidiaryType + ", companySubsidiaryCnpj=" + companySubsidiaryCnpj + ", companySubsidiaryAddress="
				+ companySubsidiaryAddress + ", companySubsidiaryCep=" + companySubsidiaryCep + ", companySubsidiaryState=" + companySubsidiaryState
				+ ", companySubsidiaryCity=" + companySubsidiaryCity + ", companyNameId=" + companyNameId + ", getId()=" + getId()
				+ ", getCompanySubsidiaryName()=" + getCompanySubsidiaryName() + ", getCompanySubsidiaryType()=" + getCompanySubsidiaryType()
				+ ", getCompanySubsidiaryCnpj()=" + getCompanySubsidiaryCnpj() + ", getCompanySubsidiaryAddress()=" + getCompanySubsidiaryAddress()
				+ ", getCompanySubsidiaryCep()=" + getCompanySubsidiaryCep() + ", getCompanySubsidiaryState()=" + getCompanySubsidiaryState()
				+ ", getCompanySubsidiaryCity()=" + getCompanySubsidiaryCity() + ", getCompanyNameId()=" + getCompanyNameId() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


}

