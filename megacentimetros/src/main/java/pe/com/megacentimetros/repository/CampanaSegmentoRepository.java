package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.CampanaSegmentoEntity;
import pe.com.megacentimetros.entity.CampanaSegmentoId;

public interface CampanaSegmentoRepository extends JpaRepository<CampanaSegmentoEntity, CampanaSegmentoId> {
	@Query("select c from CampanaSegmentoEntity c where c.estado=true")
	List<CampanaSegmentoEntity> findAllCustom();
}

