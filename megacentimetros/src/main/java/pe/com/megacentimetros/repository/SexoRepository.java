package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.SexoEntity;

public interface SexoRepository extends JpaRepository<SexoEntity, Long> {
	@Query("select s from SexoEntity s where s.estado=true")
	List<SexoEntity> findAllCustom();
}
