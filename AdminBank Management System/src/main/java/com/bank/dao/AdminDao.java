package com.bank.dao;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.Loan;
import com.bank.model.Transaction;

public interface  AdminDao {
	boolean login(String username, String password);
	boolean addAccount(Account acc);
	List<Account> viewAllAccounts();
	Account searchAccount(String accNo);
 	boolean deleteAccount(String accNo);
 	List<Transaction> viewTransactions(String accNo);
	List<Transaction> viewAllTransactions();
	int getTotalAccounts();
	double getTotalBankBalance();
	int getTotalLoans();
	int getPendingLoansCount();
	boolean applyLoan(Loan loan);   
	List<Loan> viewAllLoans();
	List<Loan> viewPendingLoans();
	List<Loan> viewApprovedLoans();
	List<Loan> viewRejectedLoans();
	boolean approveLoan(int loanId);
	boolean rejectLoan(int loanId);
}
