package pe.com.megacentimetros.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.megacentimetros.entity.DetalleTrasladoEntity;
import pe.com.megacentimetros.service.DetalleTrasladoService;

@RestController
@RequestMapping("/api/detalletraslado")
public class DetalleTrasladoRestController {
	@Autowired
	private DetalleTrasladoService servicio;

	@GetMapping
	public List<DetalleTrasladoEntity> findAll(){
		return servicio.findAll();
	}

	@GetMapping("/{id}")
	public DetalleTrasladoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public DetalleTrasladoEntity add(@RequestBody DetalleTrasladoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public DetalleTrasladoEntity update(@RequestBody DetalleTrasladoEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public DetalleTrasladoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
}
