package com.app.app.controller;

import com.app.app.model.Orden;
import com.app.app.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Orden")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<Orden> saveOrden (@RequestBody Orden orden) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.saveOrden(orden));
    }


    @GetMapping
    public ResponseEntity<Page<Orden>> getAllOrden (
            @RequestParam(required = false, defaultValue ="0") Integer page,
            @RequestParam(required = false, defaultValue ="10") Integer size,
            @RequestParam(required = false, defaultValue ="false")Boolean enablePagination
    ){
        return ResponseEntity.ok(ordenService.getAllOrden(page,size,enablePagination));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteFruta (@PathVariable ("id") Long id){
        ordenService.deleteOrden(id);
        return ResponseEntity.ok(ordenService.existsById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Boolean> fintOrdenById (@PathVariable Long id){
        ordenService.findById(id);
        return ResponseEntity.ok(ordenService.existsById(id));
    }

    @PutMapping
    public ResponseEntity<Orden>  editOrden (@RequestBody Orden orden){
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.editOrden(orden));
    }

}
