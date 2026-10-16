package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.FacturacionEntity;
public interface FacturacionService {
	List<FacturacionEntity> findAll();
	List<FacturacionEntity> findAllCustom();
	FacturacionEntity findById(Long id);
	FacturacionEntity add(FacturacionEntity obj);
	FacturacionEntity update(FacturacionEntity obj, Long id);
	FacturacionEntity delete(Long id);
	FacturacionEntity enable(Long id);
}
