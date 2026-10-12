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
@Entity(name = "StockAlmacenEntity")
@Table(name = "stockalmacen")
@IdClass(StockAlmacenId.class)
public class StockAlmacenEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "codpro",nullable = false)
	private ProductoEntity producto;
	@Id
	@ManyToOne
	@JoinColumn(name = "codalm",nullable = false)
	private AlmacenEntity almacen;
	@Column(name = "cansalm", nullable = false)
	private Integer cantidad;
	@Column(name = "minsalm", nullable = false)
	private Integer stockminimo;
	@Column(name = "fecsalm", nullable = true, insertable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaactualizacion;
}
