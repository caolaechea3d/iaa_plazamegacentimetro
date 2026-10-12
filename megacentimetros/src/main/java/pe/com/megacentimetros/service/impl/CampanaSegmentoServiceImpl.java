package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.CampanaSegmentoEntity;
import pe.com.megacentimetros.entity.CampanaSegmentoId;
import pe.com.megacentimetros.repository.CampanaSegmentoRepository;
import pe.com.megacentimetros.service.CampanaSegmentoService;

@Service
public class CampanaSegmentoServiceImpl implements CampanaSegmentoService {
	@Autowired
	private CampanaSegmentoRepository repositorio;

	@Override
	public List<CampanaSegmentoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public CampanaSegmentoEntity findById(Long campana, Long tipocliente) {
		return repositorio.findById(new CampanaSegmentoId(campana, tipocliente)).get();
	}
	@Override
	public CampanaSegmentoEntity add(CampanaSegmentoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public CampanaSegmentoEntity update(CampanaSegmentoEntity obj, Long campana, Long tipocliente) {
		CampanaSegmentoEntity objcam=repositorio.findById(new CampanaSegmentoId(campana, tipocliente)).get();
		BeanUtils.copyProperties(obj, objcam);
		return repositorio.save(objcam);
	}
	@Override
	public CampanaSegmentoEntity delete(Long campana, Long tipocliente) {
		CampanaSegmentoEntity objcam=repositorio.findById(new CampanaSegmentoId(campana, tipocliente)).get();
		repositorio.delete(objcam);
		return objcam;
	}
}
