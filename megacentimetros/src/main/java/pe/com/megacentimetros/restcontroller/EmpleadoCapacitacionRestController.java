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

import pe.com.megacentimetros.entity.EmpleadoCapacitacionEntity;
import pe.com.megacentimetros.service.EmpleadoCapacitacionService;

@RestController
@RequestMapping("/api/empleadocapacitacion")
public class EmpleadoCapacitacionRestController {
	@Autowired
	private EmpleadoCapacitacionService servicio;

	@GetMapping
	public List<EmpleadoCapacitacionEntity> findAll(){
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<EmpleadoCapacitacionEntity> findAllCustom(){
		return servicio.findAllCustom();
	}

	@GetMapping("/{empleado}/{capacitacion}")
	public EmpleadoCapacitacionEntity findById(@PathVariable Long empleado, @PathVariable Long capacitacion) {
		return servicio.findById(empleado, capacitacion);
	}

	@PostMapping
	public EmpleadoCapacitacionEntity add(@RequestBody EmpleadoCapacitacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{empleado}/{capacitacion}")
	public EmpleadoCapacitacionEntity update(@RequestBody EmpleadoCapacitacionEntity obj,
			@PathVariable Long empleado, @PathVariable Long capacitacion) {
		return servicio.update(obj, empleado, capacitacion);
	}

	@DeleteMapping("/{empleado}/{capacitacion}")
	public EmpleadoCapacitacionEntity delete(@PathVariable Long empleado, @PathVariable Long capacitacion) {
		return servicio.delete(empleado, capacitacion);
	}

	@PatchMapping("/{empleado}/{capacitacion}")
	public EmpleadoCapacitacionEntity enable(@PathVariable Long empleado, @PathVariable Long capacitacion) {
		return servicio.enable(empleado, capacitacion);
	}
}
