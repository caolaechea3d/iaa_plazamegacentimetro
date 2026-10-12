package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.EstadoTransporteEntity;
import pe.com.megacentimetros.repository.EstadoTransporteRepository;
import pe.com.megacentimetros.service.EstadoTransporteService;

@Service
public class EstadoTransporteServiceImpl implements EstadoTransporteService {
	@Autowired
	private EstadoTransporteRepository repositorio;

	@Override
	public List<EstadoTransporteEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<EstadoTransporteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public EstadoTransporteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public EstadoTransporteEntity add(EstadoTransporteEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public EstadoTransporteEntity update(EstadoTransporteEntity obj, Long id) {
		EstadoTransporteEntity objetra=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objetra);
		return repositorio.save(objetra);
	}
	@Override
	public EstadoTransporteEntity delete(Long id) {
		EstadoTransporteEntity objetra=repositorio.findById(id).get();
		objetra.setEstado(false);
		return repositorio.save(objetra);
	}
	@Override
	public EstadoTransporteEntity enable(Long id) {
		EstadoTransporteEntity objetra=repositorio.findById(id).get();
		objetra.setEstado(true);
		return repositorio.save(objetra);
	}
}
