//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;


public class UsernameEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String username;

	private String email;


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
		if (!(obj instanceof UsernameEmail)) {
		return false;
		}
		UsernameEmail other = (UsernameEmail) obj;
		if (email == null) {
		if (other.email != null) {
		return false;
		}
		} else if (!email.equals(other.email)) {
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

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	public void setEmal(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsernameEmail [username=" + username + ", emal=" + email + ", getUsername()=" + getUsername() + ", getEmal()=" + getEmail()
		+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}



}

