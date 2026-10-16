package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.FacturacionEntity;

public interface FacturacionRepository extends JpaRepository<FacturacionEntity, Long> {
	@Query("select f from FacturacionEntity f where f.estado<>'ANULADA'")
	List<FacturacionEntity> findAllCustom();
}

