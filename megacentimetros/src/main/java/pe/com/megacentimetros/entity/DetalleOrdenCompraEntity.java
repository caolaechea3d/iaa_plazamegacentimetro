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
@Entity(name = "DetalleOrdenCompraEntity")
@Table(name = "detalleordencompra")
public class DetalleOrdenCompraEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "coddocom")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "candocom", nullable = false)
	private Integer cantidad;
	@Column(name = "cosdocom", precision = 10, scale = 2, nullable = false)
	private BigDecimal costo;
	@Column(name = "subdocom", precision = 12, scale = 2, nullable = false)
	private BigDecimal subtotal;
	@ManyToOne
	@JoinColumn(name = "codocom",nullable = false)
	private OrdenCompraEntity ordencompra;
	@ManyToOne
	@JoinColumn(name = "codpro",nullable = false)
	private ProductoEntity producto;
}
