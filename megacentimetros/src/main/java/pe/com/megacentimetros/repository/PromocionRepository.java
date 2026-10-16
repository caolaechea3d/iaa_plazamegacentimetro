package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.PromocionEntity;

public interface PromocionRepository extends JpaRepository<PromocionEntity, Long> {
	@Query("select p from PromocionEntity p where p.estado=true")
	List<PromocionEntity> findAllCustom();
}

