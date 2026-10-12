package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.DetalleTrasladoEntity;
import pe.com.megacentimetros.repository.DetalleTrasladoRepository;
import pe.com.megacentimetros.service.DetalleTrasladoService;

@Service
public class DetalleTrasladoServiceImpl implements DetalleTrasladoService {
	@Autowired
	private DetalleTrasladoRepository repositorio;

	@Override
	public List<DetalleTrasladoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public DetalleTrasladoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public DetalleTrasladoEntity add(DetalleTrasladoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DetalleTrasladoEntity update(DetalleTrasladoEntity obj, Long id) {
		DetalleTrasladoEntity objdtrasl=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdtrasl);
		return repositorio.save(objdtrasl);
	}
	@Override
	public DetalleTrasladoEntity delete(Long id) {
		DetalleTrasladoEntity objdtrasl=repositorio.findById(id).get();
		repositorio.delete(objdtrasl);
		return objdtrasl;
	}
}
