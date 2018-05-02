//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_user_company")
@Table(schema = "hairdressing_master")
public class UserCompany implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "companySubsidiary")
	private String companySubsidiary;

	@Column(name = "userRole")
	private String userRole;

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
		if (!(obj instanceof UserCompany)) {
		return false;
		}
		UserCompany other = (UserCompany) obj;
		if (companySubsidiary == null) {
		if (other.companySubsidiary != null) {
		return false;
		}
		} else if (!companySubsidiary.equals(other.companySubsidiary)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (userRole == null) {
		if (other.userRole != null) {
		return false;
		}
		} else if (!userRole.equals(other.userRole)) {
		return false;
		}
		if (username == null) {
		if (other.username != null) {
		return false;
		}
		} else if (!username.equals(other.username)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the companySubsidiary
	 */
	public String getCompanySubsidiary() {
		return companySubsidiary;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companySubsidiary == null) ? 0 : companySubsidiary.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * @param companySubsidiary the companySubsidiary to set
	 */
	public void setCompanySubsidiary(String companySubsidiary) {
		this.companySubsidiary = companySubsidiary;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCompany [id=" + id + ", username=" + username + ", companySubsidiary=" + companySubsidiary + ", userRole=" + userRole
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getCompanySubsidiary()=" + getCompanySubsidiary()
				+ ", getUserRole()=" + getUserRole() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}



}

