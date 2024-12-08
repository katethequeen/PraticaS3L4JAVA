package it.epicode.entitiesDAO;

import it.epicode.entities.Concerto;
import it.epicode.entities.Evento;
import it.epicode.entities.PartitaDiCalcio;
import it.epicode.entitiesENUM.Genere;
import it.epicode.exceptions.EventoNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class EventoDAO {
    @PersistenceContext
    private EntityManager em;

    public EventoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        this.em = emf.createEntityManager();
    }

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(Long id) {
        Evento evento = em.find(Evento.class, id);
        if(evento == null) {
            throw new EventoNotFoundException("Evento con id " + id + " non trovato");
        }
        return evento;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Evento evento = em.find(Evento.class, id);
        if(evento != null) {
            em.remove(evento);
        } else {
            throw new EventoNotFoundException("Evento con id " + id + " non trovato.");
        }
        em.getTransaction().commit();
    }

    //CONCERTI STREAMING
    public List<Concerto> getConcertiInStreaming(boolean instreaming) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class)
                .setParameter("inStreaming", instreaming)
                .getResultList();
    }

    //CONCERTI PER GENERE
    public List<Concerto> getConcertiPerGenere(Genere genere) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class)
                .setParameter("genere", genere)
                .getResultList();
    }




}
