package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.MovimientoInventarioEntity;
import pe.com.megacentimetros.repository.MovimientoInventarioRepository;
import pe.com.megacentimetros.service.MovimientoInventarioService;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {
	@Autowired
	private MovimientoInventarioRepository repositorio;
	
	@Override
	public List<MovimientoInventarioEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<MovimientoInventarioEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public MovimientoInventarioEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public MovimientoInventarioEntity add(MovimientoInventarioEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public MovimientoInventarioEntity update(MovimientoInventarioEntity obj, Long id) {
		MovimientoInventarioEntity objminv=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objminv);
		return repositorio.save(objminv);
	}
	@Override
	public MovimientoInventarioEntity delete(Long id) {
		MovimientoInventarioEntity objminv=repositorio.findById(id).get();
		objminv.setEstado(false);
		return repositorio.save(objminv);
	}
	@Override
	public MovimientoInventarioEntity enable(Long id) {
		MovimientoInventarioEntity objminv=repositorio.findById(id).get();
		objminv.setEstado(true);
		return repositorio.save(objminv);
	}
}


