package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.IncidenciaDespachoEntity;

public interface IncidenciaDespachoService {
	List<IncidenciaDespachoEntity> findAll();
	IncidenciaDespachoEntity findById(Long id);
	IncidenciaDespachoEntity add(IncidenciaDespachoEntity obj);
	IncidenciaDespachoEntity update(IncidenciaDespachoEntity obj, Long id);
	IncidenciaDespachoEntity delete(Long id);
}
