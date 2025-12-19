package br.senac.pi.lavanderia.service;

import br.senac.pi.lavanderia.domain.Pedido;
import br.senac.pi.lavanderia.repository.PedidoRepository;
import java.util.List;
import java.util.Objects;

public class PedidoService {

    private final PedidoRepository repo;

    public PedidoService(PedidoRepository repo) {
        this.repo = Objects.requireNonNull(repo);
    }

    public Pedido salvar(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("Pedido é obrigatório");
        return repo.save(pedido);
    }

    public List<Pedido> listar() {
        return repo.findAll();
    }
}
