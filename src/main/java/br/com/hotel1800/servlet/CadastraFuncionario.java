package br.com.hotel1800.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrafuncionario")
public class CadastraFuncionario extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("nome");
		LocalDate dataNascimento = LocalDate.parse(req.getParameter("data_nascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataAdmissao = LocalDate.parse(req.getParameter("data_admissao"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataDemissao = LocalDate.parse(req.getParameter("data_demissao"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String logradouro = req.getParameter("lograduro");
		Integer numero = Integer.valueOf(req.getParameter("numero"));
		String complemento = req.getParameter("complemento");
		String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String uf = req.getParameter("uf");
		String cep = req.getParameter("cep");
		
		Funcionario funcionario = new Funcionario(cpf, 0, cpf, nome, dataNascimento, dataAdmissao, logradouro, 0, complemento, bairro, cidade, uf, cep);

		FuncionarioDAO funcDao = new FuncionarioDAO();
		try {
			funcDao.insere(funcionario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("listaFuncionario");
			
		}

}