//Hairdressing list
//To be created in a separated schema from Hairdressing schema
package com.mob2m.hairdressing.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_hairdressingnames")
@Table(schema = "hairdressing_master")
public class HairdressingNames implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "active")
	private boolean active;

	@Column(name = "insertdate")
	private Date insertdate;

	@Column(name = "insertby")
	private String insertby;

	@Column(name = "hairdressingname")
	private String hairdressingname;//Primary key

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	@Override
	public String toString() {
		return "HairdressingNames [id=" + id + ", active=" + active + ", insertdate=" + insertdate + ", insertby=" + insertby + ", hairdressingname="
				+ hairdressingname + ", getId()=" + getId() + ", isActive()=" + isActive() + ", getInsertdate()=" + getInsertdate()
				+ ", getInsertby()=" + getInsertby() + ", getHairdressingname()=" + getHairdressingname() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}