package com.app.app.service;

import com.app.app.model.Fruta;
import com.app.app.repositoty.IFrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@Service
public class FrutaService {
    @Autowired
    private static IFrutaRepository iFrutaRepository;

    @PostMapping
    public Fruta saveFruta (Fruta fruta){
        if (fruta.getId() == null) {
            return iFrutaRepository.save(fruta);
        }
        return null;
    }
    @GetMapping
    public Page<Fruta> getAllFruta(Integer page, Integer size, Boolean enablePagination){
        return iFrutaRepository.findAll(enablePagination ? PageRequest.of(page,size): Pageable.unpaged());
    }
    public static Optional<Fruta> findById(Long id){
        return iFrutaRepository.findById(id);
    }
    @DeleteMapping
    public void deleteFruta(Long id){
        if (iFrutaRepository.existsById(id)) {
            iFrutaRepository.deleteById(id);
        }
    }

    @PutMapping
    public Fruta editFruta (Fruta fruta){

        if (fruta.getId() != null && iFrutaRepository.existsById(fruta.getId())) {
            return iFrutaRepository.save(fruta);
        }
        return null;
    }

    public boolean existsById(Long id){
        return !iFrutaRepository.existsById(id);
    }

}
