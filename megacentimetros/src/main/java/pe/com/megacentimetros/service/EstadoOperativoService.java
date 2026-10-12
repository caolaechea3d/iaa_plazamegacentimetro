package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.EstadoOperativoEntity;

public interface EstadoOperativoService {
	List<EstadoOperativoEntity> findAll();
	EstadoOperativoEntity findById(Long id);
	EstadoOperativoEntity add(EstadoOperativoEntity obj);
	EstadoOperativoEntity update(EstadoOperativoEntity obj, Long id);
	EstadoOperativoEntity delete(Long id);
}
