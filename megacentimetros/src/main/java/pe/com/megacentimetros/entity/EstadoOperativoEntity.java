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
@Entity(name = "EstadoOperativoEntity")
@Table(name = "estadooperativo")
public class EstadoOperativoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codeope")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomeope", length = 40, nullable = false)
	private String nombre;
	@Column(name = "deseope", length = 300, nullable = true)
	private String descripcion;
}
