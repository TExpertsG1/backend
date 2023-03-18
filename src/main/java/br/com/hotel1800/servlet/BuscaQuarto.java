package br.com.hotel1800.servlet;

import java.io.IOException;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.modelo.Quarto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscaQuarto")
public class BuscaQuarto extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idquarto = Integer.valueOf(req.getParameter("idquarto"));
		QuartoDAO quartoDao = new QuartoDAO();
		Quarto quarto = quartoDao.buscaPor(idquarto);
		
		req.setAttribute("quarto", quarto);
		req.getRequestDispatcher("cadastro-quarto.jsp").forward(req, resp);
		}
}