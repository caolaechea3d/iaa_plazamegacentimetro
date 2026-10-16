package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.DespachoEntity;
public interface DespachoService {
	List<DespachoEntity> findAll();
	DespachoEntity findById(Long id);
	DespachoEntity add(DespachoEntity obj);
	DespachoEntity update(DespachoEntity obj, Long id);
}
