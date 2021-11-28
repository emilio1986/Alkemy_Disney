package alkemy.Disney2.Disney2.service.impl;

import alkemy.Disney2.Disney2.dto.ContinenteDTO;
import alkemy.Disney2.Disney2.entity.ContinenteEntity;
import alkemy.Disney2.Disney2.mapper.ContinenteMapper;
import alkemy.Disney2.Disney2.repository.ContinenteRepository;
import alkemy.Disney2.Disney2.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ContinenteServiceImpl implements ContinenteService {

    //Inyeccion de Clase ContinenteMapper  para que ni bien se levanta Spring lo pueda usar
    @Autowired
private ContinenteMapper continenteMapper;
    //Inyeccion de repositorio "ContRep"  para que ni bien se levanta Spring lo pueda usar
    @Autowired
    private ContinenteRepository continenteRepository;



public ContinenteDTO save(ContinenteDTO dto){
                                //variable privada de la clase "ContMapper"
    ContinenteEntity entity = continenteMapper.continenteDto2Entity(dto);
    // guardo el  CONTINENTE como entity en BD y me lo quedo  en entitySaved para conv Entity2Dto
     ContinenteEntity entitySaved = continenteRepository.save(entity);
//  conv  entitySaved de Entity2TDo a DTO y lo guardo en result
     ContinenteDTO result = continenteMapper.continenteEntity2TDO(entitySaved);
    return result;

}

    @Override
    public List<ContinenteDTO> getAllContinentes() {
List<ContinenteEntity> entities = continenteRepository.findAll();
List<ContinenteDTO> result = continenteMapper.continenteEntityList2TDOList(entities);
        return result;
    }

}
