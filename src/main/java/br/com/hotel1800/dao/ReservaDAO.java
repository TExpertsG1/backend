package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Reserva;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ReservaDAO {

    @PersistenceContext
    private EntityManager em;

    public void create(Reserva reserva) {
        em.persist(reserva);
    }

    public Reserva read(Integer id) {
        return em.find(Reserva.class, id);
    }

    public List<Reserva> readAll() {
        return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    }

    public void update(Reserva reserva) {
        em.merge(reserva);
    }

    public void delete(Integer id) {
        Reserva reserva = em.find(Reserva.class, id);
        em.remove(reserva);
    }

}
