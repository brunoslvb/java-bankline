package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;

@Entity
public class User {
	@Id
	@Column(nullable = false)
	private String cpf;
	
	@Column(unique = true, nullable = false, length = 20)
	private String login;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private StatusAccount status = StatusAccount.ENABLE;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public StatusAccount getStatus() {
		return status;
	}
	public void setStatus(StatusAccount status) {
		this.status = status;
	}
	

}
