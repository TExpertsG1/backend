package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Cargo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class CargoDAO {

    @PersistenceContext
    private EntityManager em;

    @CacheEvict(value = "listaCargos", allEntries = true)
    public void create(Cargo cargo) {
        em.persist(cargo);
    }

    public Cargo read(Integer id) {
        return em.find(Cargo.class, id);
    }

    @Cacheable("listaCargos")
    public List<Cargo> readAll() {
        return em.createQuery("SELECT c FROM Cargo c", Cargo.class).getResultList();
    }

    public Map<Integer, String> getCargoMap() {
        List<Cargo> cargos = em.createQuery("SELECT c FROM Cargo c", Cargo.class).getResultList();
        Map<Integer, String> cargoMap = new HashMap<>();
        for (Cargo cargo : cargos) {
            cargoMap.put(cargo.getId(), cargo.getCargo());
        }
        return cargoMap;
    }

    @CacheEvict(value = "listaCargos", allEntries = true)
    public void update(Cargo cargo) {
        em.merge(cargo);
    }

    @CacheEvict(value = "listaCargos", allEntries = true)
    public void delete(Integer id) {
        Cargo cargo = em.find(Cargo.class, id);
        em.remove(cargo);
    }

}