package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.TipoClienteEntity;
import pe.com.megacentimetros.repository.TipoClienteRepository;
import pe.com.megacentimetros.service.TipoClienteService;

@Service
public class TipoClienteServiceImpl implements TipoClienteService {
	@Autowired
	private TipoClienteRepository repositorio;
	
	@Override
	public List<TipoClienteEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoClienteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoClienteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoClienteEntity add(TipoClienteEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoClienteEntity update(TipoClienteEntity obj, Long id) {
		TipoClienteEntity objtcli=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtcli);
		return repositorio.save(objtcli);
	}
	@Override
	public TipoClienteEntity delete(Long id) {
		TipoClienteEntity objtcli=repositorio.findById(id).get();
		objtcli.setEstado(false);
		return repositorio.save(objtcli);
	}
	@Override
	public TipoClienteEntity enable(Long id) {
		TipoClienteEntity objtcli=repositorio.findById(id).get();
		objtcli.setEstado(true);
		return repositorio.save(objtcli);
	}
}


