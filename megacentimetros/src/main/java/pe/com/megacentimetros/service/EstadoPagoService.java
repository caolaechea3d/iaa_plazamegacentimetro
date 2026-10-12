package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.EstadoPagoEntity;

public interface EstadoPagoService {
	List<EstadoPagoEntity> findAll();
	List<EstadoPagoEntity> findAllCustom();
	EstadoPagoEntity findById(Long id);
	EstadoPagoEntity add(EstadoPagoEntity obj);
	EstadoPagoEntity update(EstadoPagoEntity obj, Long id);
	EstadoPagoEntity delete(Long id);
	EstadoPagoEntity enable(Long id);
}
