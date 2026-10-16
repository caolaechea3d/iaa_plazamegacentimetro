package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.EstadoEnvioEntity;
public interface EstadoEnvioService {
	List<EstadoEnvioEntity> findAll();
	List<EstadoEnvioEntity> findAllCustom();
	EstadoEnvioEntity findById(Long id);
	EstadoEnvioEntity add(EstadoEnvioEntity obj);
	EstadoEnvioEntity update(EstadoEnvioEntity obj, Long id);
	EstadoEnvioEntity delete(Long id);
	EstadoEnvioEntity enable(Long id);
}
