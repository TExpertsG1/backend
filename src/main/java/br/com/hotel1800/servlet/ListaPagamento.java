package br.com.hotel1800.servlet;

import java.io.IOException;

import br.com.hotel1800.dao.FormaDePagamentoDAO;
import br.com.hotel1800.modelo.FormaDePagamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/listaPagamento")
public class ListaPagamento extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			FormaDePagamentoDAO pgtoDao = new FormaDePagamentoDAO();
			java.util.List<FormaDePagamento> pagamento = pgtoDao.listagem();
			pagamento.forEach(c -> System.out.println(c.getForma_pagamento()));
			
			req.setAttribute("pagamento",pagamento);
			req.getRequestDispatcher("FormaPgtoCadastrado.jsp").forward(req, resp);
			
				}
}