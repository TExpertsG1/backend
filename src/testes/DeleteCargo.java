package testes;

import java.sql.SQLException;

import dao.CargoDAO;

public class DeleteCargo {

	public static void main(String[] args) throws SQLException {
		
	CargoDAO cargoDAO = new CargoDAO();
	cargoDAO.delete(6);

	}

}
