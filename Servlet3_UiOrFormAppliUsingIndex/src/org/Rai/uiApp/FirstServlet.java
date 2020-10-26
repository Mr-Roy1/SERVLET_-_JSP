package org.Rai.uiApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Roy")
public class FirstServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("fn");
		String lname=req.getParameter("ln");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='green'>"
				+ "<h1>Welcome "+fname+" "+lname+" </h1>"
						+ "</body></html>");  // PRESENTATION LOGIC//
		out.close();
	}
}
