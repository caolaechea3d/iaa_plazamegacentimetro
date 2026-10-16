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

import pe.com.megacentimetros.entity.DetalleDespachoEntity;
import pe.com.megacentimetros.service.DetalleDespachoService;

@RestController
@RequestMapping("/api/detalledespacho")
public class DetalleDespachoRestController {
	@Autowired
	private DetalleDespachoService servicio;
	
	@GetMapping
	public List<DetalleDespachoEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<DetalleDespachoEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public DetalleDespachoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public DetalleDespachoEntity add(@RequestBody DetalleDespachoEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public DetalleDespachoEntity update(@RequestBody DetalleDespachoEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public DetalleDespachoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public DetalleDespachoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
