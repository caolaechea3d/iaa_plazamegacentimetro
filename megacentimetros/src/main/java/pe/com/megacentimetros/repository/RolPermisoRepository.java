package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.RolPermisoEntity;
import pe.com.megacentimetros.entity.RolPermisoId;

public interface RolPermisoRepository extends JpaRepository<RolPermisoEntity, RolPermisoId> {
	@Query("select r from RolPermisoEntity r where r.estado=true")
	List<RolPermisoEntity> findAllCustom();
}

