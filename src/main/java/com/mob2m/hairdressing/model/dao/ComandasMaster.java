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

	@Column(name = "status")
	private String status;

	@Column(name = "comanda_type")
	private String comanda_type;

	@Column(name = "customer_name_id")
	private String customer_name_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_name")
	private Customers customers;

	public ComandasMaster() {

	}

	public ComandasMaster(Long id, String status, String comanda_type, String customer_name_id, Customers customers) {
		super();
		this.id = id;
		this.status = status;
		this.comanda_type = comanda_type;
		this.customer_name_id = customer_name_id;
		this.customers = customers;
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
		if (customers == null) {
		if (other.customers != null) {
		return false;
		}
		} else if (!customers.equals(other.customers)) {
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
	 * @return the customer_name_id
	 */
	public String getCustomer_name_id() {
		return customer_name_id;
	}

	/**
	 * @return the customers
	 */
	public Customers getCustomers() {
		return customers;
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
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
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
	 * @param customer_name_id the customer_name_id to set
	 */
	public void setCustomer_name_id(String customer_name_id) {
		this.customer_name_id = customer_name_id;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(Customers customers) {
		this.customers = customers;
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
		return "ComandasMaster [id=" + id + ", status=" + status + ", comanda_type=" + comanda_type + ", customers=" + customers + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/


}

