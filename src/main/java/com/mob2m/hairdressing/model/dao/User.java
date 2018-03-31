//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement(name = "item")
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
	private boolean active;

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
	private String city;

	@XmlElement
	@Column (name = "state")
	private String state;

	public User() {

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
		User other = (User) obj;
		if (active != other.active) {
		return false;
		}
		if (address == null) {
		if (other.address != null) {
		return false;
		}
		} else if (!address.equals(other.address)) {
		return false;
		}
		if (city == null) {
		if (other.city != null) {
		return false;
		}
		} else if (!city.equals(other.city)) {
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
		if (state == null) {
		if (other.state != null) {
		return false;
		}
		} else if (!state.equals(other.state)) {
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

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCode_pk_tbl_user() {
		return code_pk_tbl_user;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public String getInsertby() {
		return insertby;
	}

	public Date getInsertdate() {
		return insertdate;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getState() {
		return state;
	}

	public String getUsername() {
		return username;
	}

	public String getZipCode() {
		return zipCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code_pk_tbl_user == null) ? 0 : code_pk_tbl_user.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insertby == null) ? 0 : insertby.hashCode());
		result = prime * result + ((insertdate == null) ? 0 : insertdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCode_pk_tbl_user(String code_pk_tbl_user) {
		this.code_pk_tbl_user = code_pk_tbl_user;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInsertby(String insertby) {
		this.insertby = insertby;
	}

	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", active=" + active + ", insertdate=" + insertdate + ", insertby=" + insertby + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", name=" + name + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", zipCode=" + zipCode + ", city=" + city + ", state=" + state + ", getAddress()=" + getAddress() + ", getCity()=" + getCity()
				+ ", getEmail()=" + getEmail() + ", getId()=" + getId() + ", getInsertby()=" + getInsertby() + ", getInsertdate()=" + getInsertdate()
				+ ", getName()=" + getName() + ", getPassword()=" + getPassword() + ", getState()=" + getState() + ", getUsername()=" + getUsername()
				+ ", getZipCode()=" + getZipCode() + ", isActive()=" + isActive() + ", getPhonenumber()=" + getPhonenumber() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}

