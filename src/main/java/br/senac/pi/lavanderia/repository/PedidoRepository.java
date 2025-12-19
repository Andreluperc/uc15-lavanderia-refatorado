package br.senac.pi.lavanderia.repository;

import br.senac.pi.lavanderia.domain.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    Pedido save(Pedido pedido);
    Optional<Pedido> findById(Integer id);
    List<Pedido> findAll();
}
