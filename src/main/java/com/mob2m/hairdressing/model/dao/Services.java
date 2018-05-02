//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_services")
@Table(schema = "hairdressing_master")
public class Services implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "service")
	private String service;

	@Column(name = "companySubsidiaryId")
	private Long companySubsidiaryId;


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
		if (!(obj instanceof Services)) {
		return false;
		}
		Services other = (Services) obj;
		if (companySubsidiaryId == null) {
		if (other.companySubsidiaryId != null) {
		return false;
		}
		} else if (!companySubsidiaryId.equals(other.companySubsidiaryId)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (service == null) {
		if (other.service != null) {
		return false;
		}
		} else if (!service.equals(other.service)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the companySubsidiaryId
	 */
	public Long getCompanySubsidiaryId() {
		return companySubsidiaryId;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companySubsidiaryId == null) ? 0 : companySubsidiaryId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		return result;
	}

	/**
	 * @param companySubsidiaryId the companySubsidiaryId to set
	 */
	public void setCompanySubsidiaryId(Long companySubsidiaryId) {
		this.companySubsidiaryId = companySubsidiaryId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Services [id=" + id + ", service=" + service + ", companySubsidiaryId=" + companySubsidiaryId + ", getCompanySubsidiaryId()="
				+ getCompanySubsidiaryId() + ", getId()=" + getId() + ", getService()=" + getService() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}

