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

import pe.com.megacentimetros.entity.CanjeRecompensaEntity;
import pe.com.megacentimetros.service.CanjeRecompensaService;

@RestController
@RequestMapping("/api/canjerecompensa")
public class CanjeRecompensaRestController {
	@Autowired
	private CanjeRecompensaService servicio;
	
	@GetMapping
	public List<CanjeRecompensaEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<CanjeRecompensaEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public CanjeRecompensaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public CanjeRecompensaEntity add(@RequestBody CanjeRecompensaEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public CanjeRecompensaEntity update(@RequestBody CanjeRecompensaEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public CanjeRecompensaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public CanjeRecompensaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
