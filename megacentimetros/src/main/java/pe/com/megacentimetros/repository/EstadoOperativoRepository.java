package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.EstadoOperativoEntity;

public interface EstadoOperativoRepository extends JpaRepository<EstadoOperativoEntity, Long> {
}
