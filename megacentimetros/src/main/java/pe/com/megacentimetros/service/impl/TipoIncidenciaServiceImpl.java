package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TipoIncidenciaEntity;
import pe.com.megacentimetros.repository.TipoIncidenciaRepository;
import pe.com.megacentimetros.service.TipoIncidenciaService;

@Service
public class TipoIncidenciaServiceImpl implements TipoIncidenciaService {
	@Autowired
	private TipoIncidenciaRepository repositorio;

	@Override
	public List<TipoIncidenciaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoIncidenciaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoIncidenciaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoIncidenciaEntity add(TipoIncidenciaEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoIncidenciaEntity update(TipoIncidenciaEntity obj, Long id) {
		TipoIncidenciaEntity objtinc=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtinc);
		return repositorio.save(objtinc);
	}
	@Override
	public TipoIncidenciaEntity delete(Long id) {
		TipoIncidenciaEntity objtinc=repositorio.findById(id).get();
		objtinc.setEstado(false);
		return repositorio.save(objtinc);
	}
	@Override
	public TipoIncidenciaEntity enable(Long id) {
		TipoIncidenciaEntity objtinc=repositorio.findById(id).get();
		objtinc.setEstado(true);
		return repositorio.save(objtinc);
	}
}
