package it.epicode.entitiesDAO;

import it.epicode.entities.Persona;
import it.epicode.exceptions.PersonaNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class PersonaDAO {
    @PersistenceContext
    EntityManager em;

    public PersonaDAO () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        this.em = emf.createEntityManager();
    }

    public void save (Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona findById(Long id) {
        Persona persona = em.find(Persona.class, id);
        if(persona == null) {
            throw new PersonaNotFoundException("Persona con id: " + id + " non trovata.");
        }
        return persona;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Persona persona = em.find(Persona.class, id);
        if(persona !=null) {
            em.remove(persona);
        } else {
            throw new PersonaNotFoundException("Persona con id: " + id + " non trovata.");
        }
        em.getTransaction().commit();
    }
}
