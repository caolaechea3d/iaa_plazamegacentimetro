package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TipoAlmacenEntity;
import pe.com.megacentimetros.repository.TipoAlmacenRepository;
import pe.com.megacentimetros.service.TipoAlmacenService;

@Service
public class TipoAlmacenServiceImpl implements TipoAlmacenService {
	@Autowired
	private TipoAlmacenRepository repositorio;

	@Override
	public List<TipoAlmacenEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoAlmacenEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoAlmacenEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoAlmacenEntity add(TipoAlmacenEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoAlmacenEntity update(TipoAlmacenEntity obj, Long id) {
		TipoAlmacenEntity objtalm=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtalm);
		return repositorio.save(objtalm);
	}
	@Override
	public TipoAlmacenEntity delete(Long id) {
		TipoAlmacenEntity objtalm=repositorio.findById(id).get();
		objtalm.setEstado(false);
		return repositorio.save(objtalm);
	}
	@Override
	public TipoAlmacenEntity enable(Long id) {
		TipoAlmacenEntity objtalm=repositorio.findById(id).get();
		objtalm.setEstado(true);
		return repositorio.save(objtalm);
	}
}
