package employemanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	HttpSession session =req.getSession();
		  session.getAttribute("email");
    	
        String email = req.getParameter("email");
         
        //assesing values
        String id=null;
    	String name=null;
    	int age=0;
    	String gender=null;
    	double sal=0;
    	String add=null;
    	String emai=null;
    	String pass=null;
    	PrintWriter pw=resp.getWriter();
    	RequestDispatcher rd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_management", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM emp_details WHERE email = ?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	 id=rs.getString("Empid");
            	 name=rs.getString("Ename");
            	 age=rs.getInt("age");
            	 gender=rs.getString("gender");
            	 sal=rs.getDouble("sal");
            	add=rs.getString("addres");
                 emai=rs.getString("email");
            	 pass=rs.getString("password");
//                req.setAttribute("empId", rs.getString("Empid"));
//                req.setAttribute("name", rs.getString("Ename"));
//                req.setAttribute("age", rs.getInt("age"));
//                req.setAttribute("gender", rs.getString("gender"));
//                req.setAttribute("salary", rs.getDouble("sal"));
//                req.setAttribute("address", rs.getString("addres"));
//                req.setAttribute("email", rs.getString("email"));
//                req.setAttribute("password", rs.getString("password"));

            } 
            
            pw.println("<!DOCTYPE html>\r\n"
            		+ "<html lang=\"en\">\r\n"
            		+ "<head>\r\n"
            		+ "  <meta charset=\"UTF-8\">\r\n"
            		+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            		+ "  <title>User Details</title>\r\n"
            		+ "\r\n"
            		+ "  <style>\r\n"
            		+ "    * {\r\n"
            		+ "      margin: 0;\r\n"
            		+ "      padding: 0;\r\n"
            		+ "      box-sizing: border-box;\r\n"
            		+ "      font-family: \"Poppins\", sans-serif;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    body {\r\n"
            		+ "      height: 100vh;\r\n"
            		+ "      display: flex;\r\n"
            		+ "      justify-content: center;\r\n"
            		+ "      align-items: center;\r\n"
            		+ "      background: linear-gradient(135deg, #74ABE2, #5563DE);\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    .container {\r\n"
            		+ "      background: #fff;\r\n"
            		+ "      padding: 30px;\r\n"
            		+ "      width: 500px;\r\n"
            		+ "      border-radius: 15px;\r\n"
            		+ "      box-shadow: 0 8px 20px rgba(0,0,0,0.2);\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ ".btn-row form {\r\n"
            		+ "    width: 48%;\r\n"
            		+ "}\r\n"
            		+ ".btn-row button {\r\n"
            		+ "    width: 100%;\r\n"
            		+ "}\r\n"
            		+ ""
            		+ "    h2 {\r\n"
            		+ "      text-align: center;\r\n"
            		+ "      margin-bottom: 20px;\r\n"
            		+ "      color: #333;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    table {\r\n"
            		+ "      width: 100%;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    table tr th {\r\n"
            		+ "      text-align: left;\r\n"
            		+ "      padding: 10px 0;\r\n"
            		+ "      font-size: 16px;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    input {\r\n"
            		+ "      width: 100%;\r\n"
            		+ "      padding: 8px;\r\n"
            		+ "      border: 1px solid #bbb;\r\n"
            		+ "      border-radius: 5px;\r\n"
            		+ "      outline: none;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    input:focus {\r\n"
            		+ "      border-color: #5563DE;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    .btn-row {\r\n"
            		+ "      display: flex;\r\n"
            		+ "      justify-content: space-between;\r\n"
            		+ "      margin-top: 20px;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    button {\r\n"
            		+ "      width: 48%;\r\n"
            		+ "      padding: 10px;\r\n"
            		+ "      font-size: 16px;\r\n"
            		+ "      border: none;\r\n"
            		+ "      border-radius: 5px;\r\n"
            		+ "      cursor: pointer;\r\n"
            		+ "      background: #5563DE;\r\n"
            		+ "      color: #fff;\r\n"
            		+ "      transition: 0.3s;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    button:hover {\r\n"
            		+ "      background: #3d4bb8;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    .delete-btn {\r\n"
            		+ "      background: #d9534f;\r\n"
            		+ "    }\r\n"
            		+ "\r\n"
            		+ "    .delete-btn:hover {\r\n"
            		+ "      background: #b52b27;\r\n"
            		+ "    }\r\n"
            		+ "  </style>\r\n"
            		+ "</head>\r\n"
            		+ "\r\n"
            		+ "<body>\r\n"
            		+ "\r\n"
            		+ "  <div class=\"container\">\r\n"
            		+ "    <h2>User Details</h2>\r\n"
            		+ "\r\n"
            		+ "    <form action=\"\" method=\"\">\r\n"
            		+ "      <table>\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Employee ID</th>\r\n"
            		+ "          <td>"+id+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Name</th>\r\n"
            		+ "          <td>"+name+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Age</th>\r\n"
            		+ "          <td>"+age+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Gender</th>\r\n"
            		+ "          <td>"+gender+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Salary</th>\r\n"
            		+ "          <td>"+sal+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Address</th>\r\n"
            		+ "          <td>"+add+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Email</th>\r\n"
            		+ "          <td>"+emai+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "\r\n"
            		+ "        <tr>\r\n"
            		+ "          <th>Password</th>\r\n"
            		+ "          <td>"+pass+"</td>\r\n"
            		+ "        </tr>\r\n"
            		+ "      </table>\r\n"
            		+ "\r\n"
            		+ "      <div class=\"btn-row\">\r\n"
            		+ "      </div>\r\n"
            		+ "\r\n"
            		+ "    </form>\r\n"
            		+ "<div class=\"btn-row\">\r\n"
            		+ "\r\n"
            		+ "  <form method=\"get\" action=\"upd\" >\r\n"
            		+ "    <button type=\"submit\" class=\"update-btn\">Update</button>\r\n"
            		+ "  </form>\r\n"
            		+ "\r\n"
            		+ "  <form method=\"get\"  action=\"del\">\r\n"
            		+ "    <button type=\"submit\" class=\"delete-btn\">Delete</button>\r\n"
            		+ "  </form>\r\n"
            		+ "\r\n"
            		+ "</div>\r\n"
            		+ ""
            		 
            		+ "  </div>\r\n"
            		+ "\r\n"
            		+ "</body>\r\n"
            		+ "</html>\r\n"
            		+ "");
//               
//        	req.setAttribute("id", id);
//        	req.setAttribute("name", name);
//        	req.setAttribute("age", age);
//        	req.setAttribute("gender", gender);
//        	req.setAttribute("sal", sal);
//        	req.setAttribute("add", add);
//        	req.setAttribute("email", email);
//        	req.setAttribute("pass", pass);
//            rd = req.getRequestDispatcher("upd");
//            rd.forward(req, resp);
        	 session=req.getSession();
        	session.setAttribute("id", id);
        	session.setAttribute("name", name);
        	session.setAttribute("age", age);
        	session.setAttribute("gender", gender);
        	session.setAttribute("sal", sal);
        	session.setAttribute("add", add);
        	session.setAttribute("email", email);
        	session.setAttribute("pass", pass);
        	
        	
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
