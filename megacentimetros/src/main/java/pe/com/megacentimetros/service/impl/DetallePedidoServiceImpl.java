package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.DetallePedidoEntity;
import pe.com.megacentimetros.repository.DetallePedidoRepository;
import pe.com.megacentimetros.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
	@Autowired
	private DetallePedidoRepository repositorio;
	
	@Override
	public List<DetallePedidoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<DetallePedidoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public DetallePedidoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public DetallePedidoEntity add(DetallePedidoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DetallePedidoEntity update(DetallePedidoEntity obj, Long id) {
		DetallePedidoEntity objdped=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdped);
		return repositorio.save(objdped);
	}
	@Override
	public DetallePedidoEntity delete(Long id) {
		DetallePedidoEntity objdped=repositorio.findById(id).get();
		objdped.setEstado(false);
		return repositorio.save(objdped);
	}
	@Override
	public DetallePedidoEntity enable(Long id) {
		DetallePedidoEntity objdped=repositorio.findById(id).get();
		objdped.setEstado(true);
		return repositorio.save(objdped);
	}
}


