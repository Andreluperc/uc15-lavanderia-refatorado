package br.senac.pi.lavanderia.service;

import br.senac.pi.lavanderia.domain.Operador;
import br.senac.pi.lavanderia.repository.OperadorRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OperadorService {

    private final OperadorRepository repo;

    public OperadorService(OperadorRepository repo) {
        this.repo = Objects.requireNonNull(repo);
    }

    public Operador cadastrar(Operador operador) {
        validarCadastro(operador);
        return repo.save(operador);
    }

    public Optional<Operador> autenticarPorCpfEMatricula(String cpf, String matricula) {
        return repo.findByCpfAndMatricula(cpf, matricula);
    }

    public List<Operador> listar() {
        return repo.findAll();
    }

    private void validarCadastro(Operador o) {
        if (o == null) throw new IllegalArgumentException("Operador é obrigatório");
        if (isBlank(o.getNome())) throw new IllegalArgumentException("Nome do operador é obrigatório");
        if (isBlank(o.getCPF())) throw new IllegalArgumentException("CPF é obrigatório");
        if (isBlank(o.getMatricula())) throw new IllegalArgumentException("Matrícula é obrigatória");
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
