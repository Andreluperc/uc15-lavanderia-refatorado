package br.senac.pi.lavanderia.repository.jpa;

import br.senac.pi.lavanderia.domain.Cliente;
import br.senac.pi.lavanderia.infra.jpa.EntityManagerProvider;
import br.senac.pi.lavanderia.repository.ClienteRepository;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaClienteRepository implements ClienteRepository {

    private final EntityManagerProvider provider;

    public JpaClienteRepository(EntityManagerProvider provider) {
        this.provider = provider;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return JpaTx.inTx(provider, em -> {
            if (cliente.getId() == null) {
                em.persist(cliente);
                return cliente;
            }
            return em.merge(cliente);
        });
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return JpaTx.noTx(provider, em -> Optional.ofNullable(em.find(Cliente.class, id)));
    }

    @Override
    public List<Cliente> findAll() {
        return JpaTx.noTx(provider, em -> {
            TypedQuery<Cliente> q = em.createQuery("SELECT c FROM cliente c", Cliente.class);
            return q.getResultList();
        });
    }
}
