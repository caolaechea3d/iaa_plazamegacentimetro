package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.PedidoEntity;
import pe.com.megacentimetros.repository.PedidoRepository;
import pe.com.megacentimetros.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	@Autowired
	private PedidoRepository repositorio;

	@Override
	public List<PedidoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<PedidoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public PedidoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public PedidoEntity add(PedidoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public PedidoEntity update(PedidoEntity obj, Long id) {
		PedidoEntity objped=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objped);
		return repositorio.save(objped);
	}
	@Override
	public PedidoEntity delete(Long id) {
		PedidoEntity objped=repositorio.findById(id).get();
		objped.setEstado("ANULADO");
		return repositorio.save(objped);
	}
	@Override
	public PedidoEntity enable(Long id) {
		PedidoEntity objped=repositorio.findById(id).get();
		objped.setEstado("PENDIENTE");
		return repositorio.save(objped);
	}
}
