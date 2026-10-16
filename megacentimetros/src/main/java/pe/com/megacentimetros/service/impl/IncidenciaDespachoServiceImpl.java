package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.IncidenciaDespachoEntity;
import pe.com.megacentimetros.repository.IncidenciaDespachoRepository;
import pe.com.megacentimetros.service.IncidenciaDespachoService;

@Service
public class IncidenciaDespachoServiceImpl implements IncidenciaDespachoService {
	@Autowired
	private IncidenciaDespachoRepository repositorio;
	
	@Override
	public List<IncidenciaDespachoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<IncidenciaDespachoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public IncidenciaDespachoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public IncidenciaDespachoEntity add(IncidenciaDespachoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public IncidenciaDespachoEntity update(IncidenciaDespachoEntity obj, Long id) {
		IncidenciaDespachoEntity objinc=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objinc);
		return repositorio.save(objinc);
	}
	@Override
	public IncidenciaDespachoEntity delete(Long id) {
		IncidenciaDespachoEntity objinc=repositorio.findById(id).get();
		objinc.setEstado("RESUELTA");
		return repositorio.save(objinc);
	}
	@Override
	public IncidenciaDespachoEntity enable(Long id) {
		IncidenciaDespachoEntity objinc=repositorio.findById(id).get();
		objinc.setEstado("ABIERTA");
		return repositorio.save(objinc);
	}
}


