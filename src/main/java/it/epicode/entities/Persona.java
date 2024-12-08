package it.epicode.entities;

import it.epicode.entitiesENUM.Sesso;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "persone")
public class Persona {
    @Id
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    @Column(name = "lista_partecipazioni")
    private List<Partecipazione> listaPartecipazioni;
}
