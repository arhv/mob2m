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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "tbl_estados")
@Table(schema = "hairdressing_master")
public class States implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Id
	@Column(name = "cod_estados")
	private int cod_estados;

	@Column(name = "sigla")
	private String sigla;

	@Column(name = "nome")
	private String stateName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "states")
	private Set<CompanySubsidiaries> companySubsidiariesRecordsStates = new HashSet<>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "states")
	private Set<Customers> customersStates = new HashSet<>(0);

	public States() {

	}

	public States(int id, int cod_estados, String sigla, String stateName, Set<CompanySubsidiaries> companySubsidiariesRecordsStates,
			Set<Customers> customersStates) {
		super();
		this.id = id;
		this.cod_estados = cod_estados;
		this.sigla = sigla;
		this.stateName = stateName;
		this.companySubsidiariesRecordsStates = companySubsidiariesRecordsStates;
		this.customersStates = customersStates;
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
		if (!(obj instanceof States)) {
		return false;
		}
		States other = (States) obj;
		if (cod_estados != other.cod_estados) {
		return false;
		}
		if (companySubsidiariesRecordsStates == null) {
		if (other.companySubsidiariesRecordsStates != null) {
		return false;
		}
		} else if (!companySubsidiariesRecordsStates.equals(other.companySubsidiariesRecordsStates)) {
		return false;
		}
		if (customersStates == null) {
		if (other.customersStates != null) {
		return false;
		}
		} else if (!customersStates.equals(other.customersStates)) {
		return false;
		}
		if (id != other.id) {
		return false;
		}
		if (sigla == null) {
		if (other.sigla != null) {
		return false;
		}
		} else if (!sigla.equals(other.sigla)) {
		return false;
		}
		if (stateName == null) {
		if (other.stateName != null) {
		return false;
		}
		} else if (!stateName.equals(other.stateName)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the cod_estados
	 */
	public int getCod_estados() {
		return cod_estados;
	}

	/**
	 * @return the companySubsidiariesRecordsStates
	 */
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbl_estados")
	public Set<CompanySubsidiaries> getCompanySubsidiariesRecordsStates() {
		return companySubsidiariesRecordsStates;
	}

	/**
	 * @return the customersStates
	 */
	public Set<Customers> getCustomersStates() {
		return customersStates;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_estados;
		result = prime * result + ((companySubsidiariesRecordsStates == null) ? 0 : companySubsidiariesRecordsStates.hashCode());
		result = prime * result + ((customersStates == null) ? 0 : customersStates.hashCode());
		result = prime * result + id;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
		return result;
	}

	/**
	 * @param cod_estados the cod_estados to set
	 */
	public void setCod_estados(int cod_estados) {
		this.cod_estados = cod_estados;
	}

	/**
	 * @param companySubsidiariesRecordsStates the companySubsidiariesRecordsStates to set
	 */
	public void setCompanySubsidiariesRecordsStates(Set<CompanySubsidiaries> companySubsidiariesRecordsStates) {
		this.companySubsidiariesRecordsStates = companySubsidiariesRecordsStates;
	}

	/**
	 * @param customersStates the customersStates to set
	 */
	public void setCustomersStates(Set<Customers> customersStates) {
		this.customersStates = customersStates;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "States [id=" + id + ", cod_estados=" + cod_estados + ", sigla=" + sigla + ", stateName=" + stateName
				+ ", companySubsidiariesRecordsStates=" + companySubsidiariesRecordsStates + ", customersStates=" + customersStates
				+ ", getCustomersStates()=" + getCustomersStates() + ", getCod_estados()=" + getCod_estados()
				+ ", getCompanySubsidiariesRecordsStates()=" + getCompanySubsidiariesRecordsStates() + ", getId()=" + getId() + ", getSigla()="
				+ getSigla() + ", getStateName()=" + getStateName() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

}

