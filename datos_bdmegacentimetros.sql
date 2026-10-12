-- --------------------------------------------
-- DATOS DE PRUEBA - BDMEGACENTIMETROS
-- Ejecutar DESPUÉS de bdmegacentimetros.sql (sobre la base recién creada).
-- 5 registros por tabla. En las tablas con estado BIT, el registro 5 está
-- deshabilitado (estado = 0) para probar /custom y PATCH (enable).
-- --------------------------------------------

USE bdmegacentimetros;

-- --------------------------------------------
-- CATÁLOGOS
-- --------------------------------------------

INSERT INTO distrito (coddis, nomdis, estdis) VALUES
(1, 'Miraflores', 1),
(2, 'San Isidro', 1),
(3, 'Santiago de Surco', 1),
(4, 'Los Olivos', 1),
(5, 'Ate', 0);

INSERT INTO sexo (codsex, nomsex, estsex) VALUES
(1, 'Masculino', 1),
(2, 'Femenino', 1),
(3, 'Otro', 1),
(4, 'Prefiero no decir', 1),
(5, 'No especificado', 0);

INSERT INTO tipodocumento (codtipd, nomtipd, esttipd) VALUES
(1, 'DNI', 1),
(2, 'RUC', 1),
(3, 'Carnet de Extranjería', 1),
(4, 'Pasaporte', 1),
(5, 'Partida de Nacimiento', 0);

INSERT INTO tipocliente (codtcli, nomtcli, esttcli) VALUES
(1, 'Minorista', 1),
(2, 'Mayorista', 1),
(3, 'Corporativo', 1),
(4, 'Distribuidor', 1),
(5, 'Ocasional', 0);

INSERT INTO tipocomprobante (codtcom, nomtcom, esttcom) VALUES
(1, 'Boleta de Venta', 1),
(2, 'Factura', 1),
(3, 'Nota de Crédito', 1),
(4, 'Nota de Débito', 1),
(5, 'Ticket', 0);

INSERT INTO categoriaproducto (codcat, nomcat, estcat) VALUES
(1, 'Abarrotes', 1),
(2, 'Bebidas', 1),
(3, 'Limpieza', 1),
(4, 'Cuidado Personal', 1),
(5, 'Snacks', 0);

INSERT INTO marcaproducto (codmar, nommar, estmar) VALUES
(1, 'Gloria', 1),
(2, 'Costeño', 1),
(3, 'Bolívar', 1),
(4, 'San Luis', 1),
(5, 'Sapolio', 0);

INSERT INTO tipoempaque (codtemp, nomtemp, esttemp) VALUES
(1, 'Lata', 1),
(2, 'Bolsa', 1),
(3, 'Botella', 1),
(4, 'Caja', 1),
(5, 'Pote', 0);

INSERT INTO unidadmedida (codumed, nomumed, abrumed, estumed) VALUES
(1, 'Unidad', 'UND', 1),
(2, 'Kilogramo', 'KG', 1),
(3, 'Litro', 'LT', 1),
(4, 'Paquete', 'PQT', 1),
(5, 'Docena', 'DOC', 0);

INSERT INTO tipoalmacen (codtalm, nomtalm, esttalm) VALUES
(1, 'Central', 1),
(2, 'Tienda', 1),
(3, 'Tránsito', 1),
(4, 'Refrigerado', 1),
(5, 'Temporal', 0);

INSERT INTO estadooperativo (codeope, nomeope, deseope) VALUES
(1, 'Operativo', 'Funciona con normalidad'),
(2, 'En mantenimiento', 'Atención parcial por trabajos de mantenimiento'),
(3, 'Cerrado temporalmente', 'Sin atención hasta nuevo aviso'),
(4, 'En remodelación', 'Obras de ampliación o remodelación'),
(5, 'Cerrado definitivamente', 'Local dado de baja');

INSERT INTO tipoempleado (codtiemp, nomtiemp, esttiemp) VALUES
(1, 'Administrativo', 1),
(2, 'Operativo', 1),
(3, 'Gerencial', 1),
(4, 'Practicante', 1),
(5, 'Tercerizado', 0);

INSERT INTO cargo (codcarg, nomcarg, estcarg, codtiemp) VALUES
(1, 'Gerente de Tienda', 1, 3),
(2, 'Asistente Administrativo', 1, 1),
(3, 'Vendedor', 1, 2),
(4, 'Almacenero', 1, 2),
(5, 'Cajero', 0, 2);

INSERT INTO estadoasistencia (codeasis, nomeasis, deseasis) VALUES
(1, 'Puntual', 'Ingresó dentro del horario'),
(2, 'Tardanza', 'Ingresó después de la hora de entrada'),
(3, 'Falta', 'No se presentó a trabajar'),
(4, 'Falta Justificada', 'Inasistencia con sustento presentado'),
(5, 'Permiso', 'Salida autorizada antes del fin de turno');

INSERT INTO estadoevaluacion (codeeva, nomeeva, esteeva) VALUES
(1, 'Pendiente', 1),
(2, 'Aprobado', 1),
(3, 'Rechazado', 1),
(4, 'En revisión', 1),
(5, 'Suspendido', 0);

INSERT INTO tipotransporte (codttra, nomttra, estttra) VALUES
(1, 'Motocicleta', 1),
(2, 'Furgoneta', 1),
(3, 'Camión', 1),
(4, 'Camioneta', 1),
(5, 'Courier externo', 0);

INSERT INTO estadotransporte (codetra, nometra, estetra) VALUES
(1, 'Disponible', 1),
(2, 'En ruta', 1),
(3, 'En mantenimiento', 1),
(4, 'Reservado', 1),
(5, 'Fuera de servicio', 0);

INSERT INTO tipoincidencia (codtinc, nomtinc, esttinc) VALUES
(1, 'Retraso en la entrega', 1),
(2, 'Producto dañado', 1),
(3, 'Dirección errada', 1),
(4, 'Cliente ausente', 1),
(5, 'Pedido incompleto', 0);

INSERT INTO metodopago (codmpag, nommpag, estmpag) VALUES
(1, 'Efectivo', 1),
(2, 'Tarjeta de crédito/débito', 1),
(3, 'Yape/Plin', 1),
(4, 'Transferencia bancaria', 1),
(5, 'Cheque', 0);

INSERT INTO estadopago (codepag, nomepag, estepag) VALUES
(1, 'Pendiente', 1),
(2, 'En proceso', 1),
(3, 'Realizado', 1),
(4, 'Anulado', 1),
(5, 'Rechazado', 0);

INSERT INTO tipomovimiento (codtmov, nomtmov, sigtmov, esttmov) VALUES
(1, 'Entrada por compra', 1, 1),
(2, 'Salida por venta', -1, 1),
(3, 'Entrada por traslado', 1, 1),
(4, 'Salida por traslado', -1, 1),
(5, 'Ajuste por merma', -1, 0);

INSERT INTO rol (codrol, nomrol, estrol) VALUES
(1, 'Administrador', 1),
(2, 'Vendedor', 1),
(3, 'Almacenero', 1),
(4, 'Contador', 1),
(5, 'Auditor', 0);

INSERT INTO modulo (codmod, nommod, rutmod, estmod) VALUES
(1, 'Ventas', '/ventas', 1),
(2, 'Compras', '/compras', 1),
(3, 'Inventario', '/inventario', 1),
(4, 'Despacho', '/despacho', 1),
(5, 'Marketing', '/marketing', 0);

INSERT INTO capacitacion (codcap, nomcap, descap, inicap, fincap, horcap, estcap) VALUES
(1, 'Atención al cliente', 'Técnicas de servicio y manejo de reclamos', '2026-03-02', '2026-03-06', 20, 1),
(2, 'Seguridad y salud en el trabajo', 'Prevención de riesgos y uso de EPP', '2026-04-06', '2026-04-10', 16, 1),
(3, 'Manejo de inventarios', 'Kardex, rotación de stock y conteo cíclico', '2026-05-04', '2026-05-15', 24, 1),
(4, 'Manejo defensivo', 'Conducción segura para personal de reparto', '2026-10-19', '2026-10-23', 12, 1),
(5, 'Excel avanzado', 'Tablas dinámicas y reportes', '2026-07-06', '2026-07-17', 30, 0);

INSERT INTO campana (codcam, nomcam, descam, inicam, fincam, estcam) VALUES
(1, 'Campaña Escolar 2026', 'Descuentos para la temporada escolar', '2026-02-15', '2026-03-31', 1),
(2, 'Día de la Madre', 'Ofertas especiales por el Día de la Madre', '2026-05-01', '2026-05-10', 1),
(3, 'Fiestas Patrias', 'Promociones por Fiestas Patrias', '2026-07-15', '2026-07-31', 1),
(4, 'Cyber Megacentímetros', 'Descuentos de octubre en abarrotes', '2026-10-01', '2026-10-31', 1),
(5, 'Navidad 2025', 'Campaña navideña del año anterior', '2025-12-01', '2025-12-31', 0);

INSERT INTO recompensa (codrec, nomrec, desrec, punrec, estrec) VALUES
(1, 'Vale de S/ 20', 'Vale de consumo en cualquier sucursal', 500, 1),
(2, 'Vale de S/ 50', 'Vale de consumo en cualquier sucursal', 1000, 1),
(3, 'Envío gratis', 'Despacho sin costo en el siguiente pedido', 300, 1),
(4, 'Canasta de abarrotes', 'Canasta con productos de primera necesidad', 1500, 1),
(5, 'Tomatodo Megacentímetros', 'Artículo promocional de la marca', 200, 0);

INSERT INTO nivelfidelizacion (codniv, nomniv, minniv, desniv, estniv) VALUES
(1, 'Bronce', 0, 'Acumula 1 punto por cada sol', 1),
(2, 'Plata', 1000, 'Acumula puntos y recibe ofertas exclusivas', 1),
(3, 'Oro', 3000, 'Envío gratis en compras mayores a S/ 100', 1),
(4, 'Platino', 6000, 'Envío gratis y 5% de descuento permanente', 1),
(5, 'Diamante', 10000, 'Nivel en evaluación', 0);

-- --------------------------------------------
-- ALMACENES Y SUCURSALES
-- --------------------------------------------

INSERT INTO sucursal (codsuc, nomsuc, dirsuc, telsuc, estsuc, coddis, codeope) VALUES
(1, 'Megacentímetros Miraflores', 'Av. Larco 345', '01-4451234', 1, 1, 1),
(2, 'Megacentímetros San Isidro', 'Av. Javier Prado Este 1120', '01-4229876', 1, 2, 1),
(3, 'Megacentímetros Surco', 'Av. Primavera 890', '01-2715566', 1, 3, 1),
(4, 'Megacentímetros Los Olivos', 'Av. Carlos Izaguirre 456', '01-5283344', 1, 4, 2),
(5, 'Megacentímetros Ate', 'Av. Nicolás Ayllón 2780', '01-3567788', 0, 5, 3);

INSERT INTO almacen (codalm, nomalm, diralm, capalm, coddis, codtalm, codsuc, codeope) VALUES
(1, 'Almacén Central Los Olivos', 'Av. Naranjal 1500', 5000, 4, 1, 4, 1),
(2, 'Almacén Tienda Miraflores', 'Av. Larco 345 - Sótano', 800, 1, 2, 1, 1),
(3, 'Almacén Tienda San Isidro', 'Av. Javier Prado Este 1120 - Sótano', 700, 2, 2, 2, 1),
(4, 'Almacén Refrigerado Surco', 'Av. Primavera 900', 1200, 3, 4, 3, 1),
(5, 'Almacén Tránsito Ate', 'Av. Nicolás Ayllón 2790', 600, 5, 3, 5, 3);

-- --------------------------------------------
-- PERSONAS
-- --------------------------------------------

INSERT INTO empleado (codemp, nomemp, apepemp, apememp, docemp, feccemp, nacemp, diremp, telemp, celemp, coremp, estemp, coddis, codsex, codtipd, codcarg, codsuc) VALUES
(1, 'Carlos', 'Ramírez', 'Torres', '45879632', '2020-03-01', 'Peruana', 'Av. Benavides 1450', '01-2456789', '987654321', 'carlos.ramirez@megacentimetros.pe', 1, 1, 1, 1, 1, 1),
(2, 'María', 'Gonzales', 'Quispe', '46123987', '2021-06-15', 'Peruana', 'Jr. Las Begonias 230', '01-4412233', '986543210', 'maria.gonzales@megacentimetros.pe', 1, 2, 2, 1, 2, 2),
(3, 'Luis', 'Fernández', 'Rojas', '47896541', '2022-01-10', 'Peruana', 'Calle Los Pinos 145', NULL, '985432109', 'luis.fernandez@megacentimetros.pe', 1, 1, 1, 1, 3, 1),
(4, 'José', 'Huamán', 'Castillo', '48523697', '2022-08-20', 'Peruana', 'Av. Universitaria 5600', NULL, '984321098', 'jose.huaman@megacentimetros.pe', 1, 4, 1, 1, 4, 4),
(5, 'Ana', 'Valdivia', 'Pérez', '001234567', '2023-02-01', 'Venezolana', 'Av. Separadora Industrial 890', NULL, '983210987', 'ana.valdivia@megacentimetros.pe', 0, 5, 2, 3, 5, 5);

INSERT INTO cliente (codcli, nomcli, apepcli, apemcli, razcli, doccli, naccli, dircli, telcli, celcli, corcli, estcli, coddis, codsex, codtipd, codtcli) VALUES
(1, 'Rosa', 'Medina', 'Salas', NULL, '70123456', 'Peruana', 'Av. Pardo 560', NULL, '991234567', 'rosa.medina@ejemplo.com', 1, 1, 2, 1, 1),
(2, 'Jorge', 'Paredes', 'Linares', NULL, '71234567', 'Peruana', 'Jr. Cahuide 320', '01-4567890', '992345678', 'jorge.paredes@ejemplo.com', 1, 3, 1, 1, 1),
(3, NULL, NULL, NULL, 'Bodega El Progreso E.I.R.L.', '20512345678', NULL, 'Av. Antúnez de Mayolo 1020', '01-5321234', '993456789', 'ventas@bodegaelprogreso.pe', 1, 4, NULL, 2, 2),
(4, NULL, NULL, NULL, 'Distribuidora Andina S.A.C.', '20601234567', NULL, 'Av. República de Panamá 3450', '01-4223344', '994567890', 'compras@distribuidoraandina.pe', 1, 2, NULL, 2, 4),
(5, 'Pedro', 'Castro', 'Ruiz', NULL, '72345678', 'Peruana', 'Av. Los Próceres 780', NULL, '995678901', 'pedro.castro@ejemplo.com', 0, 3, 1, 1, 1);

INSERT INTO proveedor (codprov, nomprov, apepprov, apemprov, razprov, rucprov, corprov, telprov, celprov, estprov, dirprov, coddis, codeeva, feceva) VALUES
(1, NULL, NULL, NULL, 'Distribuidora Lima Norte S.A.C.', '20100011122', 'ventas@limanorte.pe', '01-5301122', '961122334', 1, 'Av. Túpac Amaru 4500', 4, 2, '2026-01-15'),
(2, NULL, NULL, NULL, 'Comercial Andes Import S.A.', '20200022233', 'pedidos@andesimport.pe', '01-4405566', '962233445', 1, 'Av. Canaval y Moreyra 480', 2, 2, '2026-02-10'),
(3, NULL, NULL, NULL, 'Agroindustrias Costa Verde S.A.C.', '20300033344', 'comercial@costaverde.pe', '01-2719988', '963344556', 1, 'Av. Caminos del Inca 1200', 3, 2, '2026-03-05'),
(4, 'Miguel', 'Torres', 'Vega', NULL, '10456789012', 'miguel.torres@ejemplo.com', NULL, '964455667', 1, 'Jr. Huáscar 215', 1, 1, NULL),
(5, NULL, NULL, NULL, 'Química Industrial Pacífico S.R.L.', '20400044455', 'ventas@quimicapacifico.pe', '01-3264477', '965566778', 0, 'Av. Separadora Industrial 1500', 5, 3, '2026-04-20');

-- --------------------------------------------
-- PRODUCTOS E INVENTARIO
-- --------------------------------------------

INSERT INTO producto (codpro, skupro, nompro, despro, prepro, cospro, estpro, codcat, codmar, codtemp, codumed) VALUES
(1, 'GLO-LEC-400', 'Leche evaporada Gloria 400 g', 'Leche evaporada entera en lata', 4.50, 3.60, 1, 1, 1, 1, 1),
(2, 'COS-ARR-001', 'Arroz extra Costeño', 'Arroz extra a granel, venta por kilo', 4.20, 3.30, 1, 1, 2, 2, 2),
(3, 'BOL-DET-2600', 'Detergente Bolívar 2.6 kg', 'Detergente en polvo aroma limón', 32.90, 26.50, 1, 3, 3, 2, 1),
(4, 'SLU-AGU-2500', 'Agua San Luis sin gas 2.5 L', 'Agua de mesa sin gas', 3.80, 2.70, 1, 2, 4, 3, 1),
(5, 'SAP-LAV-500', 'Lavavajilla Sapolio limón 500 g', 'Lavavajilla en crema', 5.90, 4.40, 0, 3, 5, 5, 1);

INSERT INTO stockalmacen (codpro, codalm, cansalm, minsalm) VALUES
(1, 1, 1090, 200),
(2, 1, 2950, 500),
(3, 1, 360, 80),
(1, 2, 30, 50),
(4, 4, 594, 100);

INSERT INTO trasladoalmacen (codtrasl, fectrasl, esttrasl, codalmori, codalmdes, codemp) VALUES
(1, '2026-09-01 08:00:00', 'RECIBIDO', 1, 2, 4),
(2, '2026-09-10 09:30:00', 'RECIBIDO', 1, 3, 4),
(3, '2026-10-05 07:45:00', 'EN TRANSITO', 1, 4, 4),
(4, '2026-10-11 10:00:00', 'PENDIENTE', 1, 2, 4),
(5, '2026-08-20 08:15:00', 'ANULADO', 2, 3, 4);

INSERT INTO detalletraslado (coddtrasl, candtrasl, codpro, codtrasl) VALUES
(1, 100, 1, 1),
(2, 50, 3, 2),
(3, 120, 4, 3),
(4, 80, 2, 4),
(5, 30, 1, 5);

INSERT INTO movimientoinventario (codminv, fecminv, canminv, refminv, codpro, codalm, codtmov, codemp) VALUES
(1, '2026-08-25 10:00:00', 1200, 'GIN-001', 1, 1, 1, 4),
(2, '2026-09-01 08:00:00', 100, 'TRA-001', 1, 1, 4, 4),
(3, '2026-09-01 14:00:00', 100, 'TRA-001', 1, 2, 3, 4),
(4, '2026-10-02 11:20:00', 10, 'PED-001', 1, 2, 2, 3),
(5, '2026-08-28 09:00:00', 3000, 'GIN-002', 2, 1, 1, 4);

-- --------------------------------------------
-- MARKETING
-- --------------------------------------------

INSERT INTO campanasegmento (codcam, codtcli) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 1),
(4, 2);

INSERT INTO promocion (codprom, nomprom, tipprom, valprom, iniprom, finprom, estprom, codcam, codpro, codcat) VALUES
(1, 'Leche Gloria 10% de descuento', 'PORCENTAJE', 10.00, '2026-02-15', '2026-03-31', 1, 1, 1, NULL),
(2, '15% en productos de limpieza', 'PORCENTAJE', 15.00, '2026-05-01', '2026-05-10', 1, 2, NULL, 3),
(3, 'S/ 5 menos en detergente', 'MONTO', 5.00, '2026-07-15', '2026-07-31', 1, 3, 3, NULL),
(4, 'Cyber: 20% en abarrotes', 'PORCENTAJE', 20.00, '2026-10-01', '2026-10-31', 1, 4, NULL, 1),
(5, 'Navidad: S/ 2 menos en agua', 'MONTO', 2.00, '2025-12-01', '2025-12-31', 0, 5, 4, NULL);

-- --------------------------------------------
-- VENTAS
-- --------------------------------------------

INSERT INTO pedido (codped, fecped, totped, estped, codcli, codemp, codsuc) VALUES
(1, '2026-10-02 11:15:00', 36.00, 'DESPACHADO', 1, 3, 1),
(2, '2026-10-03 10:00:00', 168.00, 'DESPACHADO', 3, 3, 1),
(3, '2026-10-06 16:30:00', 658.00, 'PAGADO', 4, 1, 1),
(4, '2026-10-09 12:00:00', 22.80, 'CONFIRMADO', 2, 3, 1),
(5, '2026-10-10 18:20:00', 18.00, 'ANULADO', 5, 3, 1);

INSERT INTO detallepedido (coddped, candped, predped, desdped, subdped, codped, codpro, codalm, codprom) VALUES
(1, 10, 4.50, 9.00, 36.00, 1, 1, 2, 4),
(2, 50, 4.20, 42.00, 168.00, 2, 2, 1, 4),
(3, 20, 32.90, 0.00, 658.00, 3, 3, 1, NULL),
(4, 6, 3.80, 0.00, 22.80, 4, 4, 4, NULL),
(5, 4, 4.50, 0.00, 18.00, 5, 1, 2, NULL);

INSERT INTO facturacion (codfac, serfac, numfac, fecfac, subfac, igvfac, totfac, estfac, codped, codtcom) VALUES
(1, 'B001', 1, '2026-10-02 11:20:00', 30.51, 5.49, 36.00, 'PAGADA', 1, 1),
(2, 'F001', 1, '2026-10-03 10:05:00', 142.37, 25.63, 168.00, 'PAGADA', 2, 2),
(3, 'F001', 2, '2026-10-06 16:40:00', 557.63, 100.37, 658.00, 'PAGADA', 3, 2),
(4, 'B001', 2, '2026-10-09 12:10:00', 19.32, 3.48, 22.80, 'EMITIDA', 4, 1),
(5, 'B001', 3, '2026-10-10 18:30:00', 15.25, 2.75, 18.00, 'ANULADA', 5, 1);

-- --------------------------------------------
-- COMPRAS
-- --------------------------------------------

INSERT INTO ordencompra (codocom, fecocom, estocom, fecentocom, conocom, totocom, codprov, codalm, codemp) VALUES
(1, '2026-08-20 09:00:00', 'RECIBIDA', '2026-08-25', 'Entrega en almacén central, pago a 30 días', 4320.00, 1, 1, 2),
(2, '2026-08-22 10:00:00', 'RECIBIDA', '2026-08-28', 'Entrega en almacén central, pago a 15 días', 9900.00, 3, 1, 2),
(3, '2026-09-15 11:00:00', 'RECIBIDA', '2026-09-22', 'Entrega en dos partes, pago a 30 días', 10600.00, 2, 1, 2),
(4, '2026-10-05 08:30:00', 'RECIBIDA PARCIAL', '2026-10-15', 'Entrega en almacén refrigerado, pago a 30 días', 1620.00, 1, 4, 2),
(5, '2026-07-10 09:00:00', 'ANULADA', '2026-07-20', 'Anulada: proveedor sin evaluación aprobada', 880.00, 4, 1, 2);

INSERT INTO detalleordencompra (coddocom, candocom, cosdocom, subdocom, codocom, codpro) VALUES
(1, 1200, 3.60, 4320.00, 1, 1),
(2, 3000, 3.30, 9900.00, 2, 2),
(3, 400, 26.50, 10600.00, 3, 3),
(4, 600, 2.70, 1620.00, 4, 4),
(5, 200, 4.40, 880.00, 5, 5);

INSERT INTO guiaingreso (codgin, fecgin, estgin, codocom, codalm, codemp) VALUES
(1, '2026-08-25 10:00:00', 'CONFORME', 1, 1, 4),
(2, '2026-08-28 09:00:00', 'CONFORME', 2, 1, 4),
(3, '2026-09-22 14:00:00', 'OBSERVADA', 3, 1, 4),
(4, '2026-09-29 15:30:00', 'CONFORME', 3, 1, 4),
(5, '2026-10-12 09:00:00', 'REGISTRADA', 4, 4, 4);

INSERT INTO detalleguiaingreso (coddgin, candgin, codpro, codgin) VALUES
(1, 1200, 1, 1),
(2, 3000, 2, 2),
(3, 300, 3, 3),
(4, 100, 3, 4),
(5, 300, 4, 5);

INSERT INTO facturaproveedor (codfprov, numfprov, fecfprov, venfprov, totfprov, estfprov, codocom, codprov) VALUES
(1, 'F001-00012345', '2026-08-25', '2026-09-24', 4320.00, 'PAGADA', 1, 1),
(2, 'E001-00000987', '2026-08-28', '2026-09-12', 9900.00, 'PAGADA', 2, 3),
(3, 'F002-00004521', '2026-09-22', '2026-10-22', 7950.00, 'PAGADA PARCIAL', 3, 2),
(4, 'F002-00004610', '2026-09-29', '2026-10-29', 2650.00, 'PENDIENTE', 3, 2),
(5, 'F001-00012399', '2026-10-12', '2026-11-11', 810.00, 'PENDIENTE', 4, 1);

-- --------------------------------------------
-- DESPACHO
-- --------------------------------------------

INSERT INTO transporte (codtra, platra, captra, esttra, codttra, codetra) VALUES
(1, 'A1B-234', 1500.00, 1, 2, 1),
(2, 'C3D-456', 8000.00, 1, 3, 2),
(3, 'E5F-678', 1200.00, 1, 4, 1),
(4, '1234-AB', 150.00, 1, 1, 3),
(5, 'G7H-890', 5000.00, 0, 3, 3);

INSERT INTO despacho (coddes, numdes, fecdes, dirdes, estdes, codfac, codemp, codtra, coddis) VALUES
(1, 'GR-T001-000001', '2026-10-02 15:00:00', 'Av. Pardo 560', 'ENTREGADO', 1, 4, 1, 1),
(2, 'GR-T001-000002', '2026-10-03 14:00:00', 'Av. Antúnez de Mayolo 1020', 'ENTREGADO', 2, 4, 1, 4),
(3, 'GR-T001-000003', '2026-10-07 09:00:00', 'Av. República de Panamá 3450', 'INCIDENCIA', 3, 4, 2, 2),
(4, 'GR-T001-000004', '2026-10-08 10:00:00', 'Av. República de Panamá 3450', 'EN RUTA', 3, 4, 2, 2),
(5, 'GR-T001-000005', '2026-10-10 19:00:00', 'Av. Los Próceres 780', 'ANULADO', 5, 4, 3, 3);

INSERT INTO detalledespacho (coddetdes, candetdes, codpro, codalm, coddes) VALUES
(1, 10, 1, 2, 1),
(2, 50, 2, 1, 2),
(3, 20, 3, 1, 3),
(4, 20, 3, 1, 4),
(5, 4, 1, 2, 5);

INSERT INTO incidenciadespacho (codinc, fecinc, desinc, accinc, estinc, coddes, codtinc) VALUES
(1, '2026-10-07 12:30:00', 'El cliente no se encontraba en el local', 'Se reprogramó la entrega para el día siguiente', 'RESUELTA', 3, 4),
(2, '2026-10-07 12:35:00', 'Dos bolsas de detergente llegaron rotas', 'Se repusieron las bolsas en el segundo despacho', 'RESUELTA', 3, 2),
(3, '2026-10-08 11:00:00', 'Tráfico intenso en la Vía Expresa', 'Se notificó al cliente el nuevo horario', 'EN PROCESO', 4, 1),
(4, '2026-10-03 15:10:00', 'Número de calle mal registrado', 'Se corrigió la dirección con el cliente', 'RESUELTA', 2, 3),
(5, '2026-10-10 19:10:00', 'La unidad asignada no salió por falla mecánica', NULL, 'ABIERTA', 5, 1);

-- --------------------------------------------
-- PERSONAL
-- --------------------------------------------

INSERT INTO asistencia (codasi, fecasi, entasi, salasi, codeasis, codemp) VALUES
(1, '2026-10-09', '08:00:00', '17:00:00', 1, 1),
(2, '2026-10-09', '08:15:00', '17:05:00', 2, 3),
(3, '2026-10-09', NULL, NULL, 3, 4),
(4, '2026-10-09', '07:55:00', '16:30:00', 1, 2),
(5, '2026-10-10', '08:00:00', '13:00:00', 5, 1);

INSERT INTO empleadocapacitacion (codemp, codcap, notecap, estecap, feccomp) VALUES
(3, 1, 17.50, 'APROBADO', '2026-03-06'),
(4, 2, 15.00, 'APROBADO', '2026-04-10'),
(4, 3, 10.00, 'DESAPROBADO', '2026-05-15'),
(2, 3, NULL, 'RETIRADO', NULL),
(4, 4, NULL, 'INSCRITO', NULL);

-- --------------------------------------------
-- PAGOS
-- --------------------------------------------

INSERT INTO pagocliente (codpcli, fecpcli, monpcli, numpcli, codfac, codmpag, codepag) VALUES
(1, '2026-10-02 11:20:00', 36.00, NULL, 1, 1, 3),
(2, '2026-10-03 10:10:00', 168.00, 'OP-120045', 2, 4, 3),
(3, '2026-10-06 16:45:00', 658.00, 'TRX-889900', 3, 2, 3),
(4, '2026-10-09 12:15:00', 22.80, 'YP-334455', 4, 3, 1),
(5, '2026-10-10 18:35:00', 18.00, 'TRX-889955', 5, 2, 4);

INSERT INTO pagoproveedor (codpprov, fecpprov, monpprov, numpprov, codfprov, codmpag, codepag) VALUES
(1, '2026-09-20 10:00:00', 4320.00, 'OP-778899', 1, 4, 3),
(2, '2026-09-10 11:00:00', 9900.00, 'OP-778950', 2, 4, 3),
(3, '2026-10-05 09:30:00', 4000.00, 'OP-779120', 3, 4, 3),
(4, '2026-10-12 09:00:00', 3950.00, 'OP-779300', 3, 4, 2),
(5, '2026-10-12 10:00:00', 2650.00, 'OP-779315', 4, 4, 1);

-- --------------------------------------------
-- SEGURIDAD Y AUDITORÍA
-- --------------------------------------------

INSERT INTO usuario (codusu, nomusu, passusu, estusu, intusu, ultusu, codemp, codrol) VALUES
(1, 'cramirez', SHA2('Mega2026*', 256), 'ACTIVO', 0, '2026-10-12 08:05:00', 1, 1),
(2, 'mgonzales', SHA2('Mega2026*', 256), 'ACTIVO', 0, '2026-10-11 17:40:00', 2, 4),
(3, 'lfernandez', SHA2('Mega2026*', 256), 'ACTIVO', 1, '2026-10-12 08:20:00', 3, 2),
(4, 'jhuaman', SHA2('Mega2026*', 256), 'BLOQUEADO', 3, '2026-10-08 18:00:00', 4, 3),
(5, 'avaldivia', SHA2('Mega2026*', 256), 'INACTIVO', 0, NULL, 5, 2);

INSERT INTO rolpermiso (codrol, codmod, lecper, escper, eliper) VALUES
(1, 1, 1, 1, 1),
(1, 2, 1, 1, 1),
(2, 1, 1, 1, 0),
(3, 3, 1, 1, 0),
(4, 2, 1, 0, 0);

INSERT INTO auditorialog (codlog, feclog, acclog, tablog, reglog, iplog, codusu, codmod) VALUES
(1, '2026-10-12 08:05:00', 'LOGIN', NULL, NULL, '192.168.1.10', 1, NULL),
(2, '2026-10-02 11:15:00', 'INSERT', 'pedido', '1', '192.168.1.25', 3, 1),
(3, '2026-10-03 10:05:00', 'INSERT', 'facturacion', '2', '192.168.1.25', 3, 1),
(4, '2026-08-20 09:00:00', 'INSERT', 'ordencompra', '1', '192.168.1.15', 2, 2),
(5, '2026-10-10 18:40:00', 'UPDATE', 'pedido', '5', '192.168.1.10', 1, 1);

-- --------------------------------------------
-- FIDELIZACIÓN
-- --------------------------------------------

INSERT INTO cuentapuntos (codcpun, salcpun, feccpun, codcli, codniv) VALUES
(1, 350, '2026-01-10 10:00:00', 1, 1),
(2, 1250, '2025-06-15 11:00:00', 2, 2),
(3, 3400, '2025-03-01 09:00:00', 3, 3),
(4, 6200, '2024-11-20 16:00:00', 4, 4),
(5, 0, '2026-02-05 12:00:00', 5, 1);

INSERT INTO movimientopuntos (codmpun, fecmpun, canmpun, tipmpun, codcpun, codfac) VALUES
(1, '2026-10-02 11:20:00', 36, 'ACUMULACION', 1, 1),
(2, '2026-10-03 10:10:00', 168, 'ACUMULACION', 3, 2),
(3, '2026-10-06 16:45:00', 658, 'ACUMULACION', 4, 3),
(4, '2026-09-15 12:00:00', 500, 'CANJE', 2, NULL),
(5, '2026-01-01 00:00:00', 100, 'VENCIMIENTO', 3, NULL);

INSERT INTO canjerecompensa (codcan, feccan, puncan, codcpun, codrec) VALUES
(1, '2026-09-15 12:00:00', 500, 2, 1),
(2, '2026-08-10 15:00:00', 1000, 3, 2),
(3, '2026-07-22 10:30:00', 300, 4, 3),
(4, '2026-09-30 17:00:00', 1500, 4, 4),
(5, '2026-05-12 11:00:00', 300, 1, 3);
