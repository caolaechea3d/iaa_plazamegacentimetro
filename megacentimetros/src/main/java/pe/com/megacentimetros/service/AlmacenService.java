package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.AlmacenEntity;

public interface AlmacenService {
	List<AlmacenEntity> findAll();
	AlmacenEntity findById(Long id);
	AlmacenEntity add(AlmacenEntity obj);
	AlmacenEntity update(AlmacenEntity obj, Long id);
	AlmacenEntity delete(Long id);
}
