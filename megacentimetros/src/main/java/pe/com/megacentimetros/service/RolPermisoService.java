package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.RolPermisoEntity;
public interface RolPermisoService {
	List<RolPermisoEntity> findAll();
	List<RolPermisoEntity> findAllCustom();
	RolPermisoEntity findById(Long rol, Long modulo);
	RolPermisoEntity add(RolPermisoEntity obj);
	RolPermisoEntity update(RolPermisoEntity obj, Long rol, Long modulo);
	RolPermisoEntity delete(Long rol, Long modulo);
	RolPermisoEntity enable(Long rol, Long modulo);
}
