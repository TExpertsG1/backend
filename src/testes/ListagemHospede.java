package testes;

import java.sql.SQLException;

import dao.HospedeDAO;

public class ListagemHospede {

	public static void main(String[] args) throws SQLException {

		HospedeDAO hospedeDAO = new HospedeDAO();
		hospedeDAO.listagem();

	}	
}
