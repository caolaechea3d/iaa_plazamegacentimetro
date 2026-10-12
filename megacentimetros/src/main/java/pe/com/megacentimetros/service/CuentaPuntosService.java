package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.CuentaPuntosEntity;

public interface CuentaPuntosService {
	List<CuentaPuntosEntity> findAll();
	CuentaPuntosEntity findById(Long id);
	CuentaPuntosEntity add(CuentaPuntosEntity obj);
	CuentaPuntosEntity update(CuentaPuntosEntity obj, Long id);
	CuentaPuntosEntity delete(Long id);
}
