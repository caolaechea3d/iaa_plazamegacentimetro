package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.DetalleDespachoEntity;
public interface DetalleDespachoService {
	List<DetalleDespachoEntity> findAll();
	List<DetalleDespachoEntity> findAllCustom();
	DetalleDespachoEntity findById(Long id);
	DetalleDespachoEntity add(DetalleDespachoEntity obj);
	DetalleDespachoEntity update(DetalleDespachoEntity obj, Long id);
	DetalleDespachoEntity delete(Long id);
	DetalleDespachoEntity enable(Long id);
}
