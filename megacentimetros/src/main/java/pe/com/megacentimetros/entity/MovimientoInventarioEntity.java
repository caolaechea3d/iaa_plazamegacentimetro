package pe.com.megacentimetros.entity;

import java.io.Serializable;
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
@Entity(name = "MovimientoInventarioEntity")
@Table(name = "movimientoinventario")
public class MovimientoInventarioEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codminv")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "fecminv", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fecha;
	@Column(name = "canminv", nullable = false)
	private Integer cantidad;
	@Column(name = "refminv",length = 50, nullable = true)
	private String referencia;
	@Column(name = "estminv", nullable = false)
	private Boolean estado;
	@Column(name = "usucre",length = 50, nullable = false, updatable = false)
	private String usuariocreacion;
	@Column(name = "feccre", nullable = false, insertable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechacreacion;
	@Column(name = "usuact",length = 50, nullable = true)
	private String usuarioactualizacion;
	@Column(name = "fecact", nullable = true, insertable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaactualizacion;
	
	@ManyToOne
	@JoinColumn(name = "codpro",nullable = false)
	private ProductoEntity producto;
	
	@ManyToOne
	@JoinColumn(name = "codalm",nullable = false)
	private AlmacenEntity almacen;
	
	@ManyToOne
	@JoinColumn(name = "codtmov",nullable = false)
	private TipoMovimientoEntity tipomovimiento;
	
	@ManyToOne
	@JoinColumn(name = "codemp",nullable = true)
	private EmpleadoEntity empleado;
}
