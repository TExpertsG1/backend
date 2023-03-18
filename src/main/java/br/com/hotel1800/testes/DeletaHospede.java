package br.com.hotel1800.testes;

import java.io.IOException;

import br.com.hotel1800.dao.HospedeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletarhospede")
public class DeletaHospede extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String hospede = req.getParameter("cpf");
	 
	 HospedeDAO hospDao = new HospedeDAO();
	 hospDao.deletar(hospede);
	 resp.sendRedirect("listaHospede");
	 

	}
}