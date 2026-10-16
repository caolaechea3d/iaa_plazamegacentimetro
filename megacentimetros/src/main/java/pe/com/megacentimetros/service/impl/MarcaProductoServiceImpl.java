package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.MarcaProductoEntity;
import pe.com.megacentimetros.repository.MarcaProductoRepository;
import pe.com.megacentimetros.service.MarcaProductoService;

@Service
public class MarcaProductoServiceImpl implements MarcaProductoService {
	@Autowired
	private MarcaProductoRepository repositorio;
	
	@Override
	public List<MarcaProductoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<MarcaProductoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public MarcaProductoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public MarcaProductoEntity add(MarcaProductoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public MarcaProductoEntity update(MarcaProductoEntity obj, Long id) {
		MarcaProductoEntity objmar=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objmar);
		return repositorio.save(objmar);
	}
	@Override
	public MarcaProductoEntity delete(Long id) {
		MarcaProductoEntity objmar=repositorio.findById(id).get();
		objmar.setEstado(false);
		return repositorio.save(objmar);
	}
	@Override
	public MarcaProductoEntity enable(Long id) {
		MarcaProductoEntity objmar=repositorio.findById(id).get();
		objmar.setEstado(true);
		return repositorio.save(objmar);
	}
}


