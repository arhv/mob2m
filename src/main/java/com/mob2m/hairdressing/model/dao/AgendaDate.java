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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "tbl_agenda_date")
@Table(schema = "hairdressing_master")
public class AgendaDate implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date_agenda")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_agenda;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agendaDate")
	private Set<AgendaSubsidiary> agendaSubsidiary = new HashSet<>(0);

	public AgendaDate() {

	}

	public AgendaDate(Long id, Date date_agenda, Set<AgendaSubsidiary> agendaSubsidiary) {
		super();
		this.id = id;
		this.date_agenda = date_agenda;
		this.agendaSubsidiary = agendaSubsidiary;
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
		if (!(obj instanceof AgendaDate)) {
		return false;
		}
		AgendaDate other = (AgendaDate) obj;
		if (agendaSubsidiary == null) {
		if (other.agendaSubsidiary != null) {
		return false;
		}
		} else if (!agendaSubsidiary.equals(other.agendaSubsidiary)) {
		return false;
		}
		if (date_agenda == null) {
		if (other.date_agenda != null) {
		return false;
		}
		} else if (!date_agenda.equals(other.date_agenda)) {
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
	 * @return the agendaSubsidiary
	 */
	public Set<AgendaSubsidiary> getAgendaSubsidiary() {
		return agendaSubsidiary;
	}

	/**
	 * @return the date_agenda
	 */
	public Date getDate_agenda() {
		return date_agenda;
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
		result = prime * result + ((agendaSubsidiary == null) ? 0 : agendaSubsidiary.hashCode());
		result = prime * result + ((date_agenda == null) ? 0 : date_agenda.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * @param agendaSubsidiary the agendaSubsidiary to set
	 */
	public void setAgendaSubsidiary(Set<AgendaSubsidiary> agendaSubsidiary) {
		this.agendaSubsidiary = agendaSubsidiary;
	}

	/**
	 * @param date_agenda the date_agenda to set
	 */
	public void setDate_agenda(Date date_agenda) {
		this.date_agenda = date_agenda;
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
		return "AgendaDate [id=" + id + ", date_agenda=" + date_agenda + ", agendaSubsidiary=" + agendaSubsidiary + ", hashCode()=" + hashCode()
		+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


}

