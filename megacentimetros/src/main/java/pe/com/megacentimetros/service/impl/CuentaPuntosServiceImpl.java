package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.CuentaPuntosEntity;
import pe.com.megacentimetros.repository.CuentaPuntosRepository;
import pe.com.megacentimetros.service.CuentaPuntosService;

@Service
public class CuentaPuntosServiceImpl implements CuentaPuntosService {
	@Autowired
	private CuentaPuntosRepository repositorio;

	@Override
	public List<CuentaPuntosEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public CuentaPuntosEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public CuentaPuntosEntity add(CuentaPuntosEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public CuentaPuntosEntity update(CuentaPuntosEntity obj, Long id) {
		CuentaPuntosEntity objcpun=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcpun);
		return repositorio.save(objcpun);
	}
	@Override
	public CuentaPuntosEntity delete(Long id) {
		CuentaPuntosEntity objcpun=repositorio.findById(id).get();
		repositorio.delete(objcpun);
		return objcpun;
	}
}
