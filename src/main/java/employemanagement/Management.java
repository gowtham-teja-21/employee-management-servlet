				package employemanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Management extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 
    	String empId=req.getParameter("empId");
    	String name=req.getParameter("name");
    	int age=Integer.parseInt(req.getParameter("age"));
    	String gen=req.getParameter("gender");
    	double sal=Double.parseDouble(req.getParameter("salary"));
    	String address=req.getParameter("address");
    //	double phone=Double.parseDouble(req.getParameter("phone"));
    	String email=req.getParameter("email");
    	String pass=req.getParameter("password");

    	PrintWriter pw = resp.getWriter();
    	 
  
    	try {
    	
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management?user=root && password=root");
		
		 PreparedStatement ps=con.prepareStatement("insert into emp_details values(?,?,?,?,?,?,?,?)");
		ps.setString(1, empId);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, gen);
		ps.setDouble(5, sal);
		ps.setString(6, address);
	//	ps.setDouble(7, phone);
		ps.setString(7, email);
		ps.setString(8, pass);
		
	//	ps.executeUpdate();
		
		
		int rows = ps.executeUpdate();

        if (rows >= 0) {
//            RequestDispatcher rd = req.getRequestDispatcher("login.html");
//             rd.forward(req, resp);
              resp.sendRedirect("login.html");
        } else {
            pw.println("Hello " + name + ", enter valid data.");
        }
		
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	  
    }
}
