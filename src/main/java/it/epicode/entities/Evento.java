package it.epicode.entities;

import it.epicode.entitiesENUM.TipoEvento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Entity
@Data
@NoArgsConstructor
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    private String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private Integer mumeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> listaParetcipazioni;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.mumeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
