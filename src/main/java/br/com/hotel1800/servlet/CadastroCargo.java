package br.com.hotel1800.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.hotel1800.modelo.Cargo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/cadastracargo")
public class CadastroCargo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer idcargo = Integer.valueOf(req.getParameter("idcargo"));
	String cargo = req.getParameter("cargo");
	Integer salario = Integer.valueOf(req.getParameter("salario"));
	
	Cargo cargos = new Cargo(idcargo,cargo,salario);
	

	PrintWriter saida = resp.getWriter();
	saida.println("<html>");
	saida.println("<body>");
	
	saida.println("Cargo: " + cargo + " cadastrado com Sucesso!");
	
	
	saida.println("</body>");
	saida.println("</html>");
	
	}

}
