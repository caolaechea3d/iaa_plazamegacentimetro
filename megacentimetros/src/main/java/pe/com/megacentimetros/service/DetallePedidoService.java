package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.DetallePedidoEntity;

public interface DetallePedidoService {
	List<DetallePedidoEntity> findAll();
	DetallePedidoEntity findById(Long id);
	DetallePedidoEntity add(DetallePedidoEntity obj);
	DetallePedidoEntity update(DetallePedidoEntity obj, Long id);
	DetallePedidoEntity delete(Long id);
}
