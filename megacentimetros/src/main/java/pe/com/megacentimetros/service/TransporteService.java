package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.TransporteEntity;

public interface TransporteService {
	List<TransporteEntity> findAll();
	List<TransporteEntity> findAllCustom();
	TransporteEntity findById(Long id);
	TransporteEntity add(TransporteEntity obj);
	TransporteEntity update(TransporteEntity obj, Long id);
	TransporteEntity delete(Long id);
	TransporteEntity enable(Long id);
}
