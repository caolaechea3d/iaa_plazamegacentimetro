package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.CampanaEntity;
import pe.com.megacentimetros.repository.CampanaRepository;
import pe.com.megacentimetros.service.CampanaService;

@Service
public class CampanaServiceImpl implements CampanaService {
	@Autowired
	private CampanaRepository repositorio;
	
	@Override
	public List<CampanaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CampanaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CampanaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public CampanaEntity add(CampanaEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public CampanaEntity update(CampanaEntity obj, Long id) {
		CampanaEntity objcam=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcam);
		return repositorio.save(objcam);
	}
	@Override
	public CampanaEntity delete(Long id) {
		CampanaEntity objcam=repositorio.findById(id).get();
		objcam.setEstado(false);
		return repositorio.save(objcam);
	}
	@Override
	public CampanaEntity enable(Long id) {
		CampanaEntity objcam=repositorio.findById(id).get();
		objcam.setEstado(true);
		return repositorio.save(objcam);
	}
}


