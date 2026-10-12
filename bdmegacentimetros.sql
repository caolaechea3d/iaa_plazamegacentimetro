-- --------------------------------------------
-- BASE DE DATOS INTEGRADA - PLAZA MEGACENTÍMETROS
-- Versión 2: incluye mejoras tomadas de la comparación con otros modelos.
-- Las líneas nuevas o modificadas están marcadas con [NUEVO] o [CAMBIO].
-- Requiere MySQL 8.0.16+ para que los CHECK se apliquen.
-- --------------------------------------------

DROP DATABASE IF EXISTS bdmegacentimetros;
CREATE DATABASE bdmegacentimetros CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bdmegacentimetros;

-- --------------------------------------------
-- COLUMNAS DE AUDITORÍA POR FILA (aplicadas a tablas transaccionales)
--   usucre : usuario que creó el registro   -> responde "¿quién lo registró?"
--   feccre : fecha/hora de creación          -> se llena sola con CURRENT_TIMESTAMP
--   usuact : último usuario que lo modificó  -> lo llena la aplicación al editar
--   fecact : fecha/hora de la última edición -> ON UPDATE la actualiza MySQL solo
-- Complementan a auditorialog: el log guarda TODO el historial;
-- estas columnas dan la respuesta rápida sin consultar el log.
-- --------------------------------------------

-- --------------------------------------------
-- TABLAS SIMPLES / CATÁLOGOS
-- --------------------------------------------

CREATE TABLE distrito(
    coddis INT PRIMARY KEY AUTO_INCREMENT,
    nomdis VARCHAR(50) NOT NULL UNIQUE,
    estdis BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE sexo(
    codsex INT PRIMARY KEY AUTO_INCREMENT,
    nomsex VARCHAR(30) NOT NULL UNIQUE,
    estsex BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipodocumento(
    codtipd INT PRIMARY KEY AUTO_INCREMENT,
    nomtipd VARCHAR(30) NOT NULL UNIQUE,
    esttipd BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipocliente(
    codtcli INT PRIMARY KEY AUTO_INCREMENT,
    nomtcli VARCHAR(40) NOT NULL UNIQUE,
    esttcli BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipocomprobante(
    codtcom INT PRIMARY KEY AUTO_INCREMENT,
    nomtcom VARCHAR(40) NOT NULL UNIQUE,
    esttcom BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE categoriaproducto(
    codcat INT PRIMARY KEY AUTO_INCREMENT,
    nomcat VARCHAR(50) NOT NULL UNIQUE,
    estcat BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE marcaproducto(
    codmar INT PRIMARY KEY AUTO_INCREMENT,
    nommar VARCHAR(50) NOT NULL UNIQUE,
    estmar BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipoempaque(
    codtemp INT PRIMARY KEY AUTO_INCREMENT,
    nomtemp VARCHAR(40) NOT NULL UNIQUE,
    esttemp BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

-- [NUEVO] Unidad de medida (UND, KG, LT, CAJA...).
-- Catálogo y no texto libre: así "kg", "Kg" y "kilos" no conviven como valores distintos.
CREATE TABLE unidadmedida(
    codumed INT PRIMARY KEY AUTO_INCREMENT,
    nomumed VARCHAR(30) NOT NULL UNIQUE,
    abrumed VARCHAR(10) NOT NULL UNIQUE,   -- abreviatura que se imprime en comprobantes
    estumed BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipoalmacen(
    codtalm INT PRIMARY KEY AUTO_INCREMENT,
    nomtalm VARCHAR(40) NOT NULL UNIQUE,
    esttalm BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE estadooperativo(
    codeope INT PRIMARY KEY AUTO_INCREMENT,
    nomeope VARCHAR(40) NOT NULL UNIQUE,
    deseope VARCHAR(300) NULL
)ENGINE=InnoDB;

-- [NUEVO] Administrativo / Operativo (lo pide el enunciado).
CREATE TABLE tipoempleado(
    codtiemp INT PRIMARY KEY AUTO_INCREMENT,
    nomtiemp VARCHAR(30) NOT NULL UNIQUE,
    esttiemp BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE cargo(
    codcarg INT PRIMARY KEY AUTO_INCREMENT,
    nomcarg VARCHAR(50) NOT NULL UNIQUE,
    estcarg BIT NOT NULL DEFAULT 1,
    codtiemp INT NOT NULL,                  -- [NUEVO] el tipo depende del puesto (un chofer siempre es operativo),
                                            -- por eso va en cargo y el empleado lo hereda; ponerlo también
                                            -- en empleado permitiría datos contradictorios.
    FOREIGN KEY (codtiemp) REFERENCES tipoempleado(codtiemp)
)ENGINE=InnoDB;

CREATE TABLE estadoasistencia(
    codeasis INT PRIMARY KEY AUTO_INCREMENT,
    nomeasis VARCHAR(30) NOT NULL UNIQUE,
    deseasis VARCHAR(300) NULL
)ENGINE=InnoDB;

-- [NUEVO] Resultado de la evaluación del proveedor (PENDIENTE, APROBADO, RECHAZADO).
-- El enunciado exige proveedores "evaluados y registrados".
CREATE TABLE estadoevaluacion(
    codeeva INT PRIMARY KEY AUTO_INCREMENT,
    nomeeva VARCHAR(30) NOT NULL UNIQUE,
    esteeva BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipotransporte(
    codttra INT PRIMARY KEY AUTO_INCREMENT,
    nomttra VARCHAR(40) NOT NULL UNIQUE,
    estttra BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

-- [NUEVO] Disponibilidad del vehículo (DISPONIBLE, EN RUTA, MANTENIMIENTO).
-- Distinto de esttra (BIT): esttra dice si la unidad sigue en la flota;
-- este estado dice si se le puede asignar un despacho AHORA.
CREATE TABLE estadotransporte(
    codetra INT PRIMARY KEY AUTO_INCREMENT,
    nometra VARCHAR(30) NOT NULL UNIQUE,
    estetra BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipoincidencia(
    codtinc INT PRIMARY KEY AUTO_INCREMENT,
    nomtinc VARCHAR(50) NOT NULL UNIQUE,
    esttinc BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE metodopago(
    codmpag INT PRIMARY KEY AUTO_INCREMENT,
    nommpag VARCHAR(40) NOT NULL UNIQUE,
    estmpag BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE estadopago(
    codepag INT PRIMARY KEY AUTO_INCREMENT,
    nomepag VARCHAR(30) NOT NULL UNIQUE,
    estepag BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE tipomovimiento(
    codtmov INT PRIMARY KEY AUTO_INCREMENT,
    nomtmov VARCHAR(40) NOT NULL UNIQUE,
    sigtmov TINYINT NOT NULL,
    esttmov BIT NOT NULL DEFAULT 1,
    CHECK (sigtmov IN (1,-1))
)ENGINE=InnoDB;

CREATE TABLE rol(
    codrol INT PRIMARY KEY AUTO_INCREMENT,
    nomrol VARCHAR(40) NOT NULL UNIQUE,
    estrol BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE modulo(
    codmod INT PRIMARY KEY AUTO_INCREMENT,
    nommod VARCHAR(50) NOT NULL UNIQUE,
    rutmod VARCHAR(100) NULL,
    estmod BIT NOT NULL DEFAULT 1
)ENGINE=InnoDB;

CREATE TABLE capacitacion(
    codcap INT PRIMARY KEY AUTO_INCREMENT,
    nomcap VARCHAR(100) NOT NULL,
    descap TEXT NULL,
    inicap DATE NOT NULL,
    fincap DATE NOT NULL,
    horcap INT NOT NULL,
    estcap BIT NOT NULL DEFAULT 1,
    CHECK (fincap >= inicap),
    CHECK (horcap > 0)
)ENGINE=InnoDB;

CREATE TABLE campana(
    codcam INT PRIMARY KEY AUTO_INCREMENT,
    nomcam VARCHAR(100) NOT NULL,
    descam TEXT NULL,
    inicam DATE NOT NULL,
    fincam DATE NOT NULL,
    estcam BIT NOT NULL DEFAULT 1,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,                 -- [NUEVO]
    usuact VARCHAR(50) NULL,                                            -- [NUEVO]
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,      -- [NUEVO]
    CHECK (fincam >= inicam)
)ENGINE=InnoDB;

CREATE TABLE recompensa(
    codrec INT PRIMARY KEY AUTO_INCREMENT,
    nomrec VARCHAR(100) NOT NULL UNIQUE,
    desrec TEXT NULL,
    punrec INT NOT NULL,
    estrec BIT NOT NULL DEFAULT 1,
    CHECK (punrec > 0)
)ENGINE=InnoDB;

-- [NUEVO] Niveles del programa de puntos (BRONCE, PLATA, ORO).
-- minniv guarda los puntos mínimos de cada nivel: si mañana "Plata" pasa de 500
-- a 600 puntos, se cambia un dato y no el código ni un ENUM.
CREATE TABLE nivelfidelizacion(
    codniv INT PRIMARY KEY AUTO_INCREMENT,
    nomniv VARCHAR(30) NOT NULL UNIQUE,
    minniv INT NOT NULL UNIQUE,             -- UNIQUE: dos niveles no pueden empezar en el mismo puntaje
    desniv VARCHAR(300) NULL,               -- beneficios del nivel
    estniv BIT NOT NULL DEFAULT 1,
    CHECK (minniv >= 0)
)ENGINE=InnoDB;

-- --------------------------------------------
-- ALMACENES Y SUCURSALES
-- --------------------------------------------

CREATE TABLE sucursal(
    codsuc INT PRIMARY KEY AUTO_INCREMENT,
    nomsuc VARCHAR(100) NOT NULL UNIQUE,
    dirsuc VARCHAR(200) NOT NULL,
    telsuc VARCHAR(15) NULL,                -- [NUEVO] teléfono de contacto del punto de venta
    estsuc BIT NOT NULL DEFAULT 1,
    coddis INT NOT NULL,
    codeope INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codeope) REFERENCES estadooperativo(codeope)
)ENGINE=InnoDB;

CREATE TABLE almacen(
    codalm INT PRIMARY KEY AUTO_INCREMENT,
    nomalm VARCHAR(100) NOT NULL UNIQUE,
    diralm VARCHAR(200) NOT NULL,
    capalm INT NOT NULL,
    coddis INT NOT NULL,
    codtalm INT NOT NULL,
    codsuc INT NOT NULL,
    codeope INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (capalm > 0),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codtalm) REFERENCES tipoalmacen(codtalm),
    FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc),
    FOREIGN KEY (codeope) REFERENCES estadooperativo(codeope)
)ENGINE=InnoDB;

-- --------------------------------------------
-- PERSONAS
-- --------------------------------------------

CREATE TABLE empleado(
    codemp INT PRIMARY KEY AUTO_INCREMENT,
    nomemp VARCHAR(50) NOT NULL,
    apepemp VARCHAR(40) NOT NULL,
    apememp VARCHAR(40) NOT NULL,
    docemp VARCHAR(20) NOT NULL UNIQUE,
    feccemp DATE NOT NULL,
    nacemp VARCHAR(30) NOT NULL,
    diremp VARCHAR(200) NOT NULL,
    telemp VARCHAR(15) NULL,
    celemp VARCHAR(15) NOT NULL,
    coremp VARCHAR(100) NOT NULL UNIQUE,
    estemp BIT NOT NULL DEFAULT 1,
    coddis INT NOT NULL,
    codsex INT NOT NULL,
    codtipd INT NOT NULL,
    codcarg INT NOT NULL,                   -- vía cargo se obtiene si es administrativo u operativo
    codsuc INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codsex) REFERENCES sexo(codsex),
    FOREIGN KEY (codtipd) REFERENCES tipodocumento(codtipd),
    FOREIGN KEY (codcarg) REFERENCES cargo(codcarg),
    FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc)
)ENGINE=InnoDB;

CREATE TABLE cliente(
    codcli INT PRIMARY KEY AUTO_INCREMENT,
    nomcli VARCHAR(50) NULL,                -- [CAMBIO] NULL: una empresa no tiene nombre de pila
    apepcli VARCHAR(40) NULL,               -- [CAMBIO] NULL: una empresa no tiene apellidos
    apemcli VARCHAR(40) NULL,               -- [CAMBIO] NULL: idem
    razcli VARCHAR(150) NULL,               -- [NUEVO] razón social, solo para clientes empresa (RUC)
    doccli VARCHAR(20) NOT NULL UNIQUE,
    feccli TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    naccli VARCHAR(30) NULL,                -- [CAMBIO] NULL: la nacionalidad no aplica a una empresa
    dircli VARCHAR(200) NOT NULL,
    telcli VARCHAR(15) NULL,
    celcli VARCHAR(15) NULL,
    corcli VARCHAR(100) NULL UNIQUE,
    estcli BIT NOT NULL DEFAULT 1,
    coddis INT NOT NULL,
    codsex INT NULL,                        -- [CAMBIO] NULL: una empresa no tiene sexo
    codtipd INT NOT NULL,
    codtcli INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    -- [NUEVO] Obliga a que el cliente sea una cosa u otra:
    -- empresa (tiene razón social) o persona (tiene nombre y apellido paterno).
    -- Sin este CHECK, al volver NULL las columnas se podría guardar un cliente sin nombre alguno.
    CHECK (razcli IS NOT NULL OR (nomcli IS NOT NULL AND apepcli IS NOT NULL)),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codsex) REFERENCES sexo(codsex),
    FOREIGN KEY (codtipd) REFERENCES tipodocumento(codtipd),
    FOREIGN KEY (codtcli) REFERENCES tipocliente(codtcli)
)ENGINE=InnoDB;

CREATE TABLE proveedor(
    codprov INT PRIMARY KEY AUTO_INCREMENT,
    nomprov VARCHAR(50) NULL,
    apepprov VARCHAR(40) NULL,
    apemprov VARCHAR(40) NULL,
    razprov VARCHAR(150) NULL,
    rucprov CHAR(11) NOT NULL UNIQUE,
    corprov VARCHAR(100) NULL,
    telprov VARCHAR(15) NULL,
    celprov VARCHAR(15) NULL,
    fecprov TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estprov BIT NOT NULL DEFAULT 1,
    dirprov VARCHAR(200) NOT NULL,
    coddis INT NOT NULL,
    codeeva INT NOT NULL,                   -- [NUEVO] resultado de la evaluación del proveedor
    feceva DATE NULL,                       -- [NUEVO] cuándo se evaluó (NULL mientras esté pendiente)
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (CHAR_LENGTH(rucprov) = 11),
    CHECK (razprov IS NOT NULL OR nomprov IS NOT NULL),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis),
    FOREIGN KEY (codeeva) REFERENCES estadoevaluacion(codeeva)
)ENGINE=InnoDB;

-- --------------------------------------------
-- PRODUCTOS E INVENTARIO
-- --------------------------------------------

CREATE TABLE producto(
    codpro INT PRIMARY KEY AUTO_INCREMENT,
    skupro VARCHAR(30) NOT NULL UNIQUE,     -- [NUEVO] código SKU del negocio (etiquetas, lector de barras).
                                            -- codpro es interno; el SKU es el que conoce el personal.
    nompro VARCHAR(100) NOT NULL,
    despro TEXT NULL,
    fecpro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    prepro DECIMAL(10,2) NOT NULL,          -- precio de venta
    cospro DECIMAL(10,2) NOT NULL DEFAULT 0,-- [NUEVO] costo referencial de compra: permite calcular
                                            -- el margen (prepro - cospro) sin buscar la última OC.
                                            -- El costo real de cada compra sigue en detalleordencompra.
    estpro BIT NOT NULL DEFAULT 1,
    codcat INT NOT NULL,
    codmar INT NOT NULL,
    codtemp INT NOT NULL,
    codumed INT NOT NULL,                   -- [NUEVO] unidad en que se vende (UND, KG, LT...)
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (prepro >= 0),
    CHECK (cospro >= 0),                    -- [NUEVO]
    FOREIGN KEY (codcat) REFERENCES categoriaproducto(codcat),
    FOREIGN KEY (codmar) REFERENCES marcaproducto(codmar),
    FOREIGN KEY (codtemp) REFERENCES tipoempaque(codtemp),
    FOREIGN KEY (codumed) REFERENCES unidadmedida(codumed)              -- [NUEVO]
)ENGINE=InnoDB;

CREATE TABLE stockalmacen(
    codpro INT NOT NULL,
    codalm INT NOT NULL,
    cansalm INT NOT NULL DEFAULT 0,
    minsalm INT NOT NULL DEFAULT 0,
    fecsalm TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (codpro, codalm),
    CHECK (cansalm >= 0),
    CHECK (minsalm >= 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm)
)ENGINE=InnoDB;

CREATE TABLE trasladoalmacen(
    codtrasl INT PRIMARY KEY AUTO_INCREMENT,
    fectrasl DATETIME NOT NULL,
    esttrasl VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    codalmori INT NOT NULL,
    codalmdes INT NOT NULL,
    codemp INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (esttrasl IN ('PENDIENTE','EN TRANSITO','RECIBIDO','ANULADO')),
    CHECK (codalmori <> codalmdes),
    FOREIGN KEY (codalmori) REFERENCES almacen(codalm),
    FOREIGN KEY (codalmdes) REFERENCES almacen(codalm),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
)ENGINE=InnoDB;

CREATE TABLE detalletraslado(
    coddtrasl INT PRIMARY KEY AUTO_INCREMENT,
    candtrasl INT NOT NULL,
    codpro INT NOT NULL,
    codtrasl INT NOT NULL,
    CHECK (candtrasl > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codtrasl) REFERENCES trasladoalmacen(codtrasl),
    UNIQUE (codtrasl, codpro)
)ENGINE=InnoDB;

CREATE TABLE movimientoinventario(
    codminv INT PRIMARY KEY AUTO_INCREMENT,
    fecminv TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    canminv INT NOT NULL,
    refminv VARCHAR(50) NULL,
    codpro INT NOT NULL,
    codalm INT NOT NULL,
    codtmov INT NOT NULL,
    codemp INT NULL,
    CHECK (canminv > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codtmov) REFERENCES tipomovimiento(codtmov),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
)ENGINE=InnoDB;

-- --------------------------------------------
-- MARKETING (requerido antes de ventas por la FK de promoción)
-- --------------------------------------------

CREATE TABLE campanasegmento(
    codcam INT NOT NULL,
    codtcli INT NOT NULL,
    PRIMARY KEY (codcam, codtcli),
    FOREIGN KEY (codcam) REFERENCES campana(codcam),
    FOREIGN KEY (codtcli) REFERENCES tipocliente(codtcli)
)ENGINE=InnoDB;

CREATE TABLE promocion(
    codprom INT PRIMARY KEY AUTO_INCREMENT,
    nomprom VARCHAR(100) NOT NULL,
    tipprom VARCHAR(10) NOT NULL,
    valprom DECIMAL(10,2) NOT NULL,
    iniprom DATE NOT NULL,
    finprom DATE NOT NULL,
    estprom BIT NOT NULL DEFAULT 1,
    codcam INT NOT NULL,
    codpro INT NULL,
    codcat INT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (tipprom IN ('PORCENTAJE','MONTO')),
    CHECK (valprom > 0),
    CHECK (tipprom <> 'PORCENTAJE' OR valprom <= 100),
    CHECK (finprom >= iniprom),
    FOREIGN KEY (codcam) REFERENCES campana(codcam),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codcat) REFERENCES categoriaproducto(codcat)
)ENGINE=InnoDB;

-- --------------------------------------------
-- VENTAS
-- --------------------------------------------

CREATE TABLE pedido(
    codped INT PRIMARY KEY AUTO_INCREMENT,
    fecped TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    totped DECIMAL(10,2) NOT NULL DEFAULT 0,
    estped VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    codcli INT NOT NULL,
    codemp INT NOT NULL,
    codsuc INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (totped >= 0),
    CHECK (estped IN ('PENDIENTE','CONFIRMADO','PAGADO','DESPACHADO','ANULADO')),
    FOREIGN KEY (codcli) REFERENCES cliente(codcli),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc)
)ENGINE=InnoDB;

CREATE TABLE detallepedido(
    coddped INT PRIMARY KEY AUTO_INCREMENT,
    candped INT NOT NULL,
    predped DECIMAL(10,2) NOT NULL,
    desdped DECIMAL(10,2) NOT NULL DEFAULT 0,
    subdped DECIMAL(10,2) NOT NULL,
    codped INT NOT NULL,
    codpro INT NOT NULL,
    codalm INT NOT NULL,
    codprom INT NULL,
    CHECK (candped > 0),
    CHECK (predped >= 0),
    CHECK (desdped >= 0),
    CHECK (subdped >= 0),
    FOREIGN KEY (codped) REFERENCES pedido(codped),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codprom) REFERENCES promocion(codprom)
)ENGINE=InnoDB;

CREATE TABLE facturacion(
    codfac INT PRIMARY KEY AUTO_INCREMENT,
    serfac VARCHAR(4) NOT NULL,
    numfac INT NOT NULL,
    fecfac TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    subfac DECIMAL(10,2) NOT NULL,
    igvfac DECIMAL(10,2) NOT NULL,
    totfac DECIMAL(10,2) NOT NULL,
    estfac VARCHAR(20) NOT NULL DEFAULT 'EMITIDA',
    codped INT NOT NULL UNIQUE,
    codtcom INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (subfac >= 0 AND igvfac >= 0 AND totfac >= 0),
    CHECK (estfac IN ('EMITIDA','PAGADA','ANULADA')),
    UNIQUE (codtcom, serfac, numfac),
    FOREIGN KEY (codped) REFERENCES pedido(codped),
    FOREIGN KEY (codtcom) REFERENCES tipocomprobante(codtcom)
)ENGINE=InnoDB;

-- --------------------------------------------
-- COMPRAS
-- --------------------------------------------

CREATE TABLE ordencompra(
    codocom INT PRIMARY KEY AUTO_INCREMENT,
    fecocom TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estocom VARCHAR(20) NOT NULL DEFAULT 'EMITIDA',
    fecentocom DATE NOT NULL,
    conocom VARCHAR(300) NULL,
    totocom DECIMAL(12,2) NOT NULL DEFAULT 0,
    codprov INT NOT NULL,
    codalm INT NOT NULL,
    codemp INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (totocom >= 0),
    CHECK (estocom IN ('EMITIDA','APROBADA','RECIBIDA PARCIAL','RECIBIDA','ANULADA')),
    FOREIGN KEY (codprov) REFERENCES proveedor(codprov),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
)ENGINE=InnoDB;

CREATE TABLE detalleordencompra(
    coddocom INT PRIMARY KEY AUTO_INCREMENT,
    candocom INT NOT NULL,
    cosdocom DECIMAL(10,2) NOT NULL,
    subdocom DECIMAL(12,2) NOT NULL,        -- [NUEVO] cantidad x costo. Se guarda (y no solo se calcula)
                                            -- para que el total de la OC no cambie si alguien edita el costo después.
    codocom INT NOT NULL,
    codpro INT NOT NULL,
    CHECK (candocom > 0),
    CHECK (cosdocom >= 0),
    CHECK (subdocom >= 0),                  -- [NUEVO]
    FOREIGN KEY (codocom) REFERENCES ordencompra(codocom),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    UNIQUE (codocom, codpro)
)ENGINE=InnoDB;

CREATE TABLE guiaingreso(
    codgin INT PRIMARY KEY AUTO_INCREMENT,
    fecgin TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estgin VARCHAR(20) NOT NULL DEFAULT 'REGISTRADA',
    codocom INT NOT NULL,
    codalm INT NOT NULL,
    codemp INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (estgin IN ('REGISTRADA','CONFORME','OBSERVADA','ANULADA')),
    FOREIGN KEY (codocom) REFERENCES ordencompra(codocom),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp)
)ENGINE=InnoDB;

CREATE TABLE detalleguiaingreso(
    coddgin INT PRIMARY KEY AUTO_INCREMENT,
    candgin INT NOT NULL,
    codpro INT NOT NULL,
    codgin INT NOT NULL,
    CHECK (candgin > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codgin) REFERENCES guiaingreso(codgin),
    UNIQUE (codgin, codpro)
)ENGINE=InnoDB;

CREATE TABLE facturaproveedor(
    codfprov INT PRIMARY KEY AUTO_INCREMENT,
    numfprov VARCHAR(20) NOT NULL,
    fecfprov DATE NOT NULL,
    venfprov DATE NOT NULL,
    totfprov DECIMAL(12,2) NOT NULL,
    estfprov VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    codocom INT NOT NULL,
    codprov INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (totfprov >= 0),
    CHECK (venfprov >= fecfprov),
    CHECK (estfprov IN ('PENDIENTE','PAGADA PARCIAL','PAGADA','ANULADA')),
    UNIQUE (codprov, numfprov),
    FOREIGN KEY (codocom) REFERENCES ordencompra(codocom),
    FOREIGN KEY (codprov) REFERENCES proveedor(codprov)
)ENGINE=InnoDB;

-- --------------------------------------------
-- DESPACHO
-- --------------------------------------------

CREATE TABLE transporte(
    codtra INT PRIMARY KEY AUTO_INCREMENT,
    platra VARCHAR(10) NOT NULL UNIQUE,
    captra DECIMAL(10,2) NOT NULL,
    esttra BIT NOT NULL DEFAULT 1,          -- sigue en la flota (1) o fue dado de baja (0)
    codttra INT NOT NULL,
    codetra INT NOT NULL,                   -- [NUEVO] disponibilidad actual (DISPONIBLE / EN RUTA / MANTENIMIENTO)
    CHECK (captra > 0),
    FOREIGN KEY (codttra) REFERENCES tipotransporte(codttra),
    FOREIGN KEY (codetra) REFERENCES estadotransporte(codetra)          -- [NUEVO]
)ENGINE=InnoDB;

CREATE TABLE despacho(
    coddes INT PRIMARY KEY AUTO_INCREMENT,
    numdes VARCHAR(20) NOT NULL UNIQUE,
    fecdes DATETIME NOT NULL,
    dirdes VARCHAR(200) NOT NULL,
    estdes VARCHAR(20) NOT NULL DEFAULT 'PREPARACION',
    codfac INT NOT NULL,
    codemp INT NOT NULL,
    codtra INT NOT NULL,
    coddis INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (estdes IN ('PREPARACION','EN RUTA','ENTREGADO','INCIDENCIA','ANULADO')),
    FOREIGN KEY (codfac) REFERENCES facturacion(codfac),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codtra) REFERENCES transporte(codtra),
    FOREIGN KEY (coddis) REFERENCES distrito(coddis)
)ENGINE=InnoDB;

CREATE TABLE detalledespacho(
    coddetdes INT PRIMARY KEY AUTO_INCREMENT,
    candetdes INT NOT NULL,
    codpro INT NOT NULL,
    codalm INT NOT NULL,
    coddes INT NOT NULL,
    CHECK (candetdes > 0),
    FOREIGN KEY (codpro) REFERENCES producto(codpro),
    FOREIGN KEY (codalm) REFERENCES almacen(codalm),
    FOREIGN KEY (coddes) REFERENCES despacho(coddes)
)ENGINE=InnoDB;

CREATE TABLE incidenciadespacho(
    codinc INT PRIMARY KEY AUTO_INCREMENT,
    fecinc TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    desinc TEXT NOT NULL,
    accinc TEXT NULL,
    estinc VARCHAR(20) NOT NULL DEFAULT 'ABIERTA',
    coddes INT NOT NULL,
    codtinc INT NOT NULL,
    CHECK (estinc IN ('ABIERTA','EN PROCESO','RESUELTA')),
    FOREIGN KEY (coddes) REFERENCES despacho(coddes),
    FOREIGN KEY (codtinc) REFERENCES tipoincidencia(codtinc)
)ENGINE=InnoDB;

-- --------------------------------------------
-- PERSONAL
-- --------------------------------------------

CREATE TABLE asistencia(
    codasi INT PRIMARY KEY AUTO_INCREMENT,
    fecasi DATE NOT NULL,
    entasi TIME NULL,
    salasi TIME NULL,
    codeasis INT NOT NULL,
    codemp INT NOT NULL,
    CHECK (salasi IS NULL OR entasi IS NULL OR salasi > entasi),
    FOREIGN KEY (codeasis) REFERENCES estadoasistencia(codeasis),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    UNIQUE (codemp, fecasi)
)ENGINE=InnoDB;

CREATE TABLE empleadocapacitacion(
    codemp INT NOT NULL,
    codcap INT NOT NULL,
    notecap DECIMAL(5,2) NULL,
    estecap VARCHAR(20) NOT NULL DEFAULT 'INSCRITO',
    feccomp DATE NULL,                      -- [NUEVO] cuándo terminó ESTE empleado (puede diferir del fin del curso);
                                            -- NULL mientras siga inscrito.
    PRIMARY KEY (codemp, codcap),
    CHECK (notecap IS NULL OR (notecap >= 0 AND notecap <= 20)),
    CHECK (estecap IN ('INSCRITO','APROBADO','DESAPROBADO','RETIRADO')),
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codcap) REFERENCES capacitacion(codcap)
)ENGINE=InnoDB;

-- --------------------------------------------
-- PAGOS
-- --------------------------------------------

CREATE TABLE pagocliente(
    codpcli INT PRIMARY KEY AUTO_INCREMENT,
    fecpcli TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    monpcli DECIMAL(10,2) NOT NULL,
    numpcli VARCHAR(50) NULL,
    codfac INT NOT NULL,
    codmpag INT NOT NULL,
    codepag INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (monpcli > 0),
    FOREIGN KEY (codfac) REFERENCES facturacion(codfac),
    FOREIGN KEY (codmpag) REFERENCES metodopago(codmpag),
    FOREIGN KEY (codepag) REFERENCES estadopago(codepag)
)ENGINE=InnoDB;

CREATE TABLE pagoproveedor(
    codpprov INT PRIMARY KEY AUTO_INCREMENT,
    fecpprov TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    monpprov DECIMAL(12,2) NOT NULL,
    numpprov VARCHAR(50) NULL,
    codfprov INT NOT NULL,
    codmpag INT NOT NULL,
    codepag INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (monpprov > 0),
    FOREIGN KEY (codfprov) REFERENCES facturaproveedor(codfprov),
    FOREIGN KEY (codmpag) REFERENCES metodopago(codmpag),
    FOREIGN KEY (codepag) REFERENCES estadopago(codepag)
)ENGINE=InnoDB;

-- --------------------------------------------
-- SEGURIDAD Y AUDITORÍA
-- --------------------------------------------

CREATE TABLE usuario(
    codusu INT PRIMARY KEY AUTO_INCREMENT,
    nomusu VARCHAR(50) NOT NULL UNIQUE,
    passusu VARCHAR(255) NOT NULL,          -- guardar HASH, nunca texto plano
    estusu VARCHAR(10) NOT NULL DEFAULT 'ACTIVO', -- [CAMBIO] antes BIT: un BIT solo admite 2 valores
                                                  -- y ahora hay 3 (ACTIVO, BLOQUEADO, INACTIVO).
    intusu TINYINT NOT NULL DEFAULT 0,      -- [NUEVO] intentos fallidos seguidos; la app bloquea al llegar al límite
    ultusu DATETIME NULL,                   -- [NUEVO] último acceso: detecta cuentas abandonadas (NULL = nunca ingresó)
    codemp INT NOT NULL UNIQUE,
    codrol INT NOT NULL,
    usucre VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',                       -- [NUEVO] auditoría (reemplaza a creusu)
    feccre DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuact VARCHAR(50) NULL,
    fecact DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    CHECK (estusu IN ('ACTIVO','BLOQUEADO','INACTIVO')),               -- [NUEVO]
    CHECK (intusu >= 0),                                               -- [NUEVO]
    FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    FOREIGN KEY (codrol) REFERENCES rol(codrol)
)ENGINE=InnoDB;

CREATE TABLE rolpermiso(
    codrol INT NOT NULL,
    codmod INT NOT NULL,
    lecper BIT NOT NULL DEFAULT 1,
    escper BIT NOT NULL DEFAULT 0,
    eliper BIT NOT NULL DEFAULT 0,
    PRIMARY KEY (codrol, codmod),
    FOREIGN KEY (codrol) REFERENCES rol(codrol),
    FOREIGN KEY (codmod) REFERENCES modulo(codmod)
)ENGINE=InnoDB;

CREATE TABLE auditorialog(
    codlog INT PRIMARY KEY AUTO_INCREMENT,
    feclog TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    acclog VARCHAR(20) NOT NULL,
    tablog VARCHAR(50) NULL,
    reglog VARCHAR(50) NULL,
    iplog VARCHAR(45) NULL,
    codusu INT NOT NULL,
    codmod INT NULL,                        -- [NUEVO] módulo donde ocurrió la acción, para filtrar
                                            -- "¿qué pasó en Compras?". NULL en LOGIN/LOGOUT (no son de un módulo).
    CHECK (acclog IN ('INSERT','UPDATE','DELETE','LOGIN','LOGOUT')),
    FOREIGN KEY (codusu) REFERENCES usuario(codusu),
    FOREIGN KEY (codmod) REFERENCES modulo(codmod)                      -- [NUEVO]
)ENGINE=InnoDB;

-- --------------------------------------------
-- FIDELIZACIÓN
-- --------------------------------------------

CREATE TABLE cuentapuntos(
    codcpun INT PRIMARY KEY AUTO_INCREMENT,
    salcpun INT NOT NULL DEFAULT 0,
    feccpun TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    codcli INT NOT NULL UNIQUE,
    codniv INT NOT NULL,                    -- [NUEVO] nivel actual del cliente (Bronce/Plata/Oro)
    CHECK (salcpun >= 0),
    FOREIGN KEY (codcli) REFERENCES cliente(codcli),
    FOREIGN KEY (codniv) REFERENCES nivelfidelizacion(codniv)           -- [NUEVO]
)ENGINE=InnoDB;

CREATE TABLE movimientopuntos(
    codmpun INT PRIMARY KEY AUTO_INCREMENT,
    fecmpun TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    canmpun INT NOT NULL,
    tipmpun VARCHAR(15) NOT NULL,
    codcpun INT NOT NULL,
    codfac INT NULL,
    CHECK (canmpun > 0),
    CHECK (tipmpun IN ('ACUMULACION','CANJE','VENCIMIENTO')),
    FOREIGN KEY (codcpun) REFERENCES cuentapuntos(codcpun),
    FOREIGN KEY (codfac) REFERENCES facturacion(codfac)
)ENGINE=InnoDB;

CREATE TABLE canjerecompensa(
    codcan INT PRIMARY KEY AUTO_INCREMENT,
    feccan TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    puncan INT NOT NULL,
    codcpun INT NOT NULL,
    codrec INT NOT NULL,
    CHECK (puncan > 0),
    FOREIGN KEY (codcpun) REFERENCES cuentapuntos(codcpun),
    FOREIGN KEY (codrec) REFERENCES recompensa(codrec)
)ENGINE=InnoDB;

-- --------------------------------------------
-- ÍNDICES
-- (las columnas UNIQUE y PRIMARY KEY ya tienen índice propio;
--  aquí van las FK y fechas que se usan mucho en búsquedas y reportes)
-- --------------------------------------------

CREATE INDEX idx_empleado_sucursal ON empleado(codsuc);
CREATE INDEX idx_almacen_sucursal ON almacen(codsuc);
CREATE INDEX idx_cargo_tipo ON cargo(codtiemp);                          -- [NUEVO]
CREATE INDEX idx_proveedor_eval ON proveedor(codeeva);                   -- [NUEVO]

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

CREATE INDEX idx_transporte_estado ON transporte(codetra);               -- [NUEVO] buscar vehículos disponibles
CREATE INDEX idx_despacho_factura ON despacho(codfac);
CREATE INDEX idx_detdes_despacho ON detalledespacho(coddes);
CREATE INDEX idx_incidencia_despacho ON incidenciadespacho(coddes);

CREATE INDEX idx_pagocli_factura ON pagocliente(codfac);
CREATE INDEX idx_pagoprov_factura ON pagoproveedor(codfprov);

CREATE INDEX idx_asistencia_empleado ON asistencia(codemp);
CREATE INDEX idx_log_usuario ON auditorialog(codusu);
CREATE INDEX idx_log_fecha ON auditorialog(feclog);
CREATE INDEX idx_log_modulo ON auditorialog(codmod);                     -- [NUEVO]

CREATE INDEX idx_promocion_campana ON promocion(codcam);
CREATE INDEX idx_cuentapuntos_nivel ON cuentapuntos(codniv);             -- [NUEVO]
CREATE INDEX idx_movpun_cuenta ON movimientopuntos(codcpun);
CREATE INDEX idx_canje_cuenta ON canjerecompensa(codcpun);
