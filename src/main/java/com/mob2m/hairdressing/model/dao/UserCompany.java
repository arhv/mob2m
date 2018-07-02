//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	/*@Column(name = "username")
	private String username;*/

	@Column(name = "username_string")
	private String username_string;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_role")
	private UserRoles userRoles;

	@Column(name = "user_role_string")
	private String user_role_string;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;



	public UserCompany() {

	}

	public UserCompany(Long id, String username_string, User user, UserRoles userRoles, String user_role_string,
			CompanySubsidiaries companySubsidiaries) {
		super();
		this.id = id;
		this.username_string = username_string;
		this.user = user;
		this.userRoles = userRoles;
		this.user_role_string = user_role_string;
		this.companySubsidiaries = companySubsidiaries;
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
		if (!(obj instanceof UserCompany)) {
		return false;
		}
		UserCompany other = (UserCompany) obj;
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
		if (userRoles == null) {
		if (other.userRoles != null) {
		return false;
		}
		} else if (!userRoles.equals(other.userRoles)) {
		return false;
		}
		if (user_role_string == null) {
		if (other.user_role_string != null) {
		return false;
		}
		} else if (!user_role_string.equals(other.user_role_string)) {
		return false;
		}
		if (username_string == null) {
		if (other.username_string != null) {
		return false;
		}
		} else if (!username_string.equals(other.username_string)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the companySubsidiaries
	 */
	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @return the user_role_string
	 */
	public String getUser_role_string() {
		return user_role_string;
	}


	/**
	 * @return the username_string
	 */
	public String getUsername_string() {
		return username_string;
	}


	/**
	 * @return the userRoles
	 */
	public UserRoles getUserRoles() {
		return userRoles;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		//result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
		result = prime * result + ((user_role_string == null) ? 0 : user_role_string.hashCode());
		result = prime * result + ((username_string == null) ? 0 : username_string.hashCode());
		return result;
	}



	/**
	 * @param companySubsidiaries the companySubsidiaries to set
	 */
	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}



	/**
	 * @param user_role_string the user_role_string to set
	 */
	public void setUser_role_string(String user_role_string) {
		this.user_role_string = user_role_string;
	}

	/**
	 * @param username_string the username_string to set
	 */
	public void setUsername_string(String username_string) {
		this.username_string = username_string;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "UserCompany [id=" + id + ", username=" + username + ", userRoles=" + userRoles + ", companySubsidiaries=" + companySubsidiaries
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getUserRoles()=" + getUserRoles() + ", getCompanySubsidiaries()="
				+ getCompanySubsidiaries() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/


}

