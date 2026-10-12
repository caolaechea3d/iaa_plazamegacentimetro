package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TipoTransporteEntity;

public interface TipoTransporteRepository extends JpaRepository<TipoTransporteEntity, Long> {
	@Query("select t from TipoTransporteEntity t where t.estado=true")
	List<TipoTransporteEntity> findAllCustom();
}
