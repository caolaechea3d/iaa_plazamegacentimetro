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

import pe.com.megacentimetros.entity.StockAlmacenEntity;
import pe.com.megacentimetros.service.StockAlmacenService;

@RestController
@RequestMapping("/api/stockalmacen")
public class StockAlmacenRestController {
	@Autowired
	private StockAlmacenService servicio;

	@GetMapping
	public List<StockAlmacenEntity> findAll(){
		return servicio.findAll();
	}

	@GetMapping("/{producto}/{almacen}")
	public StockAlmacenEntity findById(@PathVariable Long producto, @PathVariable Long almacen) {
		return servicio.findById(producto, almacen);
	}

	@PostMapping
	public StockAlmacenEntity add(@RequestBody StockAlmacenEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{producto}/{almacen}")
	public StockAlmacenEntity update(@RequestBody StockAlmacenEntity obj,
			@PathVariable Long producto, @PathVariable Long almacen) {
		return servicio.update(obj, producto, almacen);
	}

	@DeleteMapping("/{producto}/{almacen}")
	public StockAlmacenEntity delete(@PathVariable Long producto, @PathVariable Long almacen) {
		return servicio.delete(producto, almacen);
	}
}
