package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.TipoComprobanteEntity;
public interface TipoComprobanteService {
	List<TipoComprobanteEntity> findAll();
	List<TipoComprobanteEntity> findAllCustom();
	TipoComprobanteEntity findById(Long id);
	TipoComprobanteEntity add(TipoComprobanteEntity obj);
	TipoComprobanteEntity update(TipoComprobanteEntity obj, Long id);
	TipoComprobanteEntity delete(Long id);
	TipoComprobanteEntity enable(Long id);
}
