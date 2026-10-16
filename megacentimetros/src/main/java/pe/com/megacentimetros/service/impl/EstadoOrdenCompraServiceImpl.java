package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.EstadoOrdenCompraEntity;
import pe.com.megacentimetros.repository.EstadoOrdenCompraRepository;
import pe.com.megacentimetros.service.EstadoOrdenCompraService;

@Service
public class EstadoOrdenCompraServiceImpl implements EstadoOrdenCompraService {
	@Autowired
	private EstadoOrdenCompraRepository repositorio;
	
	@Override
	public List<EstadoOrdenCompraEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoOrdenCompraEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoOrdenCompraEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoOrdenCompraEntity add(EstadoOrdenCompraEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoOrdenCompraEntity update(EstadoOrdenCompraEntity obj, Long id) {
		EstadoOrdenCompraEntity objeocom=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objeocom);
		return repositorio.save(objeocom);
	}
	@Override
	public EstadoOrdenCompraEntity delete(Long id) {
		EstadoOrdenCompraEntity objeocom=repositorio.findById(id).get();
		objeocom.setEstado(false);
		return repositorio.save(objeocom);
	}
	@Override
	public EstadoOrdenCompraEntity enable(Long id) {
		EstadoOrdenCompraEntity objeocom=repositorio.findById(id).get();
		objeocom.setEstado(true);
		return repositorio.save(objeocom);
	}
}


