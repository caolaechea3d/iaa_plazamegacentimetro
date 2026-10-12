package pe.com.megacentimetros.entity;

import java.io.Serializable;

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
@Entity(name = "RecompensaEntity")
@Table(name = "recompensa")
public class RecompensaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codrec")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomrec", length = 100, nullable = false)
	private String nombre;
	@Column(name = "desrec", nullable = true)
	private String descripcion;
	@Column(name = "punrec", nullable = false)
	private Integer puntos;
	@Column(name = "estrec", nullable = false)
	private Boolean estado;
}
