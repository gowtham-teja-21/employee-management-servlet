package employemanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdminDashBord extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management", "root", "root");

			PreparedStatement ps = con.prepareStatement("SELECT Ename, email, age FROM emp_details");

			ResultSet rs = ps.executeQuery();

			// Start HTML
			String startHtml = """
					<!DOCTYPE html>
					<html>
					<head>
					<title>Admin Dashboard</title>

					<style>
					    body {
					        margin: 0;
					        padding: 0;
					        font-family: Arial, sans-serif;
					        background: linear-gradient(135deg, #4e73df, #1cc88a);
					        height: 100vh;
					        display: flex;
					        justify-content: center;
					        align-items: center;
					    }
					    .container {
					        width: 80%;
					        background: white;
					        padding: 20px;
					        border-radius: 15px;
					        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
					    }
					    h2 {
					        text-align: center;
					        margin-bottom: 20px;
					        font-size: 28px;
					        color: #333;
					    }
					    table {
					        width: 100%;
					        border-collapse: collapse;
					    }
					    th {
					        background-color: #4e73df;
					        color: white;
					        padding: 12px;
					        font-size: 18px;
					    }
					    td {
					        padding: 12px;
					        text-align: center;
					        border-bottom: 1px solid #ddd;
					        font-size: 16px;
					    }
					    tr:hover {
					        background-color: #f1f1f1;
					    }
					</style>

					</head>
					<body>

					<div class='container'>
					<h2>All Registered Users</h2>

					<table>
					<tr><th>Name</th><th>Email</th><th>Age</th></tr>
					""";

			out.println(startHtml);

			// Add database rows
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("Ename") + "</td>");
				out.println("<td>" + rs.getString("email") + "</td>");
				out.println("<td>" + rs.getInt("age") + "</td>");
				out.println("</tr>");
			}

			// End HTML
			String endHtml = """
					</table>
					</div>

					</body>
					</html>
					""";

			out.println(endHtml);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
