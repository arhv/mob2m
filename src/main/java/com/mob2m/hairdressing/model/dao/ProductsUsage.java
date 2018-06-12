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

@Entity(name = "tbl_products_usage")
@Table(schema = "hairdressing_master")
public class ProductsUsage implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_package")
	private String product_package;

	@Column(name = "quantity_unitary_usage")
	private double quantity_unitary_usage;

	@Column(name = "operational_cost")
	private double operational_cost;

	@Column(name = "product_usage_cost")
	private double product_usage_cost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_name_id")
	private CompanySubsidiaries companySubsidiaries;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_name_id")
	private Products products;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productsUsage")
	private Set<ProductsUsage> productsUsage = new HashSet<>(0);

	public ProductsUsage() {

	}

	public ProductsUsage(Long id, String product_package, double quantity_unitary_usage, double operational_cost, double product_usage_cost,
			CompanySubsidiaries companySubsidiaries, Products products, Set<ProductsUsage> productsUsage) {
		super();
		this.id = id;
		this.product_package = product_package;
		this.quantity_unitary_usage = quantity_unitary_usage;
		this.operational_cost = operational_cost;
		this.product_usage_cost = product_usage_cost;
		this.companySubsidiaries = companySubsidiaries;
		this.products = products;
		this.productsUsage = productsUsage;
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
		if (!(obj instanceof ProductsUsage)) {
		return false;
		}
		ProductsUsage other = (ProductsUsage) obj;
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
		if (Double.doubleToLongBits(operational_cost) != Double.doubleToLongBits(other.operational_cost)) {
		return false;
		}
		if (product_package == null) {
		if (other.product_package != null) {
		return false;
		}
		} else if (!product_package.equals(other.product_package)) {
		return false;
		}
		if (Double.doubleToLongBits(product_usage_cost) != Double.doubleToLongBits(other.product_usage_cost)) {
		return false;
		}
		if (products == null) {
		if (other.products != null) {
		return false;
		}
		} else if (!products.equals(other.products)) {
		return false;
		}
		if (productsUsage == null) {
		if (other.productsUsage != null) {
		return false;
		}
		} else if (!productsUsage.equals(other.productsUsage)) {
		return false;
		}
		if (Double.doubleToLongBits(quantity_unitary_usage) != Double.doubleToLongBits(other.quantity_unitary_usage)) {
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
	 * @return the operational_cost
	 */
	public double getOperational_cost() {
		return operational_cost;
	}

	/**
	 * @return the product_package
	 */
	public String getProduct_package() {
		return product_package;
	}

	/**
	 * @return the product_usage_cost
	 */
	public double getProduct_usage_cost() {
		return product_usage_cost;
	}

	/**
	 * @return the products
	 */
	public Products getProducts() {
		return products;
	}

	/**
	 * @return the productsUsage
	 */
	public Set<ProductsUsage> getProductsUsage() {
		return productsUsage;
	}

	/**
	 * @return the quantity_unitary_usage
	 */
	public double getQuantity_unitary_usage() {
		return quantity_unitary_usage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(operational_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product_package == null) ? 0 : product_package.hashCode());
		temp = Double.doubleToLongBits(product_usage_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		//result = prime * result + ((products == null) ? 0 : products.hashCode());
		//result = prime * result + ((productsUsage == null) ? 0 : productsUsage.hashCode());
		temp = Double.doubleToLongBits(quantity_unitary_usage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
	 * @param operational_cost the operational_cost to set
	 */
	public void setOperational_cost(double operational_cost) {
		this.operational_cost = operational_cost;
	}

	/**
	 * @param product_package the product_package to set
	 */
	public void setProduct_package(String product_package) {
		this.product_package = product_package;
	}

	/**
	 * @param product_usage_cost the product_usage_cost to set
	 */
	public void setProduct_usage_cost(double product_usage_cost) {
		this.product_usage_cost = product_usage_cost;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Products products) {
		this.products = products;
	}

	/**
	 * @param productsUsage the productsUsage to set
	 */
	public void setProductsUsage(Set<ProductsUsage> productsUsage) {
		this.productsUsage = productsUsage;
	}

	/**
	 * @param quantity_unitary_usage the quantity_unitary_usage to set
	 */
	public void setQuantity_unitary_usage(double quantity_unitary_usage) {
		this.quantity_unitary_usage = quantity_unitary_usage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "ProductsUsage [id=" + id + ", product_package=" + product_package + ", quantity_unitary_usage=" + quantity_unitary_usage
				+ ", operational_cost=" + operational_cost + ", product_usage_cost=" + product_usage_cost + ", companySubsidiaries="
				+ companySubsidiaries + ", products=" + products + ", productsUsage=" + productsUsage + ", getCompanySubsidiaries()="
				+ getCompanySubsidiaries() + ", getId()=" + getId() + ", getOperational_cost()=" + getOperational_cost() + ", getProduct_package()="
				+ getProduct_package() + ", getProduct_usage_cost()=" + getProduct_usage_cost() + ", getProducts()=" + getProducts()
				+ ", getQuantity_unitary_usage()=" + getQuantity_unitary_usage() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}*/

}

