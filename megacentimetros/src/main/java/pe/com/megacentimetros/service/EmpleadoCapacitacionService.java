package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.EmpleadoCapacitacionEntity;
public interface EmpleadoCapacitacionService {
	List<EmpleadoCapacitacionEntity> findAll();
	EmpleadoCapacitacionEntity findById(Long empleado, Long capacitacion);
	EmpleadoCapacitacionEntity add(EmpleadoCapacitacionEntity obj);
	EmpleadoCapacitacionEntity update(EmpleadoCapacitacionEntity obj, Long empleado, Long capacitacion);
}
