package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.CanjeRecompensaEntity;

public interface CanjeRecompensaRepository extends JpaRepository<CanjeRecompensaEntity, Long> {
	@Query("select c from CanjeRecompensaEntity c where c.estado=true")
	List<CanjeRecompensaEntity> findAllCustom();
}

