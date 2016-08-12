-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 11-08-2016 a las 15:04:51
-- Versión del servidor: 5.7.13-0ubuntu0.16.04.2
-- Versión de PHP: 7.0.8-0ubuntu0.16.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `CMS_VALMAR_DB`
--
CREATE DATABASE IF NOT EXISTS `CMS_VALMAR_DB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `CMS_VALMAR_DB`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autoridad`
--

DROP TABLE IF EXISTS `autoridad`;
CREATE TABLE `autoridad` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banco`
--

DROP TABLE IF EXISTS `banco`;
CREATE TABLE `banco` (
  `id` int(3) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id` int(5) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `id_categoria` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_direccion`
--

DROP TABLE IF EXISTS `cliente_direccion`;
CREATE TABLE `cliente_direccion` (
  `id` int(11) NOT NULL,
  `id_direccion` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contactos`
--

DROP TABLE IF EXISTS `contactos`;
CREATE TABLE `contactos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `correo` varchar(200) DEFAULT NULL,
  `mensaje` text,
  `telefono` varchar(10) DEFAULT NULL,
  `fecharegistro` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id` int(3) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tabla de datos departamentos de perú';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE `direccion` (
  `id` int(5) NOT NULL,
  `id_distrito` int(3) NOT NULL,
  `referencia` varchar(250) DEFAULT NULL,
  `domicilio` varchar(250) DEFAULT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `latitud` varchar(500) DEFAULT NULL,
  `longitud` varchar(500) DEFAULT NULL,
  `activo` int(1) DEFAULT NULL,
  `id_urbanizacion` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion_envio`
--

DROP TABLE IF EXISTS `direccion_envio`;
CREATE TABLE `direccion_envio` (
  `id` int(11) NOT NULL,
  `distrito` varchar(150) DEFAULT NULL,
  `provincia` varchar(150) DEFAULT NULL,
  `departamento` varchar(150) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `referencia` varchar(250) DEFAULT NULL,
  `domicilio` varchar(250) DEFAULT NULL,
  `numero` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

DROP TABLE IF EXISTS `distrito`;
CREATE TABLE `distrito` (
  `id` int(3) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `id_provincia` int(3) NOT NULL,
  `latitud` varchar(100) DEFAULT NULL,
  `longitud` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tabla de datos distritos de perú';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio`
--

DROP TABLE IF EXISTS `envio`;
CREATE TABLE `envio` (
  `id` int(3) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cuenta`
--

DROP TABLE IF EXISTS `estado_cuenta`;
CREATE TABLE `estado_cuenta` (
  `id` int(11) NOT NULL,
  `id_tienda` int(11) NOT NULL,
  `saldo_acumulado` decimal(10,0) DEFAULT NULL,
  `fecha_limite_pago` timestamp NULL DEFAULT NULL,
  `fecha_ultimo_pago` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cuenta_orden`
--

DROP TABLE IF EXISTS `estado_cuenta_orden`;
CREATE TABLE `estado_cuenta_orden` (
  `id_estado_cuenta` int(11) NOT NULL,
  `id_orden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen_producto`
--

DROP TABLE IF EXISTS `imagen_producto`;
CREATE TABLE `imagen_producto` (
  `id` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `imagen` mediumtext,
  `defecto` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen_tienda`
--

DROP TABLE IF EXISTS `imagen_tienda`;
CREATE TABLE `imagen_tienda` (
  `id` int(11) NOT NULL,
  `id_tienda` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `imagen` mediumtext,
  `defecto` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion_cliente`
--

DROP TABLE IF EXISTS `informacion_cliente`;
CREATE TABLE `informacion_cliente` (
  `id` int(11) NOT NULL,
  `nombres` varchar(150) DEFAULT NULL,
  `apellidos` varchar(150) DEFAULT NULL,
  `correo` varchar(150) DEFAULT NULL,
  `telefono_local` varchar(10) DEFAULT NULL,
  `telefono_movil` varchar(10) DEFAULT NULL,
  `id_cliente` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion_producto`
--

DROP TABLE IF EXISTS `informacion_producto`;
CREATE TABLE `informacion_producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE `marca` (
  `id` int(3) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `estado` int(2) NOT NULL COMMENT 'estatus para indicar si la tienda esta activa o no, dentro d'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_pago`
--

DROP TABLE IF EXISTS `metodo_pago`;
CREATE TABLE `metodo_pago` (
  `id` int(3) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

DROP TABLE IF EXISTS `orden`;
CREATE TABLE `orden` (
  `id` int(11) NOT NULL,
  `id_direccion_envio` int(11) NOT NULL,
  `id_informacion_cliente` int(11) NOT NULL,
  `id_informacion_producto` int(11) NOT NULL,
  `estado_orden` varchar(20) DEFAULT NULL,
  `costo_envio` decimal(10,0) DEFAULT NULL,
  `costo_total` decimal(10,0) DEFAULT NULL,
  `fecha_envio` datetime DEFAULT NULL,
  `firma` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos_por_cuenta`
--

DROP TABLE IF EXISTS `pagos_por_cuenta`;
CREATE TABLE `pagos_por_cuenta` (
  `id` int(11) NOT NULL,
  `id_cuenta` int(11) NOT NULL,
  `saldo_pagado` decimal(10,0) DEFAULT NULL,
  `fecha_pago` timestamp NULL DEFAULT NULL,
  `cuenta_banco` varchar(100) DEFAULT NULL,
  `ordenes` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `descripcion` mediumtext,
  `caracteristicas` mediumtext,
  `precio` decimal(10,0) DEFAULT NULL,
  `presentacion` varchar(45) DEFAULT NULL,
  `descuento` decimal(10,0) DEFAULT NULL,
  `id_marca` int(5) NOT NULL,
  `id_tienda` int(5) NOT NULL,
  `estado` int(1) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_modificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_categoria`
--

DROP TABLE IF EXISTS `producto_categoria`;
CREATE TABLE `producto_categoria` (
  `id` int(11) NOT NULL,
  `id_producto` int(5) NOT NULL,
  `id_categoria` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id` int(3) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `id_departamento` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tabla de datos provincias de perú';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

DROP TABLE IF EXISTS `tienda`;
CREATE TABLE `tienda` (
  `id` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `razon_social` varchar(200) DEFAULT NULL,
  `ruc` varchar(30) DEFAULT NULL,
  `telefono_local` varchar(10) DEFAULT NULL,
  `telefono_movil` varchar(10) DEFAULT NULL,
  `afiliacion` int(2) DEFAULT NULL,
  `afiliacion_valor` int(11) DEFAULT NULL,
  `costo_minimo` decimal(10,0) DEFAULT NULL,
  `estado_abierto` int(1) DEFAULT NULL,
  `horario_atencion` varchar(45) DEFAULT NULL,
  `paginaweb` varchar(200) DEFAULT NULL,
  `tarjeta` int(1) DEFAULT NULL,
  `estado` int(1) NOT NULL COMMENT 'estatus para indicar si la tienda esta activa o no, dentro d',
  `fecha_registro` datetime NOT NULL,
  `fecha_modificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda_banco`
--

DROP TABLE IF EXISTS `tienda_banco`;
CREATE TABLE `tienda_banco` (
  `id` int(11) NOT NULL,
  `id_banco` int(11) NOT NULL,
  `id_tienda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda_direccion`
--

DROP TABLE IF EXISTS `tienda_direccion`;
CREATE TABLE `tienda_direccion` (
  `id` int(5) NOT NULL,
  `id_direccion` int(5) NOT NULL,
  `id_tienda` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda_envio`
--

DROP TABLE IF EXISTS `tienda_envio`;
CREATE TABLE `tienda_envio` (
  `id` int(11) NOT NULL,
  `id_tienda` int(11) NOT NULL,
  `id_envio` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda_metodo_pago`
--

DROP TABLE IF EXISTS `tienda_metodo_pago`;
CREATE TABLE `tienda_metodo_pago` (
  `id` int(11) NOT NULL,
  `id_tienda` int(11) NOT NULL,
  `id_metodo_pago` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda_tipo_tienda`
--

DROP TABLE IF EXISTS `tienda_tipo_tienda`;
CREATE TABLE `tienda_tipo_tienda` (
  `id` int(14) NOT NULL,
  `id_tienda` int(11) NOT NULL,
  `id_tipo_tienda` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda_usuario`
--

DROP TABLE IF EXISTS `tienda_usuario`;
CREATE TABLE `tienda_usuario` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_tienda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
CREATE TABLE `tipo_documento` (
  `id` int(3) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_tienda`
--

DROP TABLE IF EXISTS `tipo_tienda`;
CREATE TABLE `tipo_tienda` (
  `id` int(5) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `token`
--

DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int(11) NOT NULL,
  `authToken` varchar(500) DEFAULT NULL,
  `issuedOn` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expiresOn` timestamp NULL DEFAULT NULL,
  `userId` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `urbanizacion`
--

DROP TABLE IF EXISTS `urbanizacion`;
CREATE TABLE `urbanizacion` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `id_distrito` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(200) DEFAULT NULL,
  `correo` varchar(200) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `tipo` int(1) DEFAULT NULL,
  `valor_documento` varchar(45) DEFAULT NULL,
  `telefono_local` varchar(45) DEFAULT NULL,
  `telefono_movil` varchar(45) DEFAULT NULL,
  `direccion_fiscal` varchar(200) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `id_distrito` int(11) DEFAULT NULL,
  `id_tipo_documento` int(5) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `estado` int(1) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_modificacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_autoridad`
--

DROP TABLE IF EXISTS `usuario_autoridad`;
CREATE TABLE `usuario_autoridad` (
  `id_usuario` int(11) NOT NULL,
  `id_autoridad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
