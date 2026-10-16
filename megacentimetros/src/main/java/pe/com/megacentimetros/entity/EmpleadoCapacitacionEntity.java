package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Entity(name = "EmpleadoCapacitacionEntity")
@Table(name = "empleadocapacitacion")
@IdClass(EmpleadoCapacitacionId.class)
public class EmpleadoCapacitacionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "codemp",nullable = false)
	private EmpleadoEntity empleado;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "codcap",nullable = false)
	private CapacitacionEntity capacitacion;
	@Column(name = "notecap", nullable = true)
	private BigDecimal nota;
	@Column(name = "feccomp", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechacompletado;
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
	@JoinColumn(name = "codecap",nullable = false)
	private EstadoCapacitacionEntity estadocapacitacion;
}
