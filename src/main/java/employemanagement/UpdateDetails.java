package employemanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateDetails extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 
    	 HttpSession session=req.getSession();
//    	  String id = req.getParameter("id");
//    	  String name = req.getParameter("name");
//    	  int age =Integer.parseInt(req.getParameter("age"));
//    	  String gender = req.getParameter("gender");
//    	  double sal =Double.parseDouble(req.getParameter("sal"));
//    	  String add = req.getParameter("add");
//    	  String email = req.getParameter("email");
//    	  String pass = req.getParameter("pass");
    	  String id = (String) session.getAttribute("id");
    	  String name = (String) session.getAttribute("name");
    	  int age =(int) session.getAttribute("age");
    	  String gender = (String) session.getAttribute("gender");
    	  double sal =(double) session.getAttribute("sal");
    	  String add = (String) session.getAttribute("add");
    	  String email =(String) session.getAttribute("email");
    	  String pass = (String) session.getAttribute("pass");
    	  
    	  PrintWriter pw=resp.getWriter();
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
    	  		+ "      margin-top: 20px;\r\n"
    	  		+ "      text-align: center;\r\n"
    	  		+ "    }\r\n"
    	  		+ "\r\n"
    	  		+ "    button {\r\n"
    	  		+ "      width: 60%;\r\n"
    	  		+ "      padding: 10px;\r\n"
    	  		+ "      font-size: 17px;\r\n"
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
    	  		+ "  </style>\r\n"
    	  		+ "</head>\r\n"
    	  		+ "\r\n"
    	  		+ "<body>\r\n"
    	  		+ "\r\n"
    	  		+ "  <div class=\"container\">\r\n"
    	  		+ "    <h2>User Details</h2>\r\n"
    	  		+ "\r\n"
    	  		+ "    <form action=\"updateuser\" method=\"post\">\r\n"
    	  		+ "      <table>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Employee ID</th>\r\n"
    	  		+ "          <td><input type=\"text\" name=\"empId\" value="+id+" readonly></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Name</th>\r\n"
    	  		+ "          <td><input type=\"text\" name=\"name\" value="+name+"></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Age</th>\r\n"
    	  		+ "          <td><input type=\"number\" name=\"age\" value="+age+"></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Gender</th>\r\n"
    	  		+ "          <td><input type=\"text\" name=\"gender\" value="+gender+"></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Salary</th>\r\n"
    	  		+ "          <td><input type=\"number\" name=\"salary\" value="+sal+" readonly></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Address</th>\r\n"
    	  		+ "          <td><input type=\"text\" name=\"address\" value="+add+"></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Email</th>\r\n"
    	  		+ "          <td><input type=\"email\" name=\"email\" value="+email+"></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "        <tr>\r\n"
    	  		+ "          <th>Password</th>\r\n"
    	  		+ "          <td><input type=\"text\" name=\"password\" value="+pass+"></td>\r\n"
    	  		+ "        </tr>\r\n"
    	  		+ "\r\n"
    	  		+ "      </table>\r\n"
    	  		+ "\r\n"
    	  		+ "      <div class=\"btn-row\">\r\n"
    	  		+ "        <button type=\"submit\">Update</button>\r\n"
    	  		+ "      </div>\r\n"
    	  		+ "\r\n"
    	  		+ "    </form>\r\n"
    	  		+ "  </div>\r\n"
    	  		+ "\r\n"
    	  		+ "</body>\r\n"
    	  		+ "</html>\r\n"
    	  		+ "");
    	  
    }
}
