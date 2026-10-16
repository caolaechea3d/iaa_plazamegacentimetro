package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.SucursalEntity;

public interface SucursalRepository extends JpaRepository<SucursalEntity, Long> {
	@Query("select s from SucursalEntity s where s.estado=true")
	List<SucursalEntity> findAllCustom();
}

