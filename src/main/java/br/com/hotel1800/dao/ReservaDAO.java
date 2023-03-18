package br.com.hotel1800.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.hotel1800.infra.JPAFactory;
import br.com.hotel1800.modelo.Hospede;
import br.com.hotel1800.modelo.Reserva;

public class ReservaDAO {

public void insere(Reserva reserva) throws SQLException {
		
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(reserva);
		em.getTransaction().commit();
		em.close();
	}

	public List<Reserva> listagem() {
		EntityManager em = JPAFactory.getEntityManager();
	    return em.createQuery("select c from Reserva c", Reserva.class).getResultList();
	}
	
	public Reserva buscaPor(Integer idreserva) {
		EntityManager em = JPAFactory.getEntityManager();
		return em.find(Reserva.class, idreserva);

	}
	

	public void deletar(Integer id) {
	    EntityManager em = JPAFactory.getEntityManager();
	    em.getTransaction().begin();
	    Reserva reserva = em.find(Reserva.class, id);
	    em.remove(reserva);
	    em.getTransaction().commit();
	    em.close();
	}
	
}
