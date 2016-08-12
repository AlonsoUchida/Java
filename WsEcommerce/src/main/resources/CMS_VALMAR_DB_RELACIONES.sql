-- Indices de la tabla `autoridad`
--
ALTER TABLE `autoridad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `banco`
--
ALTER TABLE `banco`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foreginkey_ibk_idx` (`id_categoria`);

--
-- Indices de la tabla `cliente_direccion`
--
ALTER TABLE `cliente_direccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_direccion` (`id_direccion`),
  ADD KEY `cliiente_usuario_ibfk_2_idx` (`id_cliente`);

--
-- Indices de la tabla `contactos`
--
ALTER TABLE `contactos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_distrito` (`id_distrito`),
  ADD KEY `urbanizaciones_ibfk_1_idx` (`id_urbanizacion`);

--
-- Indices de la tabla `direccion_envio`
--
ALTER TABLE `direccion_envio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_provincia` (`id_provincia`);

--
-- Indices de la tabla `envio`
--
ALTER TABLE `envio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estado_cuenta`
--
ALTER TABLE `estado_cuenta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tienda_idx` (`id_tienda`);

--
-- Indices de la tabla `estado_cuenta_orden`
--
ALTER TABLE `estado_cuenta_orden`
  ADD KEY `fkid_estado_cuenta_orden1_idx` (`id_estado_cuenta`),
  ADD KEY `fkid_estado_cuenta_orden2_idx` (`id_orden`);

--
-- Indices de la tabla `imagen_producto`
--
ALTER TABLE `imagen_producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `imagen_tienda`
--
ALTER TABLE `imagen_tienda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tienda_idx` (`id_tienda`);

--
-- Indices de la tabla `informacion_cliente`
--
ALTER TABLE `informacion_cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario_idx` (`id_cliente`);

--
-- Indices de la tabla `informacion_producto`
--
ALTER TABLE `informacion_producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `costo_envio_UNIQUE` (`costo_envio`),
  ADD KEY `id_direccion_envio` (`id_direccion_envio`),
  ADD KEY `id_informacion_cliente` (`id_informacion_cliente`),
  ADD KEY `id_informacion_producto` (`id_informacion_producto`);

--
-- Indices de la tabla `pagos_por_cuenta`
--
ALTER TABLE `pagos_por_cuenta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkid_pagos_por_cuenta_idx` (`id_cuenta`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tienda` (`id_tienda`),
  ADD KEY `producto_marca_idx` (`id_marca`);

--
-- Indices de la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_departamento` (`id_departamento`);

--
-- Indices de la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tienda_banco`
--
ALTER TABLE `tienda_banco`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkid_banco_idx` (`id_banco`),
  ADD KEY `fkid_tienda_idx` (`id_tienda`);

--
-- Indices de la tabla `tienda_direccion`
--
ALTER TABLE `tienda_direccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_direccion` (`id_direccion`),
  ADD KEY `id_tienda` (`id_tienda`);

--
-- Indices de la tabla `tienda_envio`
--
ALTER TABLE `tienda_envio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tienda` (`id_tienda`),
  ADD KEY `id_envio` (`id_envio`);

--
-- Indices de la tabla `tienda_metodo_pago`
--
ALTER TABLE `tienda_metodo_pago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tienda` (`id_tienda`),
  ADD KEY `id_metodo_pago` (`id_metodo_pago`);

--
-- Indices de la tabla `tienda_tipo_tienda`
--
ALTER TABLE `tienda_tipo_tienda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkid_idtienda_idx` (`id_tienda`),
  ADD KEY `fkid_tipo_tienda_idx` (`id_tipo_tienda`);

--
-- Indices de la tabla `tienda_usuario`
--
ALTER TABLE `tienda_usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkid_usuario_idx` (`id_usuario`),
  ADD KEY `fkid_tienda_idx` (`id_tienda`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_tienda`
--
ALTER TABLE `tipo_tienda`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_TOKENXUSUARIO` (`userId`);

--
-- Indices de la tabla `urbanizacion`
--
ALTER TABLE `urbanizacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkid_distrito_idx` (`id_distrito`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_distrito_idx` (`id_distrito`),
  ADD KEY `fk_tipo_documento_idx` (`id_tipo_documento`),
  ADD KEY `fk_usuario_idx` (`id_usuario`);

--
-- Indices de la tabla `usuario_autoridad`
--
ALTER TABLE `usuario_autoridad`
  ADD KEY `usuario_id` (`id_usuario`),
  ADD KEY `autoridad_id` (`id_autoridad`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autoridad`
--
ALTER TABLE `autoridad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `banco`
--
ALTER TABLE `banco`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `cliente_direccion`
--
ALTER TABLE `cliente_direccion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `contactos`
--
ALTER TABLE `contactos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
--
-- AUTO_INCREMENT de la tabla `direccion_envio`
--
ALTER TABLE `direccion_envio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `envio`
--
ALTER TABLE `envio`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `estado_cuenta`
--
ALTER TABLE `estado_cuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `imagen_producto`
--
ALTER TABLE `imagen_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `imagen_tienda`
--
ALTER TABLE `imagen_tienda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `informacion_cliente`
--
ALTER TABLE `informacion_cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `informacion_producto`
--
ALTER TABLE `informacion_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pagos_por_cuenta`
--
ALTER TABLE `pagos_por_cuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `tienda`
--
ALTER TABLE `tienda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;
--
-- AUTO_INCREMENT de la tabla `tienda_banco`
--
ALTER TABLE `tienda_banco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT de la tabla `tienda_direccion`
--
ALTER TABLE `tienda_direccion`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
--
-- AUTO_INCREMENT de la tabla `tienda_envio`
--
ALTER TABLE `tienda_envio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tienda_metodo_pago`
--
ALTER TABLE `tienda_metodo_pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tienda_tipo_tienda`
--
ALTER TABLE `tienda_tipo_tienda`
  MODIFY `id` int(14) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tienda_usuario`
--
ALTER TABLE `tienda_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `tipo_tienda`
--
ALTER TABLE `tipo_tienda`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `token`
--
ALTER TABLE `token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `foreginkey_ibk` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cliente_direccion`
--
ALTER TABLE `cliente_direccion`
  ADD CONSTRAINT `clientes_direcciones_ibfk_1` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id`),
  ADD CONSTRAINT `cliiente_usuario_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD CONSTRAINT `direcciones_ibfk_3` FOREIGN KEY (`id_distrito`) REFERENCES `distrito` (`id`),
  ADD CONSTRAINT `urbanizaciones_ibfk_1` FOREIGN KEY (`id_urbanizacion`) REFERENCES `urbanizacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD CONSTRAINT `distrito_ibfk_1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id`);

--
-- Filtros para la tabla `estado_cuenta`
--
ALTER TABLE `estado_cuenta`
  ADD CONSTRAINT `fkid_estado_cuenta_tienda` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estado_cuenta_orden`
--
ALTER TABLE `estado_cuenta_orden`
  ADD CONSTRAINT `fkid_estado_cuenta_orden1` FOREIGN KEY (`id_estado_cuenta`) REFERENCES `estado_cuenta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkid_estado_cuenta_orden2` FOREIGN KEY (`id_orden`) REFERENCES `orden` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `imagen_producto`
--
ALTER TABLE `imagen_producto`
  ADD CONSTRAINT `imagenes_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `imagen_tienda`
--
ALTER TABLE `imagen_tienda`
  ADD CONSTRAINT `fk_tienda` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `informacion_cliente`
--
ALTER TABLE `informacion_cliente`
  ADD CONSTRAINT `id_usuario` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `informacion_producto`
--
ALTER TABLE `informacion_producto`
  ADD CONSTRAINT `informacion_producto_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `ordenes_ibfk_1` FOREIGN KEY (`id_direccion_envio`) REFERENCES `direccion_envio` (`id`),
  ADD CONSTRAINT `ordenes_ibfk_2` FOREIGN KEY (`id_informacion_cliente`) REFERENCES `informacion_cliente` (`id`),
  ADD CONSTRAINT `ordenes_ibfk_3` FOREIGN KEY (`id_informacion_producto`) REFERENCES `informacion_producto` (`id`);

--
-- Filtros para la tabla `pagos_por_cuenta`
--
ALTER TABLE `pagos_por_cuenta`
  ADD CONSTRAINT `fkid_pagos_por_cuenta` FOREIGN KEY (`id_cuenta`) REFERENCES `estado_cuenta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`);

--
-- Filtros para la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  ADD CONSTRAINT `productos_categorias_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `productos_categorias_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`);

--
-- Filtros para la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD CONSTRAINT `provincia_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`);

--
-- Filtros para la tabla `tienda_banco`
--
ALTER TABLE `tienda_banco`
  ADD CONSTRAINT `fkid_tienda_banco_1` FOREIGN KEY (`id_banco`) REFERENCES `banco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkid_tienda_banco_2` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tienda_direccion`
--
ALTER TABLE `tienda_direccion`
  ADD CONSTRAINT `tiendas_direcciones_ibfk_1` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id`),
  ADD CONSTRAINT `tiendas_direcciones_ibfk_2` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`);

--
-- Filtros para la tabla `tienda_envio`
--
ALTER TABLE `tienda_envio`
  ADD CONSTRAINT `tiendas_envio_ibfk_1` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`),
  ADD CONSTRAINT `tiendas_envio_ibfk_2` FOREIGN KEY (`id_envio`) REFERENCES `envio` (`id`);

--
-- Filtros para la tabla `tienda_metodo_pago`
--
ALTER TABLE `tienda_metodo_pago`
  ADD CONSTRAINT `tiendas_metodo_pago_ibfk_1` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`),
  ADD CONSTRAINT `tiendas_metodo_pago_ibfk_2` FOREIGN KEY (`id_metodo_pago`) REFERENCES `metodo_pago` (`id`);

--
-- Filtros para la tabla `tienda_tipo_tienda`
--
ALTER TABLE `tienda_tipo_tienda`
  ADD CONSTRAINT `fkid_idtienda` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkid_tipo_tienda` FOREIGN KEY (`id_tipo_tienda`) REFERENCES `tipo_tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tienda_usuario`
--
ALTER TABLE `tienda_usuario`
  ADD CONSTRAINT `fkid_tienda` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkid_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `FK_TOKENXUSUARIO` FOREIGN KEY (`userId`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `urbanizacion`
--
ALTER TABLE `urbanizacion`
  ADD CONSTRAINT `fkid_distrito` FOREIGN KEY (`id_distrito`) REFERENCES `distrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_distrito` FOREIGN KEY (`id_distrito`) REFERENCES `distrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tipo_documento` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario_autoridad`
--
ALTER TABLE `usuario_autoridad`
  ADD CONSTRAINT `usuario_autoridad_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `usuario_autoridad_ibfk_2` FOREIGN KEY (`id_autoridad`) REFERENCES `autoridad` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
