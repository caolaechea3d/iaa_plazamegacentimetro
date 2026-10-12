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

import pe.com.megacentimetros.entity.PagoProveedorEntity;
import pe.com.megacentimetros.service.PagoProveedorService;

@RestController
@RequestMapping("/api/pagoproveedor")
public class PagoProveedorRestController {
	@Autowired
	private PagoProveedorService servicio;

	@GetMapping
	public List<PagoProveedorEntity> findAll(){
		return servicio.findAll();
	}

	@GetMapping("/{id}")
	public PagoProveedorEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public PagoProveedorEntity add(@RequestBody PagoProveedorEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public PagoProveedorEntity update(@RequestBody PagoProveedorEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public PagoProveedorEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
}
