package alkemy.Disney2.Disney2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ciudad")
@Getter
@Setter
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //autoincremental
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes")  //cuando el nombre es = al d la tabla NO va @column
    private Long superficie; //m2

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)     // 1 a n
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
                                                                        // solo lo uso para obtener(get) info por eso false en update y demas-> se a q CONT  pertenece
    private ContinenteEntity continente;                                //variable/tabla   continente al cual pertenece la ciudad.ME trae el continente

    @Column(name = "continente_id", nullable = false)
    private Long continenteId;                                      //defino la columna q no puede ser null y apunta a un cont

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_ciudad",                                   // nombre de la tabla INTERMEDIA
            joinColumns = @JoinColumn(name = "ciudad_id"),          //como joinea de este lado
            inverseJoinColumns = @JoinColumn(name = "icon_id"))    // como joinea del otro lado(Icon)
    private Set<IconEntity> icons = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final CiudadEntity other = (CiudadEntity) obj;
        return other.id == this.id;

    }

}


