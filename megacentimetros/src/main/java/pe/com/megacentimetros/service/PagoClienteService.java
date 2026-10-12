package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.PagoClienteEntity;

public interface PagoClienteService {
	List<PagoClienteEntity> findAll();
	PagoClienteEntity findById(Long id);
	PagoClienteEntity add(PagoClienteEntity obj);
	PagoClienteEntity update(PagoClienteEntity obj, Long id);
	PagoClienteEntity delete(Long id);
}
