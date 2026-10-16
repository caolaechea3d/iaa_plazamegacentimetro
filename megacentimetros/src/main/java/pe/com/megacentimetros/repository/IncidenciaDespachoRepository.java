package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.IncidenciaDespachoEntity;

public interface IncidenciaDespachoRepository extends JpaRepository<IncidenciaDespachoEntity, Long> {
	@Query("select i from IncidenciaDespachoEntity i where i.estado<>'RESUELTA'")
	List<IncidenciaDespachoEntity> findAllCustom();
}

