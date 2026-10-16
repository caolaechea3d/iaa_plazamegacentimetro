package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.CategoriaProductoEntity;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProductoEntity, Long> {
	@Query("select c from CategoriaProductoEntity c where c.estado=true")
	List<CategoriaProductoEntity> findAllCustom();
}

