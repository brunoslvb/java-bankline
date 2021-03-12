package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// @Entity
public class Transactions {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;*/
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_account",foreignKey = @ForeignKey(name = "fk_account"))
	private Account originAccount;
	private Account destinyAccount;
	private Date date;
	private PlanAccount type;
	private Double amount;
	private String detail;
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public PlanAccount getType() {
		return type;
	}
	public void setType(PlanAccount type) {
		this.type = type;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Account getOriginAccount() {
		return originAccount;
	}
	public void setOriginAccount(Account originAccount) {
		this.originAccount = originAccount;
	}
	
	public Account getDestinyAccount() {
		return destinyAccount;
	}
	public void setDestinyAccount(Account destinyAccount) {
		this.destinyAccount = destinyAccount;
	}
	
	
}


