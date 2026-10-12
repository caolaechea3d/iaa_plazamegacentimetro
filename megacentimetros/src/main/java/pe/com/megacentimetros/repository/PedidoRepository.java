package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
	@Query("select p from PedidoEntity p where p.estado<>'ANULADO'")
	List<PedidoEntity> findAllCustom();
}
