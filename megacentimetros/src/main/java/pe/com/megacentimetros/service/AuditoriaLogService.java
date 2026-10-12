package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.AuditoriaLogEntity;

public interface AuditoriaLogService {
	List<AuditoriaLogEntity> findAll();
	AuditoriaLogEntity findById(Long id);
	AuditoriaLogEntity add(AuditoriaLogEntity obj);
	AuditoriaLogEntity update(AuditoriaLogEntity obj, Long id);
	AuditoriaLogEntity delete(Long id);
}
