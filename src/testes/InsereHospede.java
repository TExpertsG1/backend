package testes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.HospedeDAO;
import modelo.Hospede;

public class InsereHospede {

	public static void main(String[] args) throws SQLException {

		Hospede hospede = 
				new Hospede(
						"32839634750",
						"Maria José",
						LocalDate.parse("15/10/1984", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						"11981820692",
						"maria@maria.com.br");
		
		HospedeDAO hospedeDAO = new HospedeDAO();
		hospedeDAO.insere(hospede);
		
	}

}
