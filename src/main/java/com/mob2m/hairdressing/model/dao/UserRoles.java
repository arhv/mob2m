package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_user_roles")
@Table(schema = "hairdressing_master")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	private int id;

	@Id
	@Column(name = "code_pk_tbl_user_roles")
	private String code_pk_tbl_user_roles;

	@Column(name = "active")
	private boolean active;

	@Column(name = "insertdate")
	private Date insertdate;

	@Column(name = "insertby")
	private String insertby;

	@Column (name="username")
	private String username;

	@Column (name = "role")
	private String role;

	@Column(name = "hairdressingname")
	private String hairdressingname;

	public String getCode_pk_tbl_user_roles() {
		return code_pk_tbl_user_roles;
	}

	public String getHairdressingname() {
		return hairdressingname;
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

	public String getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setCode_pk_tbl_user_roles(String code_pk_tbl_user_roles) {
		this.code_pk_tbl_user_roles = code_pk_tbl_user_roles;
	}

	public void setHairdressingname(String hairdressingname) {
		this.hairdressingname = hairdressingname;
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

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", active=" + active + ", insertdate=" + insertdate + ", insertby=" + insertby + ", username=" + username
				+ ", role=" + role + ", hairdressingname=" + hairdressingname + ", code_pk_tbl_hairdressingnames=" + code_pk_tbl_user_roles
				+ ", getHairdressingname()=" + getHairdressingname() + ", getId()=" + getId() + ", getInsertby()=" + getInsertby()
				+ ", getInsertdate()=" + getInsertdate() + ", getRole()=" + getRole() + ", getUsername()=" + getUsername() + ", isActive()="
				+ isActive() + ", getCode_pk_tbl_hairdressingnames()=" + getCode_pk_tbl_user_roles() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




}