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

@Entity(name = "tbl_company_subsidiaries")
@Table(schema = "hairdressing_master")
public class CompanySubsidiaries implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_subsidiary_name")
	private String companySubsidiaryName;

	@Column(name = "company_subsidiary_type")
	private String companySubsidiaryType;

	@Column(name = "company_subsidiary_cnpj")
	private String companySubsidiaryCnpj;

	@Column(name = "company_subsidiary_address")
	private String companySubsidiaryAddress;

	@Column(name = "company_subsidiary_cep")
	private String companySubsidiaryCep;

	@Column(name = "company_subsidiary_state")
	private int companySubsidiaryState;

	@Column(name = "company_subsidiary_city")
	private int companySubsidiaryCity;

	@Column(name = "company_name_id")
	private Long companyNameId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cidades")
	private Cities cities;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_estados")
	private States states;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<Products> products = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<Services> services = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<UserCompany> userCompany = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<UserRoles> userRoles = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<Professionals> professionals = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<Suppliers> suppliers = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<ComandasMaster> comandasMaster = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<ProductsReselling> productsReselling = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<ProductsWarehouse> productsWarehouse = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<ComandasPaymentsTypes> paymentsTypes = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<Customers> customers = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<ComandasExpensesServices> comandasExpenses = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companySubsidiaries")
	private Set<AgendaSubsidiary> agendaMaster = new HashSet<>(0);

	public CompanySubsidiaries() {

	}

	public CompanySubsidiaries(Long id, String companySubsidiaryName, String companySubsidiaryType, String companySubsidiaryCnpj,
			String companySubsidiaryAddress, String companySubsidiaryCep, int companySubsidiaryState, int companySubsidiaryCity, Long companyNameId,
			Cities cities, States states, Set<Products> products, Set<Services> services, Set<UserCompany> userCompany, Set<UserRoles> userRoles,
			Set<Professionals> professionals, Set<Suppliers> suppliers, Set<ComandasMaster> comandasMaster, Set<ProductsReselling> productsReselling,
			Set<ProductsWarehouse> productsWarehouse, Set<ComandasPaymentsTypes> paymentsTypes, Set<Customers> customers,
			Set<ComandasExpensesServices> comandasExpenses, Set<AgendaSubsidiary> agendaMaster) {
		super();
		this.id = id;
		this.companySubsidiaryName = companySubsidiaryName;
		this.companySubsidiaryType = companySubsidiaryType;
		this.companySubsidiaryCnpj = companySubsidiaryCnpj;
		this.companySubsidiaryAddress = companySubsidiaryAddress;
		this.companySubsidiaryCep = companySubsidiaryCep;
		this.companySubsidiaryState = companySubsidiaryState;
		this.companySubsidiaryCity = companySubsidiaryCity;
		this.companyNameId = companyNameId;
		this.cities = cities;
		this.states = states;
		this.products = products;
		this.services = services;
		this.userCompany = userCompany;
		this.userRoles = userRoles;
		this.professionals = professionals;
		this.suppliers = suppliers;
		this.comandasMaster = comandasMaster;
		this.productsReselling = productsReselling;
		this.productsWarehouse = productsWarehouse;
		this.paymentsTypes = paymentsTypes;
		this.customers = customers;
		this.comandasExpenses = comandasExpenses;
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
		if (!(obj instanceof CompanySubsidiaries)) {
		return false;
		}
		CompanySubsidiaries other = (CompanySubsidiaries) obj;
		if (agendaMaster == null) {
		if (other.agendaMaster != null) {
		return false;
		}
		} else if (!agendaMaster.equals(other.agendaMaster)) {
		return false;
		}
		if (cities == null) {
		if (other.cities != null) {
		return false;
		}
		} else if (!cities.equals(other.cities)) {
		return false;
		}
		if (comandasExpenses == null) {
		if (other.comandasExpenses != null) {
		return false;
		}
		} else if (!comandasExpenses.equals(other.comandasExpenses)) {
		return false;
		}
		if (comandasMaster == null) {
		if (other.comandasMaster != null) {
		return false;
		}
		} else if (!comandasMaster.equals(other.comandasMaster)) {
		return false;
		}
		if (companyNameId == null) {
		if (other.companyNameId != null) {
		return false;
		}
		} else if (!companyNameId.equals(other.companyNameId)) {
		return false;
		}
		if (companySubsidiaryAddress == null) {
		if (other.companySubsidiaryAddress != null) {
		return false;
		}
		} else if (!companySubsidiaryAddress.equals(other.companySubsidiaryAddress)) {
		return false;
		}
		if (companySubsidiaryCep == null) {
		if (other.companySubsidiaryCep != null) {
		return false;
		}
		} else if (!companySubsidiaryCep.equals(other.companySubsidiaryCep)) {
		return false;
		}
		if (companySubsidiaryCity != other.companySubsidiaryCity) {
		return false;
		}
		if (companySubsidiaryCnpj == null) {
		if (other.companySubsidiaryCnpj != null) {
		return false;
		}
		} else if (!companySubsidiaryCnpj.equals(other.companySubsidiaryCnpj)) {
		return false;
		}
		if (companySubsidiaryName == null) {
		if (other.companySubsidiaryName != null) {
		return false;
		}
		} else if (!companySubsidiaryName.equals(other.companySubsidiaryName)) {
		return false;
		}
		if (companySubsidiaryState != other.companySubsidiaryState) {
		return false;
		}
		if (companySubsidiaryType == null) {
		if (other.companySubsidiaryType != null) {
		return false;
		}
		} else if (!companySubsidiaryType.equals(other.companySubsidiaryType)) {
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
		if (paymentsTypes == null) {
		if (other.paymentsTypes != null) {
		return false;
		}
		} else if (!paymentsTypes.equals(other.paymentsTypes)) {
		return false;
		}
		if (products == null) {
		if (other.products != null) {
		return false;
		}
		} else if (!products.equals(other.products)) {
		return false;
		}
		if (productsReselling == null) {
		if (other.productsReselling != null) {
		return false;
		}
		} else if (!productsReselling.equals(other.productsReselling)) {
		return false;
		}
		if (productsWarehouse == null) {
		if (other.productsWarehouse != null) {
		return false;
		}
		} else if (!productsWarehouse.equals(other.productsWarehouse)) {
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
		if (states == null) {
		if (other.states != null) {
		return false;
		}
		} else if (!states.equals(other.states)) {
		return false;
		}
		if (suppliers == null) {
		if (other.suppliers != null) {
		return false;
		}
		} else if (!suppliers.equals(other.suppliers)) {
		return false;
		}
		if (userCompany == null) {
		if (other.userCompany != null) {
		return false;
		}
		} else if (!userCompany.equals(other.userCompany)) {
		return false;
		}
		if (userRoles == null) {
		if (other.userRoles != null) {
		return false;
		}
		} else if (!userRoles.equals(other.userRoles)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the agendaMaster
	 */
	public Set<AgendaSubsidiary> getAgendaMaster() {
		return agendaMaster;
	}

	/**
	 * @return the cities
	 */
	public Cities getCities() {
		return cities;
	}

	/**
	 * @return the comandasExpenses
	 */
	public Set<ComandasExpensesServices> getComandasExpenses() {
		return comandasExpenses;
	}

	/**
	 * @return the comandasMaster
	 */
	public Set<ComandasMaster> getComandasMaster() {
		return comandasMaster;
	}

	/**
	 * @return the companyNameId
	 */
	public Long getCompanyNameId() {
		return companyNameId;
	}

	/**
	 * @return the companySubsidiaryAddress
	 */
	public String getCompanySubsidiaryAddress() {
		return companySubsidiaryAddress;
	}

	/**
	 * @return the companySubsidiaryCep
	 */
	public String getCompanySubsidiaryCep() {
		return companySubsidiaryCep;
	}

	/**
	 * @return the companySubsidiaryCity
	 */
	public int getCompanySubsidiaryCity() {
		return companySubsidiaryCity;
	}

	/**
	 * @return the companySubsidiaryCnpj
	 */
	public String getCompanySubsidiaryCnpj() {
		return companySubsidiaryCnpj;
	}

	/**
	 * @return the companySubsidiaryName
	 */
	public String getCompanySubsidiaryName() {
		return companySubsidiaryName;
	}

	/**
	 * @return the companySubsidiaryState
	 */
	public int getCompanySubsidiaryState() {
		return companySubsidiaryState;
	}

	/**
	 * @return the companySubsidiaryType
	 */
	public String getCompanySubsidiaryType() {
		return companySubsidiaryType;
	}

	/**
	 * @return the customers
	 */
	public Set<Customers> getCustomers() {
		return customers;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the paymentsTypes
	 */
	public Set<ComandasPaymentsTypes> getPaymentsTypes() {
		return paymentsTypes;
	}

	/**
	 * @return the products
	 */
	public Set<Products> getProducts() {
		return products;
	}

	/**
	 * @return the productsReselling
	 */
	public Set<ProductsReselling> getProductsReselling() {
		return productsReselling;
	}

	/**
	 * @return the productsWarehouse
	 */
	public Set<ProductsWarehouse> getProductsWarehouse() {
		return productsWarehouse;
	}

	/**
	 * @return the professionals
	 */
	public Set<Professionals> getProfessionals() {
		return professionals;
	}

	/**
	 * @return the services
	 */
	public Set<Services> getServices() {
		return services;
	}

	/**
	 * @return the states
	 */
	public States getStates() {
		return states;
	}

	/**
	 * @return the suppliers
	 */
	public Set<Suppliers> getSuppliers() {
		return suppliers;
	}

	/**
	 * @return the userCompany
	 */
	public Set<UserCompany> getUserCompany() {
		return userCompany;
	}

	/**
	 * @return the userRoles
	 */
	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaMaster == null) ? 0 : agendaMaster.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		//result = prime * result + ((comandasExpenses == null) ? 0 : comandasExpenses.hashCode());
		result = prime * result + ((comandasMaster == null) ? 0 : comandasMaster.hashCode());
		result = prime * result + ((companyNameId == null) ? 0 : companyNameId.hashCode());
		result = prime * result + ((companySubsidiaryAddress == null) ? 0 : companySubsidiaryAddress.hashCode());
		result = prime * result + ((companySubsidiaryCep == null) ? 0 : companySubsidiaryCep.hashCode());
		result = prime * result + companySubsidiaryCity;
		result = prime * result + ((companySubsidiaryCnpj == null) ? 0 : companySubsidiaryCnpj.hashCode());
		result = prime * result + ((companySubsidiaryName == null) ? 0 : companySubsidiaryName.hashCode());
		result = prime * result + companySubsidiaryState;
		result = prime * result + ((companySubsidiaryType == null) ? 0 : companySubsidiaryType.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		//result = prime * result + ((paymentsTypes == null) ? 0 : paymentsTypes.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		//result = prime * result + ((productsReselling == null) ? 0 : productsReselling.hashCode());
		//result = prime * result + ((productsWarehouse == null) ? 0 : productsWarehouse.hashCode());
		result = prime * result + ((professionals == null) ? 0 : professionals.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + ((states == null) ? 0 : states.hashCode());
		result = prime * result + ((suppliers == null) ? 0 : suppliers.hashCode());
		result = prime * result + ((userCompany == null) ? 0 : userCompany.hashCode());
		result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
		return result;
	}

	/**
	 * @param agendaMaster the agendaMaster to set
	 */
	public void setAgendaMaster(Set<AgendaSubsidiary> agendaMaster) {
		this.agendaMaster = agendaMaster;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(Cities cities) {
		this.cities = cities;
	}

	/**
	 * @param comandasExpenses the comandasExpenses to set
	 */
	public void setComandasExpenses(Set<ComandasExpensesServices> comandasExpenses) {
		this.comandasExpenses = comandasExpenses;
	}

	/**
	 * @param comandasMaster the comandasMaster to set
	 */
	public void setComandasMaster(Set<ComandasMaster> comandasMaster) {
		this.comandasMaster = comandasMaster;
	}

	/**
	 * @param companyNameId the companyNameId to set
	 */
	public void setCompanyNameId(Long companyNameId) {
		this.companyNameId = companyNameId;
	}

	/**
	 * @param companySubsidiaryAddress the companySubsidiaryAddress to set
	 */
	public void setCompanySubsidiaryAddress(String companySubsidiaryAddress) {
		this.companySubsidiaryAddress = companySubsidiaryAddress;
	}

	/**
	 * @param companySubsidiaryCep the companySubsidiaryCep to set
	 */
	public void setCompanySubsidiaryCep(String companySubsidiaryCep) {
		this.companySubsidiaryCep = companySubsidiaryCep;
	}

	/**
	 * @param companySubsidiaryCity the companySubsidiaryCity to set
	 */
	public void setCompanySubsidiaryCity(int companySubsidiaryCity) {
		this.companySubsidiaryCity = companySubsidiaryCity;
	}

	/**
	 * @param companySubsidiaryCnpj the companySubsidiaryCnpj to set
	 */
	public void setCompanySubsidiaryCnpj(String companySubsidiaryCnpj) {
		this.companySubsidiaryCnpj = companySubsidiaryCnpj;
	}

	/**
	 * @param companySubsidiaryName the companySubsidiaryName to set
	 */
	public void setCompanySubsidiaryName(String companySubsidiaryName) {
		this.companySubsidiaryName = companySubsidiaryName;
	}

	/**
	 * @param companySubsidiaryState the companySubsidiaryState to set
	 */
	public void setCompanySubsidiaryState(int companySubsidiaryState) {
		this.companySubsidiaryState = companySubsidiaryState;
	}

	/**
	 * @param companySubsidiaryType the companySubsidiaryType to set
	 */
	public void setCompanySubsidiaryType(String companySubsidiaryType) {
		this.companySubsidiaryType = companySubsidiaryType;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(Set<Customers> customers) {
		this.customers = customers;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param paymentsTypes the paymentsTypes to set
	 */
	public void setPaymentsTypes(Set<ComandasPaymentsTypes> paymentsTypes) {
		this.paymentsTypes = paymentsTypes;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	/**
	 * @param productsReselling the productsReselling to set
	 */
	public void setProductsReselling(Set<ProductsReselling> productsReselling) {
		this.productsReselling = productsReselling;
	}

	/**
	 * @param productsWarehouse the productsWarehouse to set
	 */
	public void setProductsWarehouse(Set<ProductsWarehouse> productsWarehouse) {
		this.productsWarehouse = productsWarehouse;
	}

	/**
	 * @param professionals the professionals to set
	 */
	public void setProfessionals(Set<Professionals> professionals) {
		this.professionals = professionals;
	}

	/**
	 * @param services the services to set
	 */
	public void setServices(Set<Services> services) {
		this.services = services;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(States states) {
		this.states = states;
	}

	/**
	 * @param suppliers the suppliers to set
	 */
	public void setSuppliers(Set<Suppliers> suppliers) {
		this.suppliers = suppliers;
	}

	/**
	 * @param userCompany the userCompany to set
	 */
	public void setUserCompany(Set<UserCompany> userCompany) {
		this.userCompany = userCompany;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "CompanySubsidiaries [id=" + id + ", companySubsidiaryName=" + companySubsidiaryName + ", companySubsidiaryType="
				+ companySubsidiaryType + ", companySubsidiaryCnpj=" + companySubsidiaryCnpj + ", companySubsidiaryAddress="
				+ companySubsidiaryAddress + ", companySubsidiaryCep=" + companySubsidiaryCep + ", companySubsidiaryState=" + companySubsidiaryState
				+ ", companySubsidiaryCity=" + companySubsidiaryCity + ", companyNameId=" + companyNameId + ", cities=" + cities + ", states="
				+ states + ", products=" + products + ", services=" + services + ", userCompany=" + userCompany + ", userRoles=" + userRoles
				+ ", professionals=" + professionals + ", suppliers=" + suppliers + ", comandasMaster=" + comandasMaster + ", getCities()="
				+ getCities() + ", getComandasMaster()=" + getComandasMaster() + ", getCompanyNameId()=" + getCompanyNameId()
				+ ", getCompanySubsidiaryAddress()=" + getCompanySubsidiaryAddress() + ", getCompanySubsidiaryCep()=" + getCompanySubsidiaryCep()
				+ ", getCompanySubsidiaryCity()=" + getCompanySubsidiaryCity() + ", getCompanySubsidiaryCnpj()=" + getCompanySubsidiaryCnpj()
				+ ", getCompanySubsidiaryName()=" + getCompanySubsidiaryName() + ", getCompanySubsidiaryState()=" + getCompanySubsidiaryState()
				+ ", getCompanySubsidiaryType()=" + getCompanySubsidiaryType() + ", getId()=" + getId() + ", getProducts()=" + getProducts()
				+ ", getProfessionals()=" + getProfessionals() + ", getServices()=" + getServices() + ", getStates()=" + getStates()
				+ ", getSuppliers()=" + getSuppliers() + ", getUserCompany()=" + getUserCompany() + ", getUserRoles()=" + getUserRoles()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/

}

