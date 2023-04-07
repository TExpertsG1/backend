package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Hospede;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HospedeDAO {

    @PersistenceContext
    private EntityManager em;

    public void create(Hospede hospede) {
        em.persist(hospede);
    }

    public Hospede read(String cpf) {
        return em.find(Hospede.class, cpf);
    }

    public List<Hospede> readAll() {
        return em.createQuery("select c from Hospede c", Hospede.class).getResultList();
    }

    public List<String> readHospedeCPFS() {
        return em.createQuery("SELECT h.cpf FROM Hospede h", String.class).getResultList();
    }

    public void update(Hospede hospede) {
        em.merge(hospede);
    }

    public void delete(String cpf) {
        Hospede hospede = em.find(Hospede.class, cpf);
        em.remove(hospede);
    }
}
