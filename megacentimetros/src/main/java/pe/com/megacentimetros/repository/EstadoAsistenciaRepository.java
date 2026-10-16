package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoAsistenciaEntity;

public interface EstadoAsistenciaRepository extends JpaRepository<EstadoAsistenciaEntity, Long> {
	@Query("select e from EstadoAsistenciaEntity e where e.estado=true")
	List<EstadoAsistenciaEntity> findAllCustom();
}

