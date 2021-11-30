package alkemy.Disney2.Disney2.mapper;


import alkemy.Disney2.Disney2.dto.ContinenteDTO;
import alkemy.Disney2.Disney2.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {

    //metodo para convertir de DTo a Entity que voy a reutilizar
    public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(dto.getImagen());
        continenteEntity.setDenominacion(dto.getDenominacion());

        return continenteEntity;
    }


    public List<ContinenteDTO> continenteEntityList2DTOList(List<ContinenteEntity> entities) {
        List<ContinenteDTO> dtos = new ArrayList<>();
        for (ContinenteEntity entity : entities) {
            //transformo la entity a Dto por cada elem d la lista
            dtos.add(this.continenteEntity2TDO(entity));
        }
        return dtos; // devuelvo una lista de DTOS
    }

    public ContinenteDTO continenteEntity2TDO(ContinenteEntity entity) {
        ContinenteDTO dto = new ContinenteDTO();
        dto.setImagen(entity.getImagen());
        dto.setId(entity.getId());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }


}
