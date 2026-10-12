package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.EmpleadoCapacitacionEntity;

public interface EmpleadoCapacitacionService {
	List<EmpleadoCapacitacionEntity> findAll();
	List<EmpleadoCapacitacionEntity> findAllCustom();
	EmpleadoCapacitacionEntity findById(Long empleado, Long capacitacion);
	EmpleadoCapacitacionEntity add(EmpleadoCapacitacionEntity obj);
	EmpleadoCapacitacionEntity update(EmpleadoCapacitacionEntity obj, Long empleado, Long capacitacion);
	EmpleadoCapacitacionEntity delete(Long empleado, Long capacitacion);
	EmpleadoCapacitacionEntity enable(Long empleado, Long capacitacion);
}
