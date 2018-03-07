//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "tbl_user")
@Table(schema = "hairdressing_master")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "code_pk_tbl_user")
	private String code_pk_tbl_user;

	@Column(name = "active")
	private boolean active;

	@Column(name = "insertdate")
	private Date insertdate;

	@Column(name = "insertby")
	private String insertby;

	@Column (name="username")
	private String username;//Primary key

	@Column(name = "email")
	@Email(message = "*Favor digitar um email válido")
	@NotEmpty(message = "*Favor digitar seu email")
	private String email;

	@Column(name = "password")
	//@Length(min = 5, message = "*Sua senha deve ter pelo menos 5 ")
	@NotEmpty(message = "*Favor digitar sua senha")
	//@Transient
	private String password;

	@Column(name = "name")
	@NotEmpty(message = "*Favor digitar seu nome")
	private String name;

	@Column(name = "phonenumber")
	@NotEmpty(message = "*Favor digitar um telefone para contato")
	private String phonenumber;

	@Column (name = "address")
	private String address;

	@Column (name = "zipcode")
	private String zipCode;

	@Column (name = "city")
	private String city;

	@Column (name = "state")
	private String state;

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
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id != other.id) {
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

	public String getEmail() {
		return email;
	}

	public int getId() {
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
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

//Getters and Setters