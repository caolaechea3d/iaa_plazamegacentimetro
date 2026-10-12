package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.MarcaProductoEntity;

public interface MarcaProductoRepository extends JpaRepository<MarcaProductoEntity, Long> {
	@Query("select m from MarcaProductoEntity m where m.estado=true")
	List<MarcaProductoEntity> findAllCustom();
}
