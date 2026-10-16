package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.EstadoEnvioEntity;
import pe.com.megacentimetros.repository.EstadoEnvioRepository;
import pe.com.megacentimetros.service.EstadoEnvioService;

@Service
public class EstadoEnvioServiceImpl implements EstadoEnvioService {
	@Autowired
	private EstadoEnvioRepository repositorio;
	
	@Override
	public List<EstadoEnvioEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoEnvioEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoEnvioEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoEnvioEntity add(EstadoEnvioEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoEnvioEntity update(EstadoEnvioEntity obj, Long id) {
		EstadoEnvioEntity objeenv=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objeenv);
		return repositorio.save(objeenv);
	}
	@Override
	public EstadoEnvioEntity delete(Long id) {
		EstadoEnvioEntity objeenv=repositorio.findById(id).get();
		objeenv.setEstado(false);
		return repositorio.save(objeenv);
	}
	@Override
	public EstadoEnvioEntity enable(Long id) {
		EstadoEnvioEntity objeenv=repositorio.findById(id).get();
		objeenv.setEstado(true);
		return repositorio.save(objeenv);
	}
}


