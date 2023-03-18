package br.com.hotel1800.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.hotel1800.dao.ReservaDAO;
import br.com.hotel1800.modelo.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrareserva")
public class CadastraReserva extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idquarto = Integer.valueOf(req.getParameter("idquarto"));
		String cpf = req.getParameter("cpf");
		Integer quantidadeAdulto = Integer.valueOf(req.getParameter("quantidade_adulto"));
		Integer quantidadeCrianca = Integer.valueOf(req.getParameter("quantidade_crianca"));
		LocalDate dataCheckIn = LocalDate.parse(req.getParameter("data_check_in"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataCheckOut = LocalDate.parse(req.getParameter("data_check_out"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Reserva reserva = new Reserva();

		ReservaDAO reservaDao = new ReservaDAO();
		try {
			reservaDao.insere(reserva);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("listaReserva");
			
		}
	}


