package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.EstadoCapacitacionEntity;
import pe.com.megacentimetros.repository.EstadoCapacitacionRepository;
import pe.com.megacentimetros.service.EstadoCapacitacionService;

@Service
public class EstadoCapacitacionServiceImpl implements EstadoCapacitacionService {
	@Autowired
	private EstadoCapacitacionRepository repositorio;
	
	@Override
	public List<EstadoCapacitacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoCapacitacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoCapacitacionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoCapacitacionEntity add(EstadoCapacitacionEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoCapacitacionEntity update(EstadoCapacitacionEntity obj, Long id) {
		EstadoCapacitacionEntity objecap=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objecap);
		return repositorio.save(objecap);
	}
	@Override
	public EstadoCapacitacionEntity delete(Long id) {
		EstadoCapacitacionEntity objecap=repositorio.findById(id).get();
		objecap.setEstado(false);
		return repositorio.save(objecap);
	}
	@Override
	public EstadoCapacitacionEntity enable(Long id) {
		EstadoCapacitacionEntity objecap=repositorio.findById(id).get();
		objecap.setEstado(true);
		return repositorio.save(objecap);
	}
}


