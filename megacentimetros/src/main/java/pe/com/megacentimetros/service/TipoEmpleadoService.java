package pe.com.megacentimetros.service;

import java.util.List;

import pe.com.megacentimetros.entity.TipoEmpleadoEntity;

public interface TipoEmpleadoService {
	List<TipoEmpleadoEntity> findAll();
	List<TipoEmpleadoEntity> findAllCustom();
	TipoEmpleadoEntity findById(Long id);
	TipoEmpleadoEntity add(TipoEmpleadoEntity obj);
	TipoEmpleadoEntity update(TipoEmpleadoEntity obj, Long id);
	TipoEmpleadoEntity delete(Long id);
	TipoEmpleadoEntity enable(Long id);
}
