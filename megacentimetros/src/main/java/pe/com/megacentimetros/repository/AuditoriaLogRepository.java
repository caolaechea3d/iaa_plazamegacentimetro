package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.AuditoriaLogEntity;

public interface AuditoriaLogRepository extends JpaRepository<AuditoriaLogEntity, Long> {
	@Query("select a from AuditoriaLogEntity a where a.estado=true")
	List<AuditoriaLogEntity> findAllCustom();
}

