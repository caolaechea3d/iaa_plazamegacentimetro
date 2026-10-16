package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.DetalleGuiaIngresoEntity;
public interface DetalleGuiaIngresoService {
	List<DetalleGuiaIngresoEntity> findAll();
	List<DetalleGuiaIngresoEntity> findAllCustom();
	DetalleGuiaIngresoEntity findById(Long id);
	DetalleGuiaIngresoEntity add(DetalleGuiaIngresoEntity obj);
	DetalleGuiaIngresoEntity update(DetalleGuiaIngresoEntity obj, Long id);
	DetalleGuiaIngresoEntity delete(Long id);
	DetalleGuiaIngresoEntity enable(Long id);
}
