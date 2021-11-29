package alkemy.Disney2.Disney2.controller;


import alkemy.Disney2.Disney2.dto.IconBasicDTO;
import alkemy.Disney2.Disney2.dto.IconDTO;
import alkemy.Disney2.Disney2.service.CiudadService;
import alkemy.Disney2.Disney2.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ciudades")
public class CiudadController {

    private CiudadService ciudadService; //Interfaz
    private IconService iconService;


    //@Autowired
    //me llega un IconService y se lo asigno a mi iconService
   // public CiudadController(CiudadService ciudadService) {
     //   this.ciudadService = ciudadService; //original
   // }


    @PostMapping("/{id}")
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {

        IconDTO result = this.iconService.save(icon);
        return ResponseEntity.ok().body(result);  //devuelvo el IconDto que ya guarde en BD

    }

    @PostMapping("/{id}/ciudad/idCiudad")
    public ResponseEntity<Void> addCiudad(@PathVariable Long id, @PathVariable Long idCiudad) {

        this.iconService.addCiudad(id, idCiudad);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO icon) {
        IconDTO result = this.iconService.update(id, icon);
        return ResponseEntity.ok().body(result);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/{id}/ciudad/{idCiudad}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long idCiudad) {
        this.iconService.removeCiudad(id, idCiudad);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/all")
    public ResponseEntity<List<IconBasicDTO>> getAll() {
        List<IconBasicDTO> icons = this.iconService.getAll();
        return ResponseEntity.ok(icons);
    }

    //tipo de solicitud
    @GetMapping("/{id}")
    public ResponseEntity<IconDTO> getDetailsById(@PathVariable Long id) {
        IconDTO icon = this.iconService.getDetailsById(id);
        return ResponseEntity.ok(icon);  //devuelvo el icono a mostrar
    }



}
