package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.DetalleOrdenCompraEntity;
import pe.com.megacentimetros.repository.DetalleOrdenCompraRepository;
import pe.com.megacentimetros.service.DetalleOrdenCompraService;

@Service
public class DetalleOrdenCompraServiceImpl implements DetalleOrdenCompraService {
	@Autowired
	private DetalleOrdenCompraRepository repositorio;
	
	@Override
	public List<DetalleOrdenCompraEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<DetalleOrdenCompraEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public DetalleOrdenCompraEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public DetalleOrdenCompraEntity add(DetalleOrdenCompraEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DetalleOrdenCompraEntity update(DetalleOrdenCompraEntity obj, Long id) {
		DetalleOrdenCompraEntity objdocom=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdocom);
		return repositorio.save(objdocom);
	}
	@Override
	public DetalleOrdenCompraEntity delete(Long id) {
		DetalleOrdenCompraEntity objdocom=repositorio.findById(id).get();
		objdocom.setEstado(false);
		return repositorio.save(objdocom);
	}
	@Override
	public DetalleOrdenCompraEntity enable(Long id) {
		DetalleOrdenCompraEntity objdocom=repositorio.findById(id).get();
		objdocom.setEstado(true);
		return repositorio.save(objdocom);
	}
}


