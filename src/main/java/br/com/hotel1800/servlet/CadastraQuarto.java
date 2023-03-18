package br.com.hotel1800.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.modelo.Quarto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastraquarto")
public class CadastraQuarto extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cnpj = req.getParameter("hotel_cnpj");
		String nomeQuarto = req.getParameter("nomeQuarto");
		Integer numero = Integer.valueOf(req.getParameter("numero"));
		Integer capacidade = Integer.valueOf(req.getParameter("capacidade"));
		BigDecimal diaria = new BigDecimal(req.getParameter("capacidade"));
		
		QuartoDAO quartoDao = new QuartoDAO();
		Quarto quarto = new Quarto(cnpj, nomeQuarto, numero, capacidade, diaria);

		
		try {
			quartoDao.insere(quarto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("listaQuarto");

	}


}