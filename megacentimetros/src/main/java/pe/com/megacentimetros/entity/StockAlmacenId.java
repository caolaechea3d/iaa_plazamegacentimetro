package pe.com.megacentimetros.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockAlmacenId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long producto;
	private Long almacen;
}
