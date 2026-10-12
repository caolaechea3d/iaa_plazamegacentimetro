package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoEvaluacionEntity;

public interface EstadoEvaluacionRepository extends JpaRepository<EstadoEvaluacionEntity, Long> {
	@Query("select e from EstadoEvaluacionEntity e where e.estado=true")
	List<EstadoEvaluacionEntity> findAllCustom();
}
