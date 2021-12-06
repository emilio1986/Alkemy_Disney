package alkemy.Disney2.Disney2.service;

import alkemy.Disney2.Disney2.dto.IconBasicDTO;
import alkemy.Disney2.Disney2.dto.IconDTO;
import alkemy.Disney2.Disney2.entity.IconEntity;

import java.util.List;

public interface IconService {

    IconDTO getDetailsById(Long id);

    List<IconBasicDTO> getAllBasics();

    List<IconDTO> getAll();

    IconDTO save(IconDTO iconDTO);

    IconDTO update(Long id, IconDTO icon);

    void addCiudad(Long id, Long idCiudad);

    void removeCiudad(Long id, Long idCiudad);

    void delete(Long id);

    IconEntity getEntityById(Long idIcon);
}
