package br.senac.pi.lavanderia.infra.jpa;

import jakarta.persistence.EntityManager;

/**
 * SRP: abstrai a criação/obtenção de EntityManager.
 * DIP: serviços/repositórios dependem desta abstração, não de LavanderiaUtil estático.
 */
public interface EntityManagerProvider {
    EntityManager get();
}
