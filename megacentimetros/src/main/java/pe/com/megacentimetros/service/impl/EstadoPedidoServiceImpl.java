package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.EstadoPedidoEntity;
import pe.com.megacentimetros.repository.EstadoPedidoRepository;
import pe.com.megacentimetros.service.EstadoPedidoService;

@Service
public class EstadoPedidoServiceImpl implements EstadoPedidoService {
	@Autowired
	private EstadoPedidoRepository repositorio;
	
	@Override
	public List<EstadoPedidoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoPedidoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoPedidoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoPedidoEntity add(EstadoPedidoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoPedidoEntity update(EstadoPedidoEntity obj, Long id) {
		EstadoPedidoEntity objeped=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objeped);
		return repositorio.save(objeped);
	}
	@Override
	public EstadoPedidoEntity delete(Long id) {
		EstadoPedidoEntity objeped=repositorio.findById(id).get();
		objeped.setEstado(false);
		return repositorio.save(objeped);
	}
	@Override
	public EstadoPedidoEntity enable(Long id) {
		EstadoPedidoEntity objeped=repositorio.findById(id).get();
		objeped.setEstado(true);
		return repositorio.save(objeped);
	}
}


