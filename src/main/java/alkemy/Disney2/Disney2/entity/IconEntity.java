package alkemy.Disney2.Disney2.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //autoincremental
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long altura;

    private String historia;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<CiudadEntity> ciudades = new ArrayList<>();

    public void addCiudad(CiudadEntity ciudad) {
        this.ciudades.add(ciudad);

    }

    public void removeCiudad(CiudadEntity ciudad) {

        this.ciudades.remove(ciudad);

    }

}
