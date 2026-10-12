package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Entity(name = "TransporteEntity")
@Table(name = "transporte")
public class TransporteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codtra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "platra", length = 10, nullable = false)
	private String placa;
	@Column(name = "captra", precision = 10, scale = 2, nullable = false)
	private BigDecimal capacidad;
	@Column(name = "esttra", nullable = false)
	private Boolean estado;
	@ManyToOne
	@JoinColumn(name = "codttra",nullable = false)
	private TipoTransporteEntity tipotransporte;
	@ManyToOne
	@JoinColumn(name = "codetra",nullable = false)
	private EstadoTransporteEntity estadotransporte;
}
