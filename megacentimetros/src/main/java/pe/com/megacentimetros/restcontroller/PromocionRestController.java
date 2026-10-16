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

import pe.com.megacentimetros.entity.PromocionEntity;
import pe.com.megacentimetros.service.PromocionService;

@RestController
@RequestMapping("/api/promocion")
public class PromocionRestController {
	@Autowired
	private PromocionService servicio;
	
	@GetMapping
	public List<PromocionEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<PromocionEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public PromocionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public PromocionEntity add(@RequestBody PromocionEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public PromocionEntity update(@RequestBody PromocionEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public PromocionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public PromocionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
