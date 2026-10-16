package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.CuentaPuntosEntity;

public interface CuentaPuntosRepository extends JpaRepository<CuentaPuntosEntity, Long> {
	@Query("select c from CuentaPuntosEntity c where c.estado=true")
	List<CuentaPuntosEntity> findAllCustom();
}

