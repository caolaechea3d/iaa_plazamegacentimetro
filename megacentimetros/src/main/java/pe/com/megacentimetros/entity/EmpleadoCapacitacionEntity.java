package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
	@Column(name = "notecap", precision = 5, scale = 2, nullable = true)
	private BigDecimal nota;
	@Column(name = "estecap", length = 20, nullable = false)
	private String estado;
	@Column(name = "feccomp", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechacompletado;
}
