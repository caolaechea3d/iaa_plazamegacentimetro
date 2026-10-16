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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "CampanaEntity")
@Table(name = "campana")
public class CampanaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codcam")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomcam",length = 100, nullable = false)
	private String nombre;
	@Column(name = "descam", nullable = true)
	private String descripcion;
	@Column(name = "inicam", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechainicio;
	@Column(name = "fincam", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechafin;
	@Column(name = "estcam", nullable = false)
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
}
