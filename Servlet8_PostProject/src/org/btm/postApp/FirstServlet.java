package org.btm.postApp;

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

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		String sname=req.getParameter("nm");
		String sdept=req.getParameter("dp");
		String sperc=req.getParameter("pr");
		double perc=Double.parseDouble(sperc);
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='green'>"
				+ "<h1>Student Details are "+sname+" from "+sdept+" </h1>"
						+ "</body></html>");  //PRESENTATION LOGIC
		out.close();
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  //it return bsaed on classs of fully qualified class name
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			// set the value of placeholder before execution //
			pstmt.setInt(1, id);
			pstmt.setString(2, sname);
			pstmt.setString(3, sdept);
			pstmt.setDouble(4, perc);
			pstmt.executeUpdate();  // PERSISTENCE LOGIC
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
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
