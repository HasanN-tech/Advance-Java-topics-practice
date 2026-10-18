package com.bank.model;

import java.util.Date;

public class Loan {
		private int loanId;
	    private int customerId;
	    private String loanType;
	    private double amount;
	    private int duration;
	    private String status;
	    private Date applyDate;
	    
	    public Loan() {
	    	
	    }
		public Loan(int loanId, int customerId, String loanType, double amount, int duration, String status,
				Date applyDate) {
			super();
			this.loanId = loanId;
			this.customerId = customerId;
			this.loanType = loanType;
			this.amount = amount;
			this.duration = duration;
			this.status = status;
			this.applyDate = applyDate;
		}
		public int getLoanId() {
			return loanId;
		}
		public void setLoanId(int loanId) {
			this.loanId = loanId;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getLoanType() {
			return loanType;
		}
		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Date getApplyDate() {
			return applyDate;
		}
		public void setApplyDate(Date applyDate) {
			this.applyDate = applyDate;
		}
	    
	    
}
