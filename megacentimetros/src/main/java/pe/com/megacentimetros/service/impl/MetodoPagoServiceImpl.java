package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.MetodoPagoEntity;
import pe.com.megacentimetros.repository.MetodoPagoRepository;
import pe.com.megacentimetros.service.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
	@Autowired
	private MetodoPagoRepository repositorio;
	
	@Override
	public List<MetodoPagoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<MetodoPagoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public MetodoPagoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public MetodoPagoEntity add(MetodoPagoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public MetodoPagoEntity update(MetodoPagoEntity obj, Long id) {
		MetodoPagoEntity objmpag=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objmpag);
		return repositorio.save(objmpag);
	}
	@Override
	public MetodoPagoEntity delete(Long id) {
		MetodoPagoEntity objmpag=repositorio.findById(id).get();
		objmpag.setEstado(false);
		return repositorio.save(objmpag);
	}
	@Override
	public MetodoPagoEntity enable(Long id) {
		MetodoPagoEntity objmpag=repositorio.findById(id).get();
		objmpag.setEstado(true);
		return repositorio.save(objmpag);
	}
}


