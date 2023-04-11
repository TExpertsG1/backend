package br.com.hotel1800.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hotel1800.modelo.Hotel;

@Repository
@Transactional
public class HotelDAO {

    @PersistenceContext
    private EntityManager em;

    @CacheEvict(value = "listaHotel", allEntries = true)
    public void create(Hotel hotel) {
        em.persist(hotel);
    }

    public Hotel read(Integer id) {
        return em.find(Hotel.class, id);
    }

    @Cacheable("listaHotel")
    public List<Hotel> readAll() {
        return em.createQuery("SELECT c FROM hotel c", Hotel.class).getResultList();
    }

    @CacheEvict(value = "listaHotel", allEntries = true)
    public void update(Hotel hotel) {
        em.merge(hotel);
    }

    @CacheEvict(value = "listaHotel", allEntries = true)
    public void delete(Integer id) {
        Hotel Hotel = em.find(Hotel.class, id);
        em.remove(Hotel);
    }

}
