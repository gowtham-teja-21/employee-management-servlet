package employemanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteDetails extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    			HttpSession session =req.getSession();
		        String email=(String) session.getAttribute("email");
		        
		      try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management", "root", "root");
				  PreparedStatement ps = con.prepareStatement("DELETE FROM emp_details WHERE email=?");
			            ps.setString(1,email );
			           int i= ps.executeUpdate();
			            if(i>=0) {
			            	  resp.sendRedirect("login.html");
			            }   
			            
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }   
	 
}
