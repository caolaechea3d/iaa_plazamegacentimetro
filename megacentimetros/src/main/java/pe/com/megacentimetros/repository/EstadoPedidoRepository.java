package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EstadoPedidoEntity;

public interface EstadoPedidoRepository extends JpaRepository<EstadoPedidoEntity, Long> {
	@Query("select e from EstadoPedidoEntity e where e.estado=true")
	List<EstadoPedidoEntity> findAllCustom();
}

