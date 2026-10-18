package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.Loan;
import com.bank.model.Transaction;
import com.bank.utility.DBConnection;

public class AdminDaoImpl implements AdminDao {

	Connection con = DBConnection.getConnection();
	PreparedStatement pstmt = null;

	@Override
	public boolean login(String username, String password) {
		boolean status = false;
		try {
			pstmt = con.prepareStatement("Select * from bank_admin Where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean addAccount(Account acc) {
		int userId=acc.getUserId();
	    String username = acc.getUsername();
	    String accountNumber = acc.getAccountNumber();
	    int count=0;
	    try {
	    	pstmt=con.prepareStatement("select * from accounts where user_id=? , username=? , acc_no=? ");
	    	count=pstmt.executeUpdate();
	    	if(count==0) {
	    		pstmt=con.prepareStatement("INSERT INTO account(full_name, email, username, password, account_number, phone_no, balance) VALUES(?,?,?,?,?,?,?)");
	    		pstmt.setString(1, acc.getFullName());
	            pstmt.setString(2, acc.getEmail());
	            pstmt.setString(3, acc.getUsername());
	            pstmt.setString(4, acc.getPassword());
	            pstmt.setString(5, acc.getAccountNumber());
	            pstmt.setLong(6, acc.getPhoneNo());
	            pstmt.setDouble(7, acc.getBalance());
	            int row=pstmt.executeUpdate();
	            if(row>0) return true;
	    	}
	    }catch (Exception e) {
	    	e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Account> viewAllAccounts() {
		List<Account> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("Select * from account");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Account acc=new Account();
				acc.setUserId(rs.getInt("user_id"));
				acc.setFullName(rs.getString("full_name"));
	            acc.setEmail(rs.getString("email"));
	            acc.setUsername(rs.getString("username"));
	            acc.setAccountNumber(rs.getString("account_number"));
	            acc.setPhoneNo(rs.getLong("phone_no"));
	            acc.setBalance(rs.getDouble("balance"));
	            list.add(acc);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Account searchAccount(String accNo) {
		Account ac=null;
		try {
			pstmt=con.prepareStatement("Select * from Account where account_number=?");
			pstmt.setString(1, accNo);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				ac=new Account();
				ac.setUserId(rs.getInt("full_name"));
				ac.setEmail(rs.getString("email"));
				ac.setUsername(rs.getString("username"));
				ac.setAccountNumber(rs.getString("account_number"));
				ac.setPhoneNo(rs.getLong("phone_no"));
				ac.setBalance(rs.getDouble("balance"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ac;
	}

	@Override
	public boolean deleteAccount(String accNo) {
		try {
			pstmt=con.prepareStatement("Delete from account where ACCOUNT_NUMBER=?");
			pstmt.setString(1, accNo);
			int rows=pstmt.executeUpdate();
			if(rows>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Transaction> viewTransactions(String accNo) {
		List<Transaction> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("Select * from transaction where acc_no=?");
			pstmt.setString(1, accNo);;
			ResultSet rs=pstmt.executeQuery();
     		while(rs.next()) {
     			Transaction t=new Transaction();
     			t.setTxnId(rs.getInt("txn_id"));
     			t.setSenderAccount(rs.getString("sender_acc"));
     			t.setReceiverAccount(rs.getString("receiver_acc"));
     			t.setAmount(rs.getDouble("amount"));
     			t.setTxnType(rs.getString("txn_type"));
     			t.setStatus(rs.getString("status"));
     			t.setTxnDate(rs.getDate("txn_date"));
     			list.add(t);
     		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Transaction> viewAllTransactions() {
		List<Transaction> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("Select * from transaction");
			ResultSet rs=pstmt.executeQuery();
     		while(rs.next()) {
     			Transaction t=new Transaction();
     			t.setTxnId(rs.getInt("txn_id"));
     			t.setSenderAccount(rs.getString("sender_acc"));
     			t.setReceiverAccount(rs.getString("receiver_acc"));
     			t.setAmount(rs.getDouble("amount"));
     			t.setTxnType(rs.getString("txn_type"));
     			t.setStatus(rs.getString("status"));
     			t.setTxnDate(rs.getDate("txn_date"));
     			list.add(t);
     		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalAccounts() {
		int count=0;
		try {
			pstmt=con.prepareStatement("select count(*) from accounts");
			count=pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public double getTotalBankBalance() {
		double total=0;
		try {
			pstmt=con.prepareStatement("select sum(balance) from accounts");
			total=pstmt.executeLargeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return total ;
	}

	@Override
	public int getTotalLoans() {
		int count=0;
		try {
			pstmt=con.prepareStatement("Select count(*) from loan");
			count=pstmt.executeUpdate();
			if(count>0) return count;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getPendingLoansCount() {
		int count=0;
		try {
			pstmt=con.prepareStatement("select * from loan where status='Pending'");
			count=pstmt.executeUpdate();
			if(count>0) return count;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean applyLoan(Loan loan) {
		int count=0;
		try {
			pstmt=con.prepareStatement("INSERT INTO loan(customer_id, loan_type, amount, duration, status, apply_date) VALUES(?,?,?,?,?,?)");
			 pstmt.setInt(1, loan.getCustomerId());
		     pstmt.setString(2, loan.getLoanType());
		     pstmt.setDouble(3, loan.getAmount());
		     pstmt.setInt(4, loan.getDuration());
		     pstmt.setString(5, "PENDING");
		     pstmt.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
		     count=pstmt.executeUpdate();
		     if(count>0) return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Loan> viewAllLoans() {
		List<Loan> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select * from loan");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Loan l=new Loan();
				l.setLoanId(rs.getInt("loan_id"));
	            l.setCustomerId(rs.getInt("customer_id"));
	            l.setLoanType(rs.getString("loan_type"));
	            l.setAmount(rs.getDouble("amount"));
	            l.setDuration(rs.getInt("duration"));
	            l.setStatus(rs.getString("status"));
	            l.setApplyDate(rs.getDate("apply_date"));

	            list.add(l);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Loan> viewPendingLoans() {
		List<Loan> l=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select * from loan where status='Pending'");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Loan loan=new Loan();
				loan.setLoanId(rs.getInt("loan_id"));
				loan.setCustomerId(rs.getInt("customer_id"));
				loan.setLoanType(rs.getString("loan_type"));
				loan.setAmount(rs.getDouble("amount"));
				loan.setDuration(rs.getInt("duration"));
				loan.setStatus(rs.getString("Status"));
				loan.setApplyDate(rs.getDate("apply_date"));
				l.add(loan);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Loan> viewApprovedLoans() {
		List<Loan> l=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select * from loan where status='Approved'");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Loan loan=new Loan();
				loan.setLoanId(rs.getInt("loan_id"));
				loan.setCustomerId(rs.getInt("customer_id"));
				loan.setLoanType(rs.getString("loan_type"));
				loan.setAmount(rs.getDouble("amount"));
				loan.setDuration(rs.getInt("duration"));
				loan.setStatus(rs.getString("Status"));
				loan.setApplyDate(rs.getDate("apply_date"));
				l.add(loan);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Loan> viewRejectedLoans() {
		List<Loan> l=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select * from loan where status='Rejected'");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Loan loan=new Loan();
				loan.setLoanId(rs.getInt("loan_id"));
				loan.setCustomerId(rs.getInt("customer_id"));
				loan.setLoanType(rs.getString("loan_type"));
				loan.setAmount(rs.getDouble("amount"));
				loan.setDuration(rs.getInt("duration"));
				loan.setStatus(rs.getString("Status"));
				loan.setApplyDate(rs.getDate("apply_date"));
				l.add(loan);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean approveLoan(int loanId) {
		try {
			pstmt=con.prepareStatement("Update loan set status='Approved' where loan_id=?");
			pstmt.setInt(1, loanId);
			int rows = pstmt.executeUpdate();

            if (rows > 0) {
                return true;
            }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean rejectLoan(int loanId) {
		try {
			pstmt=con.prepareStatement("Update loan set status='Rejected' where loan_id=?");
			pstmt.setInt(1, loanId);
			int rows = pstmt.executeUpdate();

            if (rows > 0) {
                return true;
            }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
