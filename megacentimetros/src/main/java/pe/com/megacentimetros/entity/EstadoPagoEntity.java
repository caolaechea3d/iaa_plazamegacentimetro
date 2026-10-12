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
@Entity(name = "EstadoPagoEntity")
@Table(name = "estadopago")
public class EstadoPagoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codepag")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomepag", length = 30, nullable = false)
	private String nombre;
	@Column(name = "estepag", nullable = false)
	private Boolean estado;
}
