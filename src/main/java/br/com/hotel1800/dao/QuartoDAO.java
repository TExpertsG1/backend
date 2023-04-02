package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Quarto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuartoDAO {

    @PersistenceContext
    private EntityManager em;

    public void create(Quarto quarto) {
        em.persist(quarto);
    }

    public Quarto read(Long id) {
        return em.find(Quarto.class, id);
    }

    public List<Quarto> readAll() {
        return em.createQuery("select q from Quarto q", Quarto.class).getResultList();
    }

    public void update(Quarto quarto) {
        em.merge(quarto);
    }

    public void delete(Long id) {
        Quarto quarto = em.find(Quarto.class, id);
        em.remove(quarto);
    }
}
