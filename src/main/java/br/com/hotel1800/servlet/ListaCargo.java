package br.com.hotel1800.servlet;

import java.io.IOException;

import br.com.hotel1800.dao.CargoDAO;
import br.com.hotel1800.modelo.Cargo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet ("/listaCargo")
public class ListaCargo extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			CargoDAO cargoDao = new CargoDAO();
			java.util.List<Cargo> cargo = cargoDao.listagem();
			cargo.forEach(c -> System.out.println(c.getCargo()));
			
			req.setAttribute("cargo", cargo);
			req.getRequestDispatcher("cargoCadastrado.jsp").forward(req, resp);
			
				}
}
