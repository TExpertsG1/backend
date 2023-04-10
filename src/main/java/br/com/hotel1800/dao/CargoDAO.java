package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Cargo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CargoDAO {

    @PersistenceContext
    private EntityManager em;

    @CacheEvict(value = "cargos", allEntries = true)
    public void create(Cargo cargo) {
        em.persist(cargo);
    }

    public Cargo read(Integer id) {
        return em.find(Cargo.class, id);
    }

    @Cacheable("cargos")
    public List<Cargo> readAll() {
        return em.createQuery("SELECT c FROM Cargo c", Cargo.class).getResultList();
    }

    @CacheEvict(value = "cargos", allEntries = true)
    public void update(Cargo cargo) {
        em.merge(cargo);
    }

    @CacheEvict(value = "cargos", allEntries = true)
    public void delete(Integer id) {
        Cargo cargo = em.find(Cargo.class, id);
        em.remove(cargo);
    }

}