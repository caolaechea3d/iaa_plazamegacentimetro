package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.PedidoEntity;
public interface PedidoService {
	List<PedidoEntity> findAll();
	PedidoEntity findById(Long id);
	PedidoEntity add(PedidoEntity obj);
	PedidoEntity update(PedidoEntity obj, Long id);
}
