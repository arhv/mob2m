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

@Entity(name = "tbl_comandas_details")
@Table(schema = "hairdressing_master")
public class ComandasDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "service")
	private int service;

	@Column(name = "service_value")
	private String service_value;

	@Column(name = "professional_principal")
	private int professional_principal;

	@Column(name = "professional_aux_1")
	private String professional_aux_1;

	@Column(name = "professional_aux_2")
	private String professional_aux_2;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comandas_master_id")
	private ComandasMaster comandasMaster;

	public ComandasDetails() {

	}

}

