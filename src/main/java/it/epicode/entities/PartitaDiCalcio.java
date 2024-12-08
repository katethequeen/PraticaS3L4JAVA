package it.epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "partite_calcio")
@NoArgsConstructor
@AllArgsConstructor
public class PartitaDiCalcio {
    @ManyToOne
    @JoinColumn(name = "squadra_casa_id")
    private Persona squadraDiCasa;

    @ManyToOne
    @JoinColumn(name = "squadra_ospite_id")
    private Persona squadraOspite;
    private String squadraVincente;
    private Integer golCasa;
    private Integer golOspite;
}
