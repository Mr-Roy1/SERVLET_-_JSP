package orgjsp.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid=req.getParameter("i");	
		int id=Integer.parseInt(sid);
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from practice.college where id=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			
			PrintWriter out=resp.getWriter();
			
			if(rs.next()) {
				String name=rs.getString(2);
				String enroll=rs.getString(3);
				String dept=rs.getString(4);
				double perc=rs.getDouble(5);
				
				out.println("<html><body bgcolor='yellow'>"
						+ "<h1> name: "+name+",  "+"enroll: "+enroll+",  "+"dept: "+dept+",  "+"perc: "+perc+""
								+ "</h1>"+"</body></html>");
				out.close();
			}
			else {

				out.println("<html><body bgcolor='yellow'>"
						+ "<h1> id not found!!!!! </h1>"+"</body></html>");
				out.close();
			}
			
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
