<%@ page import="java.util.*,com.bank.model.Loan" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Management</title>

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
    background: linear-gradient(135deg, #11998e, #38ef7d);
    min-height: 100vh;
    padding: 20px;
}

/* Container */
.container {
    max-width: 1100px;
    margin: auto;
    background: #fff;
    padding: 25px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.2);
}

/* Header */
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

.header h2 {
    color: #333;
}

/* Back Button */
.back-btn {
    text-decoration: none;
    background: #333;
    color: white;
    padding: 10px 15px;
    border-radius: 6px;
}

/* Form */
.form {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 15px;
    margin-bottom: 25px;
}

.form input, .form select {
    padding: 10px;
    border-radius: 8px;
    border: 1px solid #ccc;
}

.form button {
    grid-column: span 2;
    padding: 12px;
    border: none;
    background: #11998e;
    color: white;
    border-radius: 8px;
    cursor: pointer;
}

.form button:hover {
    background: #0f7c73;
}

/* Table */
table {
    width: 100%;
    border-collapse: collapse;
}

table th {
    background: #11998e;
    color: white;
    padding: 10px;
}

table td {
    padding: 10px;
    text-align: center;
}

table tr:nth-child(even) {
    background: #f2f2f2;
}

/* Status */
.status {
    padding: 5px 10px;
    border-radius: 5px;
    color: white;
}

.pending {
    background: orange;
}

.approved {
    background: green;
}

.rejected {
    background: red;
}

/* Buttons */
.btn {
    padding: 5px 10px;
    border-radius: 5px;
    color: white;
    text-decoration: none;
}

.approve-btn {
    background: green;
}

.reject-btn {
    background: red;
}

/* Responsive */
@media(max-width: 768px){
    .form button {
        grid-column: span 1;
    }
}

</style>

</head>

<body>

<div class="container">

    <!-- Header -->
    <div class="header">
        <h2>Loan Management</h2>
        <a href="adminDashboard.jsp" class="back-btn">Back</a>
    </div>

    <!-- Apply Loan Form -->
    <form action="ApplyLoanServlet" method="post" class="form">

        <input type="text" name="customerId" placeholder="Customer ID" required>

        <select name="loanType">
            <option>Home Loan</option>
            <option>Car Loan</option>
            <option>Personal Loan</option>
        </select>

        <input type="text" name="amount" placeholder="Amount" required>

        <input type="text" name="duration" placeholder="Duration (months)" required>

        <button type="submit">Apply Loan</button>

    </form>

    <!-- Loan Table -->
    <%
        List<Loan> list = (List<Loan>) request.getAttribute("loans");

        if(list != null && !list.isEmpty()){
    %>

    <table>
        <tr>
            <th>ID</th>
            <th>Customer</th>
            <th>Type</th>
            <th>Amount</th>
            <th>Duration</th>
            <th>Status</th>
            <th>Action</th>
        </tr>

        <%
            for(Loan l : list){
        %>

        <tr>
            <td><%= l.getLoanId() %></td>
            <td><%= l.getCustomerId() %></td>
            <td><%= l.getLoanType() %></td>
            <td><%= l.getAmount() %></td>
            <td><%= l.getDuration() %></td>

            <td>
                <%
                    String status = l.getStatus();
                    if("PENDING".equals(status)){
                %>
                    <span class="status pending">Pending</span>
                <%
                    } else if("APPROVED".equals(status)){
                %>
                    <span class="status approved">Approved</span>
                <%
                    } else {
                %>
                    <span class="status rejected">Rejected</span>
                <%
                    }
                %>
            </td>

            <td>
                <a class="btn approve-btn"
                   href="ApproveLoanServlet?id=<%= l.getLoanId() %>">Approve</a>

                <a class="btn reject-btn"
                   href="RejectLoanServlet?id=<%= l.getLoanId() %>">Reject</a>
            </td>
        </tr>

        <%
            }
        %>

    </table>

    <%
        } else {
    %>

        <p style="text-align:center; color:red;">No Loan Records Found</p>

    <%
        }
    %>

</div>

</body>
</html>