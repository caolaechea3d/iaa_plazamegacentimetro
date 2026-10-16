package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.EstadoPedidoEntity;
public interface EstadoPedidoService {
	List<EstadoPedidoEntity> findAll();
	List<EstadoPedidoEntity> findAllCustom();
	EstadoPedidoEntity findById(Long id);
	EstadoPedidoEntity add(EstadoPedidoEntity obj);
	EstadoPedidoEntity update(EstadoPedidoEntity obj, Long id);
	EstadoPedidoEntity delete(Long id);
	EstadoPedidoEntity enable(Long id);
}
