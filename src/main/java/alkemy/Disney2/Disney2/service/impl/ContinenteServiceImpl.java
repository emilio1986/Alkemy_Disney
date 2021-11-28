package alkemy.Disney2.Disney2.service.impl;

import alkemy.Disney2.Disney2.dto.ContinenteDTO;
import alkemy.Disney2.Disney2.service.ContinenteService;
import org.springframework.stereotype.Service;

@Service

public class ContinenteServiceImpl implements ContinenteService {

public ContinenteDTO save(ContinenteDTO dto){
    //TODO: guardar CONTINENTE
    System.out.println("GUARDAR CONTINENTE");
    return dto;

}

}
