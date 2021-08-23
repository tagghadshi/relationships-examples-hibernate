package com.tcs.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class EmployeeEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;

	/**
	 * One-To-One With Foreign Key Associate
	 * 
	 * @OneToOne
	 * @JoinColumn(name = "ACCOUNT_ID")
	 */

	/**
	 * One-To-One With Common Join Table
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * @JoinTable(name="EMPLOYEE_ACCCOUNT", joinColumns
	 *                                      = @JoinColumn(name="EMPLOYEE_ID"),
	 *                                      inverseJoinColumns
	 *                                      = @JoinColumn(name="ACCOUNT_ID"))
	 */

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private AccountEntity account;

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
