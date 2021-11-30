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
    private Long ContinenteId ;

    public Long getContiennteiD() {
        return null;
    }

    public Long getContinenteId() {
        return null;
    }

    public Long getContinenteID() {
        return null;
    }

    public void setContinenteId(Long continenteId) {
    }
}