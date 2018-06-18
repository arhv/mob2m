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


@Entity(name = "tbl_comandas_receivables")
@Table(schema = "hairdressing_master")
public class ComandasReceivables implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

	@Column(name = "comanda_id")
	private Long comanda_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_type")
	private ComandasPaymentsTypes paymentsTypes;

	@Column(name = "number_parcels")
	private int number_parcels;

	@Column(name = "total_receivable_value")
	private double total_receivable_value;

	@Column(name = "receivable_date")
	private Date receivable_date;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comandasReceivables")
	private Set<ComandasReceivablesDetails> comandasReceivablesDetails = new HashSet<>(0);



	public ComandasReceivables() {

	}


	public ComandasReceivables(Long id, CompanySubsidiaries companySubsidiaries, Long comanda_id,
			ComandasPaymentsTypes paymentsTypes, int number_parcels, double total_receivable_value,
			Date receivable_date, Set<ComandasReceivablesDetails> comandasReceivablesDetails) {
		super();
		this.id = id;
		this.companySubsidiaries = companySubsidiaries;
		this.comanda_id = comanda_id;
		this.paymentsTypes = paymentsTypes;
		this.number_parcels = number_parcels;
		this.total_receivable_value = total_receivable_value;
		this.receivable_date = receivable_date;
		this.comandasReceivablesDetails = comandasReceivablesDetails;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}


	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}


	public Long getComanda_id() {
		return comanda_id;
	}


	public void setComanda_id(Long comanda_id) {
		this.comanda_id = comanda_id;
	}


	public ComandasPaymentsTypes getPaymentsTypes() {
		return paymentsTypes;
	}


	public void setPaymentsTypes(ComandasPaymentsTypes paymentsTypes) {
		this.paymentsTypes = paymentsTypes;
	}


	public int getNumber_parcels() {
		return number_parcels;
	}


	public void setNumber_parcels(int number_parcels) {
		this.number_parcels = number_parcels;
	}


	public double getTotal_receivable_value() {
		return total_receivable_value;
	}


	public void setTotal_receivable_value(double total_receivable_value) {
		this.total_receivable_value = total_receivable_value;
	}


	public Date getReceivable_date() {
		return receivable_date;
	}


	public void setReceivable_date(Date receivable_date) {
		this.receivable_date = receivable_date;
	}


	public Set<ComandasReceivablesDetails> getComandasReceivablesDetails() {
		return comandasReceivablesDetails;
	}


	public void setComandasReceivablesDetails(Set<ComandasReceivablesDetails> comandasReceivablesDetails) {
		this.comandasReceivablesDetails = comandasReceivablesDetails;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda_id == null) ? 0 : comanda_id.hashCode());
		result = prime * result + ((comandasReceivablesDetails == null) ? 0 : comandasReceivablesDetails.hashCode());
		result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + number_parcels;
		result = prime * result + ((paymentsTypes == null) ? 0 : paymentsTypes.hashCode());
		result = prime * result + ((receivable_date == null) ? 0 : receivable_date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total_receivable_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComandasReceivables other = (ComandasReceivables) obj;
		if (comanda_id == null) {
			if (other.comanda_id != null)
				return false;
		} else if (!comanda_id.equals(other.comanda_id))
			return false;
		if (comandasReceivablesDetails == null) {
			if (other.comandasReceivablesDetails != null)
				return false;
		} else if (!comandasReceivablesDetails.equals(other.comandasReceivablesDetails))
			return false;
		if (companySubsidiaries == null) {
			if (other.companySubsidiaries != null)
				return false;
		} else if (!companySubsidiaries.equals(other.companySubsidiaries))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number_parcels != other.number_parcels)
			return false;
		if (paymentsTypes == null) {
			if (other.paymentsTypes != null)
				return false;
		} else if (!paymentsTypes.equals(other.paymentsTypes))
			return false;
		if (receivable_date == null) {
			if (other.receivable_date != null)
				return false;
		} else if (!receivable_date.equals(other.receivable_date))
			return false;
		if (Double.doubleToLongBits(total_receivable_value) != Double.doubleToLongBits(other.total_receivable_value))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ComandasReceivables [id=" + id + ", companySubsidiaries=" + companySubsidiaries + ", comanda_id="
				+ comanda_id + ", paymentsTypes=" + paymentsTypes + ", number_parcels=" + number_parcels
				+ ", total_receivable_value=" + total_receivable_value + ", receivable_date=" + receivable_date
				+ ", comandasReceivablesDetails=" + comandasReceivablesDetails + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	

}

