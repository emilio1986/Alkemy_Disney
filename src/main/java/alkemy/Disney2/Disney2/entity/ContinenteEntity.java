package alkemy.Disney2.Disney2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "continente")
@Getter
@Setter
public class ContinenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)                    //autoincremental
    private Long id;

    private String imagen;

    private String denominacion;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)     // 1 a n
    @JoinColumn(name = "id", insertable = false, updatable = false) // solo lo uso para obtener(get) las ciudades   REEMPLAZO CIUDAD_ID POR ID Y LEVANTGO DEVUELTA EL PRY

    private List<CiudadEntity> ciudades = new ArrayList<>();  // coleccion de ciudades que contiene el continente
}
