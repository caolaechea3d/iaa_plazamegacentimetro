package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.MovimientoInventarioEntity;

public interface MovimientoInventarioService {
	List<MovimientoInventarioEntity> findAll();
	MovimientoInventarioEntity findById(Long id);
	MovimientoInventarioEntity add(MovimientoInventarioEntity obj);
	MovimientoInventarioEntity update(MovimientoInventarioEntity obj, Long id);
	MovimientoInventarioEntity delete(Long id);
}
