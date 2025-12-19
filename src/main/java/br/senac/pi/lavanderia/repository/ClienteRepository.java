package br.senac.pi.lavanderia.repository;

import br.senac.pi.lavanderia.domain.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Integer id);
    List<Cliente> findAll();
}
