package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TrasladoAlmacenEntity;

public interface TrasladoAlmacenRepository extends JpaRepository<TrasladoAlmacenEntity, Long> {
	@Query("select t from TrasladoAlmacenEntity t where t.estado<>'ANULADO'")
	List<TrasladoAlmacenEntity> findAllCustom();
}
