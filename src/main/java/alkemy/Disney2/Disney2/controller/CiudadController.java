package alkemy.Disney2.Disney2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import alkemy.Disney2.Disney2.dto.CiudadDTO;
import alkemy.Disney2.Disney2.dto.CiudadBasicDTO;
import alkemy.Disney2.Disney2.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;

@RestController
@RequestMapping("ciudades")
public class CiudadController {


    private CiudadService ciudadService; //Interfaz

    @Autowired
    CiudadController(CiudadService ciudadService) {           //me llega un IconService y se lo asigno a mi iconService
        this.ciudadService = ciudadService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<CiudadBasicDTO>> getAll() {
        List<CiudadBasicDTO> ciudades = this.ciudadService.getAll(); // REVISAR
        return ResponseEntity.ok(ciudades);
    }

    //tipo de solicitud
    @GetMapping("/{id}")
    public ResponseEntity<CiudadDTO> getDetailsById(@PathVariable Long id) {
        CiudadDTO ciudad = this.ciudadService.getDetailsById(id);
        return ResponseEntity.ok(ciudad);  //devuelvo la ciudad a mostrar
    }


    @PostMapping
    public ResponseEntity<CiudadDTO> save(@RequestBody CiudadDTO ciudad) {
        CiudadDTO result = this.ciudadService.save(ciudad);
        return ResponseEntity.status((HttpStatus.CREATED)).body(result);  //devuelvo el CiudadDto que ya guarde en BD

    }

    @PostMapping("/{id}/icons/idIcon")
    public ResponseEntity<Void> addIcon(@PathVariable Long id, @PathVariable Long idIcon) {

        this.ciudadService.addICon(id, idIcon);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<CiudadDTO> update(@PathVariable Long id, @RequestBody CiudadDTO ciudad) {
        CiudadDTO result = this.ciudadService.update(id, ciudad);
        return ResponseEntity.ok().body(result);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.ciudadService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/{id}/icons/{idIcon}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long idIcon) {
        this.ciudadService.removeIcon(id, idIcon);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
