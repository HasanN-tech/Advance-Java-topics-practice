package com.java.services;

import java.util.List;
import com.bank.dao.*;
import com.bank.model.*;

public class AdminServiceImpl implements AdminService {

    AdminDao dao = new AdminDaoImpl();

    // LOGIN
    @Override
    public boolean login(String username, String password) {
        return dao.login(username, password);
    }

    // ACCOUNT
    @Override
    public boolean addAccount(Account acc) {
        return dao.addAccount(acc);
    }

    @Override
    public List<Account> viewAllAccounts() {
        return dao.viewAllAccounts();
    }

    @Override
    public Account searchAccount(String accNo) {
        return dao.searchAccount(accNo);
    }

    @Override
    public boolean deleteAccount(String accNo) {
        return dao.deleteAccount(accNo);
    }

    // TRANSACTION
    @Override
    public List<Transaction> viewTransactions(String accNo) {
        return dao.viewTransactions(accNo);
    }

    @Override
    public List<Transaction> viewAllTransactions() {
        return dao.viewAllTransactions();
    }

    // DASHBOARD
    @Override
    public int getTotalAccounts() {
        return dao.getTotalAccounts();
    }

    @Override
    public double getTotalBankBalance() {
        return dao.getTotalBankBalance();
    }

    @Override
    public int getTotalLoans() {
        return dao.getTotalLoans();
    }

    @Override
    public int getPendingLoansCount() {
        return dao.getPendingLoansCount();
    }

    // LOAN
    @Override
    public boolean applyLoan(Loan loan) {
        return dao.applyLoan(loan);
    }

    @Override
    public List<Loan> viewAllLoans() {
        return dao.viewAllLoans();
    }

    @Override
    public List<Loan> viewPendingLoans() {
        return dao.viewPendingLoans();
    }

    @Override
    public List<Loan> viewApprovedLoans() {
        return dao.viewApprovedLoans();
    }

    @Override
    public List<Loan> viewRejectedLoans() {
        return dao.viewRejectedLoans();
    }

    @Override
    public boolean approveLoan(int loanId) {
        return dao.approveLoan(loanId);
    }

    @Override
    public boolean rejectLoan(int loanId) {
        return dao.rejectLoan(loanId);
    }
}