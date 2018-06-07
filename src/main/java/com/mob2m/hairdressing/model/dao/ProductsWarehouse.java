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

@Entity(name = "tbl_products_warehouse")
@Table(schema = "hairdressing_master")
public class ProductsWarehouse implements Serializable {

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

	@Column(name = "product_quantity")
	private int product_quantity;

	@Column(name = "product_unit_cost")
	private double product_unit_cost;

	@Column(name = "product_goal")
	private String product_goal;

	@Column(name = "in_out")
	private String in_out;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_name_id")
	private CompanySubsidiaries companySubsidiaries;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_name_id")
	private Products products;

	public ProductsWarehouse() {

	}

	public ProductsWarehouse(Long id, String product_package, int product_quantity, double product_unit_cost, String product_goal, String in_out,
			CompanySubsidiaries companySubsidiaries, Products products) {
		super();
		this.id = id;
		this.product_package = product_package;
		this.product_quantity = product_quantity;
		this.product_unit_cost = product_unit_cost;
		this.product_goal = product_goal;
		this.in_out = in_out;
		this.companySubsidiaries = companySubsidiaries;
		this.products = products;
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
		if (!(obj instanceof ProductsWarehouse)) {
		return false;
		}
		ProductsWarehouse other = (ProductsWarehouse) obj;
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
		if (in_out == null) {
		if (other.in_out != null) {
		return false;
		}
		} else if (!in_out.equals(other.in_out)) {
		return false;
		}
		if (product_goal == null) {
		if (other.product_goal != null) {
		return false;
		}
		} else if (!product_goal.equals(other.product_goal)) {
		return false;
		}
		if (product_package == null) {
		if (other.product_package != null) {
		return false;
		}
		} else if (!product_package.equals(other.product_package)) {
		return false;
		}
		if (product_quantity != other.product_quantity) {
		return false;
		}
		if (Double.doubleToLongBits(product_unit_cost) != Double.doubleToLongBits(other.product_unit_cost)) {
		return false;
		}
		if (products == null) {
		if (other.products != null) {
		return false;
		}
		} else if (!products.equals(other.products)) {
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
	 * @return the in_out
	 */
	public String getIn_out() {
		return in_out;
	}

	/**
	 * @return the product_goal
	 */
	public String getProduct_goal() {
		return product_goal;
	}

	/**
	 * @return the product_package
	 */
	public String getProduct_package() {
		return product_package;
	}

	/**
	 * @return the product_quantity
	 */
	public int getProduct_quantity() {
		return product_quantity;
	}

	/**
	 * @return the product_unit_cost
	 */
	public double getProduct_unit_cost() {
		return product_unit_cost;
	}

	/**
	 * @return the products
	 */
	public Products getProducts() {
		return products;
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
		result = prime * result + ((in_out == null) ? 0 : in_out.hashCode());
		result = prime * result + ((product_goal == null) ? 0 : product_goal.hashCode());
		result = prime * result + ((product_package == null) ? 0 : product_package.hashCode());
		result = prime * result + product_quantity;
		long temp;
		temp = Double.doubleToLongBits(product_unit_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
	 * @param in_out the in_out to set
	 */
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}

	/**
	 * @param product_goal the product_goal to set
	 */
	public void setProduct_goal(String product_goal) {
		this.product_goal = product_goal;
	}

	/**
	 * @param product_package the product_package to set
	 */
	public void setProduct_package(String product_package) {
		this.product_package = product_package;
	}

	/**
	 * @param product_quantity the product_quantity to set
	 */
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	/**
	 * @param product_unit_cost the product_unit_cost to set
	 */
	public void setProduct_unit_cost(double product_unit_cost) {
		this.product_unit_cost = product_unit_cost;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Products products) {
		this.products = products;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "ProductsWarehouse [id=" + id + ", product_package=" + product_package + ", product_quantity=" + product_quantity
				+ ", product_unit_cost=" + product_unit_cost + ", product_goal=" + product_goal + ", in_out=" + in_out + ", companySubsidiaries="
				+ companySubsidiaries + ", products=" + products + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}*/



}

