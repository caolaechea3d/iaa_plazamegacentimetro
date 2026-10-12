package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.MovimientoPuntosEntity;
import pe.com.megacentimetros.repository.MovimientoPuntosRepository;
import pe.com.megacentimetros.service.MovimientoPuntosService;

@Service
public class MovimientoPuntosServiceImpl implements MovimientoPuntosService {
	@Autowired
	private MovimientoPuntosRepository repositorio;

	@Override
	public List<MovimientoPuntosEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public MovimientoPuntosEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public MovimientoPuntosEntity add(MovimientoPuntosEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public MovimientoPuntosEntity update(MovimientoPuntosEntity obj, Long id) {
		MovimientoPuntosEntity objmpun=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objmpun);
		return repositorio.save(objmpun);
	}
	@Override
	public MovimientoPuntosEntity delete(Long id) {
		MovimientoPuntosEntity objmpun=repositorio.findById(id).get();
		repositorio.delete(objmpun);
		return objmpun;
	}
}
