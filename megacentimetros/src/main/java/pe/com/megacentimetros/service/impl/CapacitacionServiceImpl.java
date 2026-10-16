package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.CapacitacionEntity;
import pe.com.megacentimetros.repository.CapacitacionRepository;
import pe.com.megacentimetros.service.CapacitacionService;

@Service
public class CapacitacionServiceImpl implements CapacitacionService {
	@Autowired
	private CapacitacionRepository repositorio;
	
	@Override
	public List<CapacitacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CapacitacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CapacitacionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public CapacitacionEntity add(CapacitacionEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public CapacitacionEntity update(CapacitacionEntity obj, Long id) {
		CapacitacionEntity objcap=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcap);
		return repositorio.save(objcap);
	}
	@Override
	public CapacitacionEntity delete(Long id) {
		CapacitacionEntity objcap=repositorio.findById(id).get();
		objcap.setEstado(false);
		return repositorio.save(objcap);
	}
	@Override
	public CapacitacionEntity enable(Long id) {
		CapacitacionEntity objcap=repositorio.findById(id).get();
		objcap.setEstado(true);
		return repositorio.save(objcap);
	}
}


