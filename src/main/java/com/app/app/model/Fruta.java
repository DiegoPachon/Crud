package com.app.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import com.app.app.model.DetalleOrden;
import org.hibernate.mapping.Set;

@Data
@Entity
@Table(name="Fruta")
public class Fruta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private Integer cantidad;
    private Long precio;

    @OneToMany(mappedBy = "orden")
    Set<DetalleOrden> detalleOrden;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
