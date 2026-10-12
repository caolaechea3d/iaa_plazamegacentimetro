package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.DespachoEntity;
import pe.com.megacentimetros.repository.DespachoRepository;
import pe.com.megacentimetros.service.DespachoService;

@Service
public class DespachoServiceImpl implements DespachoService {
	@Autowired
	private DespachoRepository repositorio;

	@Override
	public List<DespachoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<DespachoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public DespachoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public DespachoEntity add(DespachoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DespachoEntity update(DespachoEntity obj, Long id) {
		DespachoEntity objdes=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdes);
		return repositorio.save(objdes);
	}
	@Override
	public DespachoEntity delete(Long id) {
		DespachoEntity objdes=repositorio.findById(id).get();
		objdes.setEstado("ANULADO");
		return repositorio.save(objdes);
	}
	@Override
	public DespachoEntity enable(Long id) {
		DespachoEntity objdes=repositorio.findById(id).get();
		objdes.setEstado("PREPARACION");
		return repositorio.save(objdes);
	}
}
