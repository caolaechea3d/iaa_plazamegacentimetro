package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.PagoClienteEntity;
import pe.com.megacentimetros.repository.PagoClienteRepository;
import pe.com.megacentimetros.service.PagoClienteService;

@Service
public class PagoClienteServiceImpl implements PagoClienteService {
	@Autowired
	private PagoClienteRepository repositorio;

	@Override
	public List<PagoClienteEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public PagoClienteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public PagoClienteEntity add(PagoClienteEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public PagoClienteEntity update(PagoClienteEntity obj, Long id) {
		PagoClienteEntity objpcli=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objpcli);
		return repositorio.save(objpcli);
	}
	@Override
	public PagoClienteEntity delete(Long id) {
		PagoClienteEntity objpcli=repositorio.findById(id).get();
		repositorio.delete(objpcli);
		return objpcli;
	}
}
