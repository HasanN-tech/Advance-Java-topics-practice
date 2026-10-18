<%@ page import="com.java.services.*,com.java.services.AdminServiceImpl" %>

<%
    AdminService service = new AdminServiceImpl();

    int totalAccounts = service.getTotalAccounts();
    double totalBalance = service.getTotalBankBalance();
    int totalLoans = service.getTotalLoans();
    int pendingLoans = service.getPendingLoansCount();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>

<style>

/* Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', sans-serif;
}

/* Body */
body {
    display: flex;
    min-height: 100vh;
    background: #f4f7fc;
}

/* Sidebar */
.sidebar {
    width: 230px;
    background: #1e293b;
    color: white;
    padding: 20px;
}

.sidebar h2 {
    margin-bottom: 20px;
    text-align: center;
}

.sidebar a {
    display: block;
    padding: 12px;
    margin: 8px 0;
    text-decoration: none;
    color: #cbd5e1;
    border-radius: 6px;
    transition: 0.3s;
}

.sidebar a:hover {
    background: #334155;
    color: white;
}

/* Main Content */
.main {
    flex: 1;
    padding: 20px;
}

/* Header */
.header {
    background: white;
    padding: 15px;
    border-radius: 10px;
    margin-bottom: 20px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

/* Cards */
.cards {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
    gap: 20px;
}

.card {
    background: white;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    transition: 0.3s;
}

.card:hover {
    transform: translateY(-5px);
}

.card h3 {
    color: #555;
    margin-bottom: 10px;
}

.card p {
    font-size: 22px;
    font-weight: bold;
    color: #2563eb;
}

/* Responsive */
@media(max-width: 768px) {
    .sidebar {
        display: none;
    }
}

</style>

</head>

<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>Admin Panel</h2>

    <a href="ViewAccountsServlet">View Accounts</a>
    <a href="searchAccount.jsp">Search Account</a>
    <a href="viewTransactions.jsp">Transactions</a>
    <a href="loan.jsp">Loan Management</a>
    <a href="home.html">Logout</a>
</div>

<!-- Main Content -->
<div class="main">

    <!-- Header -->
    <div class="header">
        <h2>Welcome Admin</h2>
    </div>

    <!-- Dashboard Cards -->
    <div class="cards">

        <div class="card">
            <h3>Total Accounts</h3>
            <p><%= totalAccounts %></p>
        </div>

        <div class="card">
            <h3>Total Balance</h3>
            <p><%= totalBalance %></p>
        </div>

        <div class="card">
            <h3>Total Loans</h3>
            <p><%= totalLoans %></p>
        </div>

        <div class="card">
            <h3>Pending Loans</h3>
            <p><%= pendingLoans %></p>
        </div>

    </div>

</div>

</body>
</html>