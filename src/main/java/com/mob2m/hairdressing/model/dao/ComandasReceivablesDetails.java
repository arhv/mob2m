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


@Entity(name = "tbl_comandas_receivables_details")
@Table(schema = "hairdressing_master")
public class ComandasReceivablesDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comandas_receivables_id")
	private ComandasReceivables comandasReceivables;

	@Column(name = "effective_receivable_value")
	private double effective_receivable_value;

	@Column(name = "effective_receivable_date")
	private Date effective_receivable_date;


	public ComandasReceivablesDetails() {

	}


	public ComandasReceivablesDetails(Long id, ComandasReceivables comandasReceivables,
			double effective_receivable_value, Date effective_receivable_date) {
		super();
		this.id = id;
		this.comandasReceivables = comandasReceivables;
		this.effective_receivable_value = effective_receivable_value;
		this.effective_receivable_date = effective_receivable_date;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
		return true;
		}
		if (obj == null) {
		return false;
		}
		if (getClass() != obj.getClass()) {
		return false;
		}
		ComandasReceivablesDetails other = (ComandasReceivablesDetails) obj;
		if (comandasReceivables == null) {
			if (other.comandasReceivables != null) {
			return false;
			}
		} else if (!comandasReceivables.equals(other.comandasReceivables)) {
		return false;
		}
		if (effective_receivable_date == null) {
			if (other.effective_receivable_date != null) {
			return false;
			}
		} else if (!effective_receivable_date.equals(other.effective_receivable_date)) {
		return false;
		}
		if (Double.doubleToLongBits(effective_receivable_value) != Double
				.doubleToLongBits(other.effective_receivable_value)) {
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

	

	public ComandasReceivables getComandasReceivables() {
		return comandasReceivables;
	}


	public Date getEffective_receivable_date() {
		return effective_receivable_date;
	}


	public double getEffective_receivable_value() {
		return effective_receivable_value;
	}


	public Long getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((comandasReceivables == null) ? 0 : comandasReceivables.hashCode());
		result = prime * result + ((effective_receivable_date == null) ? 0 : effective_receivable_date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(effective_receivable_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	public void setComandasReceivables(ComandasReceivables comandasReceivables) {
		this.comandasReceivables = comandasReceivables;
	}


	public void setEffective_receivable_date(Date effective_receivable_date) {
		this.effective_receivable_date = effective_receivable_date;
	}


	public void setEffective_receivable_value(double effective_receivable_value) {
		this.effective_receivable_value = effective_receivable_value;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ComandasReceivablesDetails [id=" + id + ", comandasReceivables=" + comandasReceivables
				+ ", effective_receivable_value=" + effective_receivable_value + ", effective_receivable_date="
				+ effective_receivable_date + ", hashCode()=" + hashCode() + ", getId()=" + getId()
				+ ", getComandasReceivables()=" + getComandasReceivables() + ", getEffective_receivable_value()="
				+ getEffective_receivable_value() + ", getEffective_receivable_date()=" + getEffective_receivable_date()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	

}

