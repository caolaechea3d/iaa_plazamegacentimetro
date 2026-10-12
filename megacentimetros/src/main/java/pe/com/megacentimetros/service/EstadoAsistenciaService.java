package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.EstadoAsistenciaEntity;

public interface EstadoAsistenciaService {
	List<EstadoAsistenciaEntity> findAll();
	EstadoAsistenciaEntity findById(Long id);
	EstadoAsistenciaEntity add(EstadoAsistenciaEntity obj);
	EstadoAsistenciaEntity update(EstadoAsistenciaEntity obj, Long id);
	EstadoAsistenciaEntity delete(Long id);
}
