package br.com.hotel1800.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.hotel1800.infra.JPAFactory;
import br.com.hotel1800.modelo.Quarto;

public class QuartoDAO {

public void insere(Quarto quarto) throws SQLException {
		
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();
		em.close();
	}

	public List<Quarto> listagem() {
		EntityManager em = JPAFactory.getEntityManager();
	    return em.createQuery("select c from Quarto c", Quarto.class).getResultList();
	}
	
	public static Quarto buscaPor(Integer idquarto) {
		EntityManager em = JPAFactory.getEntityManager();
		return em.find(Quarto.class, idquarto);

	}
	

	public void deletar(Integer id) {
	    EntityManager em = JPAFactory.getEntityManager();
	    em.getTransaction().begin();
	    Quarto quarto = em.find(Quarto.class, id);
	    em.remove(quarto);
	    em.getTransaction().commit();
	    em.close();
	}
	
}