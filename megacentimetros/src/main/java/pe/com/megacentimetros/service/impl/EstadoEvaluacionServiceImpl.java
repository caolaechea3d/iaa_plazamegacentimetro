package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.EstadoEvaluacionEntity;
import pe.com.megacentimetros.repository.EstadoEvaluacionRepository;
import pe.com.megacentimetros.service.EstadoEvaluacionService;

@Service
public class EstadoEvaluacionServiceImpl implements EstadoEvaluacionService {
	@Autowired
	private EstadoEvaluacionRepository repositorio;

	@Override
	public List<EstadoEvaluacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoEvaluacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoEvaluacionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoEvaluacionEntity add(EstadoEvaluacionEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoEvaluacionEntity update(EstadoEvaluacionEntity obj, Long id) {
		EstadoEvaluacionEntity objeeva=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objeeva);
		return repositorio.save(objeeva);
	}
	@Override
	public EstadoEvaluacionEntity delete(Long id) {
		EstadoEvaluacionEntity objeeva=repositorio.findById(id).get();
		objeeva.setEstado(false);
		return repositorio.save(objeeva);
	}
	@Override
	public EstadoEvaluacionEntity enable(Long id) {
		EstadoEvaluacionEntity objeeva=repositorio.findById(id).get();
		objeeva.setEstado(true);
		return repositorio.save(objeeva);
	}
}
