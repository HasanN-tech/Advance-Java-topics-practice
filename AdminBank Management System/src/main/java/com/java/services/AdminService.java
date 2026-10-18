package com.java.services;

import java.util.List;
import com.bank.model.*;

public interface AdminService {

    // Login
    boolean login(String username, String password);

    // Account
    boolean addAccount(Account acc);
    List<Account> viewAllAccounts();
    Account searchAccount(String accNo);
    boolean deleteAccount(String accNo);

    // Transactions
    List<Transaction> viewTransactions(String accNo);
    List<Transaction> viewAllTransactions();

    // Dashboard
    int getTotalAccounts();
    double getTotalBankBalance();
    int getTotalLoans();
    int getPendingLoansCount();

    // Loan
    boolean applyLoan(Loan loan);
    List<Loan> viewAllLoans();
    List<Loan> viewPendingLoans();
    List<Loan> viewApprovedLoans();
    List<Loan> viewRejectedLoans();
    boolean approveLoan(int loanId);
    boolean rejectLoan(int loanId);
}