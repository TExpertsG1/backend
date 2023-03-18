package br.com.hotel1800.servlet;

import java.io.IOException;
import java.util.List;

import br.com.hotel1800.dao.HospedeDAO;
import br.com.hotel1800.modelo.Hospede;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listaHospede")
public class ListaHospede extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HospedeDAO hospDao = new HospedeDAO();
		List<Hospede> hospede = hospDao.listagem();
		hospede.forEach(c -> System.out.println(c.getNome()));
		
		req.setAttribute("hospede", hospede);
		req.getRequestDispatcher("hospedeCadastrado.jsp").forward(req, resp);
	
		
	}
	
}
