package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.TipoIncidenciaEntity;

public interface TipoIncidenciaService {
	List<TipoIncidenciaEntity> findAll();
	List<TipoIncidenciaEntity> findAllCustom();
	TipoIncidenciaEntity findById(Long id);
	TipoIncidenciaEntity add(TipoIncidenciaEntity obj);
	TipoIncidenciaEntity update(TipoIncidenciaEntity obj, Long id);
	TipoIncidenciaEntity delete(Long id);
	TipoIncidenciaEntity enable(Long id);
}
