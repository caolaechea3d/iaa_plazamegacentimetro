package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.AsistenciaEntity;
import pe.com.megacentimetros.repository.AsistenciaRepository;
import pe.com.megacentimetros.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
	@Autowired
	private AsistenciaRepository repositorio;

	@Override
	public List<AsistenciaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public AsistenciaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public AsistenciaEntity add(AsistenciaEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public AsistenciaEntity update(AsistenciaEntity obj, Long id) {
		AsistenciaEntity objasi=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objasi);
		return repositorio.save(objasi);
	}
	@Override
	public AsistenciaEntity delete(Long id) {
		AsistenciaEntity objasi=repositorio.findById(id).get();
		repositorio.delete(objasi);
		return objasi;
	}
}
