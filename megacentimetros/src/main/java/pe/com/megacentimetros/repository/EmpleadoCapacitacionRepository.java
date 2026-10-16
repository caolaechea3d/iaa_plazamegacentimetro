package pe.com.megacentimetros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.megacentimetros.entity.EmpleadoCapacitacionEntity;
import pe.com.megacentimetros.entity.EmpleadoCapacitacionId;

public interface EmpleadoCapacitacionRepository extends JpaRepository<EmpleadoCapacitacionEntity, EmpleadoCapacitacionId> {
}

