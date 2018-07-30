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

@Entity(name = "tbl_agenda_master")
@Table(schema = "hairdressing_master")
public class AgendaMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agenda_subsidiary_id")
	private AgendaSubsidiary agendaSubsidiary;	

	@Column(name = "priority_list")
	private int priority_list;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_principal")
	private Professionals professionals;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agendaMaster")
	private Set<AgendaDetails> agendaDetails = new HashSet<>(0);

	public AgendaMaster() {

	}

	public AgendaMaster(Long id, AgendaSubsidiary agendaSubsidiary, int priority_list, Professionals professionals,
			Set<AgendaDetails> agendaDetails) {
		super();
		this.id = id;
		this.agendaSubsidiary = agendaSubsidiary;
		this.priority_list = priority_list;
		this.professionals = professionals;
		this.agendaDetails = agendaDetails;
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
		if (!(obj instanceof AgendaMaster)) {
		return false;
		}
		AgendaMaster other = (AgendaMaster) obj;
		if (agendaDetails == null) {
		if (other.agendaDetails != null) {
		return false;
		}
		} else if (!agendaDetails.equals(other.agendaDetails)) {
		return false;
		}
		if (agendaSubsidiary == null) {
		if (other.agendaSubsidiary != null) {
		return false;
		}
		} else if (!agendaSubsidiary.equals(other.agendaSubsidiary)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (priority_list != other.priority_list) {
		return false;
		}
		if (professionals == null) {
		if (other.professionals != null) {
		return false;
		}
		} else if (!professionals.equals(other.professionals)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the agendaDetails
	 */
	public Set<AgendaDetails> getAgendaDetails() {
		return agendaDetails;
	}

	/**
	 * @return the agendaSubsidiary
	 */
	public AgendaSubsidiary getAgendaSubsidiary() {
		return agendaSubsidiary;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the priority_list
	 */
	public int getPriority_list() {
		return priority_list;
	}

	/**
	 * @return the professionals
	 */
	public Professionals getProfessionals() {
		return professionals;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaDetails == null) ? 0 : agendaDetails.hashCode());
		result = prime * result + ((agendaSubsidiary == null) ? 0 : agendaSubsidiary.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + priority_list;
		result = prime * result + ((professionals == null) ? 0 : professionals.hashCode());
		return result;
	}

	/**
	 * @param agendaDetails the agendaDetails to set
	 */
	public void setAgendaDetails(Set<AgendaDetails> agendaDetails) {
		this.agendaDetails = agendaDetails;
	}

	/**
	 * @param agendaSubsidiary the agendaSubsidiary to set
	 */
	public void setAgendaSubsidiary(AgendaSubsidiary agendaSubsidiary) {
		this.agendaSubsidiary = agendaSubsidiary;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param priority_list the priority_list to set
	 */
	public void setPriority_list(int priority_list) {
		this.priority_list = priority_list;
	}

	/**
	 * @param professionals the professionals to set
	 */
	public void setProfessionals(Professionals professionals) {
		this.professionals = professionals;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgendaMaster [id=" + id + ", agendaSubsidiary=" + agendaSubsidiary + ", priority_list=" + priority_list + ", professionals="
				+ professionals + ", agendaDetails=" + agendaDetails + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}


}

