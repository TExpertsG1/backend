package testes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.ReservaDAO;
import modelo.Reserva;

public class InsereReserva {

	public static void main(String[] args) throws SQLException {
		Reserva reserva = new Reserva(
				2,
				"32538735212",
				2,
				1,
				LocalDate.parse("15/03/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				LocalDate.parse("20/03/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				);
		
		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.insere(reserva);
	}
	

}
