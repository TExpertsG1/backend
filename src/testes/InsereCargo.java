package testes;

import java.sql.SQLException;

import dao.CargoDAO;
import modelo.Cargo;

public class InsereCargo {

	public static void main(String[] args) throws SQLException {
	Cargo cargo = new Cargo("Faxineiro",2300);
		
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.insere(cargo);
		
	}

}
