package br.com.hotel1800.servlet;
import java.io.IOException;
import java.math.BigDecimal;

import br.com.hotel1800.dao.QuartoDAO;
import br.com.hotel1800.modelo.Quarto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/atualizaquarto")
public class AtualizaQuarto extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Integer idquarto = Integer.valueOf(req.getParameter("idquarto"));
	    String cnpj = req.getParameter("hotel_cnpj");
	    String nomeQuarto = req.getParameter("nomeQuarto");
	    Integer numero = Integer.valueOf(req.getParameter("numero"));
	    Integer capacidade = Integer.valueOf(req.getParameter("capacidade"));
	    BigDecimal diaria = new BigDecimal(req.getParameter("diaria"));

	    QuartoDAO quartoDao = new QuartoDAO();
	    Quarto quartoAtualizado = new Quarto(idquarto, cnpj, nomeQuarto, numero, capacidade, diaria);
	    try {
			quartoDao.atualiza(quartoAtualizado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    resp.sendRedirect("listaQuarto");
	}
}