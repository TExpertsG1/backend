package testes;

import java.sql.SQLException;

import dao.ReservaDAO;

public class DeleteReserva {

	public static void main(String[] args) throws SQLException {
		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.delete(1);

	}

}
