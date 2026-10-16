package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.TipoEmpleadoEntity;

public interface TipoEmpleadoRepository extends JpaRepository<TipoEmpleadoEntity, Long> {
	@Query("select t from TipoEmpleadoEntity t where t.estado=true")
	List<TipoEmpleadoEntity> findAllCustom();
}

