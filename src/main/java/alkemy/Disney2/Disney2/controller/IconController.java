package alkemy.Disney2.Disney2.controller;

import alkemy.Disney2.Disney2.dto.IconBasicDTO;
import alkemy.Disney2.Disney2.dto.IconDTO;
import alkemy.Disney2.Disney2.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {


    private IconService iconService;        //Interfaz

    @Autowired
    //me llega un IconService y se lo asigno a mi iconService
    public IconController(IconService iconService) {

        this.iconService = iconService;
    }


    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO result = this.iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);             //devuelvo el IconDto que ya guarde en BD
    }

    //@PostMapping("/{id}/ciudad/{idCiudad}")
    //public ResponseEntity<Void> addCiudad(@PathVariable Long id, @PathVariable Long idCiudad) {

    //  this.iconService.addCiudad(id, idCiudad);
    //return ResponseEntity.status(HttpStatus.CREATED).build();
    //}

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

    //@DeleteMapping("/{id}/ciudad/{idCiudad}")
    //public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long idCiudad) {
    //  this.iconService.removeCiudad(id, idCiudad);
    //return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    //}


    @GetMapping
    public ResponseEntity<List<IconBasicDTO>> getAll() {
        List<IconBasicDTO> icons = this.iconService.getAllBasics();
        return ResponseEntity.ok(icons);
    }

    //@GetMapping
    // public ResponseEntity<List<IconDTO>> getAllBasics() {
    //   List<IconDTO> icons = this.iconService.getAll();
    // return ResponseEntity.ok(icons);
    //}


    //tipo de solicitud
    @GetMapping("/{id}")
    public ResponseEntity<IconDTO> getDetailsById(@PathVariable Long id) {
        IconDTO icon = this.iconService.getDetailsById(id);
        return ResponseEntity.ok(icon);  //devuelvo el icono a mostrar
    }


}
