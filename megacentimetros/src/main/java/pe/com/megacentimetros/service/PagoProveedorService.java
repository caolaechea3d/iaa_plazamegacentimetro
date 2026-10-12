package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.PagoProveedorEntity;

public interface PagoProveedorService {
	List<PagoProveedorEntity> findAll();
	PagoProveedorEntity findById(Long id);
	PagoProveedorEntity add(PagoProveedorEntity obj);
	PagoProveedorEntity update(PagoProveedorEntity obj, Long id);
	PagoProveedorEntity delete(Long id);
}
