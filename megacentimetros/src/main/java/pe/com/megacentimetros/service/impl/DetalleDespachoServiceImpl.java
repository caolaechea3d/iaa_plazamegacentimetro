package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.DetalleDespachoEntity;
import pe.com.megacentimetros.repository.DetalleDespachoRepository;
import pe.com.megacentimetros.service.DetalleDespachoService;

@Service
public class DetalleDespachoServiceImpl implements DetalleDespachoService {
	@Autowired
	private DetalleDespachoRepository repositorio;

	@Override
	public List<DetalleDespachoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public DetalleDespachoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public DetalleDespachoEntity add(DetalleDespachoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DetalleDespachoEntity update(DetalleDespachoEntity obj, Long id) {
		DetalleDespachoEntity objdetdes=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdetdes);
		return repositorio.save(objdetdes);
	}
	@Override
	public DetalleDespachoEntity delete(Long id) {
		DetalleDespachoEntity objdetdes=repositorio.findById(id).get();
		repositorio.delete(objdetdes);
		return objdetdes;
	}
}
