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

	@Column(name = "value")
	private double value;

	@Column(name = "percentage_professional")
	private double percentage_professional;

	@Column(name = "percentage_aux_1")
	private double percentage_aux_1;

	@Column(name = "percentage_aux_2")
	private double percentage_aux_2;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_subsidiary_id")
	private CompanySubsidiaries companySubsidiaries;

	public Services() {

	}


	public Services(Long id, String service, double value, double percentage_professional, double percentage_aux_1, double percentage_aux_2,
			CompanySubsidiaries companySubsidiaries) {
		super();
		this.id = id;
		this.service = service;
		this.value = value;
		this.percentage_professional = percentage_professional;
		this.percentage_aux_1 = percentage_aux_1;
		this.percentage_aux_2 = percentage_aux_2;
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
		if (!(obj instanceof Services)) {
		return false;
		}
		Services other = (Services) obj;
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
		if (Double.doubleToLongBits(percentage_aux_1) != Double.doubleToLongBits(other.percentage_aux_1)) {
		return false;
		}
		if (Double.doubleToLongBits(percentage_aux_2) != Double.doubleToLongBits(other.percentage_aux_2)) {
		return false;
		}
		if (Double.doubleToLongBits(percentage_professional) != Double.doubleToLongBits(other.percentage_professional)) {
		return false;
		}
		if (service == null) {
		if (other.service != null) {
		return false;
		}
		} else if (!service.equals(other.service)) {
		return false;
		}
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
		return false;
		}
		return true;
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
	 * @return the percentage_aux_1
	 */
	public double getPercentage_aux_1() {
		return percentage_aux_1;
	}

	/**
	 * @return the percentage_aux_2
	 */
	public double getPercentage_aux_2() {
		return percentage_aux_2;
	}

	/**
	 * @return the percentage_professional
	 */
	public double getPercentage_professional() {
		return percentage_professional;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
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
		long temp;
		temp = Double.doubleToLongBits(percentage_aux_1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(percentage_aux_2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(percentage_professional);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
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
	 * @param percentage_aux_1 the percentage_aux_1 to set
	 */
	public void setPercentage_aux_1(double percentage_aux_1) {
		this.percentage_aux_1 = percentage_aux_1;
	}

	/**
	 * @param percentage_aux_2 the percentage_aux_2 to set
	 */
	public void setPercentage_aux_2(double percentage_aux_2) {
		this.percentage_aux_2 = percentage_aux_2;
	}

	/**
	 * @param percentage_professional the percentage_professional to set
	 */
	public void setPercentage_professional(double percentage_professional) {
		this.percentage_professional = percentage_professional;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "Services [id=" + id + ", service=" + service + ", value=" + value + ", percentage_professional=" + percentage_professional
				+ ", percentage_aux_1=" + percentage_aux_1 + ", percentage_aux_2=" + percentage_aux_2 + ", companySubsidiaries=" + companySubsidiaries
				+ ", getCompanySubsidiaries()=" + getCompanySubsidiaries() + ", getId()=" + getId() + ", getService()=" + getService()
				+ ", getValue()=" + getValue() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}*/


}

