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
@Entity(name = "CanjeRecompensaEntity")
@Table(name = "canjerecompensa")
public class CanjeRecompensaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codcan")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "feccan", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fecha;
	@Column(name = "puncan", nullable = false)
	private Integer puntos;
	@ManyToOne
	@JoinColumn(name = "codcpun",nullable = false)
	private CuentaPuntosEntity cuentapuntos;
	@ManyToOne
	@JoinColumn(name = "codrec",nullable = false)
	private RecompensaEntity recompensa;
}
