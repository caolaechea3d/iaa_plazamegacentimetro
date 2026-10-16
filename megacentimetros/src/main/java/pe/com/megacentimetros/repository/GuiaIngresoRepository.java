package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.GuiaIngresoEntity;

public interface GuiaIngresoRepository extends JpaRepository<GuiaIngresoEntity, Long> {
	@Query("select g from GuiaIngresoEntity g where g.estado<>'ANULADA'")
	List<GuiaIngresoEntity> findAllCustom();
}

