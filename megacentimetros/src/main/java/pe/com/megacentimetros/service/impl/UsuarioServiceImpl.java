package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.UsuarioEntity;
import pe.com.megacentimetros.repository.UsuarioRepository;
import pe.com.megacentimetros.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository repositorio;

	@Override
	public List<UsuarioEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<UsuarioEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public UsuarioEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public UsuarioEntity add(UsuarioEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public UsuarioEntity update(UsuarioEntity obj, Long id) {
		UsuarioEntity objusu=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objusu);
		return repositorio.save(objusu);
	}
	@Override
	public UsuarioEntity delete(Long id) {
		UsuarioEntity objusu=repositorio.findById(id).get();
		objusu.setEstado("INACTIVO");
		return repositorio.save(objusu);
	}
	@Override
	public UsuarioEntity enable(Long id) {
		UsuarioEntity objusu=repositorio.findById(id).get();
		objusu.setEstado("ACTIVO");
		return repositorio.save(objusu);
	}
}
