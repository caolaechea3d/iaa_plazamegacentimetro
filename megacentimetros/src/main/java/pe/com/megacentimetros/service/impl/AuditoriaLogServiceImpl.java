package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.AuditoriaLogEntity;
import pe.com.megacentimetros.repository.AuditoriaLogRepository;
import pe.com.megacentimetros.service.AuditoriaLogService;

@Service
public class AuditoriaLogServiceImpl implements AuditoriaLogService {
	@Autowired
	private AuditoriaLogRepository repositorio;
	
	@Override
	public List<AuditoriaLogEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<AuditoriaLogEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public AuditoriaLogEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public AuditoriaLogEntity add(AuditoriaLogEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public AuditoriaLogEntity update(AuditoriaLogEntity obj, Long id) {
		AuditoriaLogEntity objlog=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objlog);
		return repositorio.save(objlog);
	}
	@Override
	public AuditoriaLogEntity delete(Long id) {
		AuditoriaLogEntity objlog=repositorio.findById(id).get();
		objlog.setEstado(false);
		return repositorio.save(objlog);
	}
	@Override
	public AuditoriaLogEntity enable(Long id) {
		AuditoriaLogEntity objlog=repositorio.findById(id).get();
		objlog.setEstado(true);
		return repositorio.save(objlog);
	}
}


