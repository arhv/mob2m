//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "tbl_agenda_details_time")
@Table(schema = "hairdressing_master")
public class AgendaDetailsTime implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agenda_details_id")
	private AgendaDetails agendaDetails;

	@Column(name = "order_time")
	private Date order_time;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "agenda_time")
	private Date agenda_time;

	@Column(name = "agenda_time_selected")
	private Boolean agenda_time_selected;

	public AgendaDetailsTime() {

	}

	public AgendaDetailsTime(Long id, AgendaDetails agendaDetails, Date order_time, Date agenda_time, Boolean agenda_time_selected) {
		super();
		this.id = id;
		this.agendaDetails = agendaDetails;
		this.order_time = order_time;
		this.agenda_time = agenda_time;
		this.agenda_time_selected = agenda_time_selected;
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
		if (!(obj instanceof AgendaDetailsTime)) {
		return false;
		}
		AgendaDetailsTime other = (AgendaDetailsTime) obj;
		if (agendaDetails == null) {
		if (other.agendaDetails != null) {
		return false;
		}
		} else if (!agendaDetails.equals(other.agendaDetails)) {
		return false;
		}
		if (agenda_time == null) {
		if (other.agenda_time != null) {
		return false;
		}
		} else if (!agenda_time.equals(other.agenda_time)) {
		return false;
		}
		if (agenda_time_selected == null) {
		if (other.agenda_time_selected != null) {
		return false;
		}
		} else if (!agenda_time_selected.equals(other.agenda_time_selected)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (order_time == null) {
		if (other.order_time != null) {
		return false;
		}
		} else if (!order_time.equals(other.order_time)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the agenda_time
	 */
	public Date getAgenda_time() {
		return agenda_time;
	}

	/**
	 * @return the agenda_time_selected
	 */
	public Boolean getAgenda_time_selected() {
		return agenda_time_selected;
	}

	/**
	 * @return the agendaDetails
	 */
	public AgendaDetails getAgendaDetails() {
		return agendaDetails;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the order_time
	 */
	public Date getOrder_time() {
		return order_time;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaDetails == null) ? 0 : agendaDetails.hashCode());
		result = prime * result + ((agenda_time == null) ? 0 : agenda_time.hashCode());
		result = prime * result + ((agenda_time_selected == null) ? 0 : agenda_time_selected.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order_time == null) ? 0 : order_time.hashCode());
		return result;
	}

	/**
	 * @param agenda_time the agenda_time to set
	 */
	public void setAgenda_time(Date agenda_time) {
		this.agenda_time = agenda_time;
	}

	/**
	 * @param agenda_time_selected the agenda_time_selected to set
	 */
	public void setAgenda_time_selected(Boolean agenda_time_selected) {
		this.agenda_time_selected = agenda_time_selected;
	}

	/**
	 * @param agendaDetails the agendaDetails to set
	 */
	public void setAgendaDetails(AgendaDetails agendaDetails) {
		this.agendaDetails = agendaDetails;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param order_time the order_time to set
	 */
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgendaDetailsTime [id=" + id + ", agendaDetails=" + agendaDetails + ", order_time=" + order_time + ", agenda_time=" + agenda_time
				+ ", agenda_time_selected=" + agenda_time_selected + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

}

