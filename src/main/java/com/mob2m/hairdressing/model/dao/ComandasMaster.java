//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "tbl_comandas_master")
@Table(schema = "hairdressing_master")
public class ComandasMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "status")
	private String status;

	@Column(name = "comanda_type")
	private String comanda_type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_name")
	private Customers customers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comandasMaster")
	private Set<ComandasDetails> comandasDetails = new HashSet<>(0);

	public ComandasMaster() {

	}




}

