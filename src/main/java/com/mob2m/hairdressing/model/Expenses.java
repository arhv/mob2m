package com.mob2m.hairdressing.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity(name = "tbl_expenses")
@Table(schema = "hairdressing_master")
public class Expenses implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "id")
	private int id;

	@Id
	@Column(name = "code_pk_tbl_expenses")
	private String code_pk_tbl_expenses;

	@Column(name = "active")
	private int active;

	@Column(name = "insertdate")
	private Date insertdate;

	@Column(name = "insertby")
	private String insertby;

	@Column(name = "category")
	private String category;

	@Column(name = "item")
	@NotEmpty(message = "Informação obrigatória.")
	private String item;

	@Column(name = "purchaseLocation")
	@NotEmpty(message = "Informação obrigatória.")
	private String purchaseLocation;

	@Column(name = "amount")
	@NotEmpty(message = "Informação obrigatória.")
	private BigDecimal amount;

	@Column(name = "paymentType")
	private String paymentType;

	@Column(name = "financingQuotas")
	@NotEmpty(message = "Informação obrigatória.")
	private String financingQuotas;

	@Column(name = "purchaseDate")
	@NotEmpty(message = "Informação obrigatória.")
	private Date purchaseDate;

	@Column(name = "effectiveExpenseDate")
	private Date effectiveExpenseDate;

	public int getActive() {
		return active;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getCategory() {
		return category;
	}

	public String getCode_pk_tbl_expenses() {
		return code_pk_tbl_expenses;
	}

	public Date getEffectiveExpenseDate() {
		return effectiveExpenseDate;
	}

	public String getFinancingQuotas() {
		return financingQuotas;
	}

	public int getId() {
		return id;
	}

	public String getInsertby() {
		return insertby;
	}

	public Date getInsertdate() {
		return insertdate;
	}

	public String getItem() {
		return item;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public String getPurchaseLocation() {
		return purchaseLocation;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCode_pk_tbl_expenses(String code_pk_tbl_expenses) {
		this.code_pk_tbl_expenses = code_pk_tbl_expenses;
	}

	public void setEffectiveExpenseDate(Date effectiveExpenseDate) {
		this.effectiveExpenseDate = effectiveExpenseDate;
	}

	public void setFinancingQuotas(String financingQuotas) {
		this.financingQuotas = financingQuotas;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInsertby(String insertby) {
		this.insertby = insertby;
	}

	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setPurchaseLocation(String purchaseLocation) {
		this.purchaseLocation = purchaseLocation;
	}

	@Override
	public String toString() {
		return "Expenses [id=" + id + ", code_pk_tbl_expenses=" + code_pk_tbl_expenses + ", active=" + active + ", insertdate=" + insertdate
				+ ", insertby=" + insertby + ", category=" + category + ", item=" + item + ", purchaseLocation=" + purchaseLocation + ", amount="
				+ amount + ", paymentType=" + paymentType + ", financingQuotas=" + financingQuotas + ", purchaseDate=" + purchaseDate
				+ ", effectiveExpenseDate=" + effectiveExpenseDate + ", getId()=" + getId() + ", getCode_pk_tbl_expenses()="
				+ getCode_pk_tbl_expenses() + ", getActive()=" + getActive() + ", getInsertdate()=" + getInsertdate() + ", getInsertby()="
				+ getInsertby() + ", getCategory()=" + getCategory() + ", getItem()=" + getItem() + ", getPurchaseLocation()=" + getPurchaseLocation()
				+ ", getAmount()=" + getAmount() + ", getPaymentType()=" + getPaymentType() + ", getFinancingQuotas()=" + getFinancingQuotas()
				+ ", getPurchaseDate()=" + getPurchaseDate() + ", getEffectiveExpenseDate()=" + getEffectiveExpenseDate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
