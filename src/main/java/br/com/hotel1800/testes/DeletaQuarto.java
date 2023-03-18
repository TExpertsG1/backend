package br.com.hotel1800.testes;
import java.io.IOException;
import br.com.hotel1800.dao.QuartoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletarquarto")
public class DeletaQuarto extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Integer idquarto = Integer.valueOf(req.getParameter("idquarto"));
	 
	 QuartoDAO quartoDao = new QuartoDAO();
	 quartoDao.deletar(idquarto);
	 resp.sendRedirect("listaQuarto");

	}
}