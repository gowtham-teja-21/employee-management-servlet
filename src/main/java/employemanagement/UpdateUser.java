package employemanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUser  extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	 String empId=req.getParameter("empId");
//     	String name=req.getParameter("name");
//     	int age=Integer.parseInt(req.getParameter("age"));
//     	String gen=req.getParameter("gender");
//     	double sal=Double.parseDouble(req.getParameter("salary"));
//     	String address=req.getParameter("address");
//     	String email=req.getParameter("email");
//     	String pass=req.getParameter("password");
//     	
//     	
//     	HttpSession session=req.getSession();
//     	 String oldName   = (String) session.getAttribute("name");
//         int oldAge       = (int) session.getAttribute("age");
//         String oldGender = (String) session.getAttribute("gender");
//         double oldSal    = (double) session.getAttribute("sal");
//         String oldAdd    = (String) session.getAttribute("add");
//         String oldEmail  = (String) session.getAttribute("email");
//         String oldPass   = (String) session.getAttribute("pass");
//         
//         
//         if (name == null || name.trim().equals(""))  name = oldName;
//         if (gen == null || gen.trim().equals("")) gen = oldGender;
//         if (address == null || address.trim().equals("")) address = oldAdd;
//         if (email == null || email.trim().equals("")) email = oldEmail;
//         if (pass == null || pass.trim().equals("")) pass = oldPass;
//
//         int age = (ageStr == null || ageStr.trim().equals("")) ? oldAge : Integer.parseInt(ageStr);
//         double sal = (salStr == null || salStr.trim().equals("")) ? oldSal : Double.parseDouble(salStr);
//     	
    	 
    	   HttpSession session = req.getSession();

           // OLD VALUES FROM SESSION
           String oldName   = (String) session.getAttribute("name");
           int oldAge       = (int) session.getAttribute("age");
           String oldGender = (String) session.getAttribute("gender");
           double oldSal    = (double) session.getAttribute("sal");
           String oldAdd    = (String) session.getAttribute("add");
           String oldEmail  = (String) session.getAttribute("email");
           String oldPass   = (String) session.getAttribute("pass");

           String empId = req.getParameter("empId");

           // NEW VALUES FROM FORM
           String name = req.getParameter("name");
           String ageStr = req.getParameter("age");
           String gender = req.getParameter("gender");
           String salStr = req.getParameter("salary");
           String address = req.getParameter("address");
           String email = req.getParameter("email");
           String pass = req.getParameter("password");

           // CHECK EMPTY → KEEP OLD DATA
           if (name == null || name.trim().equals(""))  name = oldName;
           if (gender == null || gender.trim().equals("")) gender = oldGender;
           if (address == null || address.trim().equals("")) address = oldAdd;
           if (email == null || email.trim().equals("")) email = oldEmail;
           if (pass == null || pass.trim().equals("")) pass = oldPass;

           int age = (ageStr == null || ageStr.trim().equals("")) ? oldAge : Integer.parseInt(ageStr);
           double sal = (salStr == null || salStr.trim().equals("")) ? oldSal : Double.parseDouble(salStr);

    	 
    	 
     	  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_management", "root", "root");
				
				PreparedStatement ps=con.prepareStatement("UPDATE emp_details SET Ename =?, age=?, gender=?, sal=?, addres=?,email=?,password=? where EmpId=?");
			
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, gender);
				ps.setDouble(4, sal);
				ps.setString(5, address);
				ps.setString(6, email);
				ps.setString(7, pass);
				ps.setString(8, empId);
				
				int i=ps.executeUpdate();
	 
	            if(i >= 0) {
	                // Save email in session for DisplayDetails
	                 session = req.getSession();
	                session.setAttribute("email", email);

	                // Redirect back to DisplayDetails
	                resp.sendRedirect("detail?email=" + email);

           
	            }
	                    
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }
}
