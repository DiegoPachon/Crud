package com.app.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import com.app.app.model.Fruta;
import com.app.app.model.Orden;


@Data
@Entity
@Table(name="DetalleOrden")
class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    Orden orden;

    @ManyToOne
    @JoinColumn(name = "fruta_id")
    Fruta fruta;

    int cantidadFruta;
    
}