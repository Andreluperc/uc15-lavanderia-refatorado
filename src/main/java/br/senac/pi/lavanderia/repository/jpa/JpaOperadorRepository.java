package br.senac.pi.lavanderia.repository.jpa;

import br.senac.pi.lavanderia.domain.Operador;
import br.senac.pi.lavanderia.infra.jpa.EntityManagerProvider;
import br.senac.pi.lavanderia.repository.OperadorRepository;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaOperadorRepository implements OperadorRepository {

    private final EntityManagerProvider provider;

    public JpaOperadorRepository(EntityManagerProvider provider) {
        this.provider = provider;
    }

    @Override
    public Operador save(Operador operador) {
        return JpaTx.inTx(provider, em -> {
            if (operador.getId() == null) {
                em.persist(operador);
                return operador;
            }
            return em.merge(operador);
        });
    }

    @Override
    public Optional<Operador> findById(Integer id) {
        return JpaTx.noTx(provider, em -> Optional.ofNullable(em.find(Operador.class, id)));
    }

    @Override
    public Optional<Operador> findByCpfAndMatricula(String cpf, String matricula) {
        if (cpf == null || cpf.isBlank() || matricula == null || matricula.isBlank()) return Optional.empty();
        return JpaTx.noTx(provider, em -> {
            TypedQuery<Operador> q = em.createQuery(
                "SELECT o FROM operador o WHERE o.cpf_operador = :cpf AND o.matricula_operador = :matricula", Operador.class);
            q.setParameter("cpf", cpf);
            q.setParameter("matricula", matricula);
            List<Operador> list = q.getResultList();
            return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
        });
    }

    @Override
    public List<Operador> findAll() {
        return JpaTx.noTx(provider, em -> em.createQuery("SELECT o FROM operador o", Operador.class).getResultList());
    }
}
