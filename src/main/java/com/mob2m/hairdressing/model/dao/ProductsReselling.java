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

@Entity(name = "tbl_products_reselling")
@Table(schema = "hairdressing_master")
public class ProductsReselling implements Serializable {

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

	@Column(name = "gross_profit")
	private double gross_profit;

	@Column(name = "net_price")
	private double net_price;

	@Column(name = "sales_commission")
	private double sales_commission;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_name_id")
	private CompanySubsidiaries companySubsidiaries;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_name_id")
	private Products products;

	public ProductsReselling() {

	}


	public ProductsReselling(Long id, String product_package, double gross_profit, double net_price, double sales_commission,
			CompanySubsidiaries companySubsidiaries, Products products) {
		super();
		this.id = id;
		this.product_package = product_package;
		this.gross_profit = gross_profit;
		this.net_price = net_price;
		this.sales_commission = sales_commission;
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
		if (!(obj instanceof ProductsReselling)) {
		return false;
		}
		ProductsReselling other = (ProductsReselling) obj;
		if (companySubsidiaries == null) {
		if (other.companySubsidiaries != null) {
		return false;
		}
		} else if (!companySubsidiaries.equals(other.companySubsidiaries)) {
		return false;
		}
		if (Double.doubleToLongBits(gross_profit) != Double.doubleToLongBits(other.gross_profit)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (Double.doubleToLongBits(net_price) != Double.doubleToLongBits(other.net_price)) {
		return false;
		}
		if (product_package == null) {
		if (other.product_package != null) {
		return false;
		}
		} else if (!product_package.equals(other.product_package)) {
		return false;
		}
		if (products == null) {
		if (other.products != null) {
		return false;
		}
		} else if (!products.equals(other.products)) {
		return false;
		}
		if (Double.doubleToLongBits(sales_commission) != Double.doubleToLongBits(other.sales_commission)) {
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
	 * @return the gross_profit
	 */
	public double getGross_profit() {
		return gross_profit;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the net_price
	 */
	public double getNet_price() {
		return net_price;
	}

	/**
	 * @return the product_package
	 */
	public String getProduct_package() {
		return product_package;
	}

	/**
	 * @return the products
	 */
	public Products getProducts() {
		return products;
	}

	/**
	 * @return the sales_commission
	 */
	public double getSales_commission() {
		return sales_commission;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companySubsidiaries == null) ? 0 : companySubsidiaries.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gross_profit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(net_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product_package == null) ? 0 : product_package.hashCode());
		//result = prime * result + ((products == null) ? 0 : products.hashCode());
		temp = Double.doubleToLongBits(sales_commission);
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
	 * @param gross_profit the gross_profit to set
	 */
	public void setGross_profit(double gross_profit) {
		this.gross_profit = gross_profit;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param net_price the net_price to set
	 */
	public void setNet_price(double net_price) {
		this.net_price = net_price;
	}

	/**
	 * @param product_package the product_package to set
	 */
	public void setProduct_package(String product_package) {
		this.product_package = product_package;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Products products) {
		this.products = products;
	}

	/**
	 * @param sales_commission the sales_commission to set
	 */
	public void setSales_commission(double sales_commission) {
		this.sales_commission = sales_commission;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "ProductsReselling [id=" + id + ", product_package=" + product_package + ", gross_profit=" + gross_profit + ", net_price=" + net_price
				+ ", sales_commission=" + sales_commission + ", companySubsidiaries=" + companySubsidiaries + ", products=" + products
				+ ", getSales_commission()=" + getSales_commission() + ", getCompanySubsidiaries()=" + getCompanySubsidiaries()
				+ ", getGross_profit()=" + getGross_profit() + ", getId()=" + getId() + ", getNet_price()=" + getNet_price()
				+ ", getProduct_package()=" + getProduct_package() + ", getProducts()=" + getProducts() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}*/

}

