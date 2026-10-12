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
@Entity(name = "PagoClienteEntity")
@Table(name = "pagocliente")
public class PagoClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codpcli")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "fecpcli", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fecha;
	@Column(name = "monpcli", precision = 10, scale = 2, nullable = false)
	private BigDecimal monto;
	@Column(name = "numpcli", length = 50, nullable = true)
	private String numerooperacion;
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
	@JoinColumn(name = "codfac",nullable = false)
	private FacturacionEntity facturacion;
	@ManyToOne
	@JoinColumn(name = "codmpag",nullable = false)
	private MetodoPagoEntity metodopago;
	@ManyToOne
	@JoinColumn(name = "codepag",nullable = false)
	private EstadoPagoEntity estadopago;
}
