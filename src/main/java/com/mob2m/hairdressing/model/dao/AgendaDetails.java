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

@Entity(name = "tbl_agenda_details")
@Table(schema = "hairdressing_master")
public class AgendaDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agenda_master_id")
	private AgendaMaster agendaMaster;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_name")
	private Customers customers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id")
	private Services services;

	@Column(name = "agenda_status")
	private String agenda_status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agendaDetails")
	private Set<AgendaDetailsTime> agendaDetailsTime = new HashSet<>(0);


	public AgendaDetails() {

	}


	public AgendaDetails(Long id, AgendaMaster agendaMaster, Customers customers, Services services, String agenda_status,
			Set<AgendaDetailsTime> agendaDetailsTime) {
		super();
		this.id = id;
		this.agendaMaster = agendaMaster;
		this.customers = customers;
		this.services = services;
		this.agenda_status = agenda_status;
		this.agendaDetailsTime = agendaDetailsTime;
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
		if (!(obj instanceof AgendaDetails)) {
		return false;
		}
		AgendaDetails other = (AgendaDetails) obj;
		if (agendaDetailsTime == null) {
		if (other.agendaDetailsTime != null) {
		return false;
		}
		} else if (!agendaDetailsTime.equals(other.agendaDetailsTime)) {
		return false;
		}
		if (agendaMaster == null) {
		if (other.agendaMaster != null) {
		return false;
		}
		} else if (!agendaMaster.equals(other.agendaMaster)) {
		return false;
		}
		if (agenda_status == null) {
		if (other.agenda_status != null) {
		return false;
		}
		} else if (!agenda_status.equals(other.agenda_status)) {
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
		if (services == null) {
		if (other.services != null) {
		return false;
		}
		} else if (!services.equals(other.services)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the agenda_status
	 */
	public String getAgenda_status() {
		return agenda_status;
	}

	/**
	 * @return the agendaDetailsTime
	 */
	public Set<AgendaDetailsTime> getAgendaDetailsTime() {
		return agendaDetailsTime;
	}

	/**
	 * @return the agendaMaster
	 */
	public AgendaMaster getAgendaMaster() {
		return agendaMaster;
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
	 * @return the services
	 */
	public Services getServices() {
		return services;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaDetailsTime == null) ? 0 : agendaDetailsTime.hashCode());
		result = prime * result + ((agendaMaster == null) ? 0 : agendaMaster.hashCode());
		result = prime * result + ((agenda_status == null) ? 0 : agenda_status.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		return result;
	}

	/**
	 * @param agenda_status the agenda_status to set
	 */
	public void setAgenda_status(String agenda_status) {
		this.agenda_status = agenda_status;
	}

	/**
	 * @param agendaDetailsTime the agendaDetailsTime to set
	 */
	public void setAgendaDetailsTime(Set<AgendaDetailsTime> agendaDetailsTime) {
		this.agendaDetailsTime = agendaDetailsTime;
	}

	/**
	 * @param agendaMaster the agendaMaster to set
	 */
	public void setAgendaMaster(AgendaMaster agendaMaster) {
		this.agendaMaster = agendaMaster;
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
	 * @param services the services to set
	 */
	public void setServices(Services services) {
		this.services = services;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgendaDetails [id=" + id + ", agendaMaster=" + agendaMaster + ", customers=" + customers + ", services=" + services
				+ ", agenda_status=" + agenda_status + ", agendaDetailsTime=" + agendaDetailsTime + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

}

