package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TipoEmpaqueEntity;
import pe.com.megacentimetros.repository.TipoEmpaqueRepository;
import pe.com.megacentimetros.service.TipoEmpaqueService;

@Service
public class TipoEmpaqueServiceImpl implements TipoEmpaqueService {
	@Autowired
	private TipoEmpaqueRepository repositorio;

	@Override
	public List<TipoEmpaqueEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoEmpaqueEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoEmpaqueEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoEmpaqueEntity add(TipoEmpaqueEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoEmpaqueEntity update(TipoEmpaqueEntity obj, Long id) {
		TipoEmpaqueEntity objtemp=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtemp);
		return repositorio.save(objtemp);
	}
	@Override
	public TipoEmpaqueEntity delete(Long id) {
		TipoEmpaqueEntity objtemp=repositorio.findById(id).get();
		objtemp.setEstado(false);
		return repositorio.save(objtemp);
	}
	@Override
	public TipoEmpaqueEntity enable(Long id) {
		TipoEmpaqueEntity objtemp=repositorio.findById(id).get();
		objtemp.setEstado(true);
		return repositorio.save(objtemp);
	}
}
