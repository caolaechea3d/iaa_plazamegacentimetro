package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.RolPermisoEntity;
import pe.com.megacentimetros.entity.RolPermisoId;

public interface RolPermisoRepository extends JpaRepository<RolPermisoEntity, RolPermisoId> {
}
