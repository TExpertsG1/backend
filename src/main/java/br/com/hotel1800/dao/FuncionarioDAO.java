package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Funcionario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FuncionarioDAO {

    @PersistenceContext
    private EntityManager em;

    public void create(Funcionario funcionario) {
        em.persist(funcionario);
    }

    public Funcionario read(String cpf) {
        return em.find(Funcionario.class, cpf);
    }

    public List<Funcionario> readAll() {
        return em.createQuery("select c from Funcionario c", Funcionario.class).getResultList();
    }

    public void update(Funcionario funcionario) {
        em.merge(funcionario);
    }

    public void delete(String cpf) {
        Funcionario func = em.find(Funcionario.class, cpf);
        em.remove(func);
    }

    public Funcionario existe(String cpf, String senha) {
        String jpql = "select c from Funcionario c Where c.cpf = :cpf AND c.senha = :senha";

        try {
            return this.em.createQuery(jpql, Funcionario.class)
                    .setParameter("cpf", cpf)
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("Usuário Não encontrado");
            return null;
        }

    }
}

