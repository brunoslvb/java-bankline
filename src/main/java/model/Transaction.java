package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Account originAccount;
	
	@ManyToOne
	private Account destinyAccount;
	
	@Enumerated(EnumType.STRING)
	private PlanAccount type;
	
	private Date date;
	private Double amount;
	private String detail;
	

	public Transaction() {}
	
	public Transaction(Integer id, Account originAccount, Account destinyAccount, PlanAccount type, Date date,
			Double amount, String detail) {
		super();
		this.id = id;
		this.originAccount = originAccount;
		this.destinyAccount = destinyAccount;
		this.type = type;
		this.date = date;
		this.amount = amount;
		this.detail = detail;
	}
	
	public Integer getId() {
		return id;
	}
	
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


