package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "CapacitacionEntity")
@Table(name = "capacitacion")
public class CapacitacionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codcap")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomcap", length = 100, nullable = false)
	private String nombre;
	@Column(name = "descap", nullable = true)
	private String descripcion;
	@Column(name = "inicap", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechainicio;
	@Column(name = "fincap", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechafin;
	@Column(name = "horcap", nullable = false)
	private Integer horas;
	@Column(name = "estcap", nullable = false)
	private Boolean estado;
}
