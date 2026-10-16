package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoEnvioEntity;

public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvioEntity, Long> {
	@Query("select e from EstadoEnvioEntity e where e.estado=true")
	List<EstadoEnvioEntity> findAllCustom();
}

