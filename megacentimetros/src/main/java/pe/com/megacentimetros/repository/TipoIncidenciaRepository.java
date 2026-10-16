package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TipoIncidenciaEntity;

public interface TipoIncidenciaRepository extends JpaRepository<TipoIncidenciaEntity, Long> {
	@Query("select t from TipoIncidenciaEntity t where t.estado=true")
	List<TipoIncidenciaEntity> findAllCustom();
}

