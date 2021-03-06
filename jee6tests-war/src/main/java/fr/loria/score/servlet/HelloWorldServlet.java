package fr.loria.score.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.loria.score.ejb.HelloWorldService;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @date 24 March 2010
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private HelloWorldService service;

    public HelloWorldServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorldServlet called");
	}

}
