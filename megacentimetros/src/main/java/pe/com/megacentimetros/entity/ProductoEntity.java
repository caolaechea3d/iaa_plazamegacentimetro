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
@Entity(name = "ProductoEntity")
@Table(name = "producto")
public class ProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codpro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "skupro",length = 30, nullable = false)
	private String sku;
	@Column(name = "nompro",length = 100, nullable = false)
	private String nombre;
	@Column(name = "despro", nullable = true)
	private String descripcion;
	@Column(name = "fecpro", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaingreso;
	@Column(name = "prepro", nullable = false)
	private BigDecimal precio;
	@Column(name = "cospro", nullable = false)
	private BigDecimal costo;
	@Column(name = "estpro", nullable = false)
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
	@JoinColumn(name = "codcat",nullable = false)
	private CategoriaProductoEntity categoriaproducto;
	
	@ManyToOne
	@JoinColumn(name = "codmar",nullable = false)
	private MarcaProductoEntity marcaproducto;
	
	@ManyToOne
	@JoinColumn(name = "codtemp",nullable = false)
	private TipoEmpaqueEntity tipoempaque;
	
	@ManyToOne
	@JoinColumn(name = "codumed",nullable = false)
	private UnidadMedidaEntity unidadmedida;
}
