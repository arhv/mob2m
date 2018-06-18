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


@Entity(name = "tbl_payments_types")
@Table(schema = "hairdressing_master")
public class ComandasPaymentsTypes implements Serializable {

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

	@Column(name = "payment_type")
	private String payment_type;

	@Column(name = "tax_percentage")
	private double tax_percentage;

	@Column(name = "compensation_days")
	private int compensation_days;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentsTypes")
	private Set<ComandasReceivables> comandasReceivables = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comandasPaymentsTypes")
	private Set<ComandasExpensesServices> comandasExpenses = new HashSet<>(0);

	public ComandasPaymentsTypes() {

	}

	public ComandasPaymentsTypes(Long id, CompanySubsidiaries companySubsidiaries, String payment_type,
			double tax_percentage, int compensation_days, Set<ComandasReceivables> comandasReceivables,
			Set<ComandasExpensesServices> comandasExpenses) {
		super();
		this.id = id;
		this.companySubsidiaries = companySubsidiaries;
		this.payment_type = payment_type;
		this.tax_percentage = tax_percentage;
		this.compensation_days = compensation_days;
		this.comandasReceivables = comandasReceivables;
		this.comandasExpenses = comandasExpenses;
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
		ComandasPaymentsTypes other = (ComandasPaymentsTypes) obj;
		if (comandasExpenses == null) {
		if (other.comandasExpenses != null) {
		return false;
		}
		} else if (!comandasExpenses.equals(other.comandasExpenses)) {
		return false;
		}
		if (comandasReceivables == null) {
		if (other.comandasReceivables != null) {
		return false;
		}
		} else if (!comandasReceivables.equals(other.comandasReceivables)) {
		return false;
		}
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (compensation_days != other.compensation_days) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (payment_type == null) {
		if (other.payment_type != null) {
		return false;
		}
		} else if (!payment_type.equals(other.payment_type)) {
		return false;
		}
		if (Double.doubleToLongBits(tax_percentage) != Double.doubleToLongBits(other.tax_percentage)) {
		return false;
		}
		return true;
	}

	public Set<ComandasExpensesServices> getComandasExpenses() {
		return comandasExpenses;
	}

	public Set<ComandasReceivables> getComandasReceivables() {
		return comandasReceivables;
	}

	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}

	public int getCompensation_days() {
		return compensation_days;
	}

	public Long getId() {
		return id;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public double getTax_percentage() {
		return tax_percentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((comandasExpenses == null) ? 0 : comandasExpenses.hashCode());
		//result = prime * result + ((comandasReceivables == null) ? 0 : comandasReceivables.hashCode());
		//result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + compensation_days;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((payment_type == null) ? 0 : payment_type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tax_percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public void setComandasExpenses(Set<ComandasExpensesServices> comandasExpenses) {
		this.comandasExpenses = comandasExpenses;
	}

	public void setComandasReceivables(Set<ComandasReceivables> comandasReceivables) {
		this.comandasReceivables = comandasReceivables;
	}

	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}

	public void setCompensation_days(int compensation_days) {
		this.compensation_days = compensation_days;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public void setTax_percentage(double tax_percentage) {
		this.tax_percentage = tax_percentage;
	}

	@Override
	public String toString() {
		return "ComandasPaymentsTypes [id=" + id + ", companySubsidiaries=" + companySubsidiaries + ", payment_type="
				+ payment_type + ", tax_percentage=" + tax_percentage + ", compensation_days=" + compensation_days
				+ ", comandasReceivables=" + comandasReceivables + ", comandasExpenses=" + comandasExpenses
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}	




}

