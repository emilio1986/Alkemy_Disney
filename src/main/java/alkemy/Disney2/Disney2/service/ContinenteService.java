package alkemy.Disney2.Disney2.service;

import alkemy.Disney2.Disney2.dto.ContinenteDTO;

import java.util.List;

public interface ContinenteService {

    ContinenteDTO save(ContinenteDTO dto);

    List<ContinenteDTO> getAllContinentes();
}
