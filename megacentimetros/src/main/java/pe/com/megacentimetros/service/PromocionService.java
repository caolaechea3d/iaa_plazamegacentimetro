package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.PromocionEntity;

public interface PromocionService {
	List<PromocionEntity> findAll();
	List<PromocionEntity> findAllCustom();
	PromocionEntity findById(Long id);
	PromocionEntity add(PromocionEntity obj);
	PromocionEntity update(PromocionEntity obj, Long id);
	PromocionEntity delete(Long id);
	PromocionEntity enable(Long id);
}
