package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoOperativoEntity;

public interface EstadoOperativoRepository extends JpaRepository<EstadoOperativoEntity, Long> {
	@Query("select e from EstadoOperativoEntity e where e.estado=true")
	List<EstadoOperativoEntity> findAllCustom();
}

