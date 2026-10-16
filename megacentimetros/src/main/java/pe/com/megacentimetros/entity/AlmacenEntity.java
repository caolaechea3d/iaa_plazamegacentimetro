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
@Entity(name = "AlmacenEntity")
@Table(name = "almacen")
public class AlmacenEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codalm")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomalm",length = 100, nullable = false)
	private String nombre;
	@Column(name = "diralm",length = 200, nullable = false)
	private String direccion;
	@Column(name = "capalm", nullable = false)
	private Integer capacidad;
	@Column(name = "desalm",length = 300, nullable = true)
	private String descripcion;
	@Column(name = "estalm", nullable = false)
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
	@JoinColumn(name = "coddis",nullable = false)
	private DistritoEntity distrito;
	
	@ManyToOne
	@JoinColumn(name = "codtalm",nullable = false)
	private TipoAlmacenEntity tipoalmacen;
	
	@ManyToOne
	@JoinColumn(name = "codsuc",nullable = false)
	private SucursalEntity sucursal;
	
	@ManyToOne
	@JoinColumn(name = "codeope",nullable = false)
	private EstadoOperativoEntity estadooperativo;
}
