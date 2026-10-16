package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.ModuloEntity;
public interface ModuloService {
	List<ModuloEntity> findAll();
	List<ModuloEntity> findAllCustom();
	ModuloEntity findById(Long id);
	ModuloEntity add(ModuloEntity obj);
	ModuloEntity update(ModuloEntity obj, Long id);
	ModuloEntity delete(Long id);
	ModuloEntity enable(Long id);
}
