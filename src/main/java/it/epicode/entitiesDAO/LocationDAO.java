package it.epicode.entitiesDAO;

import it.epicode.entities.Location;
import it.epicode.exceptions.LocationNotFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class LocationDAO {
    @PersistenceContext
    EntityManager em;

    public LocationDAO (){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        this.em = emf.createEntityManager();
    }

    public void save(Location loc) {
        em.getTransaction().begin();
        em.persist(loc);
        em.getTransaction().commit();
    }

    public Location findById(Long id) {
        Location loc = em.find(Location.class, id);
        if(loc == null) {
            throw new LocationNotFound("La location con id: " + id + " non trovata");
        }
        return loc;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Location loc = em.find(Location.class, id);
        if(loc != null) {
            em.remove(loc);
        } else {
            throw new LocationNotFound("La location con id: " + id + " non trovata");
        }
        em.getTransaction().commit();
    }
}
