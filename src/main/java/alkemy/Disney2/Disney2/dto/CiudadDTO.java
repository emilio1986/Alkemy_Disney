package alkemy.Disney2.Disney2.dto;

import alkemy.Disney2.Disney2.entity.ContinenteEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter


public class CiudadDTO {

    private Long id;
    private String imagen;
    private String denominacion;
    private Long superficie;
    private Set<IconDTO> icons;
    private ContinenteEntity contiennte;
}
