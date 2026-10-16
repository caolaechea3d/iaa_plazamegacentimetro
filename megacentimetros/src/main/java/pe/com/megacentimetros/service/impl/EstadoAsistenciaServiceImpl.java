package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.EstadoAsistenciaEntity;
import pe.com.megacentimetros.repository.EstadoAsistenciaRepository;
import pe.com.megacentimetros.service.EstadoAsistenciaService;

@Service
public class EstadoAsistenciaServiceImpl implements EstadoAsistenciaService {
	@Autowired
	private EstadoAsistenciaRepository repositorio;
	
	@Override
	public List<EstadoAsistenciaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoAsistenciaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoAsistenciaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoAsistenciaEntity add(EstadoAsistenciaEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoAsistenciaEntity update(EstadoAsistenciaEntity obj, Long id) {
		EstadoAsistenciaEntity objeasis=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objeasis);
		return repositorio.save(objeasis);
	}
	@Override
	public EstadoAsistenciaEntity delete(Long id) {
		EstadoAsistenciaEntity objeasis=repositorio.findById(id).get();
		objeasis.setEstado(false);
		return repositorio.save(objeasis);
	}
	@Override
	public EstadoAsistenciaEntity enable(Long id) {
		EstadoAsistenciaEntity objeasis=repositorio.findById(id).get();
		objeasis.setEstado(true);
		return repositorio.save(objeasis);
	}
}


