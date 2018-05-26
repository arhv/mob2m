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
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity(name = "tbl_user")
@Table(schema = "hairdressing_master")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	private Long id;

	@XmlElement
	@Column(name = "code_pk_tbl_user")
	private String code_pk_tbl_user;

	@XmlElement
	@Column(name = "active")
	private Boolean active;

	@XmlElement
	@Column(name = "insertdate")
	private Date insertdate;

	@XmlElement
	@Column(name = "insertby")
	private String insertby;

	@XmlElement
	@Column(name = "username")
	@NotBlank //(message = "Favor digitar seu nome de usuário")
	private String username;

	@XmlElement
	@Column(name = "email")
	@Email //(message = "Favor digitar um email válido")
	@NotBlank //(message = "Favor digitar um email")
	private String email;

	@XmlElement
	@Column(name = "password")
	@NotBlank //(message = "Favor digitar a senha")
	private String password;

	@XmlElement
	@Column(name = "name")
	@NotBlank //(message = "Favor digitar o nome")
	private String name;

	@XmlElement
	@Column(name = "phonenumber")
	@NotBlank //(message = "Favor digitar um telefone")
	private String phonenumber;

	@XmlElement
	@Column (name = "address")
	private String address;

	@XmlElement
	@Column (name = "zipcode")
	private String zipCode;

	@XmlElement
	@Column (name = "city")
	private int cityName;

	@XmlElement
	@Column (name = "state")
	private int stateName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_cidades")
	private Cities cities;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_estados")
	private States states;

	public User() {

	}

	public User(Long id, String code_pk_tbl_user, Boolean active, Date insertdate, String insertby, String username, String email, String password,
			String name, String phonenumber, String address, String zipCode, int cityName, int stateName, Cities cities, States states) {
		super();
		this.id = id;
		this.code_pk_tbl_user = code_pk_tbl_user;
		this.active = active;
		this.insertdate = insertdate;
		this.insertby = insertby;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.zipCode = zipCode;
		this.cityName = cityName;
		this.stateName = stateName;
		this.cities = cities;
		this.states = states;
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String email) {
		this.email = email;
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
		if (!(obj instanceof User)) {
		return false;
		}
		User other = (User) obj;
		if (active == null) {
		if (other.active != null) {
		return false;
		}
		} else if (!active.equals(other.active)) {
		return false;
		}
		if (address == null) {
		if (other.address != null) {
		return false;
		}
		} else if (!address.equals(other.address)) {
		return false;
		}
		if (cities == null) {
		if (other.cities != null) {
		return false;
		}
		} else if (!cities.equals(other.cities)) {
		return false;
		}
		if (cityName != other.cityName) {
		return false;
		}
		if (code_pk_tbl_user == null) {
		if (other.code_pk_tbl_user != null) {
		return false;
		}
		} else if (!code_pk_tbl_user.equals(other.code_pk_tbl_user)) {
		return false;
		}
		if (email == null) {
		if (other.email != null) {
		return false;
		}
		} else if (!email.equals(other.email)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (insertby == null) {
		if (other.insertby != null) {
		return false;
		}
		} else if (!insertby.equals(other.insertby)) {
		return false;
		}
		if (insertdate == null) {
		if (other.insertdate != null) {
		return false;
		}
		} else if (!insertdate.equals(other.insertdate)) {
		return false;
		}
		if (name == null) {
		if (other.name != null) {
		return false;
		}
		} else if (!name.equals(other.name)) {
		return false;
		}
		if (password == null) {
		if (other.password != null) {
		return false;
		}
		} else if (!password.equals(other.password)) {
		return false;
		}
		if (phonenumber == null) {
		if (other.phonenumber != null) {
		return false;
		}
		} else if (!phonenumber.equals(other.phonenumber)) {
		return false;
		}
		if (stateName != other.stateName) {
		return false;
		}
		if (states == null) {
		if (other.states != null) {
		return false;
		}
		} else if (!states.equals(other.states)) {
		return false;
		}
		if (username == null) {
		if (other.username != null) {
		return false;
		}
		} else if (!username.equals(other.username)) {
		return false;
		}
		if (zipCode == null) {
		if (other.zipCode != null) {
		return false;
		}
		} else if (!zipCode.equals(other.zipCode)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the cities
	 */
	public Cities getCities() {
		return cities;
	}

	/**
	 * @return the cityName
	 */
	public int getCityName() {
		return cityName;
	}

	/**
	 * @return the code_pk_tbl_user
	 */
	public String getCode_pk_tbl_user() {
		return code_pk_tbl_user;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the insertby
	 */
	public String getInsertby() {
		return insertby;
	}

	/**
	 * @return the insertdate
	 */
	public Date getInsertdate() {
		return insertdate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @return the stateName
	 */
	public int getStateName() {
		return stateName;
	}

	/**
	 * @return the states
	 */
	public States getStates() {
		return states;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + cityName;
		result = prime * result + ((code_pk_tbl_user == null) ? 0 : code_pk_tbl_user.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insertby == null) ? 0 : insertby.hashCode());
		result = prime * result + ((insertdate == null) ? 0 : insertdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result + stateName;
		result = prime * result + ((states == null) ? 0 : states.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(Cities cities) {
		this.cities = cities;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(int cityName) {
		this.cityName = cityName;
	}

	/**
	 * @param code_pk_tbl_user the code_pk_tbl_user to set
	 */
	public void setCode_pk_tbl_user(String code_pk_tbl_user) {
		this.code_pk_tbl_user = code_pk_tbl_user;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param insertby the insertby to set
	 */
	public void setInsertby(String insertby) {
		this.insertby = insertby;
	}

	/**
	 * @param insertdate the insertdate to set
	 */
	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(int stateName) {
		this.stateName = stateName;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(States states) {
		this.states = states;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", code_pk_tbl_user=" + code_pk_tbl_user + ", active=" + active + ", insertdate=" + insertdate + ", insertby="
				+ insertby + ", username=" + username + ", email=" + email + ", password=" + password + ", name=" + name + ", phonenumber="
				+ phonenumber + ", address=" + address + ", zipCode=" + zipCode + ", cityName=" + cityName + ", stateName=" + stateName + ", cities="
				+ cities + ", states=" + states + ", getId()=" + getId() + ", getCode_pk_tbl_user()=" + getCode_pk_tbl_user() + ", getActive()="
				+ getActive() + ", getInsertdate()=" + getInsertdate() + ", getInsertby()=" + getInsertby() + ", getUsername()=" + getUsername()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getName()=" + getName() + ", getPhonenumber()="
				+ getPhonenumber() + ", getAddress()=" + getAddress() + ", getZipCode()=" + getZipCode() + ", getCityName()=" + getCityName()
				+ ", getStateName()=" + getStateName() + ", getCities()=" + getCities() + ", getStates()=" + getStates() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


}

