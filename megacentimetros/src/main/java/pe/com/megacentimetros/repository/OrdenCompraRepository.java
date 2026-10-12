package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.OrdenCompraEntity;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Long> {
	@Query("select o from OrdenCompraEntity o where o.estado<>'ANULADA'")
	List<OrdenCompraEntity> findAllCustom();
}
