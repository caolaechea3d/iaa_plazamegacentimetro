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

import pe.com.megacentimetros.entity.DetalleGuiaIngresoEntity;
import pe.com.megacentimetros.service.DetalleGuiaIngresoService;

@RestController
@RequestMapping("/api/detalleguiaingreso")
public class DetalleGuiaIngresoRestController {
	@Autowired
	private DetalleGuiaIngresoService servicio;
	
	@GetMapping
	public List<DetalleGuiaIngresoEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<DetalleGuiaIngresoEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public DetalleGuiaIngresoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public DetalleGuiaIngresoEntity add(@RequestBody DetalleGuiaIngresoEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public DetalleGuiaIngresoEntity update(@RequestBody DetalleGuiaIngresoEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public DetalleGuiaIngresoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public DetalleGuiaIngresoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
