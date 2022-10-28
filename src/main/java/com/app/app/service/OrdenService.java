package com.app.app.service;

import com.app.app.model.Detalle;
import com.app.app.model.Fruta;
import com.app.app.model.Orden;
import com.app.app.repositoty.IDetalleOrdenRepository;
import com.app.app.repositoty.IOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private IOrdenRepository iOrdenRepository;

    @Autowired
    private IDetalleOrdenRepository iDetalleOrdenRepository;

    @GetMapping(value = "/Buscar")
    public List<Orden> getAllOrden (Integer page, Integer size, Boolean enablePagination){
        return (List<Orden>) iOrdenRepository.findAll(enablePagination ? PageRequest.of(page,size): Pageable.unpaged());
    }

    @PostMapping(value = "/Guardar")
    public Orden saveOrden (@RequestBody Orden orden){
        if (orden.getId() == null) {
            List <Detalle> detalles = orden.getDetalleList();
            orden.setDetalleOrden(null);
            iOrdenRepository.save(orden);
            for(Detalles det: detalles ){
                Fruta fruta = FrutaService.findById()
                Detalle  detalle = new Detalle(orden, fruta,detalles)
                det.setIdDetalles(orden.getIdOrden());
            }
            iDetalleOrdenRepository.saveAll(detalles);
            orden.setDetallesList(detalles);
            return orden;
        }
        return null;
    }


    public Optional<Orden> findById (Long id){
        return iOrdenRepository.findById(id);
    }


    @DeleteMapping(value = "/Eliminar/{id}")
    public void deleteOrden(@PathVariable ("id") Long id){
        if (iOrdenRepository.existsById(id)) {
            iOrdenRepository.deleteById(id);
            iDetalleOrdenRepository.deleteById(id);
        }
    }

    public boolean existsById(Long id){
        return !iOrdenRepository.existsById(id);
    }

}
