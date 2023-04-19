package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Hotel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class HotelDAO {

    @PersistenceContext
    private EntityManager em;

    @CacheEvict(value = "listaHotel", allEntries = true)
    public void create(Hotel hotel) {
        em.persist(hotel);
    }

    public Hotel read(String cnpj) {
        return em.find(Hotel.class, cnpj);
    }

    @Cacheable("listaHotel")
    public List<Hotel> readAll() {
        return em.createQuery("select c from Hotel c", Hotel.class).getResultList();
    }

    @CacheEvict(value = "listaHotel", allEntries = true)
    public void update(Hotel hotel) {
        em.merge(hotel);
    }

    @CacheEvict(value = "listaHotel", allEntries = true)
    public void delete(String cnpj) {
        Hotel Hotel = em.find(Hotel.class, cnpj);
        em.remove(Hotel);
    }

}
