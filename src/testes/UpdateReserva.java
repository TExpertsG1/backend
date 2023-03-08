package testes;

import java.sql.SQLException;

import dao.ReservaDAO;
import modelo.Reserva;

public class UpdateReserva {

	public static void main(String[] args) throws SQLException {
		ReservaDAO dao = new ReservaDAO();
		Reserva reserva = dao.buscaPor(1012);
		
		System.out.println(reserva);
		
		reserva.setQuantidade_adultos(4);
		dao.update(reserva);
		
		Reserva reservaAlterada = dao.buscaPor(1012);
		System.out.println(reservaAlterada);
	}

}
