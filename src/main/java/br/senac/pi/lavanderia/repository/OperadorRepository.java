package br.senac.pi.lavanderia.repository;

import br.senac.pi.lavanderia.domain.Operador;
import java.util.List;
import java.util.Optional;

public interface OperadorRepository {
    Operador save(Operador operador);
    Optional<Operador> findById(Integer id);
    Optional<Operador> findByCpfAndMatricula(String cpf, String matricula);
    List<Operador> findAll();
}
