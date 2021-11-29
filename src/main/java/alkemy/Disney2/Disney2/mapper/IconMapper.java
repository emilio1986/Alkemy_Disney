package alkemy.Disney2.Disney2.mapper;

import alkemy.Disney2.Disney2.dto.CiudadDTO;
import alkemy.Disney2.Disney2.dto.IconBasicDTO;
import alkemy.Disney2.Disney2.dto.IconDTO;
import alkemy.Disney2.Disney2.entity.IconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class IconMapper {

    private CiudadMapper ciudadMapper;

    public IconEntity iconDTO2Entity(IconDTO dto) {

        IconEntity entity = new IconEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setFechaCreacion(this.string2LocalDate(dto.getFechaCreacion()));
        entity.setHistoria(dto.getHistoria());
        return entity;
    }


    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadCiudades) {

        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setFechaCreacion(entity.getFechaCreacion().toString());
        dto.setHistoria(entity.getHistoria());
        if(loadCiudades) {

            List<CiudadDTO> ciudadesDTO = this.ciudadMapper.ciudadEntityList2DTO(entity.getCiudades(), false); // lo seteo en F para q no cargue todos las ciudades
            dto.setCiudadades(ciudadesDTO);
        }
        return dto;

    }

    private LocalDate string2LocalDate(String stringDate) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, fmt);
        return date;
    }

    public void iconEntityRefreshValues(IconEntity entity , IconDTO iconDTO){

        entity.setImagen(iconDTO.getImagen());
        entity.setDenominacion(iconDTO.getDenominacion());
        entity.setFechaCreacion(this.string2LocalDate(iconDTO.getFechaCreacion()));
        // FALTA altura en BD-> entity.setAltura(iconDTO.getAltua());
    entity.setHistoria(iconDTO.getHistoria());
    }


    public java.util.Set<IconEntity> iconDTOList2Entity(List<IconDTO> dtos){

        java.util.Set<IconEntity> entities = new HashSet<>();
            for (IconDTO dto:dtos){
                entities.add(this.iconDTO2Entity(dto));

            }
            return entities;
    }

    public List<IconDTO> iconEntitySet2TDOList(Collection<IconEntity> entities , boolean loadCiudades){
        List<IconDTO> dtos = new ArrayList<>();
        for (IconEntity entity:entities){
            dtos.add(this.iconEntity2DTO(entity, loadCiudades));
        }
        return dtos;
    }

    public  List<IconBasicDTO> iconEntitySet2BasicDTOList(Collection<IconEntity> entities){
        List<IconBasicDTO> dtos = new ArrayList<>();
        IconBasicDTO basicDTO;
        for (IconEntity entity:entities){
            basicDTO = new IconBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setDenominacion(entity.getDenominacion());
            dtos.add(basicDTO);
        }
        return  dtos;

    }


    public Set<IconDTO> ciudadEntityList2DTO(Set<IconEntity> icons, boolean loadIcons) {
        return null; //codear
    }
}

