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

import pe.com.megacentimetros.entity.DespachoEntity;
import pe.com.megacentimetros.service.DespachoService;

@RestController
@RequestMapping("/api/despacho")
public class DespachoRestController {
	@Autowired
	private DespachoService servicio;
	
	@GetMapping
	public List<DespachoEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/{id}")
	public DespachoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public DespachoEntity add(@RequestBody DespachoEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public DespachoEntity update(@RequestBody DespachoEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
}
