//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;
import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "tbl_comandas_master")
@Table(schema = "hairdressing_master")
public class ComandasMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date_comanda")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date date_comanda;

	@Column(name = "status")
	private String status;

	@Column(name = "comanda_type")
	private String comanda_type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_name")
	private Customers customers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comandasMaster")
	private Set<ComandasDetailsServices> comandasDetails = new HashSet<>(0);

	public ComandasMaster() {

	}


	public ComandasMaster(Long id, Date date_comanda, String status, String comanda_type, Customers customers,
			CompanySubsidiaries companySubsidiaries, Set<ComandasDetailsServices> comandasDetails) {
		super();
		this.id = id;
		this.date_comanda = date_comanda;
		this.status = status;
		this.comanda_type = comanda_type;
		this.customers = customers;
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
		if (!(obj instanceof ComandasMaster)) {
		return false;
		}
		ComandasMaster other = (ComandasMaster) obj;
		if (comanda_type == null) {
		if (other.comanda_type != null) {
		return false;
		}
		} else if (!comanda_type.equals(other.comanda_type)) {
		return false;
		}
		if (comandasDetails == null) {
		if (other.comandasDetails != null) {
		return false;
		}
		} else if (!comandasDetails.equals(other.comandasDetails)) {
		return false;
		}
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (customers == null) {
		if (other.customers != null) {
		return false;
		}
		} else if (!customers.equals(other.customers)) {
		return false;
		}
		if (date_comanda == null) {
		if (other.date_comanda != null) {
		return false;
		}
		} else if (!date_comanda.equals(other.date_comanda)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (status == null) {
		if (other.status != null) {
		return false;
		}
		} else if (!status.equals(other.status)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the comanda_type
	 */
	public String getComanda_type() {
		return comanda_type;
	}

	/**
	 * @return the comandasDetails
	 */
	public Set<ComandasDetailsServices> getComandasDetails() {
		return comandasDetails;
	}

	/**
	 * @return the companySubsidiaries
	 */
	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}

	/**
	 * @return the customers
	 */
	public Customers getCustomers() {
		return customers;
	}

	/**
	 * @return the date_comanda
	 */
	public Date getDate_comanda() {
		return date_comanda;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda_type == null) ? 0 : comanda_type.hashCode());
		result = prime * result + ((comandasDetails == null) ? 0 : comandasDetails.hashCode());
		//result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		//result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((date_comanda == null) ? 0 : date_comanda.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/**
	 * @param comanda_type the comanda_type to set
	 */
	public void setComanda_type(String comanda_type) {
		this.comanda_type = comanda_type;
	}

	/**
	 * @param comandasDetails the comandasDetails to set
	 */
	public void setComandasDetails(Set<ComandasDetailsServices> comandasDetails) {
		this.comandasDetails = comandasDetails;
	}

	/**
	 * @param companySubsidiaries the companySubsidiaries to set
	 */
	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	/**
	 * @param date_comanda the date_comanda to set
	 */
	public void setDate_comanda(Date date_comanda) {
		this.date_comanda = date_comanda;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "ComandasMaster [id=" + id + ", status=" + status + ", comanda_type=" + comanda_type + ", customers=" + customers
				+ ", companySubsidiaries=" + companySubsidiaries + ", comandasDetails=" + comandasDetails + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/


}

