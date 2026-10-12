package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoPagoEntity;

public interface EstadoPagoRepository extends JpaRepository<EstadoPagoEntity, Long> {
	@Query("select e from EstadoPagoEntity e where e.estado=true")
	List<EstadoPagoEntity> findAllCustom();
}
