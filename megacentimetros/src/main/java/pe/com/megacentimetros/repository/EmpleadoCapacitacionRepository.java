package pe.com.megacentimetros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.megacentimetros.entity.EmpleadoCapacitacionEntity;
import pe.com.megacentimetros.entity.EmpleadoCapacitacionId;

public interface EmpleadoCapacitacionRepository extends JpaRepository<EmpleadoCapacitacionEntity, EmpleadoCapacitacionId> {
	@Query("select e from EmpleadoCapacitacionEntity e where e.estado<>'RETIRADO'")
	List<EmpleadoCapacitacionEntity> findAllCustom();
}
