package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.EstadoOrdenCompraEntity;
public interface EstadoOrdenCompraService {
	List<EstadoOrdenCompraEntity> findAll();
	List<EstadoOrdenCompraEntity> findAllCustom();
	EstadoOrdenCompraEntity findById(Long id);
	EstadoOrdenCompraEntity add(EstadoOrdenCompraEntity obj);
	EstadoOrdenCompraEntity update(EstadoOrdenCompraEntity obj, Long id);
	EstadoOrdenCompraEntity delete(Long id);
	EstadoOrdenCompraEntity enable(Long id);
}
