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

import pe.com.megacentimetros.entity.CampanaSegmentoEntity;
import pe.com.megacentimetros.service.CampanaSegmentoService;

@RestController
@RequestMapping("/api/campanasegmento")
public class CampanaSegmentoRestController {
	@Autowired
	private CampanaSegmentoService servicio;
	
	@GetMapping
	public List<CampanaSegmentoEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<CampanaSegmentoEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{campana}/{tipocliente}")
	public CampanaSegmentoEntity findById(@PathVariable Long campana, @PathVariable Long tipocliente) {
		return servicio.findById(campana, tipocliente);
	}
	
	@PostMapping
	public CampanaSegmentoEntity add(@RequestBody CampanaSegmentoEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{campana}/{tipocliente}")
	public CampanaSegmentoEntity update(@RequestBody CampanaSegmentoEntity obj,
			@PathVariable Long campana, @PathVariable Long tipocliente) {
		return servicio.update(obj, campana, tipocliente);
	}
	
	@DeleteMapping("/{campana}/{tipocliente}")
	public CampanaSegmentoEntity delete(@PathVariable Long campana, @PathVariable Long tipocliente) {
		return servicio.delete(campana, tipocliente);
	}
	
	@PatchMapping("/{campana}/{tipocliente}")
	public CampanaSegmentoEntity enable(@PathVariable Long campana, @PathVariable Long tipocliente) {
		return servicio.enable(campana, tipocliente);
	}
}
