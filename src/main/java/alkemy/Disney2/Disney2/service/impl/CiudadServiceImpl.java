package alkemy.Disney2.Disney2.service.impl;

import alkemy.Disney2.Disney2.dto.CiudadDTO;

import alkemy.Disney2.Disney2.entity.CiudadEntity;
import alkemy.Disney2.Disney2.entity.IconEntity;
import alkemy.Disney2.Disney2.mapper.CiudadMapper;
import alkemy.Disney2.Disney2.repository.CiudadRepository;
import alkemy.Disney2.Disney2.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import  alkemy.Disney2.Disney2.service.IconService;
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    private CiudadMapper ciudadMapper;

    @Autowired
    private IconService iconService;

    //Inyeccion de repositorio "CiudadRep"  para que ni bien se levanta Spring lo pueda usar
    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public CiudadDTO getDetailsById(Long id) {
        return null;
    }

    @Override
    public List<CiudadDTO> getAll() {
        return null;
    }

    @Override
    public CiudadDTO save(CiudadDTO ciudadDTO) {
        return null;
    }


    @Override
    public CiudadDTO update(Long id, CiudadDTO icon) {
        return null;
    }

    public CiudadDTO update(Long id, Long idIcono) {
        return null;
    }

    @Override
    public void addICon(Long id, Long idICon) {

    }

    @Override
    public void removeIcon(Long id, Long idIcon) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CiudadEntity getEntityById(Long idCiudad) {
        return null;
    }


    public void removeICon(Long id, Long idIcon) {
        //busco el id de la ciudad a borrar en la base
        CiudadEntity entity = this.ciudadRepository.getById(id);
        entity.getIcons().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        entity.removeIcon(iconEntity);
        this.ciudadRepository.save(entity);
}

//public Entity getEntityById(Long id){
//
//
// }
}
