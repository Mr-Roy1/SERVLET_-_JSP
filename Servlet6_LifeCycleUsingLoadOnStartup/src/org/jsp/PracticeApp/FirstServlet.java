package org.jsp.PracticeApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns="/rai",loadOnStartup=2)
public class FirstServlet extends GenericServlet{
	
	public FirstServlet() {
		System.out.println("Servlet obj is created!!!");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("obj is initialized!!!");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='green'>"
				+ "<h1>welcome "+name+" from "+place+" </h1>"
						+ "</body></html>");
		out.close();
		System.out.println("lifecycle executed");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("closed all costly resources");
	}

}
