package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TipoMovimientoEntity;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimientoEntity, Long> {
	@Query("select t from TipoMovimientoEntity t where t.estado=true")
	List<TipoMovimientoEntity> findAllCustom();
}
