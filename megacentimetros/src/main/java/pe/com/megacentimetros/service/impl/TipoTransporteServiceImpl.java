package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TipoTransporteEntity;
import pe.com.megacentimetros.repository.TipoTransporteRepository;
import pe.com.megacentimetros.service.TipoTransporteService;

@Service
public class TipoTransporteServiceImpl implements TipoTransporteService {
	@Autowired
	private TipoTransporteRepository repositorio;

	@Override
	public List<TipoTransporteEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoTransporteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoTransporteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoTransporteEntity add(TipoTransporteEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoTransporteEntity update(TipoTransporteEntity obj, Long id) {
		TipoTransporteEntity objttra=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objttra);
		return repositorio.save(objttra);
	}
	@Override
	public TipoTransporteEntity delete(Long id) {
		TipoTransporteEntity objttra=repositorio.findById(id).get();
		objttra.setEstado(false);
		return repositorio.save(objttra);
	}
	@Override
	public TipoTransporteEntity enable(Long id) {
		TipoTransporteEntity objttra=repositorio.findById(id).get();
		objttra.setEstado(true);
		return repositorio.save(objttra);
	}
}
