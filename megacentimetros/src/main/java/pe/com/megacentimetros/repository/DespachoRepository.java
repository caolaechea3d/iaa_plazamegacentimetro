package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.DespachoEntity;

public interface DespachoRepository extends JpaRepository<DespachoEntity, Long> {
	@Query("select d from DespachoEntity d where d.estado<>'ANULADO'")
	List<DespachoEntity> findAllCustom();
}
