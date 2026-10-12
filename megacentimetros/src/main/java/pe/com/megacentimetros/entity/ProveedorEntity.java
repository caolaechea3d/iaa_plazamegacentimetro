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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")
public class ProveedorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codprov")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomprov", length = 50, nullable = true)
	private String nombre;
	@Column(name = "apepprov", length = 40, nullable = true)
	private String apellidopaterno;
	@Column(name = "apemprov", length = 40, nullable = true)
	private String apellidomaterno;
	@Column(name = "razprov", length = 150, nullable = true)
	private String razonsocial;
	@Column(name = "rucprov", length = 11, nullable = false)
	private String ruc;
	@Column(name = "corprov", length = 100, nullable = true)
	private String correo;
	@Column(name = "telprov", length = 15, nullable = true)
	private String telefono;
	@Column(name = "celprov", length = 15, nullable = true)
	private String celular;
	@Column(name = "fecprov", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaingreso;
	@Column(name = "estprov", nullable = false)
	private Boolean estado;
	@Column(name = "dirprov", length = 200, nullable = false)
	private String direccion;
	@Column(name = "feceva", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaevaluacion;
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
	@JoinColumn(name = "codeeva",nullable = false)
	private EstadoEvaluacionEntity estadoevaluacion;
}
