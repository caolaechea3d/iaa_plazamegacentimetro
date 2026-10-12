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
@Entity(name = "TipoTransporteEntity")
@Table(name = "tipotransporte")
public class TipoTransporteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codttra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomttra", length = 40, nullable = false)
	private String nombre;
	@Column(name = "estttra", nullable = false)
	private Boolean estado;
}
