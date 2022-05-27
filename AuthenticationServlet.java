import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/authenticate")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname  = request.getParameter("uname");
		String password = request.getParameter("password");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","password");
			PreparedStatement pst = con.prepareStatement("Select uname, password from userdb.member where uname=? and password=?");
			pst.setString(1, uname);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				PrintWriter out = response.getWriter();
				out.print("Valid Login Credentials, Welcome!");
			}			
			else {
				PrintWriter out = response.getWriter();
				out.print("In-Valid Login Credentials");
			}
		} catch (Exception e) {
			e.printStackTrace();}	
	}}

