package br.com.hotel1800.testes;

import java.io.IOException;

import br.com.hotel1800.dao.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletarfuncionario")
public class DeletaFuncionario extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String func = req.getParameter("cpf");
	 
	 FuncionarioDAO funcDao = new FuncionarioDAO();
	 funcDao.deletar(func);
	 resp.sendRedirect("listaFuncionario");
	 

	}
}