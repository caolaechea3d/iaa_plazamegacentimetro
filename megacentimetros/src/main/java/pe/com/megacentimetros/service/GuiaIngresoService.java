package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.GuiaIngresoEntity;
public interface GuiaIngresoService {
	List<GuiaIngresoEntity> findAll();
	List<GuiaIngresoEntity> findAllCustom();
	GuiaIngresoEntity findById(Long id);
	GuiaIngresoEntity add(GuiaIngresoEntity obj);
	GuiaIngresoEntity update(GuiaIngresoEntity obj, Long id);
	GuiaIngresoEntity delete(Long id);
	GuiaIngresoEntity enable(Long id);
}
