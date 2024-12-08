package it.epicode;

import it.epicode.entities.Evento;
import it.epicode.entities.Location;
import it.epicode.entities.Partecipazione;
import it.epicode.entities.Persona;
import it.epicode.entitiesDAO.EventoDAO;
import it.epicode.entitiesDAO.LocationDAO;
import it.epicode.entitiesDAO.PartecipazioneDAO;
import it.epicode.entitiesDAO.PersonaDAO;
import it.epicode.entitiesENUM.Sesso;
import it.epicode.entitiesENUM.Stato;
import it.epicode.entitiesENUM.TipoEvento;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDA0 = new PersonaDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
        LocationDAO locationDAO = new LocationDAO();

        //NUOVA LOCATION
        Location location = new Location();
        location.setNome("Teatro");
        location.setCitta("Roma");
        locationDAO.save(location);
        System.out.println("Location salvata " + location);

        //NUOVO EVENTO
        Evento evento = new Evento();
        evento.setTitolo("Concerto");
        evento.setDataEvento(LocalDate.of(2025, 01,04));
        evento.setDescrizione("Concerto di Natale");
        evento.setTipoEvento(TipoEvento.PUBBLICO);
        evento.setMumeroMassimoPartecipanti(100);
        evento.setLocation(location);
        eventoDAO.save(evento);
        System.out.println("Evento salvato " + evento);

        //NUOVA PERSONA
        Persona persona = new Persona();
        persona.setNome("Mario");
        persona.setCognome("Rossi");
        persona.setEmail("mario.rossi@mail.com");
        persona.setDataNascita(LocalDate.of(1989, 12, 01));
        persona.setSesso(Sesso.M);
        personaDA0.save(persona);
        System.out.println("Persona salvata: " + persona);

        //NUOVA PARTECIPAZIONE
        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setPersona(persona);
        partecipazione.setEvento(evento);
        partecipazione.setStato(Stato.CONFERMATA);
        partecipazioneDAO.save(partecipazione);
        System.out.println("Partecipazione salvata: " + partecipazione);

        //METODI get E delete
        Evento eventoFound = eventoDAO.getById(evento.getId());
        System.out.println("Evento trovato: " + eventoFound);

        Partecipazione partecipazioneFound = partecipazioneDAO.findById(partecipazione.getId());
        System.out.println("Partecipazione trovata: " + partecipazioneFound);

        eventoDAO.delete(evento.getId());
        System.out.println("Evento cancellato");

        partecipazioneDAO.delete(partecipazione.getId());
        System.out.println("Partecipazione cancellata");
    }
}
