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

import pe.com.megacentimetros.entity.EstadoEnvioEntity;
import pe.com.megacentimetros.service.EstadoEnvioService;

@RestController
@RequestMapping("/api/estadoenvio")
public class EstadoEnvioRestController {
	@Autowired
	private EstadoEnvioService servicio;
	
	@GetMapping
	public List<EstadoEnvioEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<EstadoEnvioEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public EstadoEnvioEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public EstadoEnvioEntity add(@RequestBody EstadoEnvioEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public EstadoEnvioEntity update(@RequestBody EstadoEnvioEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public EstadoEnvioEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public EstadoEnvioEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
