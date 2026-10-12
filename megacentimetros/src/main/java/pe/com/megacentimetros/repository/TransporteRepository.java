package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TransporteEntity;

public interface TransporteRepository extends JpaRepository<TransporteEntity, Long> {
	@Query("select t from TransporteEntity t where t.estado=true")
	List<TransporteEntity> findAllCustom();
}
