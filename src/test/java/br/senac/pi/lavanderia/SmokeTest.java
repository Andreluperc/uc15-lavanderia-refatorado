package br.senac.pi.lavanderia;

import br.senac.pi.lavanderia.domain.Cliente;
import br.senac.pi.lavanderia.infra.jpa.JpaEntityManagerProvider;
import br.senac.pi.lavanderia.repository.jpa.JpaClienteRepository;
import br.senac.pi.lavanderia.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmokeTest {

    @Test
    void cadastraEListaCliente() {
        try (JpaEntityManagerProvider emp = new JpaEntityManagerProvider("lavanderia-test-PU")) {
            ClienteService service = new ClienteService(new JpaClienteRepository(emp));

            Cliente c = new Cliente();
            c.setNome("Fulano");
            c.setCPF("000.000.000-00");

            service.cadastrar(c);

            Assertions.assertFalse(service.listar().isEmpty());
        }
    }
}
