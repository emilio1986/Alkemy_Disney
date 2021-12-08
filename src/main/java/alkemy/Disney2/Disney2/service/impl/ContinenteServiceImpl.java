package alkemy.Disney2.Disney2.service.impl;

import alkemy.Disney2.Disney2.dto.ContinenteDTO;
import alkemy.Disney2.Disney2.entity.ContinenteEntity;
import alkemy.Disney2.Disney2.mapper.ContinenteMapper;
import alkemy.Disney2.Disney2.repository.ContinenteRepository;
import alkemy.Disney2.Disney2.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ContinenteServiceImpl implements ContinenteService {

    //Inyeccion
    @Autowired
    private ContinenteMapper continenteMapper;
    //Inyeccion
    @Autowired
    private ContinenteRepository continenteRepository;

    @Autowired
    public ContinenteServiceImpl(ContinenteRepository continentRepository, ContinenteMapper continenteMapper) {
        this.continenteRepository = continentRepository;
        this.continenteMapper = continenteMapper;
    }

    public ContinenteDTO save(ContinenteDTO dto) {                                           //PASS
        //variable privada de la clase "ContMapper"
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
        // guardo el  CONTINENTE como entity en BD y me lo quedo  en entitySaved para conv Entity2Dto
        ContinenteEntity entitySaved = continenteRepository.save(entity);
        //  conv  entitySaved de Entity2TDo a DTO y lo guardo en result
        ContinenteDTO result = continenteMapper.continenteEntity2TDO(entitySaved);
        return result;

    }

    @Override
    public List<ContinenteDTO> getAllContinentes() {                                            //PASS
        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return result;
    }


    public ContinenteDTO update(Long id, ContinenteDTO continente) {                             //PASS
        Optional<ContinenteEntity> oldEntity = Optional.of(this.continenteRepository.getById(id));
        //excepcion??
        ContinenteEntity newEntity = continenteMapper.continenteDTO2Entity(continente);
        newEntity.setId(oldEntity.get().getId());
        ContinenteEntity entitySaved = continenteRepository.save(newEntity);
        ContinenteDTO result = continenteMapper.continenteEntity2TDO(entitySaved);
        return result;
    }


    public void delete(Long id) {
        this.continenteRepository.deleteById(id);
    }               //PASS

    @Override
    public ContinenteDTO getContinenteById(Long id) {                                        //PASS
        ContinenteEntity entidadCont = this.continenteRepository.getById(id);
        ContinenteDTO contDTO = this.continenteMapper.continenteEntity2TDO(entidadCont);
        return contDTO;

    }

}
