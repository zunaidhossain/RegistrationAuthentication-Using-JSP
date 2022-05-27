import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname  = request.getParameter("uname");
		String password  = request.getParameter("password");
		String email  = request.getParameter("email");
		String phone  = request.getParameter("phone");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","password");
			PreparedStatement pst = con.prepareStatement("insert into userdb.member(uname, password, email, phone) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, phone);
			int rowCount = pst.executeUpdate();
			if (rowCount > 0) {
				PrintWriter out = response.getWriter();
				out.print("Data Entered Succesfully");
			}			
			else {
				PrintWriter out = response.getWriter();
				out.print("Data Not Entered");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

