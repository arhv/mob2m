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

@Entity(name = "tbl_agenda_subsidiary")
@Table(schema = "hairdressing_master")
public class AgendaSubsidiary implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agenda_date_id")
	private AgendaDate agendaDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agendaSubsidiary")
	private Set<AgendaMaster> agendaMaster = new HashSet<>(0);

	public AgendaSubsidiary() {

	}

	public AgendaSubsidiary(Long id, AgendaDate agendaDate, CompanySubsidiaries companySubsidiaries, Set<AgendaMaster> agendaMaster) {
		super();
		this.id = id;
		this.agendaDate = agendaDate;
		this.companySubsidiaries = companySubsidiaries;
		this.agendaMaster = agendaMaster;
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
		if (!(obj instanceof AgendaSubsidiary)) {
		return false;
		}
		AgendaSubsidiary other = (AgendaSubsidiary) obj;
		if (agendaDate == null) {
		if (other.agendaDate != null) {
		return false;
		}
		} else if (!agendaDate.equals(other.agendaDate)) {
		return false;
		}
		if (agendaMaster == null) {
		if (other.agendaMaster != null) {
		return false;
		}
		} else if (!agendaMaster.equals(other.agendaMaster)) {
		return false;
		}
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
		return true;
	}

	/**
	 * @return the agendaDate
	 */
	public AgendaDate getAgendaDate() {
		return agendaDate;
	}

	/**
	 * @return the agendaMaster
	 */
	public Set<AgendaMaster> getAgendaMaster() {
		return agendaMaster;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaDate == null) ? 0 : agendaDate.hashCode());
		result = prime * result + ((agendaMaster == null) ? 0 : agendaMaster.hashCode());
		result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * @param agendaDate the agendaDate to set
	 */
	public void setAgendaDate(AgendaDate agendaDate) {
		this.agendaDate = agendaDate;
	}

	/**
	 * @param agendaMaster the agendaMaster to set
	 */
	public void setAgendaMaster(Set<AgendaMaster> agendaMaster) {
		this.agendaMaster = agendaMaster;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgendaSubsidiary [id=" + id + ", agendaDate=" + agendaDate + ", companySubsidiaries=" + companySubsidiaries + ", agendaMaster="
				+ agendaMaster + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}

