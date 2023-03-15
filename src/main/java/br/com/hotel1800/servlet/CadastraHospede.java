package br.com.hotel1800.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.hotel1800.dao.HospedeDAO;
import br.com.hotel1800.modelo.Hospede;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrahospede")
public class CadastraHospede extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("nome");
		LocalDate dataNascimento = LocalDate.parse(req.getParameter("data_nascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String telefone = req.getParameter("telefone");
		String email = req.getParameter("email");
		
		Hospede hospede = new Hospede(cpf, nome, dataNascimento, telefone, email);

		HospedeDAO HospDao = new HospedeDAO();
		try {
			HospDao.insere(hospede);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("listaHospede");
			
		}

}
