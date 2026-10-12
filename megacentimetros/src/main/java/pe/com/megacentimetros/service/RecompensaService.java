package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.RecompensaEntity;

public interface RecompensaService {
	List<RecompensaEntity> findAll();
	List<RecompensaEntity> findAllCustom();
	RecompensaEntity findById(Long id);
	RecompensaEntity add(RecompensaEntity obj);
	RecompensaEntity update(RecompensaEntity obj, Long id);
	RecompensaEntity delete(Long id);
	RecompensaEntity enable(Long id);
}
