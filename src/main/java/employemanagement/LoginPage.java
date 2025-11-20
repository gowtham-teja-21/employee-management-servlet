package employemanagement;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html");
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
                        rd = req.getRequestDispatcher("detail");
                        rd.forward(req, resp);
            
                    } else {
                        rd = req.getRequestDispatcher("login.html");
                        rd.include(req, resp);
//                        pw.println("<html>\r\n"
//                        		+ "<head>"
//                        		+ "</head>\r\n"
//                        		+ "<body>"
//                        		+ "<h6 style='color:red'>Enter a valid Data</h6>"
//                        		+ "</body>\r\n"
//                        		+ "</html>");
                        
                    }
                } else {
                    rd = req.getRequestDispatcher("login.html");
                    rd.include(req, resp);
//                    pw.println("<html>\r\n"
//                    		+ "<head>"
//                    		+ "</head>\r\n"
//                    		+ "<body>"
//                    		+ "<h6 style='color:red'>Enter a valid Data</h6>"
//                    		+ "</body>\r\n"
//                    		+ "</html>");
                }
        } catch (ClassNotFoundException | SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
        }
    }
}
