package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TrasladoAlmacenEntity;
import pe.com.megacentimetros.repository.TrasladoAlmacenRepository;
import pe.com.megacentimetros.service.TrasladoAlmacenService;

@Service
public class TrasladoAlmacenServiceImpl implements TrasladoAlmacenService {
	@Autowired
	private TrasladoAlmacenRepository repositorio;

	@Override
	public List<TrasladoAlmacenEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TrasladoAlmacenEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TrasladoAlmacenEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TrasladoAlmacenEntity add(TrasladoAlmacenEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TrasladoAlmacenEntity update(TrasladoAlmacenEntity obj, Long id) {
		TrasladoAlmacenEntity objtrasl=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtrasl);
		return repositorio.save(objtrasl);
	}
	@Override
	public TrasladoAlmacenEntity delete(Long id) {
		TrasladoAlmacenEntity objtrasl=repositorio.findById(id).get();
		objtrasl.setEstado("ANULADO");
		return repositorio.save(objtrasl);
	}
	@Override
	public TrasladoAlmacenEntity enable(Long id) {
		TrasladoAlmacenEntity objtrasl=repositorio.findById(id).get();
		objtrasl.setEstado("PENDIENTE");
		return repositorio.save(objtrasl);
	}
}
