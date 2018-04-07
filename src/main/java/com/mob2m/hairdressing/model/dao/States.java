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
@Entity(name = "tbl_estados")
@Table(schema = "hairdressing_master")
public class States implements Serializable {

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
	@Column(name = "cod_estados")
	private int cod_estados;

	@XmlElement
	@Column(name = "sigla")
	private String sigla;

	@XmlElement
	@Column(name = "nome")
	private String nome;

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
		States other = (States) obj;
		if (cod_estados != other.cod_estados) {
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
		if (sigla == null) {
		if (other.sigla != null) {
		return false;
		}
		} else if (!sigla.equals(other.sigla)) {
		return false;
		}
		return true;
	}

	public int getCod_estados() {
		return cod_estados;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_estados;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	public void setCod_estados(int cod_estados) {
		this.cod_estados = cod_estados;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Estados [id=" + id + ", cod_estados=" + cod_estados + ", sigla=" + sigla + ", nome=" + nome + ", getId()=" + getId()
		+ ", getCod_estados()=" + getCod_estados() + ", getSigla()=" + getSigla() + ", getNome()=" + getNome() + ", hashCode()=" + hashCode()
		+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


}

