package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.EstadoOperativoEntity;
import pe.com.megacentimetros.repository.EstadoOperativoRepository;
import pe.com.megacentimetros.service.EstadoOperativoService;

@Service
public class EstadoOperativoServiceImpl implements EstadoOperativoService {
	@Autowired
	private EstadoOperativoRepository repositorio;
	
	@Override
	public List<EstadoOperativoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoOperativoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoOperativoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoOperativoEntity add(EstadoOperativoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoOperativoEntity update(EstadoOperativoEntity obj, Long id) {
		EstadoOperativoEntity objeope=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objeope);
		return repositorio.save(objeope);
	}
	@Override
	public EstadoOperativoEntity delete(Long id) {
		EstadoOperativoEntity objeope=repositorio.findById(id).get();
		objeope.setEstado(false);
		return repositorio.save(objeope);
	}
	@Override
	public EstadoOperativoEntity enable(Long id) {
		EstadoOperativoEntity objeope=repositorio.findById(id).get();
		objeope.setEstado(true);
		return repositorio.save(objeope);
	}
}


