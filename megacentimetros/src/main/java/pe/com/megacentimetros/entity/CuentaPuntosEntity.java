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
@Entity(name = "CuentaPuntosEntity")
@Table(name = "cuentapuntos")
public class CuentaPuntosEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codcpun")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "salcpun", nullable = false)
	private Integer saldo;
	@Column(name = "feccpun", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaafiliacion;
	@ManyToOne
	@JoinColumn(name = "codcli",nullable = false)
	private ClienteEntity cliente;
	@ManyToOne
	@JoinColumn(name = "codniv",nullable = false)
	private NivelFidelizacionEntity nivelfidelizacion;
}
