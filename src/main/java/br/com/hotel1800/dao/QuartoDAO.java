package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Quarto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @CacheEvict(value = "listaQuartos", allEntries = true)
    public void create(Quarto quarto) {
        em.persist(quarto);
    }

    public Quarto read(Integer id) {
        return em.find(Quarto.class, id);
    }

    @Cacheable("listaQuartos")
    public List<Quarto> readAll() {
        return em.createQuery("select q from Quarto q", Quarto.class).getResultList();
    }

    public List<Object[]> readIdNomeQuartos() {
        return em.createQuery("SELECT q.idquarto, q.nome_quarto FROM Quarto q", Object[].class).getResultList();
    }

    @CacheEvict(value = "listaQuartos", allEntries = true)
    public void update(Quarto quarto) {
        em.merge(quarto);
    }

    @CacheEvict(value = "listaQuartos", allEntries = true)
    public void delete(Integer id) {
        Quarto quarto = em.find(Quarto.class, id);
        em.remove(quarto);
    }
}
