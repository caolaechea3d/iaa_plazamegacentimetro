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
@Entity(name = "ClienteEntity")
@Table(name = "cliente")
public class ClienteEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codcli")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomcli",length = 50, nullable = true)
	private String nombre;
	@Column(name = "apepcli",length = 40, nullable = true)
	private String apellidopaterno;
	@Column(name = "apemcli",length = 40, nullable = true)
	private String apellidomaterno;
	@Column(name = "razcli",length = 150, nullable = true)
	private String razonsocial;
	@Column(name = "doccli",length = 20, nullable = false)
	private String numerodocumento;
	@Column(name = "feccli", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaingreso;
	@Column(name = "naccli",length = 30, nullable = true)
	private String nacionalidad;
	@Column(name = "dircli",length = 200, nullable = false)
	private String direccion;
	@Column(name = "telcli",length = 15, nullable = true)
	private String telefono;
	@Column(name = "celcli",length = 15, nullable = true)
	private String celular;
	@Column(name = "corcli",length = 100, nullable = true)
	private String correo;
	@Column(name = "descli",length = 300, nullable = true)
	private String descripcion;
	@Column(name = "estcli", nullable = false)
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
	@JoinColumn(name = "coddis",nullable = false)
	private DistritoEntity distrito;
	
	@ManyToOne
	@JoinColumn(name = "codsex",nullable = true)
	private SexoEntity sexo;
	
	@ManyToOne
	@JoinColumn(name = "codtipd",nullable = false)
	private TipoDocumentoEntity tipodocumento;
	
	@ManyToOne
	@JoinColumn(name = "codtcli",nullable = false)
	private TipoClienteEntity tipocliente;
}
