package br.com.hotel1800.servlet;

import java.io.IOException;
import java.sql.SQLException;

import br.com.hotel1800.dao.FormaDePagamentoDAO;
import br.com.hotel1800.modelo.FormaDePagamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/cadastrapagamento")
public class CadastraPagamento extends HttpServlet {
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forma_pagamento = req.getParameter("forma_pagamento");
		Integer idreserva = Integer.valueOf(req.getParameter("idreserva"));
		
		FormaDePagamento pgto = new FormaDePagamento(forma_pagamento,idreserva);

		FormaDePagamentoDAO pgtoDao = new FormaDePagamentoDAO();
		try {
			pgtoDao.insere(pgto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("listaPagamento");
			
		}

}
