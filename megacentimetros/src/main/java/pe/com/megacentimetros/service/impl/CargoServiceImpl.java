package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.CargoEntity;
import pe.com.megacentimetros.repository.CargoRepository;
import pe.com.megacentimetros.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {
	@Autowired
	private CargoRepository repositorio;

	@Override
	public List<CargoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CargoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CargoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public CargoEntity add(CargoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public CargoEntity update(CargoEntity obj, Long id) {
		CargoEntity objcarg=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcarg);
		return repositorio.save(objcarg);
	}
	@Override
	public CargoEntity delete(Long id) {
		CargoEntity objcarg=repositorio.findById(id).get();
		objcarg.setEstado(false);
		return repositorio.save(objcarg);
	}
	@Override
	public CargoEntity enable(Long id) {
		CargoEntity objcarg=repositorio.findById(id).get();
		objcarg.setEstado(true);
		return repositorio.save(objcarg);
	}
}
