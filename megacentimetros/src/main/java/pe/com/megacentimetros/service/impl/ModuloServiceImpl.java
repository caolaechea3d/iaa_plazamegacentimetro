package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.ModuloEntity;
import pe.com.megacentimetros.repository.ModuloRepository;
import pe.com.megacentimetros.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService {
	@Autowired
	private ModuloRepository repositorio;
	
	@Override
	public List<ModuloEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<ModuloEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public ModuloEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public ModuloEntity add(ModuloEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public ModuloEntity update(ModuloEntity obj, Long id) {
		ModuloEntity objmod=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objmod);
		return repositorio.save(objmod);
	}
	@Override
	public ModuloEntity delete(Long id) {
		ModuloEntity objmod=repositorio.findById(id).get();
		objmod.setEstado(false);
		return repositorio.save(objmod);
	}
	@Override
	public ModuloEntity enable(Long id) {
		ModuloEntity objmod=repositorio.findById(id).get();
		objmod.setEstado(true);
		return repositorio.save(objmod);
	}
}


