package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(name = "estper", nullable = false)
	private Boolean estado;
	@Column(name = "usucre",length = 50, nullable = false, updatable = false)
	private String usuariocreacion;
	@Column(name = "feccre", nullable = false, insertable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechacreacion;
	@Column(name = "usuact",length = 50, nullable = true)
	private String usuarioactualizacion;
	@Column(name = "fecact", nullable = true, insertable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaactualizacion;
}
