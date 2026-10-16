package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.CampanaEntity;
public interface CampanaService {
	List<CampanaEntity> findAll();
	List<CampanaEntity> findAllCustom();
	CampanaEntity findById(Long id);
	CampanaEntity add(CampanaEntity obj);
	CampanaEntity update(CampanaEntity obj, Long id);
	CampanaEntity delete(Long id);
	CampanaEntity enable(Long id);
}
