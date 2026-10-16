package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.ProveedorEntity;
import pe.com.megacentimetros.repository.ProveedorRepository;
import pe.com.megacentimetros.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	@Autowired
	private ProveedorRepository repositorio;
	
	@Override
	public List<ProveedorEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<ProveedorEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public ProveedorEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public ProveedorEntity add(ProveedorEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public ProveedorEntity update(ProveedorEntity obj, Long id) {
		ProveedorEntity objprov=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objprov);
		return repositorio.save(objprov);
	}
	@Override
	public ProveedorEntity delete(Long id) {
		ProveedorEntity objprov=repositorio.findById(id).get();
		objprov.setEstado(false);
		return repositorio.save(objprov);
	}
	@Override
	public ProveedorEntity enable(Long id) {
		ProveedorEntity objprov=repositorio.findById(id).get();
		objprov.setEstado(true);
		return repositorio.save(objprov);
	}
}


