package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.CanjeRecompensaEntity;
import pe.com.megacentimetros.repository.CanjeRecompensaRepository;
import pe.com.megacentimetros.service.CanjeRecompensaService;

@Service
public class CanjeRecompensaServiceImpl implements CanjeRecompensaService {
	@Autowired
	private CanjeRecompensaRepository repositorio;
	
	@Override
	public List<CanjeRecompensaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CanjeRecompensaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CanjeRecompensaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public CanjeRecompensaEntity add(CanjeRecompensaEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public CanjeRecompensaEntity update(CanjeRecompensaEntity obj, Long id) {
		CanjeRecompensaEntity objcan=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcan);
		return repositorio.save(objcan);
	}
	@Override
	public CanjeRecompensaEntity delete(Long id) {
		CanjeRecompensaEntity objcan=repositorio.findById(id).get();
		objcan.setEstado(false);
		return repositorio.save(objcan);
	}
	@Override
	public CanjeRecompensaEntity enable(Long id) {
		CanjeRecompensaEntity objcan=repositorio.findById(id).get();
		objcan.setEstado(true);
		return repositorio.save(objcan);
	}
}


