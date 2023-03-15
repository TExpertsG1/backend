package br.com.hotel1800.servlet;

import java.io.IOException;

import br.com.hotel1800.dao.HospedeDAO;
import br.com.hotel1800.modelo.Hospede;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscaHospede")
public class BuscaHospede extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		HospedeDAO hospedeDao = new HospedeDAO();
		Hospede hospede = hospedeDao.buscaPor(cpf);
		
		req.setAttribute("hospede", hospede);
		req.getRequestDispatcher("cadastro-hospede.jsp").forward(req, resp);
		}
}
