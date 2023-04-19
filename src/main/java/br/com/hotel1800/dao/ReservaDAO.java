package br.com.hotel1800.dao;

import br.com.hotel1800.modelo.Reserva;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ReservaDAO {

    @PersistenceContext
    private EntityManager em;

    public static List<Double> calcularValorTotal(int idQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut, BigDecimal diaria) {
        List<Double> valoresDaReserva = new ArrayList<Double>();
        long diasDeHospedagem = ChronoUnit.DAYS.between(dataCheckIn, dataCheckOut);
        if (diasDeHospedagem == 0) {
            diasDeHospedagem = 1;
        }
        BigDecimal valorTotalDaReserva = diaria.multiply(BigDecimal.valueOf(diasDeHospedagem));
        valoresDaReserva.add(valorTotalDaReserva.doubleValue());
        return valoresDaReserva;
    }

    public void create(Reserva reserva) {
        em.persist(reserva);
    }

    public Reserva read(Integer id) {
        return em.find(Reserva.class, id);
    }

    public List<Reserva> readAll() {
        return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    }

    public List<Reserva> readAllCpfEmail(String hospede_cpf, String email) {
        return em.createQuery("SELECT r FROM Reserva r WHERE r.hospede_cpf = :hospede_cpf AND r.email = :email", Reserva.class)
                .setParameter("hospede_cpf", hospede_cpf)
                .setParameter("email", email)
                .getResultList();
    }

    public void update(Reserva reserva) {
        em.merge(reserva);
    }

    public void delete(Integer id) {
        Reserva reserva = em.find(Reserva.class, id);
        em.remove(reserva);
    }


}
