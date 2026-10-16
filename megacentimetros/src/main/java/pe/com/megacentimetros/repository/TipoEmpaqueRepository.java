package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TipoEmpaqueEntity;

public interface TipoEmpaqueRepository extends JpaRepository<TipoEmpaqueEntity, Long> {
	@Query("select t from TipoEmpaqueEntity t where t.estado=true")
	List<TipoEmpaqueEntity> findAllCustom();
}

