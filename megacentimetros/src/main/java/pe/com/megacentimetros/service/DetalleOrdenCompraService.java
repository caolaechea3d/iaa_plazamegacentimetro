package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.DetalleOrdenCompraEntity;

public interface DetalleOrdenCompraService {
	List<DetalleOrdenCompraEntity> findAll();
	DetalleOrdenCompraEntity findById(Long id);
	DetalleOrdenCompraEntity add(DetalleOrdenCompraEntity obj);
	DetalleOrdenCompraEntity update(DetalleOrdenCompraEntity obj, Long id);
	DetalleOrdenCompraEntity delete(Long id);
}
