package pe.com.megacentimetros.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.megacentimetros.entity.OrdenCompraEntity;
import pe.com.megacentimetros.repository.OrdenCompraRepository;
import pe.com.megacentimetros.service.OrdenCompraService;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {
	@Autowired
	private OrdenCompraRepository repositorio;
	
	@Override
	public List<OrdenCompraEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public OrdenCompraEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public OrdenCompraEntity add(OrdenCompraEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public OrdenCompraEntity update(OrdenCompraEntity obj, Long id) {
		OrdenCompraEntity objocom=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objocom);
		return repositorio.save(objocom);
	}
}


