package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TransporteEntity;
import pe.com.megacentimetros.repository.TransporteRepository;
import pe.com.megacentimetros.service.TransporteService;

@Service
public class TransporteServiceImpl implements TransporteService {
	@Autowired
	private TransporteRepository repositorio;

	@Override
	public List<TransporteEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TransporteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TransporteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TransporteEntity add(TransporteEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TransporteEntity update(TransporteEntity obj, Long id) {
		TransporteEntity objtra=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtra);
		return repositorio.save(objtra);
	}
	@Override
	public TransporteEntity delete(Long id) {
		TransporteEntity objtra=repositorio.findById(id).get();
		objtra.setEstado(false);
		return repositorio.save(objtra);
	}
	@Override
	public TransporteEntity enable(Long id) {
		TransporteEntity objtra=repositorio.findById(id).get();
		objtra.setEstado(true);
		return repositorio.save(objtra);
	}
}
