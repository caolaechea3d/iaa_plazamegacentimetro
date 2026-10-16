package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.PagoProveedorEntity;
import pe.com.megacentimetros.repository.PagoProveedorRepository;
import pe.com.megacentimetros.service.PagoProveedorService;

@Service
public class PagoProveedorServiceImpl implements PagoProveedorService {
	@Autowired
	private PagoProveedorRepository repositorio;
	
	@Override
	public List<PagoProveedorEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public PagoProveedorEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public PagoProveedorEntity add(PagoProveedorEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public PagoProveedorEntity update(PagoProveedorEntity obj, Long id) {
		PagoProveedorEntity objpprov=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objpprov);
		return repositorio.save(objpprov);
	}
}


