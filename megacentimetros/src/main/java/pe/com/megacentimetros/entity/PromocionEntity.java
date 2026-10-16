package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Entity(name = "PromocionEntity")
@Table(name = "promocion")
public class PromocionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codprom")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomprom",length = 100, nullable = false)
	private String nombre;
	@Column(name = "desprom",length = 300, nullable = true)
	private String descripcion;
	@Column(name = "tipprom",length = 10, nullable = false)
	private String tipodescuento;
	@Column(name = "valprom", nullable = false)
	private BigDecimal valor;
	@Column(name = "iniprom", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechainicio;
	@Column(name = "finprom", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechafin;
	@Column(name = "estprom", nullable = false)
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
	@JoinColumn(name = "codcam",nullable = false)
	private CampanaEntity campana;
	
	@ManyToOne
	@JoinColumn(name = "codpro",nullable = true)
	private ProductoEntity producto;
	
	@ManyToOne
	@JoinColumn(name = "codcat",nullable = true)
	private CategoriaProductoEntity categoriaproducto;
}
