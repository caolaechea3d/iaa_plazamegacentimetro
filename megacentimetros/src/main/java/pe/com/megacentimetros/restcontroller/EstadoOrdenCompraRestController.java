package pe.com.megacentimetros.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.megacentimetros.entity.EstadoOrdenCompraEntity;
import pe.com.megacentimetros.service.EstadoOrdenCompraService;

@RestController
@RequestMapping("/api/estadoordencompra")
public class EstadoOrdenCompraRestController {
	@Autowired
	private EstadoOrdenCompraService servicio;
	
	@GetMapping
	public List<EstadoOrdenCompraEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<EstadoOrdenCompraEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public EstadoOrdenCompraEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public EstadoOrdenCompraEntity add(@RequestBody EstadoOrdenCompraEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public EstadoOrdenCompraEntity update(@RequestBody EstadoOrdenCompraEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public EstadoOrdenCompraEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public EstadoOrdenCompraEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
