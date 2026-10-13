-- --------------------------------------------
-- BASE DE DATOS INTEGRADA: Plaza Megacentímetros S.A.C.
-- Caso de Estudio - Sistema Integrado de Gestión Empresarial
-- Versión: 2.3
-- --------------------------------------------

DROP DATABASE IF EXISTS bdmegacentimetros;
CREATE DATABASE bdmegacentimetros
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bdmegacentimetros;

-- --------------------------------------------
-- COLUMNAS DE AUDITORÍA POR FILA (aplicadas a TODAS las tablas)
--   estado : estado (activo/inactivo).
--   usucre : usuario que creó el registro   
--   feccre : fecha/hora de creación      
--   usuact : último usuario que lo modificó  
--   fecact : fecha/hora de la última edición 
-- --------------------------------------------

-- --------------------------------------------
-- TABLAS SIMPLES / CATÁLOGOS
-- --------------------------------------------
CREATE TABLE distrito(
    coddis INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomdis VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej: Lima, Miraflores, San Isidro',
    desdis VARCHAR(300) NULL COMMENT 'Descripción del distrito',
    estdis BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Distritos geográficos donde se ubican clientes, proveedores, sucursales y almacenes';

CREATE TABLE sexo(
    codsex INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomsex VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: Femenino, Masculino',
    dessex VARCHAR(300) NULL COMMENT 'Descripción del sexo',
    estsex BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Sexo de la persona';

CREATE TABLE tipodocumento(
    codtipd INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtipd VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: DNI, RUC, Carnet de Extranjería',
    destipd VARCHAR(300) NULL COMMENT 'Descripción del tipo de documento',
    esttipd BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Tipo de documento de identificación (DNI, RUC, CE)';

CREATE TABLE tipocliente(
    codtcli INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtcli VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: Mayorista, Minorista',
    destcli VARCHAR(300) NULL COMMENT 'Descripción del tipo de cliente',
    esttcli BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Segmenta al cliente (mayorista/minorista) para atenderlo distinto';

CREATE TABLE tipocomprobante(
    codtcom INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtcom VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: Factura, Boleta',
    destcom VARCHAR(300) NULL COMMENT 'Descripción del tipo de comprobante',
    esttcom BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Tipo de comprobante de pago (factura, boleta)';

CREATE TABLE categoriaproducto(
    codcat INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomcat VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej: Abarrotes, Bebidas, Limpieza',
    descat VARCHAR(300) NULL COMMENT 'Descripción de la categoría de producto',
    estcat BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Clasifica el producto por categoría';

CREATE TABLE marcaproducto(
    codmar INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nommar VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej: Marca A, Marca B',
    desmar VARCHAR(300) NULL COMMENT 'Descripción de la marca',
    estmar BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Clasifica el producto por marca';

CREATE TABLE tipoempaque(
    codtemp INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtemp VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: Caja, Bolsa, Botella',
    destemp VARCHAR(300) NULL COMMENT 'Descripción del tipo de empaque',
    esttemp BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Tipos de empaque de los productos';

CREATE TABLE unidadmedida(
    codumed INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomumed VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: Unidad, Kilogramo, Litro',
    abrumed VARCHAR(10) NOT NULL UNIQUE COMMENT 'Abreviatura impresa en comprobantes. Ej: UND, KG, LT',  -- abreviatura que se imprime en comprobantes
    desumed VARCHAR(300) NULL COMMENT 'Descripción de la unidad de medida',
    estumed BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Unidades en que se vende un producto (UND, KG, LT)';

CREATE TABLE tipoalmacen(
    codtalm INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtalm VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: CENTRAL, REGIONAL, TRANSITO',
    destalm VARCHAR(300) NULL COMMENT 'Descripción del tipo de almacén',
    esttalm BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Tipos de almacén';

CREATE TABLE estadooperativo(
    codeope INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomeope VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: Operativo, Mantenimiento, Cerrado',
    deseope VARCHAR(300) NULL COMMENT 'Descripción del estado',
    esteope BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Estado operativo general de sucursales y almacenes';

CREATE TABLE tipoempleado(
    codtiemp INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtiemp VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: Administrativo, Operativo',
    destiemp VARCHAR(300) NULL COMMENT 'Descripción del tipo de empleado',
    esttiemp BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Diferencia entre personal administrativo y operativo';

CREATE TABLE cargo(
    codcarg INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomcarg VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej: Vendedor, Almacenero, Chofer, Administrador',
    descarg VARCHAR(300) NULL COMMENT 'Descripción del cargo y sus funciones',
    estcarg BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    codtiemp INT NOT NULL COMMENT 'FK a tipoempleado', 
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    FOREIGN KEY (codtiemp) REFERENCES tipoempleado(codtiemp)
)ENGINE=InnoDB COMMENT='Puesto o función del empleado, define si es administrativo u operativo';

CREATE TABLE estadoasistencia(
    codeasis INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomeasis VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: PUNTUAL, TARDANZA, FALTA, JUSTIFICADO',
    deseasis VARCHAR(300) NULL COMMENT 'Descripción del estado',
    esteasis BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Estados posibles de la asistencia diaria';

CREATE TABLE estadoevaluacion(
    codeeva INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomeeva VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: PENDIENTE, APROBADO, RECHAZADO',
    deseeva VARCHAR(300) NULL COMMENT 'Descripción del estado de evaluación',
    esteeva BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Resultado de la evaluación del proveedor';

CREATE TABLE tipotransporte(
    codttra INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomttra VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: Furgón, Camión, Camioneta',
    desttra VARCHAR(300) NULL COMMENT 'Descripción del tipo de transporte',
    estttra BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Clasifica el tipo de vehículo de reparto';

CREATE TABLE estadotransporte(
    codetra INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nometra VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: Disponible, En Ruta, Mantenimiento',
    desetra VARCHAR(300) NULL COMMENT 'Descripción del estado del transporte',
    estetra BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Disponibilidad de la unidad de transporte';

CREATE TABLE tipoincidencia(
    codtinc INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtinc VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej: Retraso, Daño de mercadería, Dirección errada',
    destinc VARCHAR(300) NULL COMMENT 'Descripción del tipo de incidencia',
    esttinc BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Clasificación de las incidencias de despacho';

CREATE TABLE metodopago(
    codmpag INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nommpag VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: Efectivo, Tarjeta, Transferencia, Yape/Plin',
    desmpag VARCHAR(300) NULL COMMENT 'Descripción del método de pago',
    estmpag BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Método utilizado para el pago';

CREATE TABLE estadopago(
    codepag INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomepag VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: Pendiente, Realizado, Anulado',
    desepag VARCHAR(300) NULL COMMENT 'Descripción del estado de pago',
    estepag BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Estado de la transacción de pago';

CREATE TABLE tipomovimiento(
    codtmov INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomtmov VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: ENTRADA_COMPRA, SALIDA_VENTA, AJUSTE',
    destmov VARCHAR(300) NULL COMMENT 'Descripción del tipo de movimiento',
    sigtmov TINYINT NOT NULL COMMENT 'Signo sobre el stock: 1 = suma, -1 = resta',
    esttmov BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (sigtmov IN (1,-1))
)ENGINE=InnoDB COMMENT='Tipo de movimiento de inventario (entrada, salida, ajuste) con su signo';

CREATE TABLE rol(
    codrol INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomrol VARCHAR(40) NOT NULL UNIQUE COMMENT 'Ej: Administrador, Vendedor, Almacenero, Contador',
    desrol VARCHAR(300) NULL COMMENT 'Descripción del rol y su alcance',
    estrol BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Roles de acceso al sistema';

CREATE TABLE modulo(
    codmod INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nommod VARCHAR(50) NOT NULL UNIQUE COMMENT 'Ej: Ventas, Compras, Inventario',
    desmod VARCHAR(300) NULL COMMENT 'Descripción del módulo',
    rutmod VARCHAR(100) NULL COMMENT 'Ruta o pantalla del módulo',
    estmod BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Módulos del sistema sobre los que se asignan permisos';

CREATE TABLE capacitacion(
    codcap INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomcap VARCHAR(100) NOT NULL COMMENT 'Nombre de la capacitación',
    descap TEXT NULL COMMENT 'Descripción de la capacitación',
    inicap DATE NOT NULL COMMENT 'Fecha de inicio',
    fincap DATE NOT NULL COMMENT 'Fecha de fin',
    horcap INT NOT NULL COMMENT 'Horas lectivas',
    estcap BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (fincap >= inicap),
    CHECK (horcap > 0)
)ENGINE=InnoDB COMMENT='Cursos y capacitaciones disponibles';

CREATE TABLE campana(
    codcam INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomcam VARCHAR(100) NOT NULL COMMENT 'Nombre de la campaña',
    descam TEXT NULL COMMENT 'Descripción de la campaña',
    inicam DATE NOT NULL COMMENT 'Fecha de inicio de la campaña',
    fincam DATE NOT NULL COMMENT 'Fecha de fin de la campaña',
    estcam BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (fincam >= inicam)
)ENGINE=InnoDB COMMENT='Campañas de marketing';

CREATE TABLE recompensa(
    codrec INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomrec VARCHAR(100) NOT NULL UNIQUE COMMENT 'Nombre de la recompensa',
    desrec TEXT NULL COMMENT 'Descripción de la recompensa',
    punrec INT NOT NULL COMMENT 'Puntos necesarios para canjearla',
    estrec BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (punrec > 0)
)ENGINE=InnoDB COMMENT='Premios canjeables con puntos de fidelización';

CREATE TABLE nivelfidelizacion(
    codniv INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomniv VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: BRONCE, PLATA, ORO',
    minniv INT NOT NULL UNIQUE COMMENT 'Puntaje mínimo para alcanzar el nivel', 
    desniv VARCHAR(300) NULL COMMENT 'Beneficios del nivel', 
    estniv BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (minniv >= 0)
)ENGINE=InnoDB COMMENT='Niveles del programa de puntos (Bronce, Plata, Oro) con su puntaje mínimo';

CREATE TABLE estadopedido(
    codeped INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomeped VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: PENDIENTE, CONFIRMADO, PAGADO, DESPACHADO, ANULADO',
    deseped VARCHAR(300) NULL COMMENT 'Descripción del estado',
    esteped BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Etapas de seguimiento de un pedido';

CREATE TABLE estadoenvio(
    codeenv INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomeenv VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: PREPARACION, EN RUTA, ENTREGADO, INCIDENCIA, ANULADO',
    deseenv VARCHAR(300) NULL COMMENT 'Descripción del estado',
    esteenv BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Estado del envío o despacho';

CREATE TABLE estadoordencompra(
    codeocom INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomeocom VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: EMITIDA, APROBADA, RECIBIDA PARCIAL, RECIBIDA, ANULADA',
    deseocom VARCHAR(300) NULL COMMENT 'Descripción del estado',
    esteocom BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Estado de la orden de compra a proveedor';

CREATE TABLE estadocapacitacion(
    codecap INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomecap VARCHAR(30) NOT NULL UNIQUE COMMENT 'Ej: INSCRITO, APROBADO, DESAPROBADO, RETIRADO',
    desecap VARCHAR(300) NULL COMMENT 'Descripción del estado',
    estecap BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)'
)ENGINE=InnoDB COMMENT='Estado de un empleado dentro de una capacitación';

CREATE TABLE sucursal(
    codsuc INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomsuc VARCHAR(100) NOT NULL UNIQUE COMMENT 'Nombre de la sucursal',
    dirsuc VARCHAR(200) NOT NULL COMMENT 'Dirección de la sucursal',
    telsuc VARCHAR(15) NULL COMMENT 'Teléfono de contacto de la sucursal',  
    dessuc VARCHAR(300) NULL COMMENT 'Descripción u observaciones de la sucursal',
    estsuc BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    coddis INT NOT NULL COMMENT 'FK a distrito',
    codeope INT NOT NULL COMMENT 'FK a estadooperativo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codeope) REFERENCES estadooperativo(codeope)
)ENGINE=InnoDB COMMENT='Puntos de venta o sucursales de la empresa';
 
CREATE TABLE almacen(
    codalm INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomalm VARCHAR(100) NOT NULL UNIQUE COMMENT 'Nombre del almacén',
    diralm VARCHAR(200) NOT NULL COMMENT 'Dirección del almacén',
    capalm INT NOT NULL COMMENT 'Capacidad del almacén',
    coddis INT NOT NULL COMMENT 'FK a distrito',
    codtalm INT NOT NULL COMMENT 'FK a tipoalmacen',
    codsuc INT NOT NULL COMMENT 'FK a sucursal',
    codeope INT NOT NULL COMMENT 'FK a estadooperativo',
    desalm VARCHAR(300) NULL COMMENT 'Descripción u observaciones del almacén',
    estalm BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (capalm > 0),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codtalm) REFERENCES tipoalmacen(codtalm),
    FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc),
    FOREIGN KEY (codeope) REFERENCES estadooperativo(codeope)
)ENGINE=InnoDB COMMENT='Almacenes físicos vinculados a sucursales';
 
CREATE TABLE empleado(
    codemp INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomemp VARCHAR(50) NOT NULL COMMENT 'Nombres del empleado',
    apepemp VARCHAR(40) NOT NULL COMMENT 'Apellido paterno',
    apememp VARCHAR(40) NOT NULL COMMENT 'Apellido materno',
    docemp VARCHAR(20) NOT NULL UNIQUE COMMENT 'Número de documento de identidad',
    feccemp DATE NOT NULL COMMENT 'Fecha de contratación',
    nacemp VARCHAR(30) NOT NULL COMMENT 'Nacionalidad',
    diremp VARCHAR(200) NOT NULL COMMENT 'Dirección domiciliaria',
    telemp VARCHAR(15) NULL COMMENT 'Teléfono fijo',
    celemp VARCHAR(15) NOT NULL COMMENT 'Celular',
    coremp VARCHAR(100) NOT NULL UNIQUE COMMENT 'Correo electrónico',
    desemp VARCHAR(300) NULL COMMENT 'Descripción u observaciones del empleado',
    estemp BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    coddis INT NOT NULL COMMENT 'FK a distrito',
    codsex INT NOT NULL COMMENT 'FK a sexo',
    codtipd INT NOT NULL COMMENT 'FK a tipodocumento',
    codcarg INT NOT NULL COMMENT 'FK a cargo',  
    codsuc INT NOT NULL COMMENT 'FK a sucursal',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codsex) REFERENCES sexo(codsex),
    FOREIGN KEY (codtipd) REFERENCES tipodocumento(codtipd),
    FOREIGN KEY (codcarg) REFERENCES cargo(codcarg),
    FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc)
)ENGINE=InnoDB COMMENT='Personal administrativo y operativo';
 
CREATE TABLE cliente(
    codcli INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomcli VARCHAR(50) NULL COMMENT 'Nombres (solo clientes persona)',  
    apepcli VARCHAR(40) NULL COMMENT 'Apellido paterno (solo persona)',  
    apemcli VARCHAR(40) NULL COMMENT 'Apellido materno (solo persona)',  
    razcli VARCHAR(150) NULL COMMENT 'Razón social (solo clientes empresa)',  
    doccli VARCHAR(20) NOT NULL UNIQUE COMMENT 'Número de documento (DNI o RUC)',
    feccli TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de registro del cliente',
    naccli VARCHAR(30) NULL COMMENT 'Nacionalidad (solo persona)',  
    dircli VARCHAR(200) NOT NULL COMMENT 'Dirección del cliente',
    telcli VARCHAR(15) NULL COMMENT 'Teléfono fijo',
    celcli VARCHAR(15) NULL COMMENT 'Celular',
    corcli VARCHAR(100) NULL UNIQUE COMMENT 'Correo electrónico',
    descli VARCHAR(300) NULL COMMENT 'Descripción u observaciones del cliente',
    estcli BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    coddis INT NOT NULL COMMENT 'FK a distrito',
    codsex INT NULL COMMENT 'FK a sexo',      
    codtipd INT NOT NULL COMMENT 'FK a tipodocumento',
    codtcli INT NOT NULL COMMENT 'FK a tipocliente',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (razcli IS NOT NULL OR (nomcli IS NOT NULL AND apepcli IS NOT NULL)),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codsex) REFERENCES sexo(codsex),
    FOREIGN KEY (codtipd) REFERENCES tipodocumento(codtipd),
    FOREIGN KEY (codtcli) REFERENCES tipocliente(codtcli)
)ENGINE=InnoDB COMMENT='Clientes registrados, personas o empresas (minoristas/mayoristas)';

CREATE TABLE proveedor(
    codprov INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomprov VARCHAR(50) NULL COMMENT 'Nombres (proveedor persona)',
    apepprov VARCHAR(40) NULL COMMENT 'Apellido paterno',
    apemprov VARCHAR(40) NULL COMMENT 'Apellido materno',
    razprov VARCHAR(150) NULL COMMENT 'Razón social (proveedor empresa)',
    rucprov CHAR(11) NOT NULL UNIQUE COMMENT 'RUC de 11 dígitos',
    corprov VARCHAR(100) NULL COMMENT 'Correo electrónico',
    telprov VARCHAR(15) NULL COMMENT 'Teléfono fijo',
    celprov VARCHAR(15) NULL COMMENT 'Celular',
    fecprov TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de registro del proveedor',
    desprov VARCHAR(300) NULL COMMENT 'Descripción u observaciones del proveedor',
    estprov BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    dirprov VARCHAR(200) NOT NULL COMMENT 'Dirección del proveedor',
    coddis INT NOT NULL COMMENT 'FK a distrito',
    codeeva INT NOT NULL COMMENT 'FK a estadoevaluacion',  
    feceva DATE NULL COMMENT 'Fecha de evaluación, NULL mientras esté pendiente', 
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (CHAR_LENGTH(rucprov) = 11),
    CHECK (razprov IS NOT NULL OR nomprov IS NOT NULL),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codeeva) REFERENCES estadoevaluacion(codeeva)
)ENGINE=InnoDB COMMENT='Proveedores evaluados y registrados de la empresa';

CREATE TABLE producto(
    codpro INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    skupro VARCHAR(30) NOT NULL UNIQUE COMMENT 'Código SKU del negocio (etiquetas, lector de barras)',  
    nompro VARCHAR(100) NOT NULL COMMENT 'Nombre del producto',
    despro TEXT NULL COMMENT 'Descripción del producto',
    fecpro TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de registro del producto',
    prepro DECIMAL(10,2) NOT NULL COMMENT 'Precio de venta',  
    cospro DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT 'Costo referencial de compra', 
    estpro BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    codcat INT NOT NULL COMMENT 'FK a categoriaproducto',
    codmar INT NOT NULL COMMENT 'FK a marcaproducto',
    codtemp INT NOT NULL COMMENT 'FK a tipoempaque',
    codumed INT NOT NULL COMMENT 'FK a unidadmedida', 
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (prepro >= 0),
    CHECK (cospro >= 0),            
    FOREIGN KEY (codcat) REFERENCES categoriaproducto(codcat),
    FOREIGN KEY (codmar) REFERENCES marcaproducto(codmar),
    FOREIGN KEY (codtemp) REFERENCES tipoempaque(codtemp),
    FOREIGN KEY (codumed) REFERENCES unidadmedida(codumed)       
)ENGINE=InnoDB COMMENT='Catálogo general de productos';
 
CREATE TABLE stockalmacen(
    codpro INT NOT NULL COMMENT 'FK a producto',
    codalm INT NOT NULL COMMENT 'FK a almacen',
    cansalm INT NOT NULL DEFAULT 0 COMMENT 'Cantidad disponible en el almacén',
    minsalm INT NOT NULL DEFAULT 0 COMMENT 'Stock mínimo antes de reponer',
    fecsalm TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha de la última actualización del stock',
    estsalm BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    PRIMARY KEY (codpro, codalm),
    CHECK (cansalm >= 0),
    CHECK (minsalm >= 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm)
)ENGINE=InnoDB COMMENT='Control de stock por producto y almacén';
 
-- --------------------------------------------
-- TABLAS TRANSACCIONALES
-- --------------------------------------------
 
CREATE TABLE trasladoalmacen(
    codtrasl INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fectrasl DATETIME NOT NULL COMMENT 'Fecha del traslado',
    esttrasl VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE' COMMENT 'Estado: PENDIENTE, EN TRANSITO, RECIBIDO o ANULADO',
    codalmori INT NOT NULL COMMENT 'Almacén de origen',
    codalmdes INT NOT NULL COMMENT 'Almacén de destino',
    codemp INT NOT NULL COMMENT 'FK a empleado',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (esttrasl IN ('PENDIENTE','EN TRANSITO','RECIBIDO','ANULADO')),
    CHECK (codalmori <> codalmdes),
    FOREIGN KEY (codalmori) REFERENCES almacen(codalm),
    FOREIGN KEY (codalmdes) REFERENCES almacen(codalm),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
)ENGINE=InnoDB COMMENT='Traslados de inventario entre almacenes';
 
CREATE TABLE detalletraslado(
    coddtrasl INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    candtrasl INT NOT NULL COMMENT 'Cantidad trasladada',
    codpro INT NOT NULL COMMENT 'FK a producto',
    codtrasl INT NOT NULL COMMENT 'FK a trasladoalmacen',
    estdtrasl BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (candtrasl > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codtrasl) REFERENCES trasladoalmacen(codtrasl),
    UNIQUE (codtrasl, codpro)
)ENGINE=InnoDB COMMENT='Detalle de productos en un traslado';
 
CREATE TABLE movimientoinventario(
    codminv INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecminv TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora del movimiento',
    canminv INT NOT NULL COMMENT 'Cantidad movida (siempre positiva, el signo lo da el tipo)',
    refminv VARCHAR(50) NULL COMMENT 'Documento de referencia del movimiento',
    codpro INT NOT NULL COMMENT 'FK a producto',
    codalm INT NOT NULL COMMENT 'FK a almacen',
    codtmov INT NOT NULL COMMENT 'FK a tipomovimiento',
    codemp INT NULL COMMENT 'FK a empleado',
    estminv BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (canminv > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codtmov) REFERENCES tipomovimiento(codtmov),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
)ENGINE=InnoDB COMMENT='Kardex: historial de movimientos de inventario';
 
CREATE TABLE campanasegmento(
    codcam INT NOT NULL COMMENT 'FK a campana',
    codtcli INT NOT NULL COMMENT 'FK a tipocliente',
    estcseg BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    PRIMARY KEY (codcam, codtcli),
    FOREIGN KEY (codcam) REFERENCES campana(codcam),
    FOREIGN KEY (codtcli) REFERENCES tipocliente(codtcli)
)ENGINE=InnoDB COMMENT='Segmentos de cliente a los que se dirige cada campaña';
 
CREATE TABLE promocion(
    codprom INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomprom VARCHAR(100) NOT NULL COMMENT 'Nombre de la promoción',
    desprom VARCHAR(300) NULL COMMENT 'Descripción de la promoción',
    tipprom VARCHAR(10) NOT NULL COMMENT 'Tipo de descuento: PORCENTAJE o MONTO',
    valprom DECIMAL(10,2) NOT NULL COMMENT 'Valor del descuento (porcentaje o monto)',
    iniprom DATE NOT NULL COMMENT 'Inicio de vigencia',
    finprom DATE NOT NULL COMMENT 'Fin de vigencia',
    estprom BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    codcam INT NOT NULL COMMENT 'FK a campana',
    codpro INT NULL COMMENT 'FK a producto',
    codcat INT NULL COMMENT 'FK a categoriaproducto',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (tipprom IN ('PORCENTAJE','MONTO')),
    CHECK (valprom > 0),
    CHECK (tipprom <> 'PORCENTAJE' OR valprom <= 100),
    CHECK (finprom >= iniprom),
    FOREIGN KEY (codcam) REFERENCES campana(codcam),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codcat) REFERENCES categoriaproducto(codcat)
)ENGINE=InnoDB COMMENT='Promociones (porcentaje o monto) asociadas a una campaña';
 
CREATE TABLE pedido(
    codped INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecped TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha del pedido',
    totped DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT 'Total del pedido',
    codeped INT NOT NULL DEFAULT 1 COMMENT 'FK a estadopedido',
    codcli INT NOT NULL COMMENT 'FK a cliente',
    codemp INT NOT NULL COMMENT 'FK a empleado',
    codsuc INT NOT NULL COMMENT 'FK a sucursal',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (totped >= 0),
    FOREIGN KEY (codcli) REFERENCES cliente(codcli),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc),
    FOREIGN KEY (codeped) REFERENCES estadopedido(codeped)
)ENGINE=InnoDB COMMENT='Pedidos de venta realizados por clientes';
 
CREATE TABLE detallepedido(
    coddped INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    candped INT NOT NULL COMMENT 'Cantidad pedida',
    predped DECIMAL(10,2) NOT NULL COMMENT 'Precio unitario aplicado',
    desdped DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT 'Descuento aplicado',
    subdped DECIMAL(10,2) NOT NULL COMMENT 'Subtotal de la línea',
    codped INT NOT NULL COMMENT 'FK a pedido',
    codpro INT NOT NULL COMMENT 'FK a producto',
    codalm INT NOT NULL COMMENT 'FK a almacen',
    codprom INT NULL COMMENT 'FK a promocion',
    estdped BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (candped > 0),
    CHECK (predped >= 0),
    CHECK (desdped >= 0),
    CHECK (subdped >= 0),
    FOREIGN KEY (codped) REFERENCES pedido(codped),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codprom) REFERENCES promocion(codprom)
)ENGINE=InnoDB COMMENT='Detalle de los productos por pedido';
 
CREATE TABLE facturacion(
    codfac INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    serfac VARCHAR(4) NOT NULL COMMENT 'Serie del comprobante',
    numfac INT NOT NULL COMMENT 'Número correlativo',
    fecfac TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de emisión',
    subfac DECIMAL(10,2) NOT NULL COMMENT 'Subtotal sin IGV',
    igvfac DECIMAL(10,2) NOT NULL COMMENT 'IGV',
    totfac DECIMAL(10,2) NOT NULL COMMENT 'Total con IGV',
    estfac VARCHAR(20) NOT NULL DEFAULT 'EMITIDA' COMMENT 'Estado: EMITIDA, PAGADA o ANULADA',
    codped INT NOT NULL UNIQUE COMMENT 'FK a pedido',
    codtcom INT NOT NULL COMMENT 'FK a tipocomprobante',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (subfac >= 0 AND igvfac >= 0 AND totfac >= 0),
    CHECK (estfac IN ('EMITIDA','PAGADA','ANULADA')),
    UNIQUE (codtcom, serfac, numfac),
    FOREIGN KEY (codped) REFERENCES pedido(codped),
    FOREIGN KEY (codtcom) REFERENCES tipocomprobante(codtcom)
)ENGINE=InnoDB COMMENT='Comprobantes emitidos por ventas';
 
CREATE TABLE ordencompra(
    codocom INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecocom TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de emisión de la orden',
    codeocom INT NOT NULL DEFAULT 1 COMMENT 'FK a estadoordencompra',
    fecentocom DATE NOT NULL COMMENT 'Fecha de entrega pactada',
    conocom VARCHAR(300) NULL COMMENT 'Condiciones de entrega',
    totocom DECIMAL(12,2) NOT NULL DEFAULT 0 COMMENT 'Total de la orden',
    codprov INT NOT NULL COMMENT 'FK a proveedor',
    codalm INT NOT NULL COMMENT 'FK a almacen',
    codemp INT NOT NULL COMMENT 'FK a empleado',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (totocom >= 0),
    FOREIGN KEY (codprov) REFERENCES proveedor(codprov),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codeocom) REFERENCES estadoordencompra(codeocom)
)ENGINE=InnoDB COMMENT='Órdenes de compra a proveedores';
 
CREATE TABLE detalleordencompra(
    coddocom INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    candocom INT NOT NULL COMMENT 'Cantidad ordenada',
    cosdocom DECIMAL(10,2) NOT NULL COMMENT 'Costo unitario acordado',
    subdocom DECIMAL(12,2) NOT NULL COMMENT 'Cantidad x costo, guardado para que no cambie si se edita el costo', 
    codocom INT NOT NULL COMMENT 'FK a ordencompra',
    codpro INT NOT NULL COMMENT 'FK a producto',
    estdocom BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (candocom > 0),
    CHECK (cosdocom >= 0),
    CHECK (subdocom >= 0),         
    FOREIGN KEY (codocom) REFERENCES ordencompra(codocom),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    UNIQUE (codocom, codpro)
)ENGINE=InnoDB COMMENT='Detalle de productos en una orden de compra';
 
CREATE TABLE guiaingreso(
    codgin INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecgin TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de ingreso al almacén',
    estgin VARCHAR(20) NOT NULL DEFAULT 'REGISTRADA' COMMENT 'Estado: REGISTRADA, CONFORME, OBSERVADA o ANULADA',
    codocom INT NOT NULL COMMENT 'FK a ordencompra',
    codalm INT NOT NULL COMMENT 'FK a almacen',
    codemp INT NOT NULL COMMENT 'FK a empleado',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (estgin IN ('REGISTRADA','CONFORME','OBSERVADA','ANULADA')),
    FOREIGN KEY (codocom) REFERENCES ordencompra(codocom),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
)ENGINE=InnoDB COMMENT='Guías de ingreso de mercadería a almacén contra una orden de compra';
 
CREATE TABLE detalleguiaingreso(
    coddgin INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    candgin INT NOT NULL COMMENT 'Cantidad recibida',
    codpro INT NOT NULL COMMENT 'FK a producto',
    codgin INT NOT NULL COMMENT 'FK a guiaingreso',
    estdgin BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (candgin > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codgin) REFERENCES guiaingreso(codgin),
    UNIQUE (codgin, codpro)
)ENGINE=InnoDB COMMENT='Detalle de productos recibidos en una guía de ingreso';
 
CREATE TABLE facturaproveedor(
    codfprov INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    numfprov VARCHAR(20) NOT NULL COMMENT 'Número de la factura del proveedor',
    fecfprov DATE NOT NULL COMMENT 'Fecha de emisión',
    venfprov DATE NOT NULL COMMENT 'Fecha de vencimiento',
    totfprov DECIMAL(12,2) NOT NULL COMMENT 'Total de la factura',
    estfprov VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE' COMMENT 'Estado: PENDIENTE, PAGADA PARCIAL, PAGADA o ANULADA',
    codocom INT NOT NULL COMMENT 'FK a ordencompra',
    codprov INT NOT NULL COMMENT 'FK a proveedor',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (totfprov >= 0),
    CHECK (venfprov >= fecfprov),
    CHECK (estfprov IN ('PENDIENTE','PAGADA PARCIAL','PAGADA','ANULADA')),
    UNIQUE (codprov, numfprov),
    FOREIGN KEY (codocom) REFERENCES ordencompra(codocom),
    FOREIGN KEY (codprov) REFERENCES proveedor(codprov)
)ENGINE=InnoDB COMMENT='Facturas recibidas de proveedores';
 
CREATE TABLE transporte(
    codtra INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    platra VARCHAR(10) NOT NULL UNIQUE COMMENT 'Placa del vehículo',
    captra DECIMAL(10,2) NOT NULL COMMENT 'Capacidad de carga',
    destra VARCHAR(300) NULL COMMENT 'Descripción u observaciones del vehículo',
    esttra BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',  
    codttra INT NOT NULL COMMENT 'FK a tipotransporte',
    codetra INT NOT NULL COMMENT 'FK a estadotransporte', 
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (captra > 0),
    FOREIGN KEY (codttra) REFERENCES tipotransporte(codttra),
    FOREIGN KEY (codetra) REFERENCES estadotransporte(codetra)     
)ENGINE=InnoDB COMMENT='Vehículos de transporte y despacho';
 
CREATE TABLE despacho(
    coddes INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    numdes VARCHAR(20) NOT NULL UNIQUE COMMENT 'Número del despacho',
    fecdes DATETIME NOT NULL COMMENT 'Fecha programada del despacho',
    dirdes VARCHAR(200) NOT NULL COMMENT 'Dirección de entrega',
    codeenv INT NOT NULL DEFAULT 1 COMMENT 'FK a estadoenvio',
    codfac INT NOT NULL COMMENT 'FK a facturacion',
    codemp INT NOT NULL COMMENT 'FK a empleado',
    codtra INT NOT NULL COMMENT 'FK a transporte',
    coddis INT NOT NULL COMMENT 'FK a distrito',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    FOREIGN KEY (codfac) REFERENCES facturacion(codfac),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codtra) REFERENCES transporte(codtra),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codeenv) REFERENCES estadoenvio(codeenv)
)ENGINE=InnoDB COMMENT='Gestión de despachos de comprobantes de venta';
 
CREATE TABLE detalledespacho(
    coddetdes INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    candetdes INT NOT NULL COMMENT 'Cantidad despachada',
    codpro INT NOT NULL COMMENT 'FK a producto',
    codalm INT NOT NULL COMMENT 'FK a almacen',
    coddes INT NOT NULL COMMENT 'FK a despacho',
    estdetdes BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (candetdes > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (coddes) REFERENCES despacho(coddes)
)ENGINE=InnoDB COMMENT='Detalle de productos por despacho';
 
CREATE TABLE incidenciadespacho(
    codinc INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecinc TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de la incidencia',
    desinc TEXT NOT NULL COMMENT 'Descripción de lo ocurrido',
    accinc TEXT NULL COMMENT 'Acción tomada',
    estinc VARCHAR(20) NOT NULL DEFAULT 'ABIERTA' COMMENT 'Estado: ABIERTA, EN PROCESO o RESUELTA',
    coddes INT NOT NULL COMMENT 'FK a despacho',
    codtinc INT NOT NULL COMMENT 'FK a tipoincidencia',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (estinc IN ('ABIERTA','EN PROCESO','RESUELTA')),
    FOREIGN KEY (coddes) REFERENCES despacho(coddes),
    FOREIGN KEY (codtinc) REFERENCES tipoincidencia(codtinc)
)ENGINE=InnoDB COMMENT='Incidencias ocurridas durante un despacho';
 
CREATE TABLE asistencia(
    codasi INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecasi DATE NOT NULL COMMENT 'Fecha de asistencia',
    entasi TIME NULL COMMENT 'Hora de entrada',
    salasi TIME NULL COMMENT 'Hora de salida',
    codeasis INT NOT NULL COMMENT 'FK a estadoasistencia',
    codemp INT NOT NULL COMMENT 'FK a empleado',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (salasi IS NULL OR entasi IS NULL OR salasi > entasi),
    FOREIGN KEY (codeasis) REFERENCES estadoasistencia(codeasis),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    UNIQUE (codemp, fecasi)
)ENGINE=InnoDB COMMENT='Control de asistencia diaria de empleados';
 
CREATE TABLE empleadocapacitacion(
    codemp INT NOT NULL COMMENT 'FK a empleado',
    codcap INT NOT NULL COMMENT 'FK a capacitacion',
    notecap DECIMAL(5,2) NULL COMMENT 'Nota obtenida (0 a 20)',
    codecap INT NOT NULL DEFAULT 1 COMMENT 'FK a estadocapacitacion',
    feccomp DATE NULL COMMENT 'Fecha en que este empleado terminó, NULL mientras siga inscrito',  
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    PRIMARY KEY (codemp, codcap),
    CHECK (notecap IS NULL OR (notecap >= 0 AND notecap <= 20)),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codcap) REFERENCES capacitacion(codcap),
    FOREIGN KEY (codecap) REFERENCES estadocapacitacion(codecap)
)ENGINE=InnoDB COMMENT='Relación de empleados capacitados, con nota y estado';
 
CREATE TABLE pagocliente(
    codpcli INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecpcli TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha del pago',
    monpcli DECIMAL(10,2) NOT NULL COMMENT 'Monto pagado',
    numpcli VARCHAR(50) NULL COMMENT 'Número de operación',
    codfac INT NOT NULL COMMENT 'FK a facturacion',
    codmpag INT NOT NULL COMMENT 'FK a metodopago',
    codepag INT NOT NULL COMMENT 'FK a estadopago',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (monpcli > 0),
    FOREIGN KEY (codfac) REFERENCES facturacion(codfac),
    FOREIGN KEY (codmpag) REFERENCES metodopago(codmpag),
    FOREIGN KEY (codepag) REFERENCES estadopago(codepag)
)ENGINE=InnoDB COMMENT='Pagos recibidos de clientes contra una factura de venta';
 
CREATE TABLE pagoproveedor(
    codpprov INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecpprov TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha del pago',
    monpprov DECIMAL(12,2) NOT NULL COMMENT 'Monto pagado',
    numpprov VARCHAR(50) NULL COMMENT 'Número de operación',
    codfprov INT NOT NULL COMMENT 'FK a facturaproveedor',
    codmpag INT NOT NULL COMMENT 'FK a metodopago',
    codepag INT NOT NULL COMMENT 'FK a estadopago',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (monpprov > 0),
    FOREIGN KEY (codfprov) REFERENCES facturaproveedor(codfprov),
    FOREIGN KEY (codmpag) REFERENCES metodopago(codmpag),
    FOREIGN KEY (codepag) REFERENCES estadopago(codepag)
)ENGINE=InnoDB COMMENT='Pagos realizados a proveedores contra su factura';
 
CREATE TABLE usuario(
    codusu INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    nomusu VARCHAR(50) NOT NULL UNIQUE COMMENT 'Nombre de usuario de acceso',
    passusu VARCHAR(255) NOT NULL COMMENT 'Hash de la contraseña (nunca texto plano)', 
    estusu VARCHAR(10) NOT NULL DEFAULT 'ACTIVO' COMMENT 'Estado: ACTIVO, BLOQUEADO o INACTIVO',  
    intusu TINYINT NOT NULL DEFAULT 0 COMMENT 'Intentos fallidos seguidos, la app bloquea al llegar al límite',  
    ultusu DATETIME NULL COMMENT 'Último acceso, NULL = nunca ingresó', 
    codemp INT NOT NULL UNIQUE COMMENT 'FK a empleado',
    codrol INT NOT NULL COMMENT 'FK a rol',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (estusu IN ('ACTIVO','BLOQUEADO','INACTIVO')),            
    CHECK (intusu >= 0),                                           
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codrol) REFERENCES rol(codrol)
)ENGINE=InnoDB COMMENT='Credenciales de acceso de usuarios';
 
CREATE TABLE rolpermiso(
    codrol INT NOT NULL COMMENT 'FK a rol',
    codmod INT NOT NULL COMMENT 'FK a modulo',
    lecper BIT NOT NULL DEFAULT 1 COMMENT 'Permiso de lectura',
    escper BIT NOT NULL DEFAULT 0 COMMENT 'Permiso de escritura',
    eliper BIT NOT NULL DEFAULT 0 COMMENT 'Permiso de eliminación',
    estper BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    PRIMARY KEY (codrol, codmod),
    FOREIGN KEY (codrol) REFERENCES rol(codrol),
    FOREIGN KEY (codmod) REFERENCES modulo(codmod)
)ENGINE=InnoDB COMMENT='Permisos de lectura, escritura y eliminación por rol y módulo';
 
CREATE TABLE auditorialog(
    codlog INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    feclog TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la acción',
    acclog VARCHAR(20) NOT NULL COMMENT 'Acción: INSERT, UPDATE, DELETE, LOGIN o LOGOUT',
    tablog VARCHAR(50) NULL COMMENT 'Tabla afectada',
    reglog VARCHAR(50) NULL COMMENT 'Identificador del registro afectado',
    iplog VARCHAR(45) NULL COMMENT 'Dirección IP de origen',
    codusu INT NOT NULL COMMENT 'FK a usuario',
    codmod INT NULL COMMENT 'FK a modulo',  
    estlog BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (acclog IN ('INSERT','UPDATE','DELETE','LOGIN','LOGOUT')),
    FOREIGN KEY (codusu) REFERENCES usuario(codusu),
    FOREIGN KEY (codmod) REFERENCES modulo(codmod)  
)ENGINE=InnoDB COMMENT='Historial completo de acciones de los usuarios en el sistema';
 
CREATE TABLE cuentapuntos(
    codcpun INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    salcpun INT NOT NULL DEFAULT 0 COMMENT 'Saldo actual de puntos',
    feccpun TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de apertura de la cuenta',
    codcli INT NOT NULL UNIQUE COMMENT 'FK a cliente',
    codniv INT NOT NULL COMMENT 'FK a nivelfidelizacion',  
    estcpun BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (salcpun >= 0),
    FOREIGN KEY (codcli) REFERENCES cliente(codcli),
    FOREIGN KEY (codniv) REFERENCES nivelfidelizacion(codniv)     
)ENGINE=InnoDB COMMENT='Cuenta de puntos de fidelización de cada cliente';
 
CREATE TABLE movimientopuntos(
    codmpun INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    fecmpun TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha del movimiento',
    canmpun INT NOT NULL COMMENT 'Cantidad de puntos (siempre positiva)',
    tipmpun VARCHAR(15) NOT NULL COMMENT 'Tipo: ACUMULACION, CANJE o VENCIMIENTO',
    codcpun INT NOT NULL COMMENT 'FK a cuentapuntos',
    codfac INT NULL COMMENT 'FK a facturacion',
    estmpun BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (canmpun > 0),
    CHECK (tipmpun IN ('ACUMULACION','CANJE','VENCIMIENTO')),
    FOREIGN KEY (codcpun) REFERENCES cuentapuntos(codcpun),
    FOREIGN KEY (codfac) REFERENCES facturacion(codfac)
)ENGINE=InnoDB COMMENT='Historial de acumulación, canje y vencimiento de puntos';
 
CREATE TABLE canjerecompensa(
    codcan INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Identificador único (PK)',
    feccan TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha del canje',
    puncan INT NOT NULL COMMENT 'Puntos descontados en el canje',
    codcpun INT NOT NULL COMMENT 'FK a cuentapuntos',
    codrec INT NOT NULL COMMENT 'FK a recompensa',
    estcan BIT NOT NULL DEFAULT 1 COMMENT 'Estado del registro: 1 = activo, 0 = inactivo',
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Usuario que creó el registro',
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación (automática)',
    usuact VARCHAR(50) NULL COMMENT 'Último usuario que modificó el registro (lo llena la aplicación)',
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha y hora de la última modificación (automática)',
    CHECK (puncan > 0),
    FOREIGN KEY (codcpun) REFERENCES cuentapuntos(codcpun),
    FOREIGN KEY (codrec) REFERENCES recompensa(codrec)
)ENGINE=InnoDB COMMENT='Canjes de recompensas realizados con puntos';
 
-- --------------------------------------------
-- ÍNDICES
-- --------------------------------------------
CREATE INDEX idx_empleado_sucursal ON empleado(codsuc);
CREATE INDEX idx_almacen_sucursal ON almacen(codsuc);
CREATE INDEX idx_cargo_tipo ON cargo(codtiemp);            
CREATE INDEX idx_proveedor_eval ON proveedor(codeeva);     
 
CREATE INDEX idx_producto_categoria ON producto(codcat);
CREATE INDEX idx_producto_marca ON producto(codmar);
CREATE INDEX idx_stock_almacen ON stockalmacen(codalm);
CREATE INDEX idx_movinv_producto ON movimientoinventario(codpro);
CREATE INDEX idx_movinv_almacen ON movimientoinventario(codalm);
CREATE INDEX idx_movinv_fecha ON movimientoinventario(fecminv);
 
CREATE INDEX idx_pedido_cliente ON pedido(codcli);
CREATE INDEX idx_pedido_fecha ON pedido(fecped);
CREATE INDEX idx_detped_pedido ON detallepedido(codped);
CREATE INDEX idx_detped_producto ON detallepedido(codpro);
 
CREATE INDEX idx_ocom_proveedor ON ordencompra(codprov);
CREATE INDEX idx_detocom_orden ON detalleordencompra(codocom);
CREATE INDEX idx_gin_orden ON guiaingreso(codocom);
CREATE INDEX idx_fprov_proveedor ON facturaproveedor(codprov);
 
CREATE INDEX idx_transporte_estado ON transporte(codetra);           
CREATE INDEX idx_despacho_factura ON despacho(codfac);
CREATE INDEX idx_detdes_despacho ON detalledespacho(coddes);
CREATE INDEX idx_incidencia_despacho ON incidenciadespacho(coddes);
 
CREATE INDEX idx_pagocli_factura ON pagocliente(codfac);
CREATE INDEX idx_pagoprov_factura ON pagoproveedor(codfprov);
 
CREATE INDEX idx_asistencia_empleado ON asistencia(codemp);
CREATE INDEX idx_log_usuario ON auditorialog(codusu);
CREATE INDEX idx_log_fecha ON auditorialog(feclog);
CREATE INDEX idx_log_modulo ON auditorialog(codmod);  
 
CREATE INDEX idx_promocion_campana ON promocion(codcam);
CREATE INDEX idx_cuentapuntos_nivel ON cuentapuntos(codniv);  
CREATE INDEX idx_movpun_cuenta ON movimientopuntos(codcpun);
CREATE INDEX idx_canje_cuenta ON canjerecompensa(codcpun);
 
