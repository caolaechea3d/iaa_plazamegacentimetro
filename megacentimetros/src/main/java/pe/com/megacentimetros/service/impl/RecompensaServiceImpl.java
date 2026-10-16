package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.RecompensaEntity;
import pe.com.megacentimetros.repository.RecompensaRepository;
import pe.com.megacentimetros.service.RecompensaService;

@Service
public class RecompensaServiceImpl implements RecompensaService {
	@Autowired
	private RecompensaRepository repositorio;
	
	@Override
	public List<RecompensaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<RecompensaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public RecompensaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public RecompensaEntity add(RecompensaEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public RecompensaEntity update(RecompensaEntity obj, Long id) {
		RecompensaEntity objrec=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objrec);
		return repositorio.save(objrec);
	}
	@Override
	public RecompensaEntity delete(Long id) {
		RecompensaEntity objrec=repositorio.findById(id).get();
		objrec.setEstado(false);
		return repositorio.save(objrec);
	}
	@Override
	public RecompensaEntity enable(Long id) {
		RecompensaEntity objrec=repositorio.findById(id).get();
		objrec.setEstado(true);
		return repositorio.save(objrec);
	}
}


