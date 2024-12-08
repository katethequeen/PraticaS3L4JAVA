package it.epicode.entitiesDAO;

import it.epicode.entities.Partecipazione;
import it.epicode.exceptions.PartecipazioneNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class PartecipazioneDAO {
    @PersistenceContext
    EntityManager em;

    public PartecipazioneDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        this.em = emf.createEntityManager();
    }

    public void save(Partecipazione partec) {
        em.getTransaction().begin();
        em.persist(partec);
        em.getTransaction().commit();
    }

    public Partecipazione findById(Long id) {
        Partecipazione partec = em.find(Partecipazione.class, id);
        if(partec == null) {
            throw new PartecipazioneNotFoundException("Partecipazione con id: " + id + " non trovato");
        }
        return partec;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Partecipazione partec = em.find(Partecipazione.class, id);
        if(partec != null) {
            em.remove(partec);
        } else {
            throw new PartecipazioneNotFoundException("Partecipazione con id: " + id + " non trovato");
        }
        em.getTransaction().commit();
    }
}
