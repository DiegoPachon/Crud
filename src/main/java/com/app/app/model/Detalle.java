package com.app.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name="Detalle")
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idDetalle;

    @OneToMany(mappedBy = "idFruta")
    private List<Detalle> detalleList;

    private Integer cantidadFruta;

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    public Integer getCantidadFruta() {
        return cantidadFruta;
    }

    public void setCantidadFruta(Integer cantidadFruta) {
        this.cantidadFruta = cantidadFruta;
    }
}