package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.CategoriaProductoEntity;
import pe.com.megacentimetros.repository.CategoriaProductoRepository;
import pe.com.megacentimetros.service.CategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {
	@Autowired
	private CategoriaProductoRepository repositorio;
	
	@Override
	public List<CategoriaProductoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CategoriaProductoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CategoriaProductoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public CategoriaProductoEntity add(CategoriaProductoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public CategoriaProductoEntity update(CategoriaProductoEntity obj, Long id) {
		CategoriaProductoEntity objcat=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcat);
		return repositorio.save(objcat);
	}
	@Override
	public CategoriaProductoEntity delete(Long id) {
		CategoriaProductoEntity objcat=repositorio.findById(id).get();
		objcat.setEstado(false);
		return repositorio.save(objcat);
	}
	@Override
	public CategoriaProductoEntity enable(Long id) {
		CategoriaProductoEntity objcat=repositorio.findById(id).get();
		objcat.setEstado(true);
		return repositorio.save(objcat);
	}
}


