package br.senac.pi.lavanderia.service;

import br.senac.pi.lavanderia.domain.Cliente;
import br.senac.pi.lavanderia.repository.ClienteRepository;
import java.util.List;
import java.util.Objects;

public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = Objects.requireNonNull(repo);
    }

    public Cliente cadastrar(Cliente cliente) {
        validar(cliente);
        return repo.save(cliente);
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    private void validar(Cliente c) {
        if (c == null) throw new IllegalArgumentException("Cliente é obrigatório");
        if (isBlank(c.getNome())) throw new IllegalArgumentException("Nome do cliente é obrigatório");
        if (isBlank(c.getCPF())) throw new IllegalArgumentException("CPF do cliente é obrigatório");
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
