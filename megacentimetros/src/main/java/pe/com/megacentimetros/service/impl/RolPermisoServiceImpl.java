package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.RolPermisoEntity;
import pe.com.megacentimetros.entity.RolPermisoId;
import pe.com.megacentimetros.repository.RolPermisoRepository;
import pe.com.megacentimetros.service.RolPermisoService;

@Service
public class RolPermisoServiceImpl implements RolPermisoService {
	@Autowired
	private RolPermisoRepository repositorio;
	
	@Override
	public List<RolPermisoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<RolPermisoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public RolPermisoEntity findById(Long rol, Long modulo) {
		return repositorio.findById(new RolPermisoId(rol, modulo)).get();
	}
	@Override
	public RolPermisoEntity add(RolPermisoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public RolPermisoEntity update(RolPermisoEntity obj, Long rol, Long modulo) {
		RolPermisoEntity objrol=repositorio.findById(new RolPermisoId(rol, modulo)).get();
		BeanUtils.copyProperties(obj, objrol);
		return repositorio.save(objrol);
	}
	@Override
	public RolPermisoEntity delete(Long rol, Long modulo) {
		RolPermisoEntity objrol=repositorio.findById(new RolPermisoId(rol, modulo)).get();
		objrol.setEstado(false);
		return repositorio.save(objrol);
	}
	@Override
	public RolPermisoEntity enable(Long rol, Long modulo) {
		RolPermisoEntity objrol=repositorio.findById(new RolPermisoId(rol, modulo)).get();
		objrol.setEstado(true);
		return repositorio.save(objrol);
	}
}


