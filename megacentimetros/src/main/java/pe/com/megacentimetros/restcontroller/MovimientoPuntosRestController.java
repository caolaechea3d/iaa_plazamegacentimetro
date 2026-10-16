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

import pe.com.megacentimetros.entity.MovimientoPuntosEntity;
import pe.com.megacentimetros.service.MovimientoPuntosService;

@RestController
@RequestMapping("/api/movimientopuntos")
public class MovimientoPuntosRestController {
	@Autowired
	private MovimientoPuntosService servicio;
	
	@GetMapping
	public List<MovimientoPuntosEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<MovimientoPuntosEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public MovimientoPuntosEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public MovimientoPuntosEntity add(@RequestBody MovimientoPuntosEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public MovimientoPuntosEntity update(@RequestBody MovimientoPuntosEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public MovimientoPuntosEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public MovimientoPuntosEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
