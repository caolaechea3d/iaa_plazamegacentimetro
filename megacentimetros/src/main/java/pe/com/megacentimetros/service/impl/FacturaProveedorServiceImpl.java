package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.FacturaProveedorEntity;
import pe.com.megacentimetros.repository.FacturaProveedorRepository;
import pe.com.megacentimetros.service.FacturaProveedorService;

@Service
public class FacturaProveedorServiceImpl implements FacturaProveedorService {
	@Autowired
	private FacturaProveedorRepository repositorio;

	@Override
	public List<FacturaProveedorEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<FacturaProveedorEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public FacturaProveedorEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public FacturaProveedorEntity add(FacturaProveedorEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public FacturaProveedorEntity update(FacturaProveedorEntity obj, Long id) {
		FacturaProveedorEntity objfprov=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objfprov);
		return repositorio.save(objfprov);
	}
	@Override
	public FacturaProveedorEntity delete(Long id) {
		FacturaProveedorEntity objfprov=repositorio.findById(id).get();
		objfprov.setEstado("ANULADA");
		return repositorio.save(objfprov);
	}
	@Override
	public FacturaProveedorEntity enable(Long id) {
		FacturaProveedorEntity objfprov=repositorio.findById(id).get();
		objfprov.setEstado("PENDIENTE");
		return repositorio.save(objfprov);
	}
}
