package testes;

import java.sql.SQLException;

import dao.CargoDAO;
import modelo.Cargo;

public class UpdateCargo {

	public static void main(String[] args) throws SQLException {
		CargoDAO dao = new CargoDAO();
		Cargo cargo = dao.buscaPor(5);
		
		System.out.println(cargo);
		
		cargo.setSalario(2700);
		dao.update(cargo);
		
		Cargo cargoAlterado = dao.buscaPor(5);
		System.out.println(cargoAlterado);

	}

}
