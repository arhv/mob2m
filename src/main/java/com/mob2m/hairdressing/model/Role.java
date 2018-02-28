package com.mob2m.hairdressing.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_roles")
@Table(schema = "hairdressing_master")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	private int id;

	@Id
	@Column(name = "code_pk_tbl_roles")
	private String code_pk_tbl_roles;

	@Column(name = "active")
	private int active;

	@Column(name = "insertdate")
	private Date insertdate;

	@Column(name = "insertby")
	private String insertby;

	@Column(name="role")
	private String role;

	@Column (name = "visible")
	private boolean visible;

	@Column (name = "visiblevalue")
	private String visiblevalue;

	@Column(name = "hairdressingname")
	private String hairdressingname;

	public int getActive() {
		return active;
	}

	public String getCode_pk_tbl_roles() {
		return code_pk_tbl_roles;
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

	public String getVisiblevalue() {
		return visiblevalue;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setCode_pk_tbl_roles(String code_pk_tbl_roles) {
		this.code_pk_tbl_roles = code_pk_tbl_roles;
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

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setVisiblevalue(String visiblevalue) {
		this.visiblevalue = visiblevalue;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", active=" + active + ", insertdate=" + insertdate + ", insertby=" + insertby + ", role=" + role + ", visible="
				+ visible + ", visiblevalue=" + visiblevalue + ", code_pk_tbl_roles=" + code_pk_tbl_roles + ", getActive()=" + getActive()
				+ ", getId()=" + getId() + ", getInsertby()=" + getInsertby() + ", getInsertdate()=" + getInsertdate() + ", getRole()=" + getRole()
				+ ", getVisiblevalue()=" + getVisiblevalue() + ", isVisible()=" + isVisible() + ", getCode_pk_tbl_roles()=" + getCode_pk_tbl_roles()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
