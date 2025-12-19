package br.senac.pi.lavanderia.infra.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Implementação JPA padrão. Controla o ciclo de vida do EntityManagerFactory.
 */
public final class JpaEntityManagerProvider implements EntityManagerProvider, AutoCloseable {

    private final String persistenceUnitName;
    private EntityManagerFactory emf;

    public JpaEntityManagerProvider(String persistenceUnitName) {
        if (persistenceUnitName == null || persistenceUnitName.isBlank()) {
            throw new IllegalArgumentException("persistenceUnitName não pode ser vazio");
        }
        this.persistenceUnitName = persistenceUnitName;
    }

    @Override
    public EntityManager get() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return emf.createEntityManager();
    }

    @Override
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
