package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.PromocionEntity;
import pe.com.megacentimetros.repository.PromocionRepository;
import pe.com.megacentimetros.service.PromocionService;

@Service
public class PromocionServiceImpl implements PromocionService {
	@Autowired
	private PromocionRepository repositorio;

	@Override
	public List<PromocionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<PromocionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public PromocionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public PromocionEntity add(PromocionEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public PromocionEntity update(PromocionEntity obj, Long id) {
		PromocionEntity objprom=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objprom);
		return repositorio.save(objprom);
	}
	@Override
	public PromocionEntity delete(Long id) {
		PromocionEntity objprom=repositorio.findById(id).get();
		objprom.setEstado(false);
		return repositorio.save(objprom);
	}
	@Override
	public PromocionEntity enable(Long id) {
		PromocionEntity objprom=repositorio.findById(id).get();
		objprom.setEstado(true);
		return repositorio.save(objprom);
	}
}
