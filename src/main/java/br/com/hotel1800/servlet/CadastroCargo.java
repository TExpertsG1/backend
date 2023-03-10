package br.com.hotel1800.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.hotel1800.dao.CargoDAO;
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
		String cargo = req.getParameter("cargo");
		BigDecimal salario = new BigDecimal(req.getParameter("salario"));

		Cargo cargo2 = new Cargo(cargo, salario);

		CargoDAO cargoDao = new CargoDAO();
		try {
			cargoDao.insere(cargo2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("cargoCadastrado.jsp");

		PrintWriter saida = resp.getWriter();
		saida.println("<html>");
		saida.println("<body>");

		saida.println("Cargo: " + cargo + " cadastrado com Sucesso!");

		saida.println("</body>");
		saida.println("</html>");

	}

}
