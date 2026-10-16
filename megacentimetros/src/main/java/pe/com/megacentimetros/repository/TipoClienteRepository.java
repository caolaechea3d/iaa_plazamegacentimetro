package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TipoClienteEntity;

public interface TipoClienteRepository extends JpaRepository<TipoClienteEntity, Long> {
	@Query("select t from TipoClienteEntity t where t.estado=true")
	List<TipoClienteEntity> findAllCustom();
}

