package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Entity(name = "AsistenciaEntity")
@Table(name = "asistencia")
public class AsistenciaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codasi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "fecasi", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	@Column(name = "entasi", nullable = true)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime horaentrada;
	@Column(name = "salasi", nullable = true)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime horasalida;
	@ManyToOne
	@JoinColumn(name = "codeasis",nullable = false)
	private EstadoAsistenciaEntity estadoasistencia;
	@ManyToOne
	@JoinColumn(name = "codemp",nullable = false)
	private EmpleadoEntity empleado;
}
