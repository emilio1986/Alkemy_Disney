package alkemy.Disney2.Disney2.service.impl;

import alkemy.Disney2.Disney2.dto.IconBasicDTO;
import alkemy.Disney2.Disney2.dto.IconDTO;
import alkemy.Disney2.Disney2.entity.CiudadEntity;
import alkemy.Disney2.Disney2.entity.IconEntity;
import alkemy.Disney2.Disney2.mapper.IconMapper;
import alkemy.Disney2.Disney2.repository.IconRepository;
import alkemy.Disney2.Disney2.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import  alkemy.Disney2.Disney2.service.CiudadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImpl implements IconService {

    //ESTE ESTA BIEN

    public CiudadService ciudadService;

    @Autowired
    private IconRepository iconRepository;

    @Override
    public IconDTO getDetailsById(Long id) {
        return null;
    }

    @Override
    public List<IconBasicDTO> getAll() {
        return null;
    }

    @Override
    public IconDTO save(IconDTO iconDTO) {
        return null;
    }

    @Override
    public IconDTO update(Long id, IconDTO icon) {
        return null;
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
