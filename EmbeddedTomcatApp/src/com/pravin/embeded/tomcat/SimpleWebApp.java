package com.pravin.embeded.tomcat;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class SimpleWebApp {
    public static void main(String[] args) throws LifecycleException {
	Tomcat tomcat = new Tomcat();
	tomcat.setBaseDir("temp");
	tomcat.setPort(8080);

	String contextPath = "/";
	String docBase = new File(".").getAbsolutePath();
	Context context = tomcat.addContext(contextPath, docBase);
	/*
	 * HttpServlet httpServlet = new HttpServlet() {
	 * 
	 * private static final long serialVersionUID = 1L;
	 * 
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { PrintWriter printWriter =
	 * resp.getWriter(); printWriter.println("<html><title>Welcome</title><body>");
	 * printWriter.println("<h1>Have a Great Day!</h1>");
	 * printWriter.println("</body></html>"); super.doGet(req, resp); } };
	 */

	AddServlet addServlet = new AddServlet();
	String servletName = "addServlet";
	String urlPattern = "/add";

	tomcat.addServlet(contextPath, servletName, addServlet);
	context.addServletMappingDecoded(urlPattern, servletName);
	tomcat.start();
	tomcat.getServer().await();
    }
}
