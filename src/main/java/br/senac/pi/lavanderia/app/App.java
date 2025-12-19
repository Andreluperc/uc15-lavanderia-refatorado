package br.senac.pi.lavanderia.app;

import br.senac.pi.lavanderia.domain.Cliente;
import br.senac.pi.lavanderia.domain.Operador;
import br.senac.pi.lavanderia.infra.jpa.JpaEntityManagerProvider;
import br.senac.pi.lavanderia.repository.ClienteRepository;
import br.senac.pi.lavanderia.repository.OperadorRepository;
import br.senac.pi.lavanderia.repository.jpa.JpaClienteRepository;
import br.senac.pi.lavanderia.repository.jpa.JpaOperadorRepository;
import br.senac.pi.lavanderia.service.ClienteService;
import br.senac.pi.lavanderia.service.OperadorService;
import java.util.Date;

/**
 * Testes simples (em memória) para validar regras/integração sem Swing.
 * Execute via: mvn -q test  OU  mvn -q exec:java
 */
public class App {

    public static void main(String[] args) {
        // Usa PU de TESTE para rodar em qualquer máquina (sem depender de MySQL).
        try (JpaEntityManagerProvider emp = new JpaEntityManagerProvider("lavanderia-test-PU")) {

            ClienteRepository clienteRepo = new JpaClienteRepository(emp);
            OperadorRepository operadorRepo = new JpaOperadorRepository(emp);

            ClienteService clienteService = new ClienteService(clienteRepo);
            OperadorService operadorService = new OperadorService(operadorRepo);

            // 1) Cadastrar Cliente
            Cliente c = new Cliente();
            c.setNome("Cliente Teste");
            c.setCPF("123.456.789-00");
            c.setDataNasc(new Date());
            c.setEmail("cliente@teste.com");
            clienteService.cadastrar(c);

            // 2) Cadastrar Operador (login do desktop era CPF + matrícula)
            Operador o = new Operador();
            o.setNome("Operador Teste");
            o.setCPF("111.222.333-44");
            o.setMatricula("MAT-001");
            operadorService.cadastrar(o);

            // 3) Listar
            System.out.println("Clientes cadastrados: " + clienteService.listar().size());
            System.out.println("Operadores cadastrados: " + operadorService.listar().size());

            // 4) Autenticar
            boolean ok = operadorService.autenticarPorCpfEMatricula("111.222.333-44", "MAT-001").isPresent();
            System.out.println("Autenticação (CPF+Matrícula) OK? " + ok);
        }
    }
}
