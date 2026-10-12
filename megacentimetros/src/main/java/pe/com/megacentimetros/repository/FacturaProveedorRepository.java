package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.FacturaProveedorEntity;

public interface FacturaProveedorRepository extends JpaRepository<FacturaProveedorEntity, Long> {
	@Query("select f from FacturaProveedorEntity f where f.estado<>'ANULADA'")
	List<FacturaProveedorEntity> findAllCustom();
}
