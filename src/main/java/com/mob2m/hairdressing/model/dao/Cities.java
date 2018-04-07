//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@Entity(name = "tbl_cidades")
@Table(schema = "hairdressing_master")
public class Cities implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	private Long id;

	@XmlElement
	@Column(name = "estados_cod_estados")
	private int estados_cod_estados;

	@XmlElement
	@Column(name = "cod_cidades")
	private int cod_cidades;

	@XmlElement
	@Column(name = "nome")
	private String nome;

	@XmlElement
	@Column(name = "cep")
	private String cep;

	public Cities(Long id, int estados_cod_estados, int cod_cidades, String nome, String cep) {
		this.id = id;
		this.estados_cod_estados = estados_cod_estados;
		this.cod_cidades = cod_cidades;
		this.nome = nome;
		this.cep = cep;
	}

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
		Cities other = (Cities) obj;
		if (cep == null) {
		if (other.cep != null) {
		return false;
		}
		} else if (!cep.equals(other.cep)) {
		return false;
		}
		if (cod_cidades != other.cod_cidades) {
		return false;
		}
		if (estados_cod_estados != other.estados_cod_estados) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (nome == null) {
		if (other.nome != null) {
		return false;
		}
		} else if (!nome.equals(other.nome)) {
		return false;
		}
		return true;
	}

	public String getCep() {
		return cep;
	}

	public int getCod_cidades() {
		return cod_cidades;
	}

	public int getEstados_cod_estados() {
		return estados_cod_estados;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + cod_cidades;
		result = prime * result + estados_cod_estados;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCod_cidades(int cod_cidades) {
		this.cod_cidades = cod_cidades;
	}

	public void setEstados_cod_estados(int estados_cod_estados) {
		this.estados_cod_estados = estados_cod_estados;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cidades [id=" + id + ", estados_cod_estados=" + estados_cod_estados + ", cod_cidades=" + cod_cidades + ", nome=" + nome + ", cep="
				+ cep + ", getId()=" + getId() + ", getEstados_cod_estados()=" + getEstados_cod_estados() + ", getCod_cidades()=" + getCod_cidades()
				+ ", getNome()=" + getNome() + ", getCep()=" + getCep() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

}

