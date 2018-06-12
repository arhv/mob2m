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

@Entity(name = "tbl_comandas_details_products_usage")
@Table(schema = "hairdressing_master")
public class ComandasDetailsProductsUsage implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comandas_master_id")
	private ComandasMaster comandasMaster;

	@Column(name = "comanda_details_type")
	private String comanda_details_type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_usage_id")
	private ProductsUsage productsUsage;

	@Column(name = "quantity_unitary_usage")
	private double quantity_unitary_usage;

	@Column(name = "product_usage_cost")
	private double product_usage_cost;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_principal")
	private Professionals professionals;



	public ComandasDetailsProductsUsage() {

	}

	public ComandasDetailsProductsUsage(Long id, ComandasMaster comandasMaster, String comanda_details_type, ProductsUsage productsUsage,
			double quantity_unitary_usage, double product_usage_cost, Professionals professionals) {
		super();
		this.id = id;
		this.comandasMaster = comandasMaster;
		this.comanda_details_type = comanda_details_type;
		this.productsUsage = productsUsage;
		this.quantity_unitary_usage = quantity_unitary_usage;
		this.product_usage_cost = product_usage_cost;
		this.professionals = professionals;
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
		if (!(obj instanceof ComandasDetailsProductsUsage)) {
		return false;
		}
		ComandasDetailsProductsUsage other = (ComandasDetailsProductsUsage) obj;
		if (comanda_details_type == null) {
		if (other.comanda_details_type != null) {
		return false;
		}
		} else if (!comanda_details_type.equals(other.comanda_details_type)) {
		return false;
		}
		if (comandasMaster == null) {
		if (other.comandasMaster != null) {
		return false;
		}
		} else if (!comandasMaster.equals(other.comandasMaster)) {
		return false;
		}
		if (id == null) {
		if (other.id != null) {
		return false;
		}
		} else if (!id.equals(other.id)) {
		return false;
		}
		if (Double.doubleToLongBits(product_usage_cost) != Double.doubleToLongBits(other.product_usage_cost)) {
		return false;
		}
		if (productsUsage == null) {
		if (other.productsUsage != null) {
		return false;
		}
		} else if (!productsUsage.equals(other.productsUsage)) {
		return false;
		}
		if (professionals == null) {
		if (other.professionals != null) {
		return false;
		}
		} else if (!professionals.equals(other.professionals)) {
		return false;
		}
		if (Double.doubleToLongBits(quantity_unitary_usage) != Double.doubleToLongBits(other.quantity_unitary_usage)) {
		return false;
		}
		return true;
	}

	/**
	 * @return the comanda_details_type
	 */
	public String getComanda_details_type() {
		return comanda_details_type;
	}

	/**
	 * @return the comandasMaster
	 */
	public ComandasMaster getComandasMaster() {
		return comandasMaster;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the product_usage_cost
	 */
	public double getProduct_usage_cost() {
		return product_usage_cost;
	}

	/**
	 * @return the productsUsage
	 */
	public ProductsUsage getProductsUsage() {
		return productsUsage;
	}

	/**
	 * @return the professionals
	 */
	public Professionals getProfessionals() {
		return professionals;
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
		result = prime * result + ((comanda_details_type == null) ? 0 : comanda_details_type.hashCode());
		//result = prime * result + ((comandasMaster == null) ? 0 : comandasMaster.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(product_usage_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productsUsage == null) ? 0 : productsUsage.hashCode());
		result = prime * result + ((professionals == null) ? 0 : professionals.hashCode());
		temp = Double.doubleToLongBits(quantity_unitary_usage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * @param comanda_details_type the comanda_details_type to set
	 */
	public void setComanda_details_type(String comanda_details_type) {
		this.comanda_details_type = comanda_details_type;
	}

	/**
	 * @param comandasMaster the comandasMaster to set
	 */
	public void setComandasMaster(ComandasMaster comandasMaster) {
		this.comandasMaster = comandasMaster;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param product_usage_cost the product_usage_cost to set
	 */
	public void setProduct_usage_cost(double product_usage_cost) {
		this.product_usage_cost = product_usage_cost;
	}

	/**
	 * @param productsUsage the productsUsage to set
	 */
	public void setProductsUsage(ProductsUsage productsUsage) {
		this.productsUsage = productsUsage;
	}

	/**
	 * @param professionals the professionals to set
	 */
	public void setProfessionals(Professionals professionals) {
		this.professionals = professionals;
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
		return "ComandasDetailsProductsUsage [id=" + id + ", comandasMaster=" + comandasMaster + ", comanda_details_type=" + comanda_details_type
				+ ", productsUsage=" + productsUsage + ", quantity_unitary_usage=" + quantity_unitary_usage + ", product_usage_cost="
				+ product_usage_cost + ", professionals=" + professionals + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}*/


}

