package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TipoMovimientoEntity;
import pe.com.megacentimetros.repository.TipoMovimientoRepository;
import pe.com.megacentimetros.service.TipoMovimientoService;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService {
	@Autowired
	private TipoMovimientoRepository repositorio;

	@Override
	public List<TipoMovimientoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoMovimientoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoMovimientoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoMovimientoEntity add(TipoMovimientoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoMovimientoEntity update(TipoMovimientoEntity obj, Long id) {
		TipoMovimientoEntity objtmov=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtmov);
		return repositorio.save(objtmov);
	}
	@Override
	public TipoMovimientoEntity delete(Long id) {
		TipoMovimientoEntity objtmov=repositorio.findById(id).get();
		objtmov.setEstado(false);
		return repositorio.save(objtmov);
	}
	@Override
	public TipoMovimientoEntity enable(Long id) {
		TipoMovimientoEntity objtmov=repositorio.findById(id).get();
		objtmov.setEstado(true);
		return repositorio.save(objtmov);
	}
}
