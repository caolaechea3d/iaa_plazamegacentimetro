-- --------------------------------------------
-- DATOS DE PRUEBA: Plaza Megacentímetros S.A.C.
-- Ejecutar DESPUÉS de bdmegacentimetros_auditoria.sql
-- --------------------------------------------
USE bdmegacentimetros;
SET NAMES utf8mb4;

-- ================= CATÁLOGOS =================
INSERT INTO distrito(coddis, nomdis, desdis) VALUES
 (1,'Lima','Cercado de Lima'),
 (2,'Miraflores','Distrito comercial y turístico'),
 (3,'San Isidro','Distrito financiero'),
 (4,'Santiago de Surco','Zona residencial y comercial'),
 (5,'La Molina','Zona residencial'),
 (6,'San Borja','Zona residencial y comercial'),
 (7,'Callao','Provincia Constitucional del Callao'),
 (8,'Ate','Zona industrial y de almacenes');

INSERT INTO sexo(codsex, nomsex, dessex) VALUES
 (1,'Femenino','Persona de sexo femenino'),
 (2,'Masculino','Persona de sexo masculino');

INSERT INTO tipodocumento(codtipd, nomtipd, destipd) VALUES
 (1,'DNI','Documento Nacional de Identidad (8 dígitos)'),
 (2,'RUC','Registro Único de Contribuyentes (11 dígitos)'),
 (3,'Carnet de Extranjería','Documento para residentes extranjeros'),
 (4,'Pasaporte','Documento de viaje internacional');

INSERT INTO tipocliente(codtcli, nomtcli, destcli) VALUES
 (1,'Minorista','Compra por unidad para consumo propio'),
 (2,'Mayorista','Compra por volumen para reventa'),
 (3,'Corporativo','Empresa con contrato o convenio de compras');

INSERT INTO tipocomprobante(codtcom, nomtcom, destcom) VALUES
 (1,'Factura','Comprobante con RUC del cliente'),
 (2,'Boleta','Comprobante para consumidor final');

INSERT INTO categoriaproducto(codcat, nomcat, descat) VALUES
 (1,'Abarrotes','Alimentos no perecibles de uso diario'),
 (2,'Bebidas','Gaseosas, cervezas, aguas y jugos'),
 (3,'Lácteos y Derivados','Leche, yogurt, mantequilla y quesos'),
 (4,'Limpieza','Detergentes, lejías y desinfectantes'),
 (5,'Cuidado Personal','Higiene y cuidado personal');

INSERT INTO marcaproducto(codmar, nommar, desmar) VALUES
 (1,'Costeño','Arroz y menestras'),
 (2,'Gloria','Lácteos y derivados'),
 (3,'Backus','Cervezas'),
 (4,'Laive','Lácteos y mantequillas'),
 (5,'Alicorp','Aceites, fideos y harinas'),
 (6,'Bolívar','Detergentes y limpieza'),
 (7,'Colgate','Higiene bucal'),
 (8,'Coca-Cola','Gaseosas');

INSERT INTO tipoempaque(codtemp, nomtemp, destemp) VALUES
 (1,'Botella','Envase de plástico o vidrio'),
 (2,'Bolsa','Envase flexible'),
 (3,'Caja','Envase de cartón'),
 (4,'Lata','Envase metálico'),
 (5,'Paquete','Envoltorio sellado');

INSERT INTO unidadmedida(codumed, nomumed, abrumed, desumed) VALUES
 (1,'Unidad','UND','Venta por unidad'),
 (2,'Kilogramo','KG','Venta por peso'),
 (3,'Litro','LT','Venta por volumen'),
 (4,'Caja','CJ','Venta por caja cerrada'),
 (5,'Docena','DOC','Venta por 12 unidades');

INSERT INTO tipoalmacen(codtalm, nomtalm, destalm) VALUES
 (1,'Central','Almacén principal de recepción y distribución'),
 (2,'Regional','Almacén de apoyo a una sucursal'),
 (3,'Tránsito','Almacén temporal de mercadería en movimiento');

INSERT INTO estadooperativo(codeope, nomeope, deseope) VALUES
 (1,'Operativo','Funciona con normalidad'),
 (2,'Mantenimiento','Atención limitada por mantenimiento'),
 (3,'Cerrado temporal','Sin atención por un periodo');

INSERT INTO tipoempleado(codtiemp, nomtiemp, destiemp) VALUES
 (1,'Administrativo','Personal de gestión y oficina'),
 (2,'Operativo','Personal de tienda, almacén y reparto');

INSERT INTO cargo(codcarg, nomcarg, descarg, codtiemp) VALUES
 (1,'Gerente General','Dirige la operación de la empresa',1),
 (2,'Jefe de Almacén','Supervisa inventarios y traslados',1),
 (3,'Vendedor','Atiende y registra pedidos de clientes',2),
 (4,'Almacenero','Recibe, ubica y despacha mercadería',2),
 (5,'Chofer','Transporta pedidos a los clientes',2),
 (6,'Contador','Controla facturación, pagos y compras',1);

INSERT INTO estadoasistencia(codeasis, nomeasis, deseasis) VALUES
 (1,'Puntual','Ingresó dentro del horario'),
 (2,'Tardanza','Ingresó después del horario'),
 (3,'Falta','No asistió sin justificación'),
 (4,'Justificado','Ausencia con sustento');

INSERT INTO estadoevaluacion(codeeva, nomeeva, deseeva) VALUES
 (1,'Pendiente','Evaluación sin realizar'),
 (2,'Aprobado','Proveedor habilitado para compras'),
 (3,'Rechazado','Proveedor no habilitado');

INSERT INTO tipotransporte(codttra, nomttra, desttra) VALUES
 (1,'Furgón','Vehículo cerrado de carga mediana'),
 (2,'Camión','Vehículo de carga pesada'),
 (3,'Camioneta','Vehículo de reparto liviano');

INSERT INTO estadotransporte(codetra, nometra, desetra) VALUES
 (1,'Disponible','Puede asignarse a un despacho'),
 (2,'En Ruta','Realizando un despacho'),
 (3,'Mantenimiento','Fuera de servicio temporal');

INSERT INTO tipoincidencia(codtinc, nomtinc, destinc) VALUES
 (1,'Retraso en entrega','La entrega superó la hora acordada'),
 (2,'Mercadería dañada','Productos con daño en el traslado'),
 (3,'Dirección errada','La dirección registrada no es correcta'),
 (4,'Cliente ausente','Nadie recibió el pedido');

INSERT INTO metodopago(codmpag, nommpag, desmpag) VALUES
 (1,'Efectivo','Pago en caja'),
 (2,'Tarjeta','Débito o crédito'),
 (3,'Transferencia','Transferencia bancaria'),
 (4,'Yape/Plin','Billetera digital');

INSERT INTO estadopago(codepag, nomepag, desepag) VALUES
 (1,'Pendiente','Pago por confirmar'),
 (2,'Realizado','Pago confirmado'),
 (3,'Anulado','Pago anulado');

INSERT INTO tipomovimiento(codtmov, nomtmov, destmov, sigtmov) VALUES
 (1,'ENTRADA_COMPRA','Ingreso por compra a proveedor',1),
 (2,'SALIDA_VENTA','Salida por venta',-1),
 (3,'TRASLADO_SALIDA','Salida por traslado entre almacenes',-1),
 (4,'TRASLADO_ENTRADA','Ingreso por traslado entre almacenes',1),
 (5,'AJUSTE_POSITIVO','Corrección que aumenta el stock',1),
 (6,'AJUSTE_NEGATIVO','Corrección que disminuye el stock',-1);

INSERT INTO rol(codrol, nomrol, desrol) VALUES
 (1,'Administrador','Acceso total al sistema'),
 (2,'Vendedor','Registra pedidos y consulta inventario'),
 (3,'Almacenero','Gestiona inventario, traslados y despachos'),
 (4,'Contador','Gestiona facturación, compras y pagos');

INSERT INTO modulo(codmod, nommod, desmod, rutmod) VALUES
 (1,'Ventas','Pedidos, facturación y pagos de clientes','/ventas'),
 (2,'Compras','Órdenes de compra, guías y facturas de proveedor','/compras'),
 (3,'Inventario','Stock, traslados y kardex','/inventario'),
 (4,'Despacho','Despachos, transporte e incidencias','/despacho'),
 (5,'Personal','Empleados, asistencia y capacitaciones','/personal'),
 (6,'Seguridad','Usuarios, roles y auditoría','/seguridad');

INSERT INTO capacitacion(codcap, nomcap, descap, inicap, fincap, horcap) VALUES
 (1,'Atención al cliente','Técnicas de atención y manejo de reclamos','2026-03-02','2026-03-06',20),
 (2,'Manejo de inventarios','Control de stock, kardex y conteos cíclicos','2026-05-11','2026-05-15',24),
 (3,'Seguridad y salud en el trabajo','Prevención de riesgos en almacén y reparto','2026-09-14','2026-09-18',16);

INSERT INTO campana(codcam, nomcam, descam, inicam, fincam) VALUES
 (1,'Fiestas Patrias 2026','Ofertas por 28 de julio','2026-07-20','2026-07-31'),
 (2,'Campaña Navideña 2026','Ofertas de fin de año','2026-12-01','2026-12-31'),
 (3,'Semana de Ofertas Octubre','Descuentos de mitad de temporada','2026-10-01','2026-10-31');

INSERT INTO recompensa(codrec, nomrec, desrec, punrec) VALUES
 (1,'Vale de S/ 10','Vale de descuento para la próxima compra',500),
 (2,'Bolsa ecológica','Bolsa reutilizable con logo',150),
 (3,'Descuento 15% próxima compra','Descuento sobre el total de una compra',800),
 (4,'Canasta de productos','Canasta con productos de abarrotes',2000);

INSERT INTO nivelfidelizacion(codniv, nomniv, minniv, desniv) VALUES
 (1,'BRONCE',0,'Acumula 1 punto por cada S/ 1 de compra'),
 (2,'PLATA',500,'Acumulación de puntos y ofertas exclusivas'),
 (3,'ORO',1500,'Mayor acumulación, ofertas y atención preferente');

INSERT INTO estadopedido(codeped, nomeped, deseped) VALUES
 (1,'PENDIENTE','Pedido registrado, sin confirmar'),
 (2,'CONFIRMADO','Pedido confirmado por el cliente'),
 (3,'PAGADO','Pedido con pago registrado'),
 (4,'DESPACHADO','Pedido entregado a despacho'),
 (5,'ANULADO','Pedido anulado');

INSERT INTO estadoenvio(codeenv, nomeenv, deseenv) VALUES
 (1,'PREPARACION','Despacho en preparación'),
 (2,'EN RUTA','Despacho en camino al cliente'),
 (3,'ENTREGADO','Despacho entregado'),
 (4,'INCIDENCIA','Despacho con incidencia abierta'),
 (5,'ANULADO','Despacho anulado');

INSERT INTO estadoordencompra(codeocom, nomeocom, deseocom) VALUES
 (1,'EMITIDA','Orden emitida al proveedor'),
 (2,'APROBADA','Orden aprobada'),
 (3,'RECIBIDA PARCIAL','Mercadería recibida en parte'),
 (4,'RECIBIDA','Mercadería recibida completa'),
 (5,'ANULADA','Orden anulada');

INSERT INTO estadocapacitacion(codecap, nomecap, desecap) VALUES
 (1,'INSCRITO','Empleado inscrito en la capacitación'),
 (2,'APROBADO','Empleado aprobó la capacitación'),
 (3,'DESAPROBADO','Empleado desaprobó la capacitación'),
 (4,'RETIRADO','Empleado se retiró de la capacitación');

-- ================= ALMACENES Y SUCURSALES =================
INSERT INTO sucursal(codsuc, nomsuc, dirsuc, telsuc, dessuc, coddis, codeope) VALUES
 (1,'Sucursal Miraflores','Av. Larco 1234','014451234','Tienda principal',2,1),
 (2,'Sucursal San Isidro','Av. Javier Prado Este 456','014452345','Atención a empresas',3,1),
 (3,'Sucursal Surco','Av. Primavera 890','014453456','Tienda de barrio',4,1);

INSERT INTO almacen(codalm, nomalm, diralm, capalm, coddis, codtalm, codsuc, codeope, desalm) VALUES
 (1,'Almacén Central Ate','Av. Nicolás Ayllón 2100',5000,8,1,1,1,'Recepción y distribución general'),
 (2,'Almacén Miraflores','Calle Los Pinos 150',800,2,2,1,1,'Apoyo a la sucursal Miraflores'),
 (3,'Almacén San Isidro','Calle Las Begonias 320',900,3,2,2,1,'Apoyo a la sucursal San Isidro'),
 (4,'Almacén Surco','Av. Caminos del Inca 700',700,4,2,3,2,'Apoyo a la sucursal Surco');

-- ================= PERSONAS =================
INSERT INTO empleado(codemp, nomemp, apepemp, apememp, docemp, feccemp, nacemp, diremp, telemp, celemp, coremp, desemp, coddis, codsex, codtipd, codcarg, codsuc) VALUES
 (1,'Carlos','Ramírez','Torres','40123456','2020-01-15','Peruana','Av. Arequipa 1020, Lima','014441001','987654321','c.ramirez@megacentimetros.pe','Gerente fundador',2,2,1,1,1),
 (2,'María Fernanda','Quispe','Huamán','41234567','2021-03-01','Peruana','Jr. Cusco 455, Lima','014441002','987654322','m.quispe@megacentimetros.pe',NULL,1,1,1,2,1),
 (3,'José Luis','Mendoza','Rojas','42345678','2022-02-10','Peruana','Av. Brasil 2300, Lima','014441003','987654323','j.mendoza@megacentimetros.pe',NULL,1,2,1,3,1),
 (4,'Ana Lucía','Paredes','Vega','43456789','2022-06-20','Peruana','Av. Universitaria 1500, Lima','014441004','987654324','a.paredes@megacentimetros.pe',NULL,3,1,1,3,2),
 (5,'Pedro Pablo','Castillo','Díaz','44567890','2021-09-05','Peruana','Calle Los Olivos 88, Ate','014441005','987654325','p.castillo@megacentimetros.pe',NULL,8,2,1,4,1),
 (6,'Luis Alberto','Flores','Gómez','45678901','2023-01-16','Peruana','Av. Nicolás Ayllón 3300, Ate','014441006','987654326','l.flores@megacentimetros.pe','Licencia A-IIIb',8,2,1,5,1),
 (7,'Rosa Elena','Salazar','Cruz','46789012','2020-11-02','Peruana','Av. Benavides 760, Surco','014441007','987654327','r.salazar@megacentimetros.pe',NULL,4,1,1,6,1),
 (8,'Jorge Antonio','Vargas','León','47890123','2024-04-08','Peruana','Av. Primavera 1450, Surco','014441008','987654328','j.vargas@megacentimetros.pe',NULL,4,2,1,3,3);

INSERT INTO cliente(codcli, nomcli, apepcli, apemcli, razcli, doccli, feccli, naccli, dircli, telcli, celcli, corcli, descli, coddis, codsex, codtipd, codtcli) VALUES
 (1,'Juan Carlos','Pérez','Soto',NULL,'70123456','2026-01-10 10:00:00','Peruana','Jr. Lampa 320, Lima',NULL,'955111001','jperez@correo.pe',NULL,1,2,1,1),
 (2,'Lucía','Gómez','Rivas',NULL,'71234567','2026-02-14 11:30:00','Peruana','Av. Pardo 780, Miraflores',NULL,'955111002','lgomez@correo.pe',NULL,2,1,1,1),
 (3,NULL,NULL,NULL,'Bodega Don Pepe S.A.C.','20512345678','2026-01-20 09:15:00',NULL,'Av. Los Héroes 1200, Lima','014461001','955111003','compras@donpepe.pe','Bodega con compras semanales',1,NULL,2,2),
 (4,NULL,NULL,NULL,'Restaurante El Buen Sabor E.I.R.L.','20523456789','2026-03-05 15:00:00',NULL,'Av. Conquistadores 215, San Isidro','014461002','955111004','logistica@buensabor.pe',NULL,3,NULL,2,3),
 (5,'Mark','Thompson','Reyes',NULL,'001234567','2026-05-18 12:45:00','Estadounidense','Calle Monte Rosa 255, Surco',NULL,'955111005','mthompson@correo.com',NULL,4,2,3,1),
 (6,NULL,NULL,NULL,'Distribuidora Andina S.A.C.','20534567890','2026-04-02 08:30:00',NULL,'Av. Argentina 4100, Callao','014461003','955111006','pedidos@andina.pe','Distribuidor zona Callao',7,NULL,2,2);

INSERT INTO proveedor(codprov, nomprov, apepprov, apemprov, razprov, rucprov, corprov, telprov, celprov, fecprov, desprov, dirprov, coddis, codeeva, feceva) VALUES
 (1,NULL,NULL,NULL,'Distribuidora Alimentos del Perú S.A.C.','20601234567','ventas@alimentosperu.pe','014471001','944222001','2025-11-10 10:00:00','Abarrotes y menestras','Av. Industrial 450, Ate',8,2,'2025-11-20'),
 (2,NULL,NULL,NULL,'Lácteos del Valle S.A.C.','20602345678','comercial@lacteosvalle.pe','014471002','944222002','2025-12-01 09:30:00','Lácteos y derivados','Av. Separadora 800, Ate',8,2,'2025-12-10'),
 (3,NULL,NULL,NULL,'Bebidas Nacionales S.A.','20603456789','ventas@bebidasnac.pe','014471003','944222003','2026-01-15 11:00:00','Gaseosas y cervezas','Av. Nicolás Ayllón 5000, Ate',8,2,'2026-01-25'),
 (4,NULL,NULL,NULL,'Productos de Limpieza Brillo S.A.C.','20604567890','info@brillo.pe','014471004','944222004','2026-09-20 16:00:00','Evaluación en curso','Jr. Huancavelica 90, Callao',7,1,NULL);

-- ================= PRODUCTOS E INVENTARIO =================
INSERT INTO producto(codpro, skupro, nompro, despro, fecpro, prepro, cospro, codcat, codmar, codtemp, codumed) VALUES
 (1,'ABR-0001','Arroz Superior 5 kg','Arroz extra de grano largo','2025-11-15 10:00:00',24.90,20.50,1,1,2,1),
 (2,'ABR-0002','Aceite Vegetal 1 L','Aceite vegetal comestible','2025-11-15 10:05:00',9.90,7.80,1,5,1,1),
 (3,'ABR-0003','Azúcar Rubia 1 kg','Azúcar rubia de caña','2025-11-15 10:10:00',4.50,3.60,1,1,2,1),
 (4,'LAC-0001','Leche Evaporada 400 g','Leche evaporada entera en lata','2025-12-10 09:00:00',4.20,3.30,3,2,4,1),
 (5,'LAC-0002','Yogurt Natural 1 L','Yogurt natural sin azúcar','2025-12-10 09:05:00',8.50,6.90,3,2,1,1),
 (6,'LAC-0003','Mantequilla 200 g','Mantequilla con sal','2025-12-10 09:10:00',7.90,6.20,3,4,5,1),
 (7,'BEB-0001','Gaseosa 2.5 L','Gaseosa sabor cola','2026-01-20 10:00:00',11.50,9.20,2,8,1,1),
 (8,'BEB-0002','Cerveza Lata 355 ml','Cerveza rubia en lata','2026-01-20 10:05:00',4.50,3.20,2,3,4,1),
 (9,'LIM-0001','Detergente en Polvo 2 kg','Detergente para ropa','2026-02-05 11:00:00',19.90,15.80,4,6,2,1),
 (10,'LIM-0002','Lejía 1 L','Lejía desinfectante','2026-02-05 11:05:00',4.90,3.50,4,6,1,1),
 (11,'CUI-0001','Pasta Dental 75 ml','Pasta dental con flúor','2026-02-12 12:00:00',6.50,4.80,5,7,3,1),
 (12,'ABR-0004','Fideos Spaghetti 500 g','Fideos de sémola','2025-11-15 10:15:00',3.80,2.90,1,5,2,1);

INSERT INTO stockalmacen(codpro, codalm, cansalm, minsalm) VALUES
 (1,1,378,50),(2,1,299,50),(3,1,170,40),(4,1,232,60),(5,1,96,30),(6,1,78,30),
 (7,1,150,40),(8,1,294,60),(9,1,100,30),(10,1,120,30),(11,1,200,40),(12,1,180,40),
 (1,2,100,20),(2,2,60,15),(4,2,30,20),(7,2,25,10),
 (1,3,40,10),(4,3,96,20),(8,3,173,40),(10,3,50,15),
 (1,4,60,15),(7,4,40,10),(11,4,90,20),(12,4,120,25);

INSERT INTO trasladoalmacen(codtrasl, fectrasl, esttrasl, codalmori, codalmdes, codemp) VALUES
 (1,'2026-09-20 09:00:00','RECIBIDO',1,2,5),
 (2,'2026-09-28 10:30:00','RECIBIDO',1,3,5),
 (3,'2026-10-10 08:15:00','EN TRANSITO',1,2,5);

INSERT INTO detalletraslado(coddtrasl, candtrasl, codpro, codtrasl) VALUES
 (1,100,1,1),(2,60,2,1),
 (3,120,4,2),(4,200,8,2),
 (5,80,7,3),(6,40,9,3);

INSERT INTO movimientoinventario(codminv, fecminv, canminv, refminv, codpro, codalm, codtmov, codemp) VALUES
 (1,'2026-09-10 09:00:00',500,'OC-000001',1,1,1,5),
 (2,'2026-09-10 09:00:00',300,'OC-000001',2,1,1,5),
 (3,'2026-09-10 09:00:00',200,'OC-000001',3,1,1,5),
 (4,'2026-09-20 10:00:00',400,'OC-000002',4,1,1,5),
 (5,'2026-09-20 10:00:00',100,'OC-000002',5,1,1,5),
 (6,'2026-09-20 09:00:00',100,'TR-000001',1,1,3,5),
 (7,'2026-09-20 15:00:00',100,'TR-000001',1,2,4,5),
 (8,'2026-09-20 09:00:00',60,'TR-000001',2,1,3,5),
 (9,'2026-09-20 15:00:00',60,'TR-000001',2,2,4,5),
 (10,'2026-09-28 10:30:00',120,'TR-000002',4,1,3,5),
 (11,'2026-09-28 16:00:00',120,'TR-000002',4,3,4,5),
 (12,'2026-10-02 10:30:00',2,'B001-00000001',1,1,2,3),
 (13,'2026-10-02 10:30:00',1,'B001-00000001',2,1,2,3),
 (14,'2026-10-03 12:00:00',20,'F001-00000001',1,1,2,3),
 (15,'2026-10-05 09:45:00',24,'F001-00000002',4,3,2,4),
 (16,'2026-10-06 18:00:00',3,'AJ-000001',8,3,6,2);

-- ================= MARKETING =================
INSERT INTO campanasegmento(codcam, codtcli) VALUES
 (1,1),(1,2),(2,1),(2,3),(3,1),(3,2),(3,3);

INSERT INTO promocion(codprom, nomprom, desprom, tipprom, valprom, iniprom, finprom, codcam, codpro, codcat) VALUES
 (1,'Descuento Abarrotes Fiestas Patrias','10% en toda la categoría Abarrotes','PORCENTAJE',10.00,'2026-07-20','2026-07-31',1,NULL,1),
 (2,'Rebaja Aceite Vegetal','S/ 1.50 menos por unidad','MONTO',1.50,'2026-10-01','2026-10-31',3,2,NULL),
 (3,'Descuento Bebidas Octubre','15% en toda la categoría Bebidas','PORCENTAJE',15.00,'2026-10-01','2026-10-31',3,NULL,2),
 (4,'Navidad Lácteos','12% en lácteos y derivados','PORCENTAJE',12.00,'2026-12-01','2026-12-31',2,NULL,3);

-- ================= VENTAS =================
INSERT INTO pedido(codped, fecped, totped, codeped, codcli, codemp, codsuc) VALUES
 (1,'2026-10-02 10:15:00',82.65,4,1,3,1),
 (2,'2026-10-03 11:40:00',834.60,4,3,3,1),
 (3,'2026-10-05 09:20:00',241.60,3,4,4,2),
 (4,'2026-10-07 16:05:00',24.40,1,5,8,3),
 (5,'2026-10-08 12:30:00',396.50,2,6,3,1),
 (6,'2026-10-09 10:00:00',49.80,4,2,3,1);

INSERT INTO detallepedido(coddped, candped, predped, desdped, subdped, codped, codpro, codalm, codprom) VALUES
 (1,2,24.90,0.00,49.80,1,1,1,NULL),
 (2,1,9.90,0.00,9.90,1,2,1,NULL),
 (3,6,4.50,4.05,22.95,1,8,1,3),
 (4,20,24.90,0.00,498.00,2,1,1,NULL),
 (5,30,4.50,0.00,135.00,2,3,1,NULL),
 (6,48,4.20,0.00,201.60,2,4,1,NULL),
 (7,24,4.20,0.00,100.80,3,4,3,NULL),
 (8,10,4.90,0.00,49.00,3,10,3,NULL),
 (9,24,4.50,16.20,91.80,3,8,3,3),
 (10,2,6.50,0.00,13.00,4,11,4,NULL),
 (11,3,3.80,0.00,11.40,4,12,4,NULL),
 (12,15,19.90,0.00,298.50,5,9,1,NULL),
 (13,20,4.90,0.00,98.00,5,10,1,NULL),
 (14,4,8.50,0.00,34.00,6,5,1,NULL),
 (15,2,7.90,0.00,15.80,6,6,1,NULL);

INSERT INTO facturacion(codfac, serfac, numfac, fecfac, subfac, igvfac, totfac, estfac, codped, codtcom) VALUES
 (1,'B001',1,'2026-10-02 10:20:00',82.65,14.88,97.53,'PAGADA',1,2),
 (2,'F001',1,'2026-10-03 12:00:00',834.60,150.23,984.83,'PAGADA',2,1),
 (3,'F001',2,'2026-10-05 09:30:00',241.60,43.49,285.09,'PAGADA',3,1),
 (4,'B001',2,'2026-10-09 10:10:00',49.80,8.96,58.76,'EMITIDA',6,2);

-- ================= COMPRAS =================
INSERT INTO ordencompra(codocom, fecocom, codeocom, fecentocom, conocom, totocom, codprov, codalm, codemp) VALUES
 (1,'2026-09-05 10:00:00',4,'2026-09-10','Entrega en almacén central, pago a 30 días',13310.00,1,1,2),
 (2,'2026-09-12 11:00:00',3,'2026-09-20','Entrega en almacén central, pago a 30 días',2355.00,2,1,2),
 (3,'2026-10-08 09:30:00',2,'2026-10-18','Entrega en almacén central, pago a 15 días',3744.00,3,1,2);

INSERT INTO detalleordencompra(coddocom, candocom, cosdocom, subdocom, codocom, codpro) VALUES
 (1,500,20.50,10250.00,1,1),
 (2,300,7.80,2340.00,1,2),
 (3,200,3.60,720.00,1,3),
 (4,400,3.30,1320.00,2,4),
 (5,150,6.90,1035.00,2,5),
 (6,240,9.20,2208.00,3,7),
 (7,480,3.20,1536.00,3,8);

INSERT INTO guiaingreso(codgin, fecgin, estgin, codocom, codalm, codemp) VALUES
 (1,'2026-09-10 08:50:00','CONFORME',1,1,5),
 (2,'2026-09-20 09:40:00','OBSERVADA',2,1,5);

INSERT INTO detalleguiaingreso(coddgin, candgin, codpro, codgin) VALUES
 (1,500,1,1),(2,300,2,1),(3,200,3,1),
 (4,400,4,2),(5,100,5,2);

INSERT INTO facturaproveedor(codfprov, numfprov, fecfprov, venfprov, totfprov, estfprov, codocom, codprov) VALUES
 (1,'F001-000458','2026-09-10','2026-10-10',13310.00,'PAGADA',1,1),
 (2,'F005-001204','2026-09-20','2026-10-20',2010.00,'PAGADA PARCIAL',2,2);

-- ================= DESPACHO =================
INSERT INTO transporte(codtra, platra, captra, destra, codttra, codetra) VALUES
 (1,'AQP-452',1500.00,'Furgón de reparto urbano',1,1),
 (2,'BNT-781',8000.00,'Camión para pedidos mayoristas',2,2),
 (3,'CMR-310',600.00,'Camioneta en revisión mecánica',3,3);

INSERT INTO despacho(coddes, numdes, fecdes, dirdes, codeenv, codfac, codemp, codtra, coddis) VALUES
 (1,'DES-000001','2026-10-02 14:00:00','Jr. Lampa 320, Lima',3,1,6,1,1),
 (2,'DES-000002','2026-10-04 09:00:00','Av. Los Héroes 1200, Lima',3,2,6,2,1),
 (3,'DES-000003','2026-10-10 10:00:00','Av. Pardo 780, Miraflores',4,4,6,2,2);

INSERT INTO detalledespacho(coddetdes, candetdes, codpro, codalm, coddes) VALUES
 (1,2,1,1,1),(2,1,2,1,1),(3,6,8,1,1),
 (4,20,1,1,2),(5,30,3,1,2),(6,48,4,1,2),
 (7,4,5,1,3),(8,2,6,1,3);

INSERT INTO incidenciadespacho(codinc, fecinc, desinc, accinc, estinc, coddes, codtinc) VALUES
 (1,'2026-10-04 10:15:00','Retraso de 30 minutos por tráfico en Av. Javier Prado','Se notificó al cliente y se entregó el mismo día','RESUELTA',2,1),
 (2,'2026-10-10 11:30:00','Cliente no se encontraba en el domicilio al momento de la entrega','Se reprogramó la entrega para el día siguiente','EN PROCESO',3,4);

-- ================= PERSONAL =================
INSERT INTO asistencia(codasi, fecasi, entasi, salasi, codeasis, codemp) VALUES
 (1,'2026-10-12','08:00:00','17:00:00',1,1),
 (2,'2026-10-12','08:25:00','17:00:00',2,2),
 (3,'2026-10-12','07:58:00','17:02:00',1,3),
 (4,'2026-10-12','08:40:00','17:05:00',2,4),
 (5,'2026-10-12',NULL,NULL,3,5),
 (6,'2026-10-12','07:30:00','16:30:00',1,6),
 (7,'2026-10-12',NULL,NULL,4,7),
 (8,'2026-10-12','08:00:00','17:00:00',1,8);

INSERT INTO empleadocapacitacion(codemp, codcap, notecap, codecap, feccomp) VALUES
 (3,1,17.50,2,'2026-03-06'),
 (4,1,14.00,2,'2026-03-06'),
 (8,1,16.00,2,'2026-03-06'),
 (5,2,9.50,3,'2026-05-15'),
 (5,3,NULL,1,NULL),
 (6,3,NULL,1,NULL);

INSERT INTO pagocliente(codpcli, fecpcli, monpcli, numpcli, codfac, codmpag, codepag) VALUES
 (1,'2026-10-02 10:20:00',97.53,'OP-0001',1,1,2),
 (2,'2026-10-03 12:10:00',500.00,'TRF-77231',2,3,2),
 (3,'2026-10-06 15:00:00',484.83,'TRF-78012',2,3,2),
 (4,'2026-10-05 09:35:00',285.09,'POS-55120',3,2,2),
 (5,'2026-10-09 10:20:00',58.76,NULL,4,4,1);

INSERT INTO pagoproveedor(codpprov, fecpprov, monpprov, numpprov, codfprov, codmpag, codepag) VALUES
 (1,'2026-09-30 11:00:00',13310.00,'TRF-20260930-001',1,3,2),
 (2,'2026-10-05 10:30:00',1000.00,'TRF-20261005-002',2,3,2);

-- ================= SEGURIDAD Y AUDITORÍA =================
-- passusu: hash de ejemplo (NO es una contraseña real; la app debe generar el suyo)
INSERT INTO usuario(codusu, nomusu, passusu, estusu, intusu, ultusu, codemp, codrol) VALUES
 (1,'admin.cramirez','$2b$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy','ACTIVO',0,'2026-10-12 08:01:00',1,1),
 (2,'mquispe','$2b$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy','ACTIVO',0,'2026-10-12 08:30:00',2,3),
 (3,'jmendoza','$2b$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy','ACTIVO',0,'2026-10-12 07:59:00',3,2),
 (4,'aparedes','$2b$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy','ACTIVO',1,'2026-10-12 08:41:00',4,2),
 (5,'rsalazar','$2b$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy','ACTIVO',0,'2026-10-09 09:10:00',7,4),
 (6,'jvargas','$2b$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy','BLOQUEADO',5,'2026-10-08 08:05:00',8,2);

INSERT INTO rolpermiso(codrol, codmod, lecper, escper, eliper) VALUES
 (1,1,1,1,1),(1,2,1,1,1),(1,3,1,1,1),(1,4,1,1,1),(1,5,1,1,1),(1,6,1,1,1),
 (2,1,1,1,0),(2,3,1,0,0),
 (3,2,1,0,0),(3,3,1,1,0),(3,4,1,1,0),
 (4,1,1,0,0),(4,2,1,1,0);

INSERT INTO auditorialog(codlog, feclog, acclog, tablog, reglog, iplog, codusu, codmod) VALUES
 (1,'2026-10-12 07:59:00','LOGIN',NULL,NULL,'192.168.1.25',3,NULL),
 (2,'2026-10-02 10:15:00','INSERT','pedido','1','192.168.1.25',3,1),
 (3,'2026-10-02 10:20:00','INSERT','facturacion','1','192.168.1.25',3,1),
 (4,'2026-10-05 09:20:00','INSERT','pedido','3','192.168.1.31',4,1),
 (5,'2026-10-06 18:00:00','INSERT','movimientoinventario','16','192.168.1.40',2,3),
 (6,'2026-10-08 08:05:00','LOGIN',NULL,NULL,'192.168.1.52',6,NULL),
 (7,'2026-10-09 09:10:00','UPDATE','facturacion','4','192.168.1.60',5,1),
 (8,'2026-10-12 08:01:00','LOGIN',NULL,NULL,'192.168.1.10',1,NULL);

-- ================= FIDELIZACIÓN =================
INSERT INTO cuentapuntos(codcpun, salcpun, feccpun, codcli, codniv) VALUES
 (1,97,'2026-10-02 10:20:00',1,1),
 (2,484,'2026-10-03 12:00:00',3,2),
 (3,285,'2026-10-05 09:30:00',4,1),
 (4,0,'2026-10-09 10:10:00',2,1);

INSERT INTO movimientopuntos(codmpun, fecmpun, canmpun, tipmpun, codcpun, codfac) VALUES
 (1,'2026-10-02 10:20:00',97,'ACUMULACION',1,1),
 (2,'2026-10-03 12:00:00',984,'ACUMULACION',2,2),
 (3,'2026-10-06 18:00:00',500,'CANJE',2,NULL),
 (4,'2026-10-05 09:30:00',285,'ACUMULACION',3,3);

INSERT INTO canjerecompensa(codcan, feccan, puncan, codcpun, codrec) VALUES
 (1,'2026-10-06 18:00:00',500,2,1);
