package alkemy.Disney2.Disney2.mapper;


import alkemy.Disney2.Disney2.dto.CiudadDTO;
import alkemy.Disney2.Disney2.dto.ContinenteDTO;
import alkemy.Disney2.Disney2.entity.CiudadEntity;
import alkemy.Disney2.Disney2.entity.ContinenteEntity;
import alkemy.Disney2.Disney2.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {


    private CiudadMapper ciudadMapper;

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
        dto.setCiudades(ciudadesEntityList2DTOList(entity.getCiudades()));                    //agregado ahora
        return dto;
    }

    public List<CiudadDTO> ciudadesEntityList2DTOList(List<CiudadEntity> entities) {        //Agregado ahora
        List<CiudadDTO> dtos = new ArrayList<>();                                           //Agregado ahora
        for (CiudadEntity entity  : entities) {                                                 //Agregado ahora
            //transformo la entityCiudad  a DtoCiudad por cada elem d la lista|             //Agregado ahora
            dtos.add(this.ciudadMapper.ciudadEntity2DTO(entity, true));         //Agregado ahora
        }
        return dtos; // devuelvo una lista de DTOS                                    //agah
    }


}
