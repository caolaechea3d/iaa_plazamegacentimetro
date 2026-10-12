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
@Entity(name = "UnidadMedidaEntity")
@Table(name = "unidadmedida")
public class UnidadMedidaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codumed")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomumed", length = 30, nullable = false)
	private String nombre;
	@Column(name = "abrumed", length = 10, nullable = false)
	private String abreviatura;
	@Column(name = "estumed", nullable = false)
	private Boolean estado;
}
