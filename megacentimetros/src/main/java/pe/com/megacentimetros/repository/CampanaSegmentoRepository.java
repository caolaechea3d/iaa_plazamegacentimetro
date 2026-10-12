package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.CampanaSegmentoEntity;
import pe.com.megacentimetros.entity.CampanaSegmentoId;

public interface CampanaSegmentoRepository extends JpaRepository<CampanaSegmentoEntity, CampanaSegmentoId> {
}
