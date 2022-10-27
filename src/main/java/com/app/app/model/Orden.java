package com.app.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Data
@Entity
@Table(name="Orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private Integer cantidad;
    private Long total;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
