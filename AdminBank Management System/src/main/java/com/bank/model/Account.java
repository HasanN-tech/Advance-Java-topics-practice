package com.bank.model;

public class Account {
	private int userId;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String accountNumber;
    private Long PhoneNo;
    private Double balance;
    
    public Account() {
    	
    }
	public Account(int userId, String fullName, String email, String username, String password, String accountNumber,
			Long phoneNo) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accountNumber = accountNumber;
		PhoneNo = phoneNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		PhoneNo = phoneNo;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
