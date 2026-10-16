package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.DetalleGuiaIngresoEntity;

public interface DetalleGuiaIngresoRepository extends JpaRepository<DetalleGuiaIngresoEntity, Long> {
	@Query("select d from DetalleGuiaIngresoEntity d where d.estado=true")
	List<DetalleGuiaIngresoEntity> findAllCustom();
}

