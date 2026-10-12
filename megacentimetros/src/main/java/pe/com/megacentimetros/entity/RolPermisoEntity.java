package pe.com.megacentimetros.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Entity(name = "RolPermisoEntity")
@Table(name = "rolpermiso")
@IdClass(RolPermisoId.class)
public class RolPermisoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "codrol",nullable = false)
	private RolEntity rol;
	@Id
	@ManyToOne
	@JoinColumn(name = "codmod",nullable = false)
	private ModuloEntity modulo;
	@Column(name = "lecper", nullable = false)
	private Boolean lectura;
	@Column(name = "escper", nullable = false)
	private Boolean escritura;
	@Column(name = "eliper", nullable = false)
	private Boolean eliminacion;
}
