package com.app.app.repositoty;


import com.app.app.model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IDetalleOrdenRepository extends JpaRepository<Detalle, Serializable> {
}
