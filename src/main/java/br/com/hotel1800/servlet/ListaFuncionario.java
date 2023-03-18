package br.com.hotel1800.servlet;

import java.io.IOException;
import java.util.List;

import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listaFuncionario")
public class ListaFuncionario extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FuncionarioDAO funcDao = new FuncionarioDAO();
		List<Funcionario> funcionario = funcDao.listagem();
		funcionario.forEach(c -> System.out.println(c.getNome()));
		
		req.setAttribute("funcionario", funcionario);
		req.getRequestDispatcher("funcionarioCadastrado.jsp").forward(req, resp);
	
		
	}
	
}