package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "DetallePedidoEntity")
@Table(name = "detallepedido")
public class DetallePedidoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "coddped")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "candped", nullable = false)
	private Integer cantidad;
	@Column(name = "predped", precision = 10, scale = 2, nullable = false)
	private BigDecimal precio;
	@Column(name = "desdped", precision = 10, scale = 2, nullable = false)
	private BigDecimal descuento;
	@Column(name = "subdped", precision = 10, scale = 2, nullable = false)
	private BigDecimal subtotal;
	@ManyToOne
	@JoinColumn(name = "codped",nullable = false)
	private PedidoEntity pedido;
	@ManyToOne
	@JoinColumn(name = "codpro",nullable = false)
	private ProductoEntity producto;
	@ManyToOne
	@JoinColumn(name = "codalm",nullable = false)
	private AlmacenEntity almacen;
	@ManyToOne
	@JoinColumn(name = "codprom",nullable = true)
	private PromocionEntity promocion;
}
