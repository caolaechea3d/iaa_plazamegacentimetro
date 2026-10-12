package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.AsistenciaEntity;

public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, Long> {
}
