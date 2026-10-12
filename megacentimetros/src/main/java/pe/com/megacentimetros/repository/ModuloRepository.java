package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.ModuloEntity;

public interface ModuloRepository extends JpaRepository<ModuloEntity, Long> {
	@Query("select m from ModuloEntity m where m.estado=true")
	List<ModuloEntity> findAllCustom();
}
