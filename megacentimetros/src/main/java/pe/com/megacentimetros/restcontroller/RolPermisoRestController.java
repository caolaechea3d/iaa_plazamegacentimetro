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

import pe.com.megacentimetros.entity.RolPermisoEntity;
import pe.com.megacentimetros.service.RolPermisoService;

@RestController
@RequestMapping("/api/rolpermiso")
public class RolPermisoRestController {
	@Autowired
	private RolPermisoService servicio;

	@GetMapping
	public List<RolPermisoEntity> findAll(){
		return servicio.findAll();
	}

	@GetMapping("/{rol}/{modulo}")
	public RolPermisoEntity findById(@PathVariable Long rol, @PathVariable Long modulo) {
		return servicio.findById(rol, modulo);
	}

	@PostMapping
	public RolPermisoEntity add(@RequestBody RolPermisoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{rol}/{modulo}")
	public RolPermisoEntity update(@RequestBody RolPermisoEntity obj,
			@PathVariable Long rol, @PathVariable Long modulo) {
		return servicio.update(obj, rol, modulo);
	}

	@DeleteMapping("/{rol}/{modulo}")
	public RolPermisoEntity delete(@PathVariable Long rol, @PathVariable Long modulo) {
		return servicio.delete(rol, modulo);
	}
}
