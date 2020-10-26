package org.jsp.lifeCycleApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet{

	public FirstServlet() {
		System.out.println("Servlet object is Created");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet object is initialized");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		
		PrintWriter pw=resp.getWriter();  // PRINTWRITER IS A CLASS PRESENT IN IO PACKAGE AND getWritter IS A FACTORY OR HELPER METHOD //
		pw.println("<html><body bgcolor='yellow'>"
				+ "<h1>Welcome "+name+" from "+place+"</h1>"
						+ "</body></html>");  // PRESENTATION LOGIC //
		pw.close();
		System.out.println("service() is executed!!!");
	}
	@Override
	public void destroy() {
		System.out.println("close   costly resources");
	}
}
