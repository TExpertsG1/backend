package br.com.hotel1800.servlet;

import java.io.IOException;
import java.util.List;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.modelo.Quarto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/listaQuarto")
public class ListaQuarto extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			QuartoDAO quartoDao = new QuartoDAO();
			List<Quarto> quarto = quartoDao.listagem();
			quarto.forEach(c -> System.out.println(c.getIdquarto()));
			
			req.setAttribute("quarto",quarto);
			req.getRequestDispatcher("quartoCadastrado.jsp").forward(req, resp);
			
				}
}
