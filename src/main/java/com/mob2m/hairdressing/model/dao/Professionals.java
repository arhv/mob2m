//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;


//@Entity(name = "tbl_professionals")
//@Table(schema = "hairdressing_master")
public class Professionals implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubisidiaries;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User user;


	public Professionals() {

	}*/


}

