package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.StockAlmacenEntity;

public interface StockAlmacenService {
	List<StockAlmacenEntity> findAll();
	StockAlmacenEntity findById(Long producto, Long almacen);
	StockAlmacenEntity add(StockAlmacenEntity obj);
	StockAlmacenEntity update(StockAlmacenEntity obj, Long producto, Long almacen);
	StockAlmacenEntity delete(Long producto, Long almacen);
}
