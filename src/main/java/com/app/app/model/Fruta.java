package com.app.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import java.util.Set;

@Data
@Entity
@Table(name="Fruta")
public class Fruta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFruta;
    private String tipo;
    private Integer cantidad;
    private Long precio;

    @OneToMany(mappedBy = "orden")
    Set<Detalle> detalleOrden;

    public void setId(Long id) {
        this.idFruta = id;
    }

    public Long getId() {
        return idFruta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Set<Detalle> getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(Set<Detalle> detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public Long getIdFruta() {
        return idFruta;
    }

    public void setIdFruta(Long idFruta) {
        this.idFruta = idFruta;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
