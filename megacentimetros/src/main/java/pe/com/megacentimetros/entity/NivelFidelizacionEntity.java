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
@Entity(name = "NivelFidelizacionEntity")
@Table(name = "nivelfidelizacion")
public class NivelFidelizacionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codniv")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomniv", length = 30, nullable = false)
	private String nombre;
	@Column(name = "minniv", nullable = false)
	private Integer puntosminimos;
	@Column(name = "desniv", length = 300, nullable = true)
	private String descripcion;
	@Column(name = "estniv", nullable = false)
	private Boolean estado;
}
