package pe.com.megacentimetros.entity;

import java.io.Serializable;

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
@Entity(name = "DetalleGuiaIngresoEntity")
@Table(name = "detalleguiaingreso")
public class DetalleGuiaIngresoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "coddgin")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "candgin", nullable = false)
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name = "codpro",nullable = false)
	private ProductoEntity producto;
	@ManyToOne
	@JoinColumn(name = "codgin",nullable = false)
	private GuiaIngresoEntity guiaingreso;
}
