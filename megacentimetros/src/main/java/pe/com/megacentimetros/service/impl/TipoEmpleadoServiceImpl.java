package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.TipoEmpleadoEntity;
import pe.com.megacentimetros.repository.TipoEmpleadoRepository;
import pe.com.megacentimetros.service.TipoEmpleadoService;

@Service
public class TipoEmpleadoServiceImpl implements TipoEmpleadoService {
	@Autowired
	private TipoEmpleadoRepository repositorio;

	@Override
	public List<TipoEmpleadoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoEmpleadoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoEmpleadoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public TipoEmpleadoEntity add(TipoEmpleadoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public TipoEmpleadoEntity update(TipoEmpleadoEntity obj, Long id) {
		TipoEmpleadoEntity objtiemp=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtiemp);
		return repositorio.save(objtiemp);
	}
	@Override
	public TipoEmpleadoEntity delete(Long id) {
		TipoEmpleadoEntity objtiemp=repositorio.findById(id).get();
		objtiemp.setEstado(false);
		return repositorio.save(objtiemp);
	}
	@Override
	public TipoEmpleadoEntity enable(Long id) {
		TipoEmpleadoEntity objtiemp=repositorio.findById(id).get();
		objtiemp.setEstado(true);
		return repositorio.save(objtiemp);
	}
}
