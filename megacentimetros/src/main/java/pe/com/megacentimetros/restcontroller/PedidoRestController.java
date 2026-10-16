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

import pe.com.megacentimetros.entity.PedidoEntity;
import pe.com.megacentimetros.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController {
	@Autowired
	private PedidoService servicio;
	
	@GetMapping
	public List<PedidoEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/{id}")
	public PedidoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	@PostMapping
	public PedidoEntity add(@RequestBody PedidoEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public PedidoEntity update(@RequestBody PedidoEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
}
