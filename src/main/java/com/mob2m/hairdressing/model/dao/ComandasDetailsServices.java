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

@Entity(name = "tbl_comandas_details_services")
@Table(schema = "hairdressing_master")
public class ComandasDetailsServices implements Serializable {

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
	@JoinColumn(name = "service_id")
	private Services services;

	@Column(name = "service_usage_value")
	private double service_value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_principal")
	private Professionals professionals;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_aux_1")
	private Professionals professionals1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professional_aux_2")
	private Professionals professionals2;

	public ComandasDetailsServices() {

	}

	public ComandasDetailsServices(Long id, ComandasMaster comandasMaster, String comanda_details_type, Services services, double service_value,
			Professionals professionals, Professionals professionals1, Professionals professionals2) {
		super();
		this.id = id;
		this.comandasMaster = comandasMaster;
		this.comanda_details_type = comanda_details_type;
		this.services = services;
		this.service_value = service_value;
		this.professionals = professionals;
		this.professionals1 = professionals1;
		this.professionals2 = professionals2;
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
		if (!(obj instanceof ComandasDetailsServices)) {
		return false;
		}
		ComandasDetailsServices other = (ComandasDetailsServices) obj;
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
		if (professionals == null) {
		if (other.professionals != null) {
		return false;
		}
		} else if (!professionals.equals(other.professionals)) {
		return false;
		}
		if (professionals1 == null) {
		if (other.professionals1 != null) {
		return false;
		}
		} else if (!professionals1.equals(other.professionals1)) {
		return false;
		}
		if (professionals2 == null) {
		if (other.professionals2 != null) {
		return false;
		}
		} else if (!professionals2.equals(other.professionals2)) {
		return false;
		}
		if (Double.doubleToLongBits(service_value) != Double.doubleToLongBits(other.service_value)) {
		return false;
		}
		if (services == null) {
		if (other.services != null) {
		return false;
		}
		} else if (!services.equals(other.services)) {
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
	 * @return the professionals
	 */
	public Professionals getProfessionals() {
		return professionals;
	}

	/**
	 * @return the professionals1
	 */
	public Professionals getProfessionals1() {
		return professionals1;
	}

	/**
	 * @return the professionals2
	 */
	public Professionals getProfessionals2() {
		return professionals2;
	}

	/**
	 * @return the service_value
	 */
	public double getService_value() {
		return service_value;
	}

	/**
	 * @return the services
	 */
	public Services getServices() {
		return services;
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
		//result = prime * result + ((professionals == null) ? 0 : professionals.hashCode());
		//result = prime * result + ((professionals1 == null) ? 0 : professionals1.hashCode());
		//result = prime * result + ((professionals2 == null) ? 0 : professionals2.hashCode());
		long temp;
		temp = Double.doubleToLongBits(service_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((services == null) ? 0 : services.hashCode());
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
	 * @param professionals the professionals to set
	 */
	public void setProfessionals(Professionals professionals) {
		this.professionals = professionals;
	}

	/**
	 * @param professionals1 the professionals1 to set
	 */
	public void setProfessionals1(Professionals professionals1) {
		this.professionals1 = professionals1;
	}

	/**
	 * @param professionals2 the professionals2 to set
	 */
	public void setProfessionals2(Professionals professionals2) {
		this.professionals2 = professionals2;
	}

	/**
	 * @param service_value the service_value to set
	 */
	public void setService_value(double service_value) {
		this.service_value = service_value;
	}

	/**
	 * @param services the services to set
	 */
	public void setServices(Services services) {
		this.services = services;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()

	@Override
	public String toString() {
		return "ComandasDetailsServices [id=" + id + ", comandasMaster=" + comandasMaster + ", comanda_details_type=" + comanda_details_type
				+ ", services=" + services + ", service_value=" + service_value + ", professionals=" + professionals + ", professionals1="
				+ professionals1 + ", professionals2=" + professionals2 + ", getProfessionals1()=" + getProfessionals1() + ", getProfessionals2()="
				+ getProfessionals2() + ", getComanda_details_type()=" + getComanda_details_type() + ", getComandasMaster()=" + getComandasMaster()
				+ ", getId()=" + getId() + ", getProfessionals()=" + getProfessionals() + ", getService_value()=" + getService_value()
				+ ", getServices()=" + getServices() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}*/

}

