package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.EstadoAsistenciaEntity;

public interface EstadoAsistenciaRepository extends JpaRepository<EstadoAsistenciaEntity, Long> {
}
