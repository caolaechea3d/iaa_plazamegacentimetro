package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.TipoComprobanteEntity;
import pe.com.megacentimetros.repository.TipoComprobanteRepository;
import pe.com.megacentimetros.service.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {
	@Autowired
	private TipoComprobanteRepository repositorio;
	
	@Override
	public List<TipoComprobanteEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoComprobanteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoComprobanteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoComprobanteEntity add(TipoComprobanteEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoComprobanteEntity update(TipoComprobanteEntity obj, Long id) {
		TipoComprobanteEntity objtcom=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtcom);
		return repositorio.save(objtcom);
	}
	@Override
	public TipoComprobanteEntity delete(Long id) {
		TipoComprobanteEntity objtcom=repositorio.findById(id).get();
		objtcom.setEstado(false);
		return repositorio.save(objtcom);
	}
	@Override
	public TipoComprobanteEntity enable(Long id) {
		TipoComprobanteEntity objtcom=repositorio.findById(id).get();
		objtcom.setEstado(true);
		return repositorio.save(objtcom);
	}
}


