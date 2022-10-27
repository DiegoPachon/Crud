package com.app.app.repositoty;

import com.app.app.model.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrutaRepository extends JpaRepository<Fruta,Long> {
}
