package com.mob2m.expense.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "tbl_expenses")
public class ExpensesModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Informação obrigatória.")
	private String category;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Informação obrigatória.")
	private String item;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Informação obrigatória.")
	private String purchase_location;
	
	@Column(nullable = false, length = 10)
	@NotBlank(message = "Informação obrigatória.")
	private BigDecimal amount;

	@Column(nullable = false, length = 150)
	@NotBlank(message = "Informação obrigatória.")
	private String payment_type;

	@Column(nullable = false, length = 150)
	@NotBlank(message = "Informação obrigatória.")
	private String purchase_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPurchase_location() {
		return purchase_location;
	}

	public void setPurchase_location(String purchase_location) {
		this.purchase_location = purchase_location;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

}
