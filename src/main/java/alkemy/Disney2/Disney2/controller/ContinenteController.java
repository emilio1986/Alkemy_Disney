package alkemy.Disney2.Disney2.controller;

import alkemy.Disney2.Disney2.dto.ContinenteDTO;
import alkemy.Disney2.Disney2.service.ContinenteService;
import alkemy.Disney2.Disney2.service.impl.ContinenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("continentes")

public class ContinenteController {

    @Autowired
    private ContinenteService continenteService; //Interfaz
    //tipo de solicitud
    @PostMapping
    public ResponseEntity<ContinenteDTO>  save(@RequestBody ContinenteDTO continente){
        ContinenteDTO continenteGuardado = continenteService.save(continente);
         return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado); //devuelvo el continente guardado
    }
}


// forma  de acceso al endpoint -> POST localhost/continente
//solamente recibe una solicitud aca y manda una RTA
