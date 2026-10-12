package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.CanjeRecompensaEntity;

public interface CanjeRecompensaService {
	List<CanjeRecompensaEntity> findAll();
	CanjeRecompensaEntity findById(Long id);
	CanjeRecompensaEntity add(CanjeRecompensaEntity obj);
	CanjeRecompensaEntity update(CanjeRecompensaEntity obj, Long id);
	CanjeRecompensaEntity delete(Long id);
}
