package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.CampanaEntity;

public interface CampanaRepository extends JpaRepository<CampanaEntity, Long> {
	@Query("select c from CampanaEntity c where c.estado=true")
	List<CampanaEntity> findAllCustom();
}

