package testes;

import java.sql.SQLException;

import dao.ReservaDAO;

public class ListagemReserva {

	public static void main(String[] args) throws SQLException {

		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.listagem();
	}
}