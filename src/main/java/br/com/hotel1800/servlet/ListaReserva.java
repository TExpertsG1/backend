package br.com.hotel1800.servlet;

import java.io.IOException;
import java.util.List;

import br.com.hotel1800.dao.ReservaDAO;
import br.com.hotel1800.modelo.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/listaReserva")
public class ListaReserva extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ReservaDAO reservaDao = new ReservaDAO();
			List<Reserva> reserva = reservaDao.listagem();
			reserva.forEach(c -> System.out.println(c.getIdreserva()));
			
			req.setAttribute("reserva",reserva);
			req.getRequestDispatcher("reservaCadastrada.jsp").forward(req, resp);
			
				}
}
