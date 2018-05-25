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


@Entity(name = "tbl_cidades")
@Table(schema = "hairdressing_master")
public class Cities implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "estados_cod_estados")
	private int estados_cod_estados;

	@Id
	@Column(name = "cod_cidades")
	private int cod_cidades;

	@Column(name = "nome")
	private String cityName;

	@Column(name = "cep")
	private String cep;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cities")
	private Set<CompanySubsidiaries> companySubsidiariesRecordsCities = new HashSet<>(0);

	public Cities() {

	}

	public Cities(Long id, int estados_cod_estados, int cod_cidades, String cityName, String cep) {
		this.id = id;
		this.estados_cod_estados = estados_cod_estados;
		this.cod_cidades = cod_cidades;
		this.cityName = cityName;
		this.cep = cep;
	}

	public Cities(Long id, int estados_cod_estados, int cod_cidades, String cityName, String cep,
			Set<CompanySubsidiaries> companySubsidiariesRecords) {
		this.id = id;
		this.estados_cod_estados = estados_cod_estados;
		this.cod_cidades = cod_cidades;
		this.cityName = cityName;
		this.cep = cep;
		this.companySubsidiariesRecordsCities = companySubsidiariesRecords;
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
		if (!(obj instanceof Cities)) {
		return false;
		}
		Cities other = (Cities) obj;
		if (cep == null) {
		if (other.cep != null) {
		return false;
		}
		} else if (!cep.equals(other.cep)) {
		return false;
		}
		if (cityName == null) {
		if (other.cityName != null) {
		return false;
		}
		} else if (!cityName.equals(other.cityName)) {
		return false;
		}
		if (cod_cidades != other.cod_cidades) {
		return false;
		}
		if (companySubsidiariesRecordsCities == null) {
		if (other.companySubsidiariesRecordsCities != null) {
		return false;
		}
		} else if (!companySubsidiariesRecordsCities.equals(other.companySubsidiariesRecordsCities)) {
		return false;
		}
		if (estados_cod_estados != other.estados_cod_estados) {
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
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @return the cod_cidades
	 */
	public int getCod_cidades() {
		return cod_cidades;
	}

	/**
	 * @return the companySubsidiariesRecords
	 */
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbl_cidades")
	public Set<CompanySubsidiaries> getCompanySubsidiariesRecords() {
		return companySubsidiariesRecordsCities;
	}

	/**
	 * @return the estados_cod_estados
	 */
	public int getEstados_cod_estados() {
		return estados_cod_estados;
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
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + cod_cidades;
		result = prime * result + ((companySubsidiariesRecordsCities == null) ? 0 : companySubsidiariesRecordsCities.hashCode());
		result = prime * result + estados_cod_estados;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @param cod_cidades the cod_cidades to set
	 */
	public void setCod_cidades(int cod_cidades) {
		this.cod_cidades = cod_cidades;
	}

	/**
	 * @param companySubsidiariesRecords the companySubsidiariesRecords to set
	 */
	public void setCompanySubsidiariesRecords(Set<CompanySubsidiaries> companySubsidiariesRecords) {
		this.companySubsidiariesRecordsCities = companySubsidiariesRecords;
	}

	/**
	 * @param estados_cod_estados the estados_cod_estados to set
	 */
	public void setEstados_cod_estados(int estados_cod_estados) {
		this.estados_cod_estados = estados_cod_estados;
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
		return "Cities [id=" + id + ", estados_cod_estados=" + estados_cod_estados + ", cod_cidades=" + cod_cidades + ", cityName=" + cityName
				+ ", cep=" + cep + ", companySubsidiariesRecords=" + companySubsidiariesRecordsCities + ", getId()=" + getId()
				+ ", getEstados_cod_estados()=" + getEstados_cod_estados() + ", getCod_cidades()=" + getCod_cidades() + ", getCityName()="
				+ getCityName() + ", getCep()=" + getCep() + ", getCompanySubsidiariesRecords()=" + getCompanySubsidiariesRecords() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}

