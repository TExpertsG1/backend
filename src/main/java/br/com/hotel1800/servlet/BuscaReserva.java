package br.com.hotel1800.servlet;

import java.io.IOException;

import br.com.hotel1800.dao.ReservaDAO;
import br.com.hotel1800.modelo.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscaReserva")
public class BuscaReserva extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idreserva = Integer.valueOf(req.getParameter("idreserva"));
		ReservaDAO reservaDao = new ReservaDAO();
		Reserva reserva = reservaDao.buscaPor(idreserva);
		
		req.setAttribute("reserva", reserva);
		req.getRequestDispatcher("cadastro-reserva.jsp").forward(req, resp);
		}
}
