package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
@Entity(name = "FacturacionEntity")
@Table(name = "facturacion")
public class FacturacionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codfac")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "serfac", length = 4, nullable = false)
	private String serie;
	@Column(name = "numfac", nullable = false)
	private Integer numero;
	@Column(name = "fecfac", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fecha;
	@Column(name = "subfac", precision = 10, scale = 2, nullable = false)
	private BigDecimal subtotal;
	@Column(name = "igvfac", precision = 10, scale = 2, nullable = false)
	private BigDecimal igv;
	@Column(name = "totfac", precision = 10, scale = 2, nullable = false)
	private BigDecimal total;
	@Column(name = "estfac", length = 20, nullable = false)
	private String estado;
	@Column(name = "usucre", length = 50, nullable = false, updatable = false)
	private String usuariocreacion;
	@Column(name = "feccre", nullable = false, insertable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechacreacion;
	@Column(name = "usuact", length = 50, nullable = true)
	private String usuarioactualizacion;
	@Column(name = "fecact", nullable = true, insertable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaactualizacion;
	@ManyToOne
	@JoinColumn(name = "codped",nullable = false)
	private PedidoEntity pedido;
	@ManyToOne
	@JoinColumn(name = "codtcom",nullable = false)
	private TipoComprobanteEntity tipocomprobante;
}
