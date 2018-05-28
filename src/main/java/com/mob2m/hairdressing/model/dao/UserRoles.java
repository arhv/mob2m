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

@Entity(name = "tbl_user_roles")
@Table(schema = "hairdressing_master")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_role")
	private String userRoleName;

	@Column(name = "style_value_agenda")
	private String style_value_agenda;

	@Column(name = "style_value_comandas")
	private String style_value_comandas;

	@Column(name = "style_value_cadastro")
	private String style_value_cadastro;

	@Column(name = "style_value_servicos")
	private String style_value_servicos;

	@Column(name = "style_value_produtos")
	private String style_value_produtos;

	@Column(name = "style_value_administrativo")
	private String style_value_administrativo;

	@Column(name = "style_value_financeiro")
	private String style_value_financeiro;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userRoles")
	private Set<UserCompany> userCompany1 = new HashSet<>(0);

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_subsidiary")
	private CompanySubsidiaries companySubsidiaries;

	public UserRoles() {

	}

	public UserRoles(Long id, String userRoleName, String style_value_agenda, String style_value_comandas, String style_value_cadastro,
			String style_value_servicos, String style_value_produtos, String style_value_administrativo, String style_value_financeiro,
			Set<UserCompany> userCompany1, CompanySubsidiaries companySubsidiaries) {
		super();
		this.id = id;
		this.userRoleName = userRoleName;
		this.style_value_agenda = style_value_agenda;
		this.style_value_comandas = style_value_comandas;
		this.style_value_cadastro = style_value_cadastro;
		this.style_value_servicos = style_value_servicos;
		this.style_value_produtos = style_value_produtos;
		this.style_value_administrativo = style_value_administrativo;
		this.style_value_financeiro = style_value_financeiro;
		this.userCompany1 = userCompany1;
		this.companySubsidiaries = companySubsidiaries;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
		return true;
		}
		if (obj == null) {
		return false;
		}
		if (!(obj instanceof UserRoles)) {
		return false;
		}
		UserRoles other = (UserRoles) obj;
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (style_value_administrativo == null) {
		if (other.style_value_administrativo != null) {
		return false;
		}
		} else if (!style_value_administrativo.equals(other.style_value_administrativo)) {
		return false;
		}
		if (style_value_agenda == null) {
		if (other.style_value_agenda != null) {
		return false;
		}
		} else if (!style_value_agenda.equals(other.style_value_agenda)) {
		return false;
		}
		if (style_value_cadastro == null) {
		if (other.style_value_cadastro != null) {
		return false;
		}
		} else if (!style_value_cadastro.equals(other.style_value_cadastro)) {
		return false;
		}
		if (style_value_comandas == null) {
		if (other.style_value_comandas != null) {
		return false;
		}
		} else if (!style_value_comandas.equals(other.style_value_comandas)) {
		return false;
		}
		if (style_value_financeiro == null) {
		if (other.style_value_financeiro != null) {
		return false;
		}
		} else if (!style_value_financeiro.equals(other.style_value_financeiro)) {
		return false;
		}
		if (style_value_produtos == null) {
		if (other.style_value_produtos != null) {
		return false;
		}
		} else if (!style_value_produtos.equals(other.style_value_produtos)) {
		return false;
		}
		if (style_value_servicos == null) {
		if (other.style_value_servicos != null) {
		return false;
		}
		} else if (!style_value_servicos.equals(other.style_value_servicos)) {
		return false;
		}
		if (userCompany1 == null) {
		if (other.userCompany1 != null) {
		return false;
		}
		} else if (!userCompany1.equals(other.userCompany1)) {
		return false;
		}
		if (userRoleName == null) {
		if (other.userRoleName != null) {
		return false;
		}
		} else if (!userRoleName.equals(other.userRoleName)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the companySubsidiaries
	 */
	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the style_value_administrativo
	 */
	public String getStyle_value_administrativo() {
		return style_value_administrativo;
	}

	/**
	 * @return the style_value_agenda
	 */
	public String getStyle_value_agenda() {
		return style_value_agenda;
	}

	/**
	 * @return the style_value_cadastro
	 */
	public String getStyle_value_cadastro() {
		return style_value_cadastro;
	}

	/**
	 * @return the style_value_comandas
	 */
	public String getStyle_value_comandas() {
		return style_value_comandas;
	}

	/**
	 * @return the style_value_financeiro
	 */
	public String getStyle_value_financeiro() {
		return style_value_financeiro;
	}

	/**
	 * @return the style_value_produtos
	 */
	public String getStyle_value_produtos() {
		return style_value_produtos;
	}

	/**
	 * @return the style_value_servicos
	 */
	public String getStyle_value_servicos() {
		return style_value_servicos;
	}

	/**
	 * @return the userCompany1
	 */
	public Set<UserCompany> getUserCompany1() {
		return userCompany1;
	}

	/**
	 * @return the userRoleName
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((style_value_administrativo == null) ? 0 : style_value_administrativo.hashCode());
		result = prime * result + ((style_value_agenda == null) ? 0 : style_value_agenda.hashCode());
		result = prime * result + ((style_value_cadastro == null) ? 0 : style_value_cadastro.hashCode());
		result = prime * result + ((style_value_comandas == null) ? 0 : style_value_comandas.hashCode());
		result = prime * result + ((style_value_financeiro == null) ? 0 : style_value_financeiro.hashCode());
		result = prime * result + ((style_value_produtos == null) ? 0 : style_value_produtos.hashCode());
		result = prime * result + ((style_value_servicos == null) ? 0 : style_value_servicos.hashCode());
		result = prime * result + ((userCompany1 == null) ? 0 : userCompany1.hashCode());
		result = prime * result + ((userRoleName == null) ? 0 : userRoleName.hashCode());
		return result;
	}

	/**
	 * @param companySubsidiaries the companySubsidiaries to set
	 */
	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param style_value_administrativo the style_value_administrativo to set
	 */
	public void setStyle_value_administrativo(String style_value_administrativo) {
		this.style_value_administrativo = style_value_administrativo;
	}

	/**
	 * @param style_value_agenda the style_value_agenda to set
	 */
	public void setStyle_value_agenda(String style_value_agenda) {
		this.style_value_agenda = style_value_agenda;
	}

	/**
	 * @param style_value_cadastro the style_value_cadastro to set
	 */
	public void setStyle_value_cadastro(String style_value_cadastro) {
		this.style_value_cadastro = style_value_cadastro;
	}

	/**
	 * @param style_value_comandas the style_value_comandas to set
	 */
	public void setStyle_value_comandas(String style_value_comandas) {
		this.style_value_comandas = style_value_comandas;
	}

	/**
	 * @param style_value_financeiro the style_value_financeiro to set
	 */
	public void setStyle_value_financeiro(String style_value_financeiro) {
		this.style_value_financeiro = style_value_financeiro;
	}

	/**
	 * @param style_value_produtos the style_value_produtos to set
	 */
	public void setStyle_value_produtos(String style_value_produtos) {
		this.style_value_produtos = style_value_produtos;
	}

	/**
	 * @param style_value_servicos the style_value_servicos to set
	 */
	public void setStyle_value_servicos(String style_value_servicos) {
		this.style_value_servicos = style_value_servicos;
	}

	/**
	 * @param userCompany1 the userCompany1 to set
	 */
	public void setUserCompany1(Set<UserCompany> userCompany1) {
		this.userCompany1 = userCompany1;
	}

	/**
	 * @param userRoleName the userRoleName to set
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", userRoleName=" + userRoleName + ", style_value_agenda=" + style_value_agenda + ", style_value_comandas="
				+ style_value_comandas + ", style_value_cadastro=" + style_value_cadastro + ", style_value_servicos=" + style_value_servicos
				+ ", style_value_produtos=" + style_value_produtos + ", style_value_administrativo=" + style_value_administrativo
				+ ", style_value_financeiro=" + style_value_financeiro + ", userCompany1=" + userCompany1 + ", companySubsidiaries="
				+ companySubsidiaries + ", getId()=" + getId() + ", getUserRoleName()=" + getUserRoleName() + ", getStyle_value_agenda()="
				+ getStyle_value_agenda() + ", getStyle_value_comandas()=" + getStyle_value_comandas() + ", getStyle_value_cadastro()="
				+ getStyle_value_cadastro() + ", getStyle_value_servicos()=" + getStyle_value_servicos() + ", getStyle_value_produtos()="
				+ getStyle_value_produtos() + ", getStyle_value_administrativo()=" + getStyle_value_administrativo()
				+ ", getStyle_value_financeiro()=" + getStyle_value_financeiro() + ", getUserCompany1()=" + getUserCompany1()
				+ ", getCompanySubsidiaries()=" + getCompanySubsidiaries() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}*/


}