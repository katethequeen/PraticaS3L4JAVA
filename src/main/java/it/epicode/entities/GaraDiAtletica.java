package it.epicode.entities;

import it.epicode.entitiesENUM.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "gare_atletica")
@NoArgsConstructor
@AllArgsConstructor
public class GaraDiAtletica extends Evento{

    @ManyToMany
    @JoinTable(name = "gara_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id")
    )
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;


}
