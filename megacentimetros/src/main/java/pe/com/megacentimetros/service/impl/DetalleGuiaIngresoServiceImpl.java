package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.DetalleGuiaIngresoEntity;
import pe.com.megacentimetros.repository.DetalleGuiaIngresoRepository;
import pe.com.megacentimetros.service.DetalleGuiaIngresoService;

@Service
public class DetalleGuiaIngresoServiceImpl implements DetalleGuiaIngresoService {
	@Autowired
	private DetalleGuiaIngresoRepository repositorio;

	@Override
	public List<DetalleGuiaIngresoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public DetalleGuiaIngresoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public DetalleGuiaIngresoEntity add(DetalleGuiaIngresoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DetalleGuiaIngresoEntity update(DetalleGuiaIngresoEntity obj, Long id) {
		DetalleGuiaIngresoEntity objdgin=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdgin);
		return repositorio.save(objdgin);
	}
	@Override
	public DetalleGuiaIngresoEntity delete(Long id) {
		DetalleGuiaIngresoEntity objdgin=repositorio.findById(id).get();
		repositorio.delete(objdgin);
		return objdgin;
	}
}
