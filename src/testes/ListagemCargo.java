package testes;

import java.sql.SQLException;

import dao.CargoDAO;

public class ListagemCargo {

	public static void main(String[] args) throws SQLException {

		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.listagem();
	}
}