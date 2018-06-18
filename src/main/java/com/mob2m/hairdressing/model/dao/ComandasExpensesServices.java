package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "tbl_expenses_services")
@Table(schema = "hairdressing_master")
public class ComandasExpensesServices implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	private int id;		
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;
	
	@Column(name = "expense_type")
	private String expense_type;
	
	@Column(name = "comanda_id")
	private Long comanda_id;
	
	@Column(name = "payment_date")
	private Date payment_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_id")
	private Professionals professionals;
	
	@Column(name = "comanda_total_value")
	private double comanda_total_value;
	
	@Column(name = "professional_service_percentage")
	private double professional_service_percentage;	
	
	@Column(name = "professional_service_total_value")
	private double professional_service_total_value;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_type_id")
	private ComandasPaymentsTypes comandasPaymentsTypes;

	@Column(name = "payment_type_discount_percentage")
	private double payment_type_discount_percentage;
	
	@Column(name = "payment_type_discount_value")
	private double payment_type_discount_value;
	
	@Column(name = "total_professional_discounted")
	private double total_professional_discounted;		
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customers customers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id")
	private Services services;		
	

	public ComandasExpensesServices() {
		
	}


	public ComandasExpensesServices(int id, CompanySubsidiaries companySubsidiaries, String expense_type,
			Long comanda_id, Date payment_date, Professionals professionals, double comanda_total_value,
			double professional_service_percentage, double professional_service_total_value,
			double payment_type_discount_percentage, double payment_type_discount_value,
			double total_professional_discounted, ComandasPaymentsTypes comandasPaymentsTypes, Customers customers,
			Services services) {
		super();
		this.id = id;
		this.companySubsidiaries = companySubsidiaries;
		this.expense_type = expense_type;
		this.comanda_id = comanda_id;
		this.payment_date = payment_date;
		this.professionals = professionals;
		this.comanda_total_value = comanda_total_value;
		this.professional_service_percentage = professional_service_percentage;
		this.professional_service_total_value = professional_service_total_value;
		this.payment_type_discount_percentage = payment_type_discount_percentage;
		this.payment_type_discount_value = payment_type_discount_value;
		this.total_professional_discounted = total_professional_discounted;
		this.comandasPaymentsTypes = comandasPaymentsTypes;
		this.customers = customers;
		this.services = services;
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
		ComandasExpensesServices other = (ComandasExpensesServices) obj;
		if (comanda_id == null) {
			if (other.comanda_id != null) {
			return false;
			}
		} else if (!comanda_id.equals(other.comanda_id)) {
		return false;
		}
		if (Double.doubleToLongBits(comanda_total_value) != Double.doubleToLongBits(other.comanda_total_value)) {
		return false;
		}
		if (comandasPaymentsTypes == null) {
			if (other.comandasPaymentsTypes != null) {
			return false;
			}
		} else if (!comandasPaymentsTypes.equals(other.comandasPaymentsTypes)) {
		return false;
		}
		if (companySubsidiaries == null) {
			if (other.companySubsidiaries != null) {
			return false;
			}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (customers == null) {
			if (other.customers != null) {
			return false;
			}
		} else if (!customers.equals(other.customers)) {
		return false;
		}
		if (expense_type == null) {
			if (other.expense_type != null) {
			return false;
			}
		} else if (!expense_type.equals(other.expense_type)) {
		return false;
		}
		if (id != other.id) {
		return false;
		}
		if (payment_date == null) {
			if (other.payment_date != null) {
			return false;
			}
		} else if (!payment_date.equals(other.payment_date)) {
		return false;
		}
		if (Double.doubleToLongBits(payment_type_discount_percentage) != Double
				.doubleToLongBits(other.payment_type_discount_percentage)) {
		return false;
		}
		if (Double.doubleToLongBits(payment_type_discount_value) != Double
				.doubleToLongBits(other.payment_type_discount_value)) {
		return false;
		}
		if (Double.doubleToLongBits(professional_service_percentage) != Double
				.doubleToLongBits(other.professional_service_percentage)) {
		return false;
		}
		if (Double.doubleToLongBits(professional_service_total_value) != Double
				.doubleToLongBits(other.professional_service_total_value)) {
		return false;
		}
		if (professionals == null) {
			if (other.professionals != null) {
			return false;
			}
		} else if (!professionals.equals(other.professionals)) {
		return false;
		}
		if (services == null) {
			if (other.services != null) {
			return false;
			}
		} else if (!services.equals(other.services)) {
		return false;
		}
		if (Double.doubleToLongBits(total_professional_discounted) != Double
				.doubleToLongBits(other.total_professional_discounted)) {
		return false;
		}
		return true;
	}


	public Long getComanda_id() {
		return comanda_id;
	}


	public double getComanda_total_value() {
		return comanda_total_value;
	}


	public ComandasPaymentsTypes getComandasPaymentsTypes() {
		return comandasPaymentsTypes;
	}


	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}


	public Customers getCustomers() {
		return customers;
	}


	public String getExpense_type() {
		return expense_type;
	}


	public int getId() {
		return id;
	}


	public Date getPayment_date() {
		return payment_date;
	}


	public double getPayment_type_discount_percentage() {
		return payment_type_discount_percentage;
	}


	public double getPayment_type_discount_value() {
		return payment_type_discount_value;
	}


	public double getProfessional_service_percentage() {
		return professional_service_percentage;
	}


	public double getProfessional_service_total_value() {
		return professional_service_total_value;
	}


	public Professionals getProfessionals() {
		return professionals;
	}


	public Services getServices() {
		return services;
	}


	public double getTotal_professional_discounted() {
		return total_professional_discounted;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda_id == null) ? 0 : comanda_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(comanda_total_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((comandasPaymentsTypes == null) ? 0 : comandasPaymentsTypes.hashCode());
		result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((expense_type == null) ? 0 : expense_type.hashCode());
		result = prime * result + id;
		result = prime * result + ((payment_date == null) ? 0 : payment_date.hashCode());
		temp = Double.doubleToLongBits(payment_type_discount_percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(payment_type_discount_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(professional_service_percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(professional_service_total_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		//result = prime * result + ((professionals == null) ? 0 : professionals.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		temp = Double.doubleToLongBits(total_professional_discounted);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	public void setComanda_id(Long comanda_id) {
		this.comanda_id = comanda_id;
	}


	public void setComanda_total_value(double comanda_total_value) {
		this.comanda_total_value = comanda_total_value;
	}


	public void setComandasPaymentsTypes(ComandasPaymentsTypes comandasPaymentsTypes) {
		this.comandasPaymentsTypes = comandasPaymentsTypes;
	}


	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}


	public void setCustomers(Customers customers) {
		this.customers = customers;
	}


	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}


	public void setPayment_type_discount_percentage(double payment_type_discount_percentage) {
		this.payment_type_discount_percentage = payment_type_discount_percentage;
	}


	public void setPayment_type_discount_value(double payment_type_discount_value) {
		this.payment_type_discount_value = payment_type_discount_value;
	}


	public void setProfessional_service_percentage(double professional_service_percentage) {
		this.professional_service_percentage = professional_service_percentage;
	}


	public void setProfessional_service_total_value(double professional_service_total_value) {
		this.professional_service_total_value = professional_service_total_value;
	}


	public void setProfessionals(Professionals professionals) {
		this.professionals = professionals;
	}


	public void setServices(Services services) {
		this.services = services;
	}


	public void setTotal_professional_discounted(double total_professional_discounted) {
		this.total_professional_discounted = total_professional_discounted;
	}


	@Override
	public String toString() {
		return "ComandasExpensesServices [id=" + id + ", companySubsidiaries=" + companySubsidiaries + ", expense_type="
				+ expense_type + ", comanda_id=" + comanda_id + ", payment_date=" + payment_date + ", professionals="
				+ professionals + ", comanda_total_value=" + comanda_total_value + ", professional_service_percentage="
				+ professional_service_percentage + ", professional_service_total_value="
				+ professional_service_total_value + ", payment_type_discount_percentage="
				+ payment_type_discount_percentage + ", payment_type_discount_value=" + payment_type_discount_value
				+ ", total_professional_discounted=" + total_professional_discounted + ", comandasPaymentsTypes="
				+ comandasPaymentsTypes + ", customers=" + customers + ", services=" + services + ", hashCode()="
				+ hashCode() + ", getId()=" + getId() + ", getCompanySubsidiaries()=" + getCompanySubsidiaries()
				+ ", getExpense_type()=" + getExpense_type() + ", getComanda_id()=" + getComanda_id()
				+ ", getPayment_date()=" + getPayment_date() + ", getProfessionals()=" + getProfessionals()
				+ ", getComanda_total_value()=" + getComanda_total_value() + ", getProfessional_service_percentage()="
				+ getProfessional_service_percentage() + ", getProfessional_service_total_value()="
				+ getProfessional_service_total_value() + ", getPayment_type_discount_percentage()="
				+ getPayment_type_discount_percentage() + ", getPayment_type_discount_value()="
				+ getPayment_type_discount_value() + ", getTotal_professional_discounted()="
				+ getTotal_professional_discounted() + ", getComandasPaymentsTypes()=" + getComandasPaymentsTypes()
				+ ", getCustomers()=" + getCustomers() + ", getServices()=" + getServices() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
