package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.EmpleadoCapacitacionEntity;
import pe.com.megacentimetros.entity.EmpleadoCapacitacionId;
import pe.com.megacentimetros.repository.EmpleadoCapacitacionRepository;
import pe.com.megacentimetros.service.EmpleadoCapacitacionService;

@Service
public class EmpleadoCapacitacionServiceImpl implements EmpleadoCapacitacionService {
	@Autowired
	private EmpleadoCapacitacionRepository repositorio;
	
	@Override
	public List<EmpleadoCapacitacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public EmpleadoCapacitacionEntity findById(Long empleado, Long capacitacion) {
		return repositorio.findById(new EmpleadoCapacitacionId(empleado, capacitacion)).get();
	}
	@Override
	public EmpleadoCapacitacionEntity add(EmpleadoCapacitacionEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EmpleadoCapacitacionEntity update(EmpleadoCapacitacionEntity obj, Long empleado, Long capacitacion) {
		EmpleadoCapacitacionEntity objemp=repositorio.findById(new EmpleadoCapacitacionId(empleado, capacitacion)).get();
		BeanUtils.copyProperties(obj, objemp);
		return repositorio.save(objemp);
	}
}


