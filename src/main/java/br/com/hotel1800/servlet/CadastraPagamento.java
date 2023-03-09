package br.com.hotel1800.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		Integer idpagamento = Integer.valueOf(req.getParameter("idpagamento"));
		String forma_pagamento = req.getParameter("forma_pagamento");
		Integer idreserva = Integer.valueOf(req.getParameter("idreserva"));
		
		FormaDePagamento pagamentos = new FormaDePagamento(idpagamento,forma_pagamento,idreserva);
		System.out.println(pagamentos);
		
		PrintWriter saida = resp.getWriter();
		saida.println("<html>");
		saida.println("<body>");
		
		saida.println("Pagamento " + pagamentos + " cadastrado com Sucesso!");
		
		
		saida.println("</body>");
		saida.println("</html>");
		
		}

}
