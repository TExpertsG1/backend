package br.com.hotel1800;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testeservlet")
// public class TesteServlet extends HttpServlet {
// @Override
// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
// ServletException, IOException {
// System.out.println("Chegou na Servlet");
// RequestDispatcher requestDispatcher =
// req.getRequestDispatcher("hotel1800.jsp");
// requestDispatcher.forward(req, resp);
// }
//
public class TesteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Testando a Servlet");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("hotel1800.jsp");
		requestDispatcher.forward(req, resp);
	}

}
