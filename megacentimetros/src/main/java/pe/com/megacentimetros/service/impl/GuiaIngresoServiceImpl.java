package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.GuiaIngresoEntity;
import pe.com.megacentimetros.repository.GuiaIngresoRepository;
import pe.com.megacentimetros.service.GuiaIngresoService;

@Service
public class GuiaIngresoServiceImpl implements GuiaIngresoService {
	@Autowired
	private GuiaIngresoRepository repositorio;
	
	@Override
	public List<GuiaIngresoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<GuiaIngresoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public GuiaIngresoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public GuiaIngresoEntity add(GuiaIngresoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public GuiaIngresoEntity update(GuiaIngresoEntity obj, Long id) {
		GuiaIngresoEntity objgin=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objgin);
		return repositorio.save(objgin);
	}
	@Override
	public GuiaIngresoEntity delete(Long id) {
		GuiaIngresoEntity objgin=repositorio.findById(id).get();
		objgin.setEstado("ANULADA");
		return repositorio.save(objgin);
	}
	@Override
	public GuiaIngresoEntity enable(Long id) {
		GuiaIngresoEntity objgin=repositorio.findById(id).get();
		objgin.setEstado("REGISTRADA");
		return repositorio.save(objgin);
	}
}


