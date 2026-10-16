package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoOrdenCompraEntity;

public interface EstadoOrdenCompraRepository extends JpaRepository<EstadoOrdenCompraEntity, Long> {
	@Query("select e from EstadoOrdenCompraEntity e where e.estado=true")
	List<EstadoOrdenCompraEntity> findAllCustom();
}

