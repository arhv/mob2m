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

	@Column(name = "service_product_usage_value")
	private String service_value;

	@Column(name = "professional_aux_1")
	private String professional_aux_1;

	@Column(name = "professional_aux_2")
	private String professional_aux_2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comandas_master_id")
	private ComandasMaster comandasMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id")
	private Services services;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_principal")
	private Professionals professionals;

	public ComandasDetails() {

	}

}

