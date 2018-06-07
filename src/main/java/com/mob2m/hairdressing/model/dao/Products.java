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

	@Column(name = "company_subsidiary_id")
	private int company_subsidiary_id;

	@Column(name = "product_nick_name")
	private String productNickName;

	@Column(name = "product_official_name")
	private String productOfficialName;

	@Column(name = "barcode", unique = true)
	private String barcode;

	@Column(name = "content_value")
	private String contentValue;

	@Column(name = "unit_content")
	private String unitContent;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_name_id")
	private CompanySubsidiaries companySubsidiaries;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private Set<ProductsReselling> productsReselling = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private Set<ProductsUsage> productsUsage = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private Set<ProductsWarehouse> productsWarehouse = new HashSet<>(0);

	public Products() {

	}


	public Products(Long id, int company_subsidiary_id, String productNickName, String productOfficialName, String barcode, String contentValue,
			String unitContent, CompanySubsidiaries companySubsidiaries, Set<ProductsReselling> productsReselling, Set<ProductsUsage> productsUsage,
			Set<ProductsWarehouse> productsWarehouse) {
		super();
		this.id = id;
		this.company_subsidiary_id = company_subsidiary_id;
		this.productNickName = productNickName;
		this.productOfficialName = productOfficialName;
		this.barcode = barcode;
		this.contentValue = contentValue;
		this.unitContent = unitContent;
		this.companySubsidiaries = companySubsidiaries;
		this.productsReselling = productsReselling;
		this.productsUsage = productsUsage;
		this.productsWarehouse = productsWarehouse;
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
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (company_subsidiary_id != other.company_subsidiary_id) {
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
		if (productsReselling == null) {
		if (other.productsReselling != null) {
		return false;
		}
		} else if (!productsReselling.equals(other.productsReselling)) {
		return false;
		}
		if (productsUsage == null) {
		if (other.productsUsage != null) {
		return false;
		}
		} else if (!productsUsage.equals(other.productsUsage)) {
		return false;
		}
		if (productsWarehouse == null) {
		if (other.productsWarehouse != null) {
		return false;
		}
		} else if (!productsWarehouse.equals(other.productsWarehouse)) {
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
	 * @return the company_subsidiary_id
	 */
	public int getCompany_subsidiary_id() {
		return company_subsidiary_id;
	}

	/**
	 * @return the companySubsidiaries
	 */
	public CompanySubsidiaries getCompanySubsidiaries() {
		return companySubsidiaries;
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
	 * @return the productsReselling
	 */
	public Set<ProductsReselling> getProductsReselling() {
		return productsReselling;
	}

	/**
	 * @return the productsUsage
	 */
	public Set<ProductsUsage> getProductsUsage() {
		return productsUsage;
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
		result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + company_subsidiary_id;
		result = prime * result + ((contentValue == null) ? 0 : contentValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productNickName == null) ? 0 : productNickName.hashCode());
		result = prime * result + ((productOfficialName == null) ? 0 : productOfficialName.hashCode());
		//result = prime * result + ((productsReselling == null) ? 0 : productsReselling.hashCode());
		result = prime * result + ((productsUsage == null) ? 0 : productsUsage.hashCode());
		//result = prime * result + ((productsWarehouse == null) ? 0 : productsWarehouse.hashCode());
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
	 * @param company_subsidiary_id the company_subsidiary_id to set
	 */
	public void setCompany_subsidiary_id(int company_subsidiary_id) {
		this.company_subsidiary_id = company_subsidiary_id;
	}

	/**
	 * @param companySubsidiaries the companySubsidiaries to set
	 */
	public void setCompanySubsidiaries(CompanySubsidiaries companySubsidiaries) {
		this.companySubsidiaries = companySubsidiaries;
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
	 * @param productsReselling the productsReselling to set
	 */
	public void setProductsReselling(Set<ProductsReselling> productsReselling) {
		this.productsReselling = productsReselling;
	}

	/**
	 * @param productsUsage the productsUsage to set
	 */
	public void setProductsUsage(Set<ProductsUsage> productsUsage) {
		this.productsUsage = productsUsage;
	}

	/**
	 * @param unitContent the unitContent to set
	 */
	public void setUnitContent(String unitContent) {
		this.unitContent = unitContent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "Products [id=" + id + ", company_subsidiary_id=" + company_subsidiary_id + ", productNickName=" + productNickName
				+ ", productOfficialName=" + productOfficialName + ", barcode=" + barcode + ", contentValue=" + contentValue + ", unitContent="
				+ unitContent + ", companySubsidiaries=" + companySubsidiaries + ", productsReselling=" + productsReselling + ", productsUsage="
				+ productsUsage + ", productsWarehouse=" + productsWarehouse + ", getBarcode()=" + getBarcode() + ", getCompany_subsidiary_id()="
				+ getCompany_subsidiary_id() + ", getCompanySubsidiaries()=" + getCompanySubsidiaries() + ", getContentValue()=" + getContentValue()
				+ ", getId()=" + getId() + ", getProductNickName()=" + getProductNickName() + ", getProductOfficialName()=" + getProductOfficialName()
				+ ", getProductsReselling()=" + getProductsReselling() + ", getProductsUsage()=" + getProductsUsage() + ", getUnitContent()="
				+ getUnitContent() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/


}

