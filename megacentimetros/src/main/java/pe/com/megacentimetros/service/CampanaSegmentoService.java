package pe.com.megacentimetros.service;
import java.util.List;
import pe.com.megacentimetros.entity.CampanaSegmentoEntity;
public interface CampanaSegmentoService {
	List<CampanaSegmentoEntity> findAll();
	List<CampanaSegmentoEntity> findAllCustom();
	CampanaSegmentoEntity findById(Long campana, Long tipocliente);
	CampanaSegmentoEntity add(CampanaSegmentoEntity obj);
	CampanaSegmentoEntity update(CampanaSegmentoEntity obj, Long campana, Long tipocliente);
	CampanaSegmentoEntity delete(Long campana, Long tipocliente);
	CampanaSegmentoEntity enable(Long campana, Long tipocliente);
}
