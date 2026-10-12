package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.EstadoPagoEntity;
import pe.com.megacentimetros.repository.EstadoPagoRepository;
import pe.com.megacentimetros.service.EstadoPagoService;

@Service
public class EstadoPagoServiceImpl implements EstadoPagoService {
	@Autowired
	private EstadoPagoRepository repositorio;

	@Override
	public List<EstadoPagoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoPagoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoPagoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoPagoEntity add(EstadoPagoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoPagoEntity update(EstadoPagoEntity obj, Long id) {
		EstadoPagoEntity objepag=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objepag);
		return repositorio.save(objepag);
	}
	@Override
	public EstadoPagoEntity delete(Long id) {
		EstadoPagoEntity objepag=repositorio.findById(id).get();
		objepag.setEstado(false);
		return repositorio.save(objepag);
	}
	@Override
	public EstadoPagoEntity enable(Long id) {
		EstadoPagoEntity objepag=repositorio.findById(id).get();
		objepag.setEstado(true);
		return repositorio.save(objepag);
	}
}
