//package br.com.hotel1800.testes;
//
//import java.io.IOException;
//
//import br.com.hotel1800.dao.CargoDAO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/deletar")
//public class DeletaCargo extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	 Integer idcargos = Integer.valueOf(req.getParameter("idcargos"));
//
//	 CargoDAO cargoDao = new CargoDAO();
//	 cargoDao.deletar(idcargos);
//	 
//	 resp.sendRedirect("listaCargo");
//	 
//	}
//}
