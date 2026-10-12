package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.AlmacenEntity;
import pe.com.megacentimetros.repository.AlmacenRepository;
import pe.com.megacentimetros.service.AlmacenService;

@Service
public class AlmacenServiceImpl implements AlmacenService {
	@Autowired
	private AlmacenRepository repositorio;

	@Override
	public List<AlmacenEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public AlmacenEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public AlmacenEntity add(AlmacenEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public AlmacenEntity update(AlmacenEntity obj, Long id) {
		AlmacenEntity objalm=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objalm);
		return repositorio.save(objalm);
	}
	@Override
	public AlmacenEntity delete(Long id) {
		AlmacenEntity objalm=repositorio.findById(id).get();
		repositorio.delete(objalm);
		return objalm;
	}
}
