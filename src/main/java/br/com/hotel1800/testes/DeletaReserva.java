package br.com.hotel1800.testes;
import java.io.IOException;

import br.com.hotel1800.dao.ReservaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletareserva")
public class DeletaReserva extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Integer reserva = Integer.valueOf(req.getParameter("idreserva"));
	 
	 ReservaDAO reservaDao = new ReservaDAO();
	 reservaDao.deletar(reserva);
	 resp.sendRedirect("listaReserva");

	}
}