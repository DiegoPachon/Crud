package com.app.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrden;
    private Long total;

    @OneToMany(mappedBy = "fruta")
    private List<Fruta> detalleOrden;

    public static List<Fruta> getDetalleList(Orden orden) {
        return null;
    }

    public void setId(Long id) {
        this.idOrden = id;
    }

    public Long getId() {
        return idOrden;
    }

    public List<Fruta> getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(List<Fruta> detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
