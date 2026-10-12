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
@Entity(name = "TipoEmpaqueEntity")
@Table(name = "tipoempaque")
public class TipoEmpaqueEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codtemp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomtemp", length = 40, nullable = false)
	private String nombre;
	@Column(name = "esttemp", nullable = false)
	private Boolean estado;
}
