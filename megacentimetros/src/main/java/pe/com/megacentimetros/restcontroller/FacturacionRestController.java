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

import pe.com.megacentimetros.entity.FacturacionEntity;
import pe.com.megacentimetros.service.FacturacionService;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionRestController {
	@Autowired
	private FacturacionService servicio;
	
	@GetMapping
	public List<FacturacionEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<FacturacionEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public FacturacionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public FacturacionEntity add(@RequestBody FacturacionEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public FacturacionEntity update(@RequestBody FacturacionEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public FacturacionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public FacturacionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
