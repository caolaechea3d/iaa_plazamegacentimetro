package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.MovimientoInventarioEntity;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventarioEntity, Long> {
}
