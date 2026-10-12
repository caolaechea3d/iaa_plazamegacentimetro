package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.NivelFidelizacionEntity;

public interface NivelFidelizacionRepository extends JpaRepository<NivelFidelizacionEntity, Long> {
	@Query("select n from NivelFidelizacionEntity n where n.estado=true")
	List<NivelFidelizacionEntity> findAllCustom();
}
