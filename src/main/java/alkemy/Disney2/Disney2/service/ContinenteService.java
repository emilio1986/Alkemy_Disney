package alkemy.Disney2.Disney2.service;

import alkemy.Disney2.Disney2.dto.ContinenteDTO;
import alkemy.Disney2.Disney2.entity.CiudadEntity;

import java.util.List;

public interface ContinenteService {

    ContinenteDTO save(ContinenteDTO dto);

    List<ContinenteDTO> getAllContinentes();

    void delete(Long id);

    ContinenteDTO getContinenteById(Long id);

    ContinenteDTO update(Long id, ContinenteDTO continente);


    ContinenteDTO getDetailsById(Long id);

    void addCiudad(CiudadEntity ciudadEnt, Long idCiudad);

    void addCiudad(Long idCiudad, Long idCont);
}
