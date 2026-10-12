package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.DetalleTrasladoEntity;

public interface DetalleTrasladoService {
	List<DetalleTrasladoEntity> findAll();
	DetalleTrasladoEntity findById(Long id);
	DetalleTrasladoEntity add(DetalleTrasladoEntity obj);
	DetalleTrasladoEntity update(DetalleTrasladoEntity obj, Long id);
	DetalleTrasladoEntity delete(Long id);
}
