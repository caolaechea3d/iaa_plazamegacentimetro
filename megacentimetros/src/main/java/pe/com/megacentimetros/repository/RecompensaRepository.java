package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.RecompensaEntity;

public interface RecompensaRepository extends JpaRepository<RecompensaEntity, Long> {
	@Query("select r from RecompensaEntity r where r.estado=true")
	List<RecompensaEntity> findAllCustom();
}
