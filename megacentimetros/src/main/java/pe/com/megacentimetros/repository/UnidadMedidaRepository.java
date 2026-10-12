package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.UnidadMedidaEntity;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedidaEntity, Long> {
	@Query("select u from UnidadMedidaEntity u where u.estado=true")
	List<UnidadMedidaEntity> findAllCustom();
}
