package alkemy.Disney2.Disney2.service.impl;

import alkemy.Disney2.Disney2.dto.CiudadBasicDTO;
import alkemy.Disney2.Disney2.dto.CiudadDTO;
import alkemy.Disney2.Disney2.dto.IconBasicDTO;
import alkemy.Disney2.Disney2.dto.IconDTO;
import alkemy.Disney2.Disney2.entity.CiudadEntity;
import alkemy.Disney2.Disney2.entity.IconEntity;
import alkemy.Disney2.Disney2.mapper.IconMapper;
import alkemy.Disney2.Disney2.repository.IconRepository;
import alkemy.Disney2.Disney2.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import alkemy.Disney2.Disney2.service.CiudadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconServiceImpl implements IconService {

    //ESTE ESTA BIEN

    public CiudadService ciudadService;

    @Autowired
    private IconRepository iconRepository;
    @Autowired
    private IconMapper iconMapper;

    public IconServiceImpl(IconRepository iconRepository, IconMapper iconMapper) {
        this.iconRepository = iconRepository;
        this.iconMapper = iconMapper;
    }

    @Override
    public IconDTO getDetailsById(Long id) {

        IconEntity entity = this.iconRepository.getById(id);
        IconDTO dtoIcons = this.iconMapper.iconEntity2DTO(entity, true);
        return dtoIcons;


    }


    @Override
    public List<IconBasicDTO> getAllBasics() {
        List<IconEntity> entities = this.iconRepository.findAll();
        List<IconBasicDTO> iconBasicDTOS = iconMapper.iconEntityList2BasicDTOList(entities);
        return iconBasicDTOS;
    }

    @Override
    public List<IconDTO> getAll() {
        List<IconEntity> entities = this.iconRepository.findAll();
        List<IconDTO> iconDTOS = iconMapper.iconEntityList2DTOList(entities);
        return iconDTOS;
    }

    @Override
    public IconDTO save(IconDTO iconDTO) {

        IconEntity entity = iconMapper.iconDTO2Entity(iconDTO);
        IconEntity entidadGuardada = iconRepository.save(entity);
        IconDTO result;
        result = iconMapper.iconEntity2DTO(entidadGuardada, true);          //ANDA
        return result;

    }

    @Override
    public IconDTO update(Long id, IconDTO icon) {
        Optional<IconEntity> entity = this.iconRepository.findById(id);
        // if (!entity.isPresent()) {
        //   throw new ParamNotFound("city id not valid");
        //}
        this.iconMapper.iconEntityRefreshValues(entity.get(), icon);
        IconEntity updatedEntity = this.iconRepository.save(entity.get());
        IconDTO result = this.iconMapper.iconEntity2DTO(updatedEntity, true);
        return result;
    }


    public IconDTO update(Long id, Long idCiudad) {
        return null;
    }

    @Override
    public void addCiudad(Long id, Long idCiudad) {

    }

    @Override
    public void removeCiudad(Long id, Long idCiudad) {
        //busco el id de la ciudad a borrar en la base
        IconEntity entity = this.iconRepository.getById(id);
        entity.getCiudades().size();
        CiudadEntity ciudadEntity = this.ciudadService.getEntityById(idCiudad);
        entity.removeCiudad(ciudadEntity);
        this.iconRepository.save(entity);

    }


    @Override
    public void delete(Long id) {

        this.iconRepository.deleteById(id);

    }

    @Override
    public IconEntity getEntityById(Long idIcon) {
        return null;//codear
    }
}
