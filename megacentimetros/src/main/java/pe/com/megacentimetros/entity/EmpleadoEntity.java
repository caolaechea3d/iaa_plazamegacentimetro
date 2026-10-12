package pe.com.megacentimetros.entity;

import java.io.Serializable;
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
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codemp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomemp", length = 50, nullable = false)
	private String nombre;
	@Column(name = "apepemp", length = 40, nullable = false)
	private String apellidopaterno;
	@Column(name = "apememp", length = 40, nullable = false)
	private String apellidomaterno;
	@Column(name = "docemp", length = 20, nullable = false)
	private String numerodocumento;
	@Column(name = "feccemp", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechacontratacion;
	@Column(name = "nacemp", length = 30, nullable = false)
	private String nacionalidad;
	@Column(name = "diremp", length = 200, nullable = false)
	private String direccion;
	@Column(name = "telemp", length = 15, nullable = true)
	private String telefono;
	@Column(name = "celemp", length = 15, nullable = false)
	private String celular;
	@Column(name = "coremp", length = 100, nullable = false)
	private String correo;
	@Column(name = "estemp", nullable = false)
	private Boolean estado;
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
	@JoinColumn(name = "coddis",nullable = false)
	private DistritoEntity distrito;
	@ManyToOne
	@JoinColumn(name = "codsex",nullable = false)
	private SexoEntity sexo;
	@ManyToOne
	@JoinColumn(name = "codtipd",nullable = false)
	private TipoDocumentoEntity tipodocumento;
	@ManyToOne
	@JoinColumn(name = "codcarg",nullable = false)
	private CargoEntity cargo;
	@ManyToOne
	@JoinColumn(name = "codsuc",nullable = false)
	private SucursalEntity sucursal;
}
