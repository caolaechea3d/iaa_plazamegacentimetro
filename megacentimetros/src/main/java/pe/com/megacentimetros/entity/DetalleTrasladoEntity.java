package pe.com.megacentimetros.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
@Entity(name = "DetalleTrasladoEntity")
@Table(name = "detalletraslado")
public class DetalleTrasladoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "coddtrasl")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "candtrasl", nullable = false)
	private Integer cantidad;
	@Column(name = "estdtrasl", nullable = false)
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
	
	@ManyToOne
	@JoinColumn(name = "codpro",nullable = false)
	private ProductoEntity producto;
	
	@ManyToOne
	@JoinColumn(name = "codtrasl",nullable = false)
	private TrasladoAlmacenEntity trasladoalmacen;
}
