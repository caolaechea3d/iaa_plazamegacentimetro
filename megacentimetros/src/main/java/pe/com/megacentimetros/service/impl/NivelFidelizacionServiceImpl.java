package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.NivelFidelizacionEntity;
import pe.com.megacentimetros.repository.NivelFidelizacionRepository;
import pe.com.megacentimetros.service.NivelFidelizacionService;

@Service
public class NivelFidelizacionServiceImpl implements NivelFidelizacionService {
	@Autowired
	private NivelFidelizacionRepository repositorio;
	
	@Override
	public List<NivelFidelizacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<NivelFidelizacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public NivelFidelizacionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public NivelFidelizacionEntity add(NivelFidelizacionEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public NivelFidelizacionEntity update(NivelFidelizacionEntity obj, Long id) {
		NivelFidelizacionEntity objniv=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objniv);
		return repositorio.save(objniv);
	}
	@Override
	public NivelFidelizacionEntity delete(Long id) {
		NivelFidelizacionEntity objniv=repositorio.findById(id).get();
		objniv.setEstado(false);
		return repositorio.save(objniv);
	}
	@Override
	public NivelFidelizacionEntity enable(Long id) {
		NivelFidelizacionEntity objniv=repositorio.findById(id).get();
		objniv.setEstado(true);
		return repositorio.save(objniv);
	}
}


