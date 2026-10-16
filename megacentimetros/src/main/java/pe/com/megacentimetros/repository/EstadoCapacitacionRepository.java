package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoCapacitacionEntity;

public interface EstadoCapacitacionRepository extends JpaRepository<EstadoCapacitacionEntity, Long> {
	@Query("select e from EstadoCapacitacionEntity e where e.estado=true")
	List<EstadoCapacitacionEntity> findAllCustom();
}

