package com.mob2m.hairdressing.model.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ProfessionalSelection {

	private Long professionalId;

	private Date startDate;

	private Date endDate;

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
		if (!(obj instanceof ProfessionalSelection)) {
		return false;
		}
		ProfessionalSelection other = (ProfessionalSelection) obj;
		if (endDate == null) {
		if (other.endDate != null) {
		return false;
		}
		} else if (!endDate.equals(other.endDate)) {
		return false;
		}
		if (professionalId == null) {
		if (other.professionalId != null) {
		return false;
		}
		} else if (!professionalId.equals(other.professionalId)) {
		return false;
		}
		if (startDate == null) {
		if (other.startDate != null) {
		return false;
		}
		} else if (!startDate.equals(other.startDate)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @return the professionalId
	 */
	public Long getProfessionalId() {
		return professionalId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((professionalId == null) ? 0 : professionalId.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param professionalId the professionalId to set
	 */
	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfessionalSelection [professionalId=" + professionalId + ", startDate=" + startDate + ", endDate=" + endDate + ", getEndDate()="
				+ getEndDate() + ", getProfessionalId()=" + getProfessionalId() + ", getStartDate()=" + getStartDate() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
