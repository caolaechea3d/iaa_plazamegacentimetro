package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.SucursalEntity;
import pe.com.megacentimetros.repository.SucursalRepository;
import pe.com.megacentimetros.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {
	@Autowired
	private SucursalRepository repositorio;
	
	@Override
	public List<SucursalEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<SucursalEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public SucursalEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public SucursalEntity add(SucursalEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public SucursalEntity update(SucursalEntity obj, Long id) {
		SucursalEntity objsuc=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objsuc);
		return repositorio.save(objsuc);
	}
	@Override
	public SucursalEntity delete(Long id) {
		SucursalEntity objsuc=repositorio.findById(id).get();
		objsuc.setEstado(false);
		return repositorio.save(objsuc);
	}
	@Override
	public SucursalEntity enable(Long id) {
		SucursalEntity objsuc=repositorio.findById(id).get();
		objsuc.setEstado(true);
		return repositorio.save(objsuc);
	}
}


