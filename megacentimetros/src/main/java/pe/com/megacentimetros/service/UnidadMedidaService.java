package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.UnidadMedidaEntity;
public interface UnidadMedidaService {
	List<UnidadMedidaEntity> findAll();
	List<UnidadMedidaEntity> findAllCustom();
	UnidadMedidaEntity findById(Long id);
	UnidadMedidaEntity add(UnidadMedidaEntity obj);
	UnidadMedidaEntity update(UnidadMedidaEntity obj, Long id);
	UnidadMedidaEntity delete(Long id);
	UnidadMedidaEntity enable(Long id);
}
