package it.epicode.entities;

import it.epicode.entitiesENUM.Genere;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "concerti")
@NoArgsConstructor
@AllArgsConstructor

public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private Genere genere;

    private boolean inStreaming;

}
