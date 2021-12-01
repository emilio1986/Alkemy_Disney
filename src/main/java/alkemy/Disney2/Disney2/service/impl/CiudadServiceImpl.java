package alkemy.Disney2.Disney2.service.impl;

import alkemy.Disney2.Disney2.dto.CiudadBasicDTO;
import alkemy.Disney2.Disney2.dto.CiudadDTO;
import org.springframework.stereotype.Service;
import alkemy.Disney2.Disney2.entity.CiudadEntity;
import alkemy.Disney2.Disney2.entity.IconEntity;
import alkemy.Disney2.Disney2.mapper.CiudadMapper;
import alkemy.Disney2.Disney2.repository.CiudadRepository;
import alkemy.Disney2.Disney2.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import alkemy.Disney2.Disney2.service.IconService;

import java.util.List;
import java.util.Optional;


@Service
public class CiudadServiceImpl implements CiudadService {

////////////////////////////////////////////////////////

    //Inyeccion de repositorio "CiudadRep"  para que ni bien se levanta Spring lo pueda usar
    private CiudadRepository ciudadRepository;


    private CiudadMapper ciudadMapper;

    private IconService iconService;

    @Autowired
    public CiudadServiceImpl(
            CiudadRepository ciudadRepository,
            CiudadMapper ciudadMapper,
            IconService iconService
    ) {
        this.ciudadRepository = ciudadRepository;

        this.ciudadMapper = ciudadMapper;
        this.iconService = iconService;
    }


    @Override
    public CiudadDTO getDetailsById(Long id) {
        Optional<CiudadEntity> entity = Optional.of(ciudadRepository.getById(id));

        CiudadDTO ciudadDTO = this.ciudadMapper.ciudadEntity2DTO(entity.get(), true);
        return ciudadDTO;
    }


    @Override
    public CiudadDTO save(CiudadDTO dto ) {
        CiudadEntity entity = ciudadMapper.ciudadDTO2Entity(dto);
        CiudadEntity entidadGuardada = ciudadRepository.save(entity);
        CiudadDTO result;
        result = ciudadMapper.ciudadEntity2DTO(true, entidadGuardada);          //ANDA
        return result;
    }

    @Override
    public List<CiudadBasicDTO> getAll() {
        List<CiudadEntity> entities = ciudadRepository.findAll();
        List<CiudadBasicDTO> iconBasicDTOS = ciudadMapper.ciudadEntityList2BasicDTOList(entities);
        return iconBasicDTOS;
    }

    @Override
    public CiudadDTO update(Long id, CiudadDTO ciudad) {
        Optional<CiudadEntity> entity = this.ciudadRepository.findById(id);
        //if (!entity.isPresent()) {
        //return (System.out.println(" ciudad Invalida ")); //??? Deberia ir una excepcion??
        //}
        this.ciudadMapper.ciudadEntityRefreshValues(entity.get(), ciudad);
        CiudadEntity entidadAct = this.ciudadRepository.save(entity.get());
        CiudadDTO result = this.ciudadMapper.ciudadEntity2DTO(entidadAct, true);
        return result;
    }


    @Override
    public void addICon(Long id, Long idIcon) {
        CiudadEntity entity = this.ciudadRepository.getById(id);
        entity.getIcons().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        entity.addIcon(iconEntity);
        this.ciudadRepository.save(entity);
    }


    public void removeIcon(Long id, Long idIcon) {
        //busco el id de la ciudad a borrar en la base
        CiudadEntity entity = this.ciudadRepository.getById(id);
        entity.getIcons().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        entity.removeIcon(iconEntity);
        this.ciudadRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        this.ciudadRepository.deleteById(id);
    }

    @Override
    public CiudadEntity getEntityById(Long idCiudad) {
        return null;
    }


//public Entity getEntityById(Long id){
//
//
// }
}
