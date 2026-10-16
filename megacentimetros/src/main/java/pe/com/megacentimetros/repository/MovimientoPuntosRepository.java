package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.MovimientoPuntosEntity;

public interface MovimientoPuntosRepository extends JpaRepository<MovimientoPuntosEntity, Long> {
	@Query("select m from MovimientoPuntosEntity m where m.estado=true")
	List<MovimientoPuntosEntity> findAllCustom();
}

