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

@Entity(name = "tbl_professionals")
@Table(schema = "hairdressing_master")
public class Professionals implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username_code")
	private User user;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionals")
	private Set<ComandasDetailsServices> comandasDetails = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionals1")
	private Set<ComandasDetailsServices> comandasDetails1 = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionals2")
	private Set<ComandasDetailsServices> comandasDetails2 = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionals")
	private Set<ComandasExpensesServices> comandasExpenses = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionals")
	private Set<AgendaMaster> agendaMaster = new HashSet<>(0);


	public Professionals() {

	}


	public Professionals(Long id, User user, CompanySubsidiaries companySubsidiaries, Set<ComandasDetailsServices> comandasDetails,
			Set<ComandasDetailsServices> comandasDetails1, Set<ComandasDetailsServices> comandasDetails2,
			Set<ComandasExpensesServices> comandasExpenses, Set<AgendaMaster> agendaMaster) {
		super();
		this.id = id;
		this.user = user;
		this.companySubsidiaries = companySubsidiaries;
		this.comandasDetails = comandasDetails;
		this.comandasDetails1 = comandasDetails1;
		this.comandasDetails2 = comandasDetails2;
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
		if (!(obj instanceof Professionals)) {
		return false;
		}
		Professionals other = (Professionals) obj;
		if (agendaMaster == null) {
		if (other.agendaMaster != null) {
		return false;
		}
		} else if (!agendaMaster.equals(other.agendaMaster)) {
		return false;
		}
		if (comandasDetails == null) {
		if (other.comandasDetails != null) {
		return false;
		}
		} else if (!comandasDetails.equals(other.comandasDetails)) {
		return false;
		}
		if (comandasDetails1 == null) {
		if (other.comandasDetails1 != null) {
		return false;
		}
		} else if (!comandasDetails1.equals(other.comandasDetails1)) {
		return false;
		}
		if (comandasDetails2 == null) {
		if (other.comandasDetails2 != null) {
		return false;
		}
		} else if (!comandasDetails2.equals(other.comandasDetails2)) {
		return false;
		}
		if (comandasExpenses == null) {
		if (other.comandasExpenses != null) {
		return false;
		}
		} else if (!comandasExpenses.equals(other.comandasExpenses)) {
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
		if (user == null) {
		if (other.user != null) {
		return false;
		}
		} else if (!user.equals(other.user)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the agendaMaster
	 */
	public Set<AgendaMaster> getAgendaMaster() {
		return agendaMaster;
	}

	public Set<ComandasDetailsServices> getComandasDetails() {
		return comandasDetails;
	}



	public Set<ComandasDetailsServices> getComandasDetails1() {
		return comandasDetails1;
	}



	public Set<ComandasDetailsServices> getComandasDetails2() {
		return comandasDetails2;
	}



	public Set<ComandasExpensesServices> getComandasExpenses() {
		return comandasExpenses;
	}



	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}



	public Long getId() {
		return id;
	}



	public User getUser() {
		return user;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaMaster == null) ? 0 : agendaMaster.hashCode());
		result = prime * result + ((comandasDetails == null) ? 0 : comandasDetails.hashCode());
		result = prime * result + ((comandasDetails1 == null) ? 0 : comandasDetails1.hashCode());
		result = prime * result + ((comandasDetails2 == null) ? 0 : comandasDetails2.hashCode());
		result = prime * result + ((comandasExpenses == null) ? 0 : comandasExpenses.hashCode());
		//result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}



	/**
	 * @param agendaMaster the agendaMaster to set
	 */
	public void setAgendaMaster(Set<AgendaMaster> agendaMaster) {
		this.agendaMaster = agendaMaster;
	}



	public void setComandasDetails(Set<ComandasDetailsServices> comandasDetails) {
		this.comandasDetails = comandasDetails;
	}



	public void setComandasDetails1(Set<ComandasDetailsServices> comandasDetails1) {
		this.comandasDetails1 = comandasDetails1;
	}



	public void setComandasDetails2(Set<ComandasDetailsServices> comandasDetails2) {
		this.comandasDetails2 = comandasDetails2;
	}



	public void setComandasExpenses(Set<ComandasExpensesServices> comandasExpenses) {
		this.comandasExpenses = comandasExpenses;
	}



	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setUser(User user) {
		this.user = user;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "Professionals [id=" + id + ", user=" + user + ", companySubsidiaries=" + companySubsidiaries + ", comandasDetails=" + comandasDetails
				+ ", comandasDetails1=" + comandasDetails1 + ", comandasDetails2=" + comandasDetails2 + ", comandasExpenses=" + comandasExpenses
				+ ", getComandasDetails()=" + getComandasDetails() + ", getComandasDetails1()=" + getComandasDetails1() + ", getComandasDetails2()="
				+ getComandasDetails2() + ", getComandasExpenses()=" + getComandasExpenses() + ", getCompanySubsidiaries()="
				+ getCompanySubsidiaries() + ", getId()=" + getId() + ", getUser()=" + getUser() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}*/




}

