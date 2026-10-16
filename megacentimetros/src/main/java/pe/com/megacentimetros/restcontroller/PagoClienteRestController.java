package pe.com.megacentimetros.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.megacentimetros.entity.PagoClienteEntity;
import pe.com.megacentimetros.service.PagoClienteService;

@RestController
@RequestMapping("/api/pagocliente")
public class PagoClienteRestController {
	@Autowired
	private PagoClienteService servicio;
	
	@GetMapping
	public List<PagoClienteEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/{id}")
	public PagoClienteEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public PagoClienteEntity add(@RequestBody PagoClienteEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public PagoClienteEntity update(@RequestBody PagoClienteEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
}
