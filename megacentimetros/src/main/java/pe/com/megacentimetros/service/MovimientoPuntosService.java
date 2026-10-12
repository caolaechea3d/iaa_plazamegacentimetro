package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.MovimientoPuntosEntity;

public interface MovimientoPuntosService {
	List<MovimientoPuntosEntity> findAll();
	MovimientoPuntosEntity findById(Long id);
	MovimientoPuntosEntity add(MovimientoPuntosEntity obj);
	MovimientoPuntosEntity update(MovimientoPuntosEntity obj, Long id);
	MovimientoPuntosEntity delete(Long id);
}
