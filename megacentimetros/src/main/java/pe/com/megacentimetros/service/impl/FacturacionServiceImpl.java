package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.FacturacionEntity;
import pe.com.megacentimetros.repository.FacturacionRepository;
import pe.com.megacentimetros.service.FacturacionService;

@Service
public class FacturacionServiceImpl implements FacturacionService {
	@Autowired
	private FacturacionRepository repositorio;

	@Override
	public List<FacturacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<FacturacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public FacturacionEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public FacturacionEntity add(FacturacionEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public FacturacionEntity update(FacturacionEntity obj, Long id) {
		FacturacionEntity objfac=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objfac);
		return repositorio.save(objfac);
	}
	@Override
	public FacturacionEntity delete(Long id) {
		FacturacionEntity objfac=repositorio.findById(id).get();
		objfac.setEstado("ANULADA");
		return repositorio.save(objfac);
	}
	@Override
	public FacturacionEntity enable(Long id) {
		FacturacionEntity objfac=repositorio.findById(id).get();
		objfac.setEstado("EMITIDA");
		return repositorio.save(objfac);
	}
}
