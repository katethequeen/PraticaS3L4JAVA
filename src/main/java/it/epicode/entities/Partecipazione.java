package it.epicode.entities;

import it.epicode.entitiesENUM.Stato;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;
}
