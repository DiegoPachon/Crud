package com.app.app.controller;

import com.app.app.model.Fruta;
import com.app.app.service.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @PostMapping
    public ResponseEntity<Fruta> saveFruta (@RequestBody Fruta fruta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(frutaService.saveFruta(fruta));
    }


    @GetMapping
    public ResponseEntity<Page<Fruta>> getAllFruta (
            @RequestParam(required = false, defaultValue ="0") Integer page,
            @RequestParam(required = false, defaultValue ="10") Integer size,
            @RequestParam(required = false, defaultValue ="false")Boolean enablePagination
    ){
        return ResponseEntity.ok(frutaService.getAllFruta(page,size,enablePagination));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteFruta (@PathVariable ("id") Long id){
        frutaService.deleteFruta(id);
        return ResponseEntity.ok(frutaService.existsById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Boolean> fintFrutaById (@PathVariable Long id){
        frutaService.findById(id);
        return ResponseEntity.ok(frutaService.existsById(id));
    }

    @PutMapping
    public ResponseEntity<Fruta>  editFruta (@RequestBody Fruta fruta){
        return ResponseEntity.status(HttpStatus.CREATED).body(frutaService.editFruta(fruta));
    }

}

