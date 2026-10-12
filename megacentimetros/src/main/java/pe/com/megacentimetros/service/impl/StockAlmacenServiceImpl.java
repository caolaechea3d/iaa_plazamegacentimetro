package pe.com.megacentimetros.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.entity.StockAlmacenEntity;
import pe.com.megacentimetros.entity.StockAlmacenId;
import pe.com.megacentimetros.repository.StockAlmacenRepository;
import pe.com.megacentimetros.service.StockAlmacenService;

@Service
public class StockAlmacenServiceImpl implements StockAlmacenService {
	@Autowired
	private StockAlmacenRepository repositorio;

	@Override
	public List<StockAlmacenEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public StockAlmacenEntity findById(Long producto, Long almacen) {
		return repositorio.findById(new StockAlmacenId(producto, almacen)).get();
	}
	@Override
	public StockAlmacenEntity add(StockAlmacenEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public StockAlmacenEntity update(StockAlmacenEntity obj, Long producto, Long almacen) {
		StockAlmacenEntity objsto=repositorio.findById(new StockAlmacenId(producto, almacen)).get();
		BeanUtils.copyProperties(obj, objsto);
		return repositorio.save(objsto);
	}
	@Override
	public StockAlmacenEntity delete(Long producto, Long almacen) {
		StockAlmacenEntity objsto=repositorio.findById(new StockAlmacenId(producto, almacen)).get();
		repositorio.delete(objsto);
		return objsto;
	}
}
