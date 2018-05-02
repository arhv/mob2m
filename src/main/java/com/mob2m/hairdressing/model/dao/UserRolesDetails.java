package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_user_roles_details")
@Table(schema = "hairdressing_master")
public class UserRolesDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "roleId")
	private Long roleId;

	@Column(name = "roleName")
	private Long roleName;

	@Column(name = "roleValue")
	private Long roleValue;

}