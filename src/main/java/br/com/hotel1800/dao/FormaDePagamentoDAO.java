package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.FormaDePagamento;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class FormaDePagamentoDAO {

    @PersistenceContext
    private EntityManager em;

    public void create(FormaDePagamento formaDePagamento) throws SQLException {
        em.persist(formaDePagamento);
    }

    public FormaDePagamento read(Integer id) {
        return em.find(FormaDePagamento.class, id);
    }

    public List<FormaDePagamento> readAll() {
        return em.createQuery("select c from FormaDePagamento c", FormaDePagamento.class).getResultList();
    }

    public void update(FormaDePagamento formaDePagamento) {
        em.merge(formaDePagamento);
    }

    public void delete(Integer id) {
        FormaDePagamento formaDePagamento = em.find(FormaDePagamento.class, id);
        em.remove(formaDePagamento);
    }

}
