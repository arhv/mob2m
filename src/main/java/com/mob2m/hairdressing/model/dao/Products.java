//To be created in a separated schema from Hairdressing schema

package com.mob2m.hairdressing.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tbl_products")
@Table(schema = "hairdressing_master")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "productNickName")
	private String productNickName;

	@Column(name = "productOfficialName")
	private String productOfficialName;

	@Column(name = "barcode", unique = true)
	private String barcode;

	@Column(name = "contentValue")
	private String contentValue;

	@Column(name = "unitContent")
	private String unitContent;

	@Column(name = "company")
	private String company;

	@Column(name = "companySubsidiaryId")
	private Long companySubsidiaryId;

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
		if (!(obj instanceof Products)) {
		return false;
		}
		Products other = (Products) obj;
		if (barcode == null) {
		if (other.barcode != null) {
		return false;
		}
		} else if (!barcode.equals(other.barcode)) {
		return false;
		}
		if (company == null) {
		if (other.company != null) {
		return false;
		}
		} else if (!company.equals(other.company)) {
		return false;
		}
		if (companySubsidiaryId == null) {
		if (other.companySubsidiaryId != null) {
		return false;
		}
		} else if (!companySubsidiaryId.equals(other.companySubsidiaryId)) {
		return false;
		}
		if (contentValue == null) {
		if (other.contentValue != null) {
		return false;
		}
		} else if (!contentValue.equals(other.contentValue)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (productNickName == null) {
		if (other.productNickName != null) {
		return false;
		}
		} else if (!productNickName.equals(other.productNickName)) {
		return false;
		}
		if (productOfficialName == null) {
		if (other.productOfficialName != null) {
		return false;
		}
		} else if (!productOfficialName.equals(other.productOfficialName)) {
		return false;
		}
		if (unitContent == null) {
		if (other.unitContent != null) {
		return false;
		}
		} else if (!unitContent.equals(other.unitContent)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @return the companySubsidiaryId
	 */
	public Long getCompanySubsidiaryId() {
		return companySubsidiaryId;
	}

	/**
	 * @return the contentValue
	 */
	public String getContentValue() {
		return contentValue;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the productNickName
	 */
	public String getProductNickName() {
		return productNickName;
	}

	/**
	 * @return the productOfficialName
	 */
	public String getProductOfficialName() {
		return productOfficialName;
	}

	/**
	 * @return the unitContent
	 */
	public String getUnitContent() {
		return unitContent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((companySubsidiaryId == null) ? 0 : companySubsidiaryId.hashCode());
		result = prime * result + ((contentValue == null) ? 0 : contentValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productNickName == null) ? 0 : productNickName.hashCode());
		result = prime * result + ((productOfficialName == null) ? 0 : productOfficialName.hashCode());
		result = prime * result + ((unitContent == null) ? 0 : unitContent.hashCode());
		return result;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @param companySubsidiaryId the companySubsidiaryId to set
	 */
	public void setCompanySubsidiaryId(Long companySubsidiaryId) {
		this.companySubsidiaryId = companySubsidiaryId;
	}

	/**
	 * @param contentValue the contentValue to set
	 */
	public void setContentValue(String contentValue) {
		this.contentValue = contentValue;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param productNickName the productNickName to set
	 */
	public void setProductNickName(String productNickName) {
		this.productNickName = productNickName;
	}

	/**
	 * @param productOfficialName the productOfficialName to set
	 */
	public void setProductOfficialName(String productOfficialName) {
		this.productOfficialName = productOfficialName;
	}

	/**
	 * @param unitContent the unitContent to set
	 */
	public void setUnitContent(String unitContent) {
		this.unitContent = unitContent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Products [id=" + id + ", productNickName=" + productNickName + ", productOfficialName=" + productOfficialName + ", barcode=" + barcode
				+ ", contentValue=" + contentValue + ", unitContent=" + unitContent + ", company=" + company + ", companySubsidiaryId="
				+ companySubsidiaryId + ", getId()=" + getId() + ", getProductNickName()=" + getProductNickName() + ", getProductOfficialName()="
				+ getProductOfficialName() + ", getBarcode()=" + getBarcode() + ", getContentValue()=" + getContentValue() + ", getUnitContent()="
				+ getUnitContent() + ", getCompany()=" + getCompany() + ", getCompanySubsidiaryId()=" + getCompanySubsidiaryId() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
