package employemanagement;

import java.io.IOException;
import java.io.PrintWriter;
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

public class AdminValidation extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	 String email = req.getParameter("email");
         String password = req.getParameter("password");
         
         RequestDispatcher rd = null;
         Connection con =null;
         PreparedStatement ps=null;
         PrintWriter pw=resp.getWriter();
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management", "root", "root");
                  ps = con.prepareStatement("SELECT password FROM emp_details WHERE email=?");
                 ps.setString(1, email);
                 ResultSet rs = ps.executeQuery();

                 if (rs.next()) {
                     String dbPassword = rs.getString("password");
                     if (dbPassword.equals(password)) {
                     	req.setAttribute("email", email);
                         rd = req.getRequestDispatcher("adminDashbored");
                         rd.forward(req, resp);
//                    	 HttpSession session = req.getSession();
//                         session.setAttribute("adminEmail", email);
         
             
                     } else {
                        
                    	 rd = req.getRequestDispatcher("AdminView");
                         rd.include(req, resp);
            
                     }
                 } else {
                     rd = req.getRequestDispatcher("AdminView");
                     rd.include(req, resp);
       
               
                 }
         } catch (ClassNotFoundException | SQLException e) {
     		// TODO Auto-generated catch block
     		e.printStackTrace();
         }
    }
} 
