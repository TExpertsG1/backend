package br.com.hotel1800.servlet;

import java.io.IOException;

import br.com.hotel1800.dao.FuncionarioDAO;
import br.com.hotel1800.modelo.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscaFuncionario")
public class BuscaFuncionario extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDao.buscaPor(cpf);
		
		req.setAttribute("funcionario", funcionario);
		req.getRequestDispatcher("cadastro-funcionario.jsp").forward(req, resp);
		}
}