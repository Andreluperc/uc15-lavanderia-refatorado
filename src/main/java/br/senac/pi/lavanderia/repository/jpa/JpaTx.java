package br.senac.pi.lavanderia.repository.jpa;

import br.senac.pi.lavanderia.infra.jpa.EntityManagerProvider;
import jakarta.persistence.EntityManager;

/**
 * Helper interno para reduzir duplicação de begin/commit/rollback.
 * (Refatoração: extraiu método/estrutura comum).
 */
final class JpaTx {

    interface Work<T> {
        T run(EntityManager em);
    }

    static <T> T inTx(EntityManagerProvider provider, Work<T> work) {
        EntityManager em = provider.get();
        try {
            em.getTransaction().begin();
            T result = work.run(em);
            em.getTransaction().commit();
            return result;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    static <T> T noTx(EntityManagerProvider provider, Work<T> work) {
        EntityManager em = provider.get();
        try {
            return work.run(em);
        } finally {
            em.close();
        }
    }

    private JpaTx() {}
}
