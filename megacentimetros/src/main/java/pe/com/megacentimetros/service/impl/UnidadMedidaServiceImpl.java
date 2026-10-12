package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.UnidadMedidaEntity;
import pe.com.megacentimetros.repository.UnidadMedidaRepository;
import pe.com.megacentimetros.service.UnidadMedidaService;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {
	@Autowired
	private UnidadMedidaRepository repositorio;

	@Override
	public List<UnidadMedidaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<UnidadMedidaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public UnidadMedidaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public UnidadMedidaEntity add(UnidadMedidaEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public UnidadMedidaEntity update(UnidadMedidaEntity obj, Long id) {
		UnidadMedidaEntity objumed=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objumed);
		return repositorio.save(objumed);
	}
	@Override
	public UnidadMedidaEntity delete(Long id) {
		UnidadMedidaEntity objumed=repositorio.findById(id).get();
		objumed.setEstado(false);
		return repositorio.save(objumed);
	}
	@Override
	public UnidadMedidaEntity enable(Long id) {
		UnidadMedidaEntity objumed=repositorio.findById(id).get();
		objumed.setEstado(true);
		return repositorio.save(objumed);
	}
}
