package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TipoComprobanteEntity;

public interface TipoComprobanteRepository extends JpaRepository<TipoComprobanteEntity, Long> {
	@Query("select t from TipoComprobanteEntity t where t.estado=true")
	List<TipoComprobanteEntity> findAllCustom();
}

