package br.senac.pi.lavanderia.repository.jpa;

import br.senac.pi.lavanderia.domain.Pedido;
import br.senac.pi.lavanderia.infra.jpa.EntityManagerProvider;
import br.senac.pi.lavanderia.repository.PedidoRepository;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaPedidoRepository implements PedidoRepository {

    private final EntityManagerProvider provider;

    public JpaPedidoRepository(EntityManagerProvider provider) {
        this.provider = provider;
    }

    @Override
    public Pedido save(Pedido pedido) {
        return JpaTx.inTx(provider, em -> {
            if (pedido.getId() == null) {
                em.persist(pedido);
                return pedido;
            }
            return em.merge(pedido);
        });
    }

    @Override
    public Optional<Pedido> findById(Integer id) {
        return JpaTx.noTx(provider, em -> Optional.ofNullable(em.find(Pedido.class, id)));
    }

    @Override
    public List<Pedido> findAll() {
        return JpaTx.noTx(provider, em -> {
            TypedQuery<Pedido> q = em.createQuery("SELECT p FROM pedido p", Pedido.class);
            return q.getResultList();
        });
    }
}
