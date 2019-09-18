-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2018 a las 23:02:18
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sistemallanteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calidad`
--

CREATE TABLE IF NOT EXISTS `calidad` (
  `idcalidad` int(11) NOT NULL AUTO_INCREMENT,
  `calidad` varchar(20) NOT NULL,
  PRIMARY KEY (`idcalidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `calidad`
--

INSERT INTO `calidad` (`idcalidad`, `calidad`) VALUES
(1, 'Sin calidad'),
(4, 'Calidad D'),
(5, 'Calidad C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_categoria` varchar(50) NOT NULL,
  `descripcion` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`),
  UNIQUE KEY `Nom_categoria_UNIQUE` (`Nom_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idcategoria`, `Nom_categoria`, `descripcion`) VALUES
(1, 'Sin categoria', 'Sin descripción'),
(4, 'Categoria 2 act', 'descripcion 2 act'),
(5, 'Categoria 3', 'descripcion 3'),
(6, 'Categoria Madera', 'Todo tipo de madera'),
(8, 'Categoria hierro', 'descripcion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(75) DEFAULT NULL,
  `telefono` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idcliente`, `nombre`, `apellido`, `direccion`, `telefono`) VALUES
(1, 'Noe Jonathan', 'Landaverde', 'La esperanza', '70804980'),
(2, 'cristian asdrubal', 'menjivar recinos', 'laguna seca', '88998899'),
(3, 'Diego', 'Ridriguez', 'Chalatenango', '78787878'),
(4, 'Ideas Constructiva', '.', 'Collolito', '12122121'),
(5, 'Feliciano', 'Menjivar', 'Laguna', '32323232'),
(6, 'Marvin', 'Hernandez', 'Amayo', '78788778'),
(7, 'Pedro', 'Valles', 'Nueva', '11122212');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `creditos`
--

CREATE TABLE IF NOT EXISTS `creditos` (
  `idcredito` int(11) NOT NULL AUTO_INCREMENT,
  `idcliente` int(11) NOT NULL,
  `idventa` int(11) NOT NULL,
  `monto` float NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idcredito`),
  KEY `fkcredito_venta_idx` (`idventa`),
  KEY `fkcredito_venta_cliente_idx` (`idcliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Volcado de datos para la tabla `creditos`
--

INSERT INTO `creditos` (`idcredito`, `idcliente`, `idventa`, `monto`, `fecha`) VALUES
(3, 1, 1, 600, '2018-10-10'),
(4, 2, 75, 400, '2018-10-08'),
(5, 2, 76, 313.5, '2018-10-07'),
(6, 2, 77, 613.5, '2018-10-07'),
(7, 2, 80, 1713.5, '2018-10-07'),
(8, 3, 81, 677, '2018-10-07'),
(9, 3, 82, 420, '2018-10-07'),
(10, 4, 83, 600, '2018-10-08'),
(11, 5, 80, 100, '2018-10-07'),
(12, 5, 80, 1400, '2018-10-07'),
(13, 1, 85, 500, '2018-10-09'),
(14, 4, 88, 870.5, '2018-10-11'),
(15, 5, 89, 327, '2018-10-11'),
(16, 2, 91, 1600, '2018-10-12'),
(17, 4, 93, 313.5, '2018-10-13'),
(18, 2, 12, 2333, '2018-10-05'),
(19, 1, 95, 669, '2018-10-15'),
(20, 6, 97, 130, '2018-10-15'),
(21, 7, 98, 400, '2018-10-15'),
(22, 4, 110, 240.2, '2018-10-26'),
(23, 2, 121, 400.2, '2018-10-27'),
(24, 2, 128, 33.2, '2018-10-28'),
(25, 7, 138, 567.2, '2018-10-28'),
(26, 2, 139, 33.2, '2018-10-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleenviosucursal`
--

CREATE TABLE IF NOT EXISTS `detalleenviosucursal` (
  `idDetalleEnvio` int(11) NOT NULL AUTO_INCREMENT,
  `idproducto` int(11) NOT NULL,
  `cantidadEnviada` int(11) NOT NULL,
  `idEnvio` int(11) NOT NULL,
  PRIMARY KEY (`idDetalleEnvio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=133 ;

--
-- Volcado de datos para la tabla `detalleenviosucursal`
--

INSERT INTO `detalleenviosucursal` (`idDetalleEnvio`, `idproducto`, `cantidadEnviada`, `idEnvio`) VALUES
(1, 1, 1, 1),
(2, 8, 1, 1),
(3, 5, 1, 1),
(4, 6, 1, 1),
(5, 7, 1, 1),
(6, 1, 2, 2),
(7, 8, 2, 2),
(8, 5, 2, 2),
(9, 6, 2, 2),
(10, 7, 2, 2),
(11, 12, 2, 2),
(12, 11, 2, 2),
(13, 4, 2, 2),
(14, 1, 1, 3),
(15, 8, 1, 3),
(16, 2, 1, 3),
(17, 3, 1, 3),
(18, 7, 1, 3),
(19, 6, 1, 3),
(20, 5, 1, 3),
(21, 4, 1, 3),
(22, 11, 1, 3),
(23, 12, 1, 3),
(24, 12, 1, 3),
(25, 9, 1, 3),
(26, 10, 1, 3),
(27, 2, 1, 4),
(28, 3, 1, 4),
(29, 2, 1, 5),
(30, 3, 1, 5),
(31, 5, 1, 5),
(32, 6, 1, 5),
(33, 1, 1, 6),
(34, 8, 1, 6),
(35, 3, 1, 6),
(36, 7, 1, 6),
(37, 6, 1, 6),
(38, 2, 1, 6),
(39, 7, 3, 7),
(40, 3, 5, 7),
(41, 9, 2, 7),
(42, 7, 3, 8),
(43, 3, 5, 8),
(44, 9, 2, 8),
(45, 1, 1, 8),
(46, 1, 1, 9),
(47, 8, 1, 9),
(48, 5, 1, 9),
(49, 1, 20, 10),
(50, 4, 5, 10),
(51, 11, 10, 10),
(52, 8, 2, 10),
(53, 9, 1, 10),
(54, 1, 3, 11),
(55, 8, 1, 11),
(56, 7, 2, 11),
(57, 11, 1, 11),
(58, 2, 5, 12),
(59, 3, 5, 12),
(60, 1, 3, 12),
(61, 1, 1, 13),
(62, 15, 3, 13),
(63, 14, 1, 13),
(64, 8, 1, 13),
(65, 11, 1, 14),
(66, 12, 1, 14),
(67, 12, 1, 14),
(68, 12, 1, 14),
(69, 1, 1, 14),
(70, 15, 1, 14),
(71, 14, 1, 14),
(72, 8, 1, 14),
(73, 17, 1, 14),
(74, 2, 1, 15),
(75, 3, 1, 15),
(76, 6, 1, 15),
(77, 7, 1, 15),
(78, 9, 1, 15),
(79, 10, 1, 15),
(80, 7, 1, 15),
(81, 3, 1, 15),
(82, 2, 1, 15),
(83, 6, 1, 15),
(84, 7, 1, 15),
(85, 9, 1, 15),
(86, 7, 1, 15),
(87, 3, 1, 15),
(88, 6, 1, 15),
(89, 5, 1, 15),
(90, 5, 1, 15),
(91, 2, 1, 15),
(92, 3, 1, 15),
(93, 14, 1, 16),
(94, 2, 1, 16),
(95, 6, 1, 16),
(96, 7, 1, 16),
(97, 14, 2, 17),
(98, 12, 2, 17),
(99, 10, 2, 17),
(100, 9, 1, 17),
(101, 16, 3, 17),
(102, 12, 1, 17),
(103, 11, 1, 17),
(104, 4, 3, 17),
(105, 5, 1, 17),
(106, 6, 1, 17),
(107, 2, 50, 18),
(108, 3, 60, 18),
(109, 4, 25, 18),
(110, 14, 100, 19),
(111, 17, 100, 19),
(112, 2, 300, 19),
(113, 3, 50, 19),
(114, 6, 49, 19),
(115, 7, 100, 19),
(116, 5, 200, 19),
(117, 3, 1, 20),
(118, 2, 1, 20),
(119, 8, 1, 21),
(120, 12, 1, 21),
(121, 11, 1, 21),
(122, 9, 50, 22),
(123, 10, 50, 22),
(124, 11, 50, 22),
(125, 12, 50, 22),
(126, 15, 50, 23),
(127, 1, 40, 23),
(128, 16, 40, 23),
(129, 1, 1, 28),
(130, 8, 95, 30),
(131, 17, 95, 30),
(132, 2, 95, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_credito`
--

CREATE TABLE IF NOT EXISTS `detalle_credito` (
  `iddetalle_credito` int(11) NOT NULL AUTO_INCREMENT,
  `idcredito` int(11) NOT NULL,
  `pago` double NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`iddetalle_credito`),
  KEY `fkdetallecredito_credito_idx` (`idcredito`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=62 ;

--
-- Volcado de datos para la tabla `detalle_credito`
--

INSERT INTO `detalle_credito` (`iddetalle_credito`, `idcredito`, `pago`, `fecha`) VALUES
(1, 5, 100, '2018-10-08'),
(2, 5, 100, '2018-10-08'),
(3, 5, 113.5, '2018-10-09'),
(4, 4, 113.5, '2018-10-09'),
(5, 4, 113.5, '2018-10-09'),
(6, 3, 150, '2018-10-09'),
(7, 4, 100, '2018-10-08'),
(8, 3, 100, '2018-10-08'),
(9, 3, 300, '2018-10-08'),
(10, 6, 200, '2018-10-07'),
(11, 6, 100, '2018-10-07'),
(12, 9, 200, '2018-10-07'),
(13, 9, 200, '2018-10-07'),
(14, 9, 10, '2018-10-07'),
(15, 9, 5, '2018-10-07'),
(16, 8, 150, '2018-10-09'),
(17, 8, 150, '2018-10-09'),
(18, 10, 300, '2018-10-08'),
(19, 10, 200, '2018-10-08'),
(20, 10, 100, '2018-10-08'),
(21, 9, 5, '2018-10-07'),
(22, 12, 50, '2018-10-07'),
(23, 12, 50, '2018-10-07'),
(24, 12, 50, '2018-10-07'),
(25, 12, 50, '2018-10-07'),
(26, 12, 50, '2018-10-07'),
(27, 12, 50, '2018-10-07'),
(28, 12, 50, '2018-10-07'),
(29, 12, 50, '2018-10-07'),
(30, 12, 50, '2018-10-07'),
(31, 12, 50, '2018-10-07'),
(32, 12, 50, '2018-10-07'),
(33, 12, 100, '2018-10-07'),
(34, 12, 100, '2018-10-07'),
(35, 12, 100, '2018-10-07'),
(36, 12, 100, '2018-10-07'),
(37, 12, 30, '2018-10-07'),
(38, 12, 20, '2018-10-07'),
(39, 15, 100, '2018-10-11'),
(40, 15, 200, '2018-10-11'),
(41, 15, 17, '2018-10-11'),
(42, 15, 10, '2018-10-11'),
(43, 14, 870.5, '2018-10-11'),
(44, 16, 500, '2018-10-12'),
(45, 16, 500, '2018-10-15'),
(46, 16, 500, '2018-10-16'),
(47, 16, 100, '2018-10-16'),
(48, 17, 34, '2018-10-14'),
(49, 17, 34, '2018-10-15'),
(50, 12, 50, '2018-10-07'),
(51, 12, 50, '2018-10-07'),
(52, 12, 50, '2018-10-07'),
(53, 19, 100, '2018-10-16'),
(54, 19, 100, '2018-10-16'),
(55, 20, 100, '2018-10-18'),
(56, 20, 30, '2018-10-18'),
(57, 21, 100, '2018-10-16'),
(58, 21, 200, '2018-10-17'),
(59, 21, 100, '2018-10-17'),
(60, 23, 200, '2018-10-18'),
(61, 25, 0, '2018-10-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE IF NOT EXISTS `detalle_ventas` (
  `iddetalle_ventas` int(11) NOT NULL AUTO_INCREMENT,
  `idproducto` int(11) NOT NULL,
  `idventa` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`iddetalle_ventas`),
  KEY `fkdetalleventa_producto_idx` (`idproducto`),
  KEY `fkdetalle_venta_ventas_idx` (`idventa`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=535 ;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`iddetalle_ventas`, `idproducto`, `idventa`, `cantidad`, `importe`) VALUES
(1, 1, 8, 20, 200),
(2, 2, 8, 2, 200),
(3, 3, 8, 10, 200),
(4, 1, 17, 1, 13.5),
(5, 7, 17, 1, 300),
(6, 1, 17, 1, 100),
(7, 1, 17, 1, 100),
(8, 1, 17, 1, 100),
(9, 10, 17, 1, 20),
(10, 11, 17, 1, 99.2),
(11, 1, 17, 1, 1),
(18, 1, 18, 1, 13.5),
(19, 7, 18, 1, 300),
(20, 1, 19, 1, 13.5),
(21, 7, 19, 1, 300),
(22, 1, 19, 1, 100),
(23, 1, 19, 1, 100),
(24, 1, 19, 1, 100),
(25, 1, 19, 1, 100),
(26, 1, 20, 1, 13.5),
(27, 7, 20, 1, 300),
(28, 1, 20, 1, 100),
(29, 7, 21, 1, 300),
(30, 1, 21, 1, 100),
(31, 1, 21, 1, 100),
(32, 1, 22, 1, 100),
(33, 1, 23, 1, 100),
(34, 1, 24, 1, 100),
(35, 1, 24, 1, 100),
(36, 7, 25, 1, 300),
(37, 1, 25, 1, 100),
(52, 7, 26, 1, 300),
(53, 1, 26, 1, 100),
(56, 1, 27, 1, 100),
(57, 1, 28, 1, 13.5),
(58, 7, 28, 1, 300),
(59, 1, 28, 1, 100),
(60, 1, 28, 1, 100),
(61, 1, 29, 1, 13.5),
(62, 7, 29, 1, 300),
(63, 1, 29, 1, 100),
(64, 1, 29, 1, 100),
(65, 1, 30, 1, 100),
(66, 7, 30, 1, 300),
(67, 1, 30, 1, 100),
(68, 1, 31, 1, 13.5),
(69, 7, 31, 1, 300),
(70, 1, 31, 1, 100),
(71, 1, 31, 1, 100),
(72, 1, 31, 1, 100),
(73, 1, 32, 1, 13.5),
(74, 7, 32, 1, 300),
(75, 1, 32, 1, 100),
(76, 1, 32, 1, 100),
(77, 1, 32, 5, 500),
(78, 1, 32, 1, 100),
(79, 10, 32, 1, 20),
(80, 11, 32, 1, 99.2),
(81, 1, 32, 1, 1),
(82, 1, 33, 1, 13.5),
(83, 7, 33, 1, 300),
(84, 1, 33, 1, 100),
(85, 1, 34, 1, 13.5),
(86, 7, 34, 1, 300),
(87, 1, 34, 1, 100),
(88, 1, 34, 1, 100),
(89, 1, 34, 1, 100),
(90, 1, 34, 1, 13.5),
(91, 1, 34, 1, 13.5),
(92, 1, 34, 1, 30),
(93, 11, 34, 1, 99.2),
(94, 1, 34, 1, 1),
(95, 7, 34, 1, 20),
(96, 1, 35, 1, 13.5),
(97, 7, 35, 1, 300),
(98, 1, 35, 1, 100),
(99, 1, 35, 1, 100),
(100, 1, 35, 1, 100),
(101, 1, 36, 1, 100),
(102, 7, 36, 1, 300),
(103, 1, 36, 1, 100),
(104, 1, 37, 1, 100),
(105, 1, 37, 1, 100),
(106, 1, 37, 1, 100),
(107, 1, 38, 1, 13.5),
(108, 1, 38, 1, 100),
(109, 1, 38, 1, 100),
(110, 1, 38, 1, 100),
(111, 1, 38, 1, 100),
(112, 1, 39, 1, 100),
(113, 1, 39, 1, 100),
(114, 1, 39, 1, 100),
(115, 7, 39, 1, 300),
(116, 1, 40, 1, 100),
(117, 1, 40, 1, 100),
(118, 1, 40, 1, 13.5),
(119, 7, 40, 1, 300),
(120, 1, 41, 1, 100),
(121, 1, 41, 1, 100),
(122, 1, 41, 1, 100),
(123, 1, 41, 1, 100),
(124, 1, 42, 1, 13.5),
(125, 7, 42, 1, 300),
(126, 7, 42, 1, 300),
(127, 1, 42, 1, 100),
(128, 1, 42, 1, 100),
(129, 1, 42, 1, 100),
(130, 7, 43, 1, 300),
(131, 1, 43, 1, 100),
(132, 1, 43, 1, 100),
(133, 1, 44, 1, 13.5),
(134, 1, 44, 1, 13.5),
(135, 7, 44, 1, 300),
(136, 11, 44, 3, 99.2),
(137, 10, 44, 1, 20),
(138, 1, 44, 2, 200),
(139, 11, 44, 3, 99.2),
(140, 7, 44, 1, 300),
(141, 1, 44, 3, 100),
(142, 1, 45, 3, 40.5),
(143, 7, 45, 5, 1500),
(144, 1, 45, 5, 500),
(145, 1, 45, 2, 200),
(146, 1, 46, 3, 40.5),
(147, 7, 46, 1, 300),
(148, 1, 46, 1, 100),
(149, 1, 46, 2, 200),
(150, 1, 47, 5, 67.5),
(151, 7, 47, 1, 300),
(152, 1, 47, 1, 13.5),
(153, 7, 48, 1, 300),
(154, 1, 48, 2, 200),
(155, 1, 48, 1, 100),
(156, 1, 48, 1, 100),
(157, 1, 48, 1, 100),
(158, 1, 48, 1, 13.5),
(159, 1, 49, 1, 13.5),
(160, 7, 49, 1, 300),
(161, 1, 49, 1, 100),
(162, 1, 49, 1, 100),
(163, 1, 49, 1, 13.5),
(164, 1, 49, 1, 30),
(165, 7, 51, 1, 300),
(166, 7, 52, 1, 300),
(167, 1, 52, 1, 100),
(168, 7, 52, 1, 300),
(169, 1, 52, 1, 100),
(170, 1, 52, 1, 100),
(171, 1, 53, 2, 27),
(172, 7, 53, 1, 300),
(173, 1, 53, 5, 500),
(174, 1, 54, 1, 13.5),
(175, 7, 54, 1, 300),
(176, 1, 54, 1, 100),
(177, 1, 54, 1, 100),
(178, 1, 55, 1, 13.5),
(179, 7, 55, 1, 300),
(180, 1, 55, 1, 100),
(181, 1, 55, 1, 100),
(182, 1, 56, 1, 13.5),
(183, 1, 56, 1, 100),
(184, 1, 56, 1, 100),
(185, 1, 56, 1, 100),
(186, 7, 56, 1, 300),
(187, 1, 57, 1, 13.5),
(188, 7, 57, 1, 300),
(189, 1, 57, 1, 100),
(190, 1, 58, 1, 13.5),
(191, 7, 58, 1, 300),
(192, 1, 58, 1, 100),
(193, 1, 59, 1, 13.5),
(194, 7, 59, 1, 300),
(195, 7, 60, 1, 300),
(196, 1, 61, 1, 13.5),
(197, 7, 61, 1, 300),
(198, 1, 61, 1, 13.5),
(199, 1, 62, 1, 13.5),
(200, 7, 62, 1, 300),
(201, 1, 62, 1, 100),
(202, 7, 63, 1, 300),
(203, 1, 64, 1, 100),
(204, 1, 65, 1, 100),
(205, 1, 65, 1, 100),
(206, 1, 66, 1, 13.5),
(207, 7, 66, 1, 300),
(208, 1, 66, 1, 100),
(209, 1, 66, 1, 100),
(210, 7, 67, 5, 100),
(211, 7, 67, 5, 100),
(212, 7, 68, 10, 200),
(213, 7, 68, 10, 200),
(214, 1, 69, 3, 40.5),
(215, 7, 69, 2, 600),
(216, 1, 69, 1, 13.5),
(217, 7, 70, 20, 400),
(218, 7, 70, 10, 200),
(219, 9, 71, 5, 100),
(220, 10, 71, 10, 200),
(221, 1, 72, 1, 13.5),
(222, 8, 72, 1, 300),
(223, 5, 72, 1, 100),
(224, 8, 73, 1, 300),
(225, 1, 73, 1, 13.5),
(226, 8, 73, 1, 300),
(227, 5, 73, 1, 100),
(228, 1, 74, 1, 13.5),
(229, 1, 74, 1, 13.5),
(230, 8, 74, 1, 300),
(231, 5, 74, 1, 100),
(232, 1, 75, 1, 13.5),
(233, 8, 75, 1, 300),
(234, 5, 75, 1, 100),
(235, 6, 75, 1, 100),
(236, 7, 75, 1, 100),
(237, 1, 76, 1, 13.5),
(238, 5, 76, 1, 100),
(239, 6, 76, 1, 100),
(240, 7, 76, 1, 100),
(241, 1, 77, 1, 13.5),
(242, 8, 77, 1, 300),
(243, 5, 77, 1, 100),
(244, 6, 77, 1, 100),
(245, 7, 77, 1, 100),
(246, 5, 78, 1, 100),
(247, 6, 78, 1, 100),
(248, 8, 78, 1, 300),
(249, 5, 79, 1, 100),
(250, 8, 79, 1, 300),
(251, 8, 80, 5, 1500),
(252, 2, 80, 1, 13.5),
(253, 7, 80, 2, 200),
(254, 8, 81, 2, 600),
(255, 1, 81, 1, 13.5),
(256, 2, 81, 1, 13.5),
(257, 3, 81, 1, 30),
(258, 10, 81, 1, 20),
(259, 1, 82, 1, 13.5),
(260, 8, 82, 1, 300),
(261, 5, 82, 1, 100),
(262, 8, 83, 1, 300),
(263, 5, 83, 1, 100),
(264, 6, 83, 1, 100),
(265, 7, 83, 1, 100),
(266, 8, 84, 1, 300),
(267, 5, 84, 1, 100),
(268, 7, 85, 1, 100),
(269, 6, 85, 1, 100),
(270, 8, 85, 1, 300),
(271, 2, 86, 2, 27),
(272, 3, 86, 3, 90),
(273, 2, 87, 3, 40.5),
(274, 3, 87, 2, 60),
(275, 2, 88, 2, 27),
(276, 3, 88, 1, 30),
(277, 5, 88, 3, 300),
(278, 6, 88, 5, 500),
(279, 1, 88, 1, 13.5),
(280, 2, 89, 1, 13.5),
(281, 8, 89, 1, 300),
(282, 2, 89, 1, 13.5),
(283, 1, 90, 1, 13.5),
(284, 8, 90, 1, 300),
(285, 2, 90, 1, 13.5),
(286, 8, 91, 5, 1500),
(287, 1, 92, 1, 13.5),
(288, 8, 92, 1, 300),
(289, 1, 93, 1, 13.5),
(290, 8, 93, 1, 300),
(291, 1, 94, 3, 40.5),
(292, 14, 94, 2, 90),
(293, 8, 94, 1, 300),
(294, 15, 95, 3, 69),
(295, 6, 95, 1, 100),
(296, 7, 95, 4, 400),
(297, 5, 95, 1, 100),
(298, 2, 96, 1, 13.5),
(299, 6, 96, 1, 100),
(300, 7, 96, 1, 100),
(301, 3, 97, 1, 30),
(302, 6, 97, 1, 100),
(303, 6, 98, 2, 200),
(304, 7, 98, 1, 100),
(305, 5, 98, 1, 100),
(306, 1, 99, 1, 10),
(307, 8, 99, 1, 300),
(308, 6, 99, 1, 60),
(309, 7, 99, 1, 60),
(310, 2, 100, 2, 15),
(311, 3, 100, 2, 30),
(312, 6, 100, 2, 150),
(313, 7, 100, 2, 150),
(314, 6, 101, 2, 200),
(315, 7, 101, 4, 400),
(316, 5, 101, 1, 100),
(317, 2, 102, 1, 10.2),
(318, 17, 102, 2, 4),
(319, 14, 102, 1, 34),
(320, 17, 102, 1, 2),
(321, 18, 102, 1, 6),
(322, 16, 103, 1, 80),
(323, 17, 103, 1, 2),
(324, 18, 103, 1, 6),
(325, 1, 104, 1, 10.2),
(326, 14, 104, 1, 34),
(327, 15, 104, 1, 23),
(328, 6, 104, 1, 70),
(329, 3, 105, 35, 700),
(330, 2, 105, 29, 295.79999999999995),
(331, 3, 106, 2, 40),
(332, 3, 106, 2, 40),
(333, 3, 106, 4, 80),
(334, 3, 107, 1, 20),
(335, 3, 107, 1, 20),
(336, 3, 107, 1, 20),
(337, 3, 108, 60, 1200),
(338, 2, 109, 2, 20.4),
(339, 6, 109, 1, 70),
(340, 7, 109, 1, 70),
(341, 6, 109, 1, 70),
(342, 3, 109, 1, 20),
(343, 5, 109, 1, 70),
(344, 6, 109, 1, 70),
(345, 2, 110, 1, 10.2),
(346, 6, 110, 1, 70),
(347, 7, 110, 1, 70),
(348, 6, 110, 1, 70),
(349, 3, 110, 1, 20),
(350, 1, 111, 1, 10.2),
(351, 15, 111, 1, 23),
(352, 14, 111, 1, 34),
(353, 8, 111, 1, 250),
(354, 8, 111, 1, 250),
(355, 6, 111, 1, 70),
(356, 4, 111, 1, 15),
(357, 4, 111, 1, 15),
(358, 4, 111, 1, 15),
(359, 4, 111, 1, 15),
(360, 4, 112, 30, 450),
(361, 8, 113, 1, 250),
(362, 6, 113, 1, 70),
(363, 4, 113, 1, 15),
(364, 11, 113, 1, 99.1),
(365, 12, 113, 1, 1),
(366, 1, 113, 1, 10.2),
(367, 15, 113, 1, 23),
(368, 14, 113, 1, 34),
(369, 8, 113, 1, 250),
(370, 17, 113, 1, 2),
(371, 18, 113, 1, 6),
(372, 2, 113, 1, 10.2),
(373, 3, 113, 1, 20),
(374, 6, 113, 1, 70),
(375, 7, 113, 1, 70),
(376, 5, 113, 1, 70),
(377, 4, 113, 1, 15),
(378, 11, 113, 1, 99.1),
(379, 12, 113, 1, 1),
(380, 16, 113, 1, 80),
(381, 10, 113, 1, 15),
(382, 9, 113, 1, 25),
(383, 1, 114, 9, 91.8),
(384, 15, 114, 9, 207),
(385, 14, 114, 9, 306),
(386, 8, 114, 9, 2250),
(387, 6, 114, 9, 630),
(388, 4, 114, 9, 135),
(389, 4, 115, 20, 300),
(390, 8, 115, 20, 5000),
(391, 1, 116, 1, 10.2),
(392, 15, 116, 1, 23),
(393, 14, 116, 1, 34),
(394, 8, 116, 1, 250),
(395, 17, 116, 1, 2),
(396, 18, 116, 1, 6),
(397, 2, 116, 1, 10.2),
(398, 3, 116, 1, 20),
(399, 6, 116, 1, 70),
(400, 7, 116, 1, 70),
(401, 5, 116, 1, 70),
(402, 4, 116, 1, 15),
(403, 11, 116, 1, 99.1),
(404, 12, 116, 1, 1),
(405, 16, 116, 1, 80),
(406, 10, 116, 1, 15),
(407, 12, 116, 1, 1),
(408, 11, 116, 1, 99.1),
(409, 11, 116, 1, 99.1),
(410, 4, 116, 1, 15),
(411, 11, 116, 1, 99.1),
(412, 11, 116, 1, 99.1),
(413, 12, 116, 1, 1),
(414, 11, 116, 1, 99.1),
(415, 12, 116, 1, 1),
(416, 16, 116, 1, 80),
(417, 12, 116, 1, 1),
(418, 11, 116, 1, 99.1),
(419, 4, 116, 1, 15),
(420, 11, 116, 1, 99.1),
(421, 12, 116, 1, 1),
(422, 1, 116, 1, 10.2),
(423, 15, 116, 1, 23),
(424, 14, 116, 1, 34),
(425, 8, 116, 1, 250),
(426, 17, 116, 1, 2),
(427, 18, 116, 1, 6),
(428, 2, 116, 1, 10.2),
(429, 3, 116, 1, 20),
(430, 9, 116, 1, 25),
(431, 10, 116, 1, 15),
(432, 9, 116, 1, 25),
(433, 10, 116, 1, 15),
(434, 9, 116, 1, 25),
(435, 10, 116, 1, 15),
(436, 1, 117, 1, 10.2),
(437, 15, 117, 1, 23),
(438, 14, 117, 1, 34),
(439, 14, 117, 1, 34),
(440, 8, 117, 1, 250),
(441, 8, 117, 1, 250),
(442, 8, 117, 1, 250),
(443, 8, 117, 1, 250),
(444, 8, 117, 1, 250),
(445, 8, 117, 1, 250),
(446, 8, 117, 1, 250),
(447, 8, 117, 1, 250),
(448, 8, 117, 1, 250),
(449, 8, 117, 1, 250),
(450, 8, 117, 1, 250),
(451, 8, 117, 1, 250),
(452, 8, 117, 1, 250),
(453, 8, 117, 1, 250),
(454, 1, 118, 2, 20.4),
(455, 15, 118, 5, 115),
(456, 14, 118, 4, 136),
(457, 8, 118, 3, 750),
(458, 17, 118, 5, 10),
(459, 8, 119, 1, 250),
(460, 4, 120, 20, 300),
(461, 2, 121, 1, 10.2),
(462, 3, 121, 2, 40),
(463, 6, 121, 1, 70),
(464, 7, 121, 3, 210),
(465, 5, 121, 1, 70),
(466, 2, 122, 1, 10.2),
(467, 6, 122, 1, 70),
(468, 7, 122, 1, 70),
(469, 15, 123, 1, 23),
(470, 15, 124, 1, 23),
(471, 15, 124, 1, 23),
(472, 15, 124, 1, 23),
(473, 14, 125, 1, 34),
(474, 8, 125, 1, 250),
(475, 6, 125, 1, 70),
(476, 4, 125, 1, 15),
(477, 11, 125, 1, 99.1),
(478, 12, 125, 1, 1),
(479, 16, 125, 1, 80),
(480, 15, 125, 1, 23),
(481, 8, 125, 1, 250),
(482, 14, 125, 1, 34),
(483, 14, 125, 1, 34),
(484, 8, 125, 1, 250),
(485, 14, 125, 1, 34),
(486, 8, 125, 1, 250),
(487, 8, 126, 1, 250),
(488, 8, 126, 1, 250),
(489, 18, 127, 1, 6),
(490, 11, 127, 1, 99.1),
(491, 12, 127, 1, 1),
(492, 1, 128, 1, 10.2),
(493, 15, 128, 1, 23),
(494, 1, 129, 1, 10.2),
(495, 15, 129, 1, 23),
(496, 14, 129, 1, 34),
(497, 8, 129, 1, 250),
(498, 6, 129, 1, 70),
(499, 1, 130, 5, 51),
(500, 15, 130, 1, 23),
(501, 6, 130, 3, 210),
(502, 6, 130, 1, 70),
(503, 7, 130, 7, 490),
(504, 5, 130, 1, 70),
(505, 8, 131, 1, 250),
(506, 2, 132, 5, 51),
(507, 3, 132, 5, 100),
(508, 14, 132, 5, 170),
(509, 1, 133, 1, 10.2),
(510, 15, 133, 1, 23),
(511, 14, 133, 1, 34),
(512, 8, 133, 1, 250),
(513, 7, 133, 1, 70),
(514, 6, 133, 1, 70),
(515, 2, 133, 1, 10.2),
(516, 1, 134, 1, 10.2),
(517, 1, 134, 1, 10.2),
(518, 15, 134, 1, 23),
(519, 15, 134, 1, 23),
(520, 17, 134, 1, 2),
(521, 14, 134, 1, 34),
(522, 14, 134, 1, 34),
(523, 14, 134, 1, 34),
(524, 8, 135, 5, 1250),
(525, 16, 136, 20, 1600),
(526, 17, 137, 1, 2),
(527, 2, 137, 1, 10.2),
(528, 1, 138, 1, 10.2),
(529, 14, 138, 1, 34),
(530, 8, 138, 1, 250),
(531, 15, 138, 1, 23),
(532, 8, 138, 1, 250),
(533, 1, 139, 1, 10.2),
(534, 15, 139, 1, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(75) DEFAULT NULL,
  `telefono` varchar(8) DEFAULT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `salario_devengado` float NOT NULL,
  `comision` float DEFAULT NULL,
  PRIMARY KEY (`idempleado`),
  UNIQUE KEY `idempleado_UNIQUE` (`idempleado`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`idempleado`, `nombre`, `apellido`, `direccion`, `telefono`, `cargo`, `salario_devengado`, `comision`) VALUES
(1, 'Cristhian', 'Menjivar', 'laguna seca', '87787878', 'gerente', 400, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enviossucursale`
--

CREATE TABLE IF NOT EXISTS `enviossucursale` (
  `idEnvio` int(11) NOT NULL AUTO_INCREMENT,
  `fechaEnvio` varchar(30) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  PRIMARY KEY (`idEnvio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `enviossucursale`
--

INSERT INTO `enviossucursale` (`idEnvio`, `fechaEnvio`, `idSucursal`) VALUES
(1, '2018-10-09', 1),
(2, '2018-10-09', 1),
(3, '2018-10-09', 1),
(4, '2018-10-09', 2),
(5, '2018-10-10', 1),
(6, '2018-10-10', 3),
(7, '2018-10-10', 4),
(8, '2018-10-10', 2),
(9, '2018-10-10', 3),
(10, '2018-10-10', 4),
(11, '2018-10-11', 3),
(12, '2018-10-12', 4),
(13, '2018-10-15', 4),
(14, '2018-10-19', 3),
(15, '2018-10-24', 3),
(16, '2018-10-24', 1),
(17, '2018-10-25', 2),
(18, '2018-10-25', 1),
(19, '2018-10-25', 1),
(20, '2018-10-27', 1),
(21, '2018-10-28', 4),
(22, '2018-10-28', 1),
(23, '2018-10-28', 1),
(24, '2018-10-29', 1),
(25, '2018-10-29', 1),
(26, '2018-10-29', 1),
(27, '2018-10-29', 1),
(28, '2018-10-29', 1),
(29, '2018-10-29', 1),
(30, '2018-10-29', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos`
--

CREATE TABLE IF NOT EXISTS `gastos` (
  `idgasto` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_gasto` varchar(50) NOT NULL,
  `total` double NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idgasto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `gastos`
--

INSERT INTO `gastos` (`idgasto`, `tipo_gasto`, `total`, `fecha`) VALUES
(1, 'Pago a Empleados', 100, '2018-10-10'),
(2, 'Pago a Empleados', 300, '2018-10-10'),
(3, 'Pago a Empleados', 300, '2018-10-14'),
(4, 'Pago a Proveedores', 500, '2018-10-12'),
(5, 'Pago a Empleados', 800, '2018-10-13'),
(6, 'Otros', 55, '2018-10-12'),
(7, 'Pago a Empleados', 500, '2018-10-15'),
(8, 'Pago a Empleados', 100, '2018-10-21'),
(9, 'Pago a Proveedores', 300, '2018-10-21'),
(10, 'Pago a Proveedores', 30, '2018-10-21'),
(11, 'Pago a Empleados', 400, '2018-10-21'),
(12, 'Pago a Empleados', 200, '2018-10-21'),
(13, 'Pago a Empleados', 20, '2018-10-12'),
(14, 'Pago a Empleados', 50, '2018-10-12'),
(15, 'Pago a Empleados', 20, '2018-10-12'),
(16, 'Pago a Empleados', 500, '2018-10-12'),
(17, 'Pago a Empleados', 10, '2018-10-12'),
(18, 'Pago a Empleados', 10, '2018-10-21'),
(19, 'Pago a Empleados', 10, '2018-10-21'),
(20, 'Pago a Empleados', 10, '2018-10-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE IF NOT EXISTS `marca` (
  `idmarca` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) NOT NULL,
  PRIMARY KEY (`idmarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`idmarca`, `marca`) VALUES
(1, 'Sin marca'),
(4, 'Marca4'),
(5, 'Marca5'),
(6, 'Marca Nueva act'),
(7, 'marca nueva act'),
(9, 'samsum'),
(10, 'Dumlop');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `masvendidos`
--

CREATE TABLE IF NOT EXISTS `masvendidos` (
  `idMasVendidos` int(11) NOT NULL AUTO_INCREMENT,
  `idproducto` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`idMasVendidos`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=44 ;

--
-- Volcado de datos para la tabla `masvendidos`
--

INSERT INTO `masvendidos` (`idMasVendidos`, `idproducto`, `cantidad`, `fecha`) VALUES
(33, 1, 4, '2018-10-28'),
(34, 15, 4, '2018-10-28'),
(35, 14, 5, '2018-10-28'),
(36, 8, 8, '2018-10-28'),
(37, 7, 1, '2018-10-28'),
(38, 6, 1, '2018-10-28'),
(39, 2, 2, '2018-10-28'),
(40, 17, 2, '2018-10-28'),
(41, 16, 20, '2018-10-28'),
(42, 1, 1, '2018-10-29'),
(43, 15, 1, '2018-10-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `medida` varchar(20) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio_compra` double NOT NULL,
  `precio_sugerido` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `inventario` int(11) DEFAULT NULL,
  `averiado` int(11) DEFAULT NULL,
  `idmarca` int(11) DEFAULT NULL,
  `idproveedor` int(11) DEFAULT NULL,
  `idcategoria` int(11) DEFAULT NULL,
  `idcalidad` int(11) DEFAULT NULL,
  `tipoRegistro` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idproducto`, `medida`, `nombre`, `precio_compra`, `precio_sugerido`, `stock`, `inventario`, `averiado`, `idmarca`, `idproveedor`, `idcategoria`, `idcalidad`, `tipoRegistro`) VALUES
(1, '12.23', 'Aceite', 6.5, 10.2, 10, 97, 3, 6, 1, 5, 4, 'producto'),
(2, '12.23', 'LLanta 12', 6.5, 10.2, 20, 4, 2, 4, 9, 4, 4, 'producto'),
(3, '3030', 'LLanta 13', 10, 20, 30, 100, 0, 1, 1, 1, 1, 'producto'),
(4, '12', 'Neumaticos', 10, 15, 40, 100, 0, 5, 1, 6, 1, 'producto'),
(5, '44-1', 'llantas rojas', 50, 70, 10, 100, 0, 1, 1, 1, 1, 'producto'),
(6, '33-11', 'llantas blancas', 50, 70, 10, 100, 0, 1, 1, 4, 1, 'producto'),
(7, '44-12', 'llantas negras', 50, 70, 10, 100, 5, 1, 1, 4, 1, 'producto'),
(8, '12-12', 'Computadora', 200, 250, 2, 3, 1, 4, 7, 5, 1, 'producto'),
(9, '13-13', 'sillas', 20, 25, 10, 100, 0, 5, 9, 5, 1, 'producto'),
(10, '1m * 1m', 'sillas', 10, 15, 5, 100, 0, 5, 7, 6, 1, 'producto'),
(11, '99', 'producto prueva', 99, 99.1, 10, 100, 0, 7, 11, 8, 1, 'producto'),
(12, '1', 'producto prueva2', 1, 1, 1, 100, 1, 1, 1, 1, 1, 'producto'),
(14, '3', 'celular', 32, 34, 60, 99, 0, 9, 13, 6, 1, 'producto'),
(15, '2050', 'aceite ', 18, 23, 2, 98, 2, 4, 11, 4, 4, 'producto'),
(16, '1ss2', 'rin carro', 50, 80, 40, 100, 0, 10, 14, 5, 4, 'producto'),
(17, '21-12', 'golosinas', 1, 2, 10, 4, 0, 10, 14, 1, 4, 'producto'),
(18, '-', 'lavado de auto', 0, 6, 0, 0, 0, 1, 1, 1, 1, 'servicio'),
(20, 'ada2', 'prueva prueva', 67, 13, 2, 100, 2, 6, 11, 6, 5, 'producto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `idproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_empresa` varchar(50) NOT NULL,
  `direccion_empresa` varchar(75) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idproveedor`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idproveedor`, `nombre_empresa`, `direccion_empresa`, `telefono`) VALUES
(1, 'Sin proveedor', '-', '-'),
(7, 'proveedor 5', 'Santa ana asdasd', '78787878'),
(9, 'proveedor 4', 'chalatenango', '4040404'),
(11, 'Consultora S.A de C.V', 'San Salavador/ Chalatenango', '7090-7788'),
(13, 'Empresa 1', 'Chalatenango', '2222222'),
(14, 'Ideas Constructivas', 'Collolito calle principal', '78788778');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE IF NOT EXISTS `sucursales` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `direccionSucursal` varchar(100) NOT NULL,
  `telefonoSucursal` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idSucursal`),
  UNIQUE KEY `direccionSucursal` (`direccionSucursal`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`idSucursal`, `direccionSucursal`, `telefonoSucursal`) VALUES
(1, 'Sucursal de Amayo', '78998899'),
(2, 'Sucursal de El poy', '77889900'),
(3, 'San Salvador #12', '66778877'),
(4, 'Santa Ana #5', '88997766');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(32) NOT NULL,
  `tipo_usuario` varchar(25) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `usuario`, `contraseña`, `tipo_usuario`) VALUES
(1, 'cristian', '1234', 'Administrador'),
(3, 'jonathan', '12345', 'Administrador'),
(4, 'nuevo', '2', 'Digitador'),
(5, 'Nuevo', 'nuevo123', 'Digitador'),
(6, 'ElCholo', 'Elcholo', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(30) NOT NULL,
  `monto` double NOT NULL,
  `tipo_venta` varchar(40) NOT NULL,
  `tipo_pago` varchar(40) NOT NULL,
  PRIMARY KEY (`idventa`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=140 ;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idventa`, `fecha`, `monto`, `tipo_venta`, `tipo_pago`) VALUES
(1, '2018-10-10', 500, 'Factura', 'Credito'),
(2, '2018-10-01', 313.5, 'Factura', 'Efectivo'),
(3, '2018-10-01', 313.5, 'Factura', 'Efectivo'),
(4, '2018-10-01', 313.5, 'Factura', 'Efectivo'),
(5, '2018-10-01', 13.5, 'Factura', 'Efectivo'),
(6, '2018-10-01', 500.1, 'factura', 'efectivo'),
(7, '2018-10-01', 500.1, 'factura', 'efectivo'),
(8, '2018-10-01', 3000.99, 'comprobante', 'Credito'),
(9, '2018-10-01', 613.5, 'Factura', 'Efectivo'),
(10, '2018-10-01', 613.5, 'Factura', 'Efectivo'),
(11, '2018-10-01', 513.5, 'Factura', 'Efectivo'),
(12, '2018-10-01', 313.5, 'Factura', 'Efectivo'),
(13, '2018-10-01', 513.5, 'Factura', 'Efectivo'),
(14, '2018-10-01', 413.5, 'Factura', 'Efectivo'),
(15, '2018-10-01', 313.5, 'Factura', 'Efectivo'),
(16, '2018-10-01', 400, 'Factura', 'Efectivo'),
(17, '2018-10-01', 733.7, 'Factura', 'Efectivo'),
(18, '2018-10-01', 313.5, '0', '0'),
(19, '2018-10-01', 713.5, '1', '0'),
(20, '2018-10-01', 413.5, '1', '1'),
(21, '2018-10-01', 500, '0', '0'),
(22, '2018-10-01', 100, '1', '1'),
(23, '2018-10-01', 100, '1', '0'),
(24, '2018-10-01', 200, '1', '1'),
(25, '2018-10-01', 400, '0', '0'),
(26, '2018-10-01', 400, 'Efectivo', 'Factura'),
(27, '2018-10-01', 100, 'Al Crédito', 'Comprobante Fiscal'),
(28, '2018-10-01', 513.5, 'Al Crédito', 'Comprobante Fiscal'),
(29, '2018-10-01', 513.5, 'Al Crédito', 'Comprobante Fiscal'),
(30, '2018-10-01', 500, 'Al Crédito', 'Comprobante Fiscal'),
(31, '2018-10-01', 613.5, 'Al Crédito', 'Comprobante Fiscal'),
(32, '2018-10-01', 1233.7, 'Efectivo', 'Factura'),
(33, '2018-10-01', 413.5, 'Efectivo', 'Factura'),
(34, '2018-10-01', 790.7, 'Efectivo', 'Comprobante Fiscal'),
(35, '2018-10-01', 613.5, 'Al Crédito', 'Factura'),
(36, '2018-10-01', 500, 'Efectivo', 'Factura'),
(37, '2018-10-01', 300, 'Efectivo', 'Comprobante Fiscal'),
(38, '2018-10-01', 413.5, 'Al Crédito', 'Factura'),
(39, '2018-10-01', 600, 'Efectivo', 'Factura'),
(40, '2018-10-01', 513.5, 'Efectivo', 'Factura'),
(41, '2018-10-01', 400, 'Al Crédito', 'Factura'),
(42, '2018-10-01', 913.5, 'Al Crédito', 'Comprobante Fiscal'),
(43, '2018-10-02', 500, 'Al Crédito', 'Comprobante Fiscal'),
(44, '2018-10-02', 1145.4, 'Efectivo', 'Factura'),
(45, '2018-10-02', 2240.5, 'Efectivo', 'Factura'),
(46, '2018-10-03', 640.5, 'Efectivo', 'Factura'),
(47, '2018-10-03', 381, 'Al Crédito', 'Comprobante Fiscal'),
(48, '2018-10-03', 813.5, 'Efectivo', 'Factura'),
(49, '2018-10-04', 557, 'Efectivo', 'Factura'),
(50, '2018-10-04', 0, 'Efectivo', 'Factura'),
(51, '2018-10-04', 300, 'Efectivo', 'Factura'),
(52, '2018-10-06', 900, 'Al Crédito', 'Comprobante Fiscal'),
(53, '2018-10-06', 827, 'Al Crédito', 'Comprobante Fiscal'),
(54, '2018-10-06', 513.5, 'Al Crédito', 'Factura'),
(55, '2018-10-06', 513.5, 'Al Crédito', 'Factura'),
(56, '2018-10-06', 613.5, 'Al Crédito', 'Factura'),
(57, '2018-10-06', 413.5, 'Al Crédito', 'Factura'),
(58, '2018-10-06', 413.5, 'Al Crédito', 'Factura'),
(59, '2018-10-06', 313.5, 'Al Crédito', 'Factura'),
(60, '2018-10-06', 300, 'Al Crédito', 'Factura'),
(61, '2018-10-06', 327, 'Al Crédito', 'Factura'),
(62, '2018-10-06', 413.5, 'Al Crédito', 'Factura'),
(63, '2018-10-06', 300, 'Al Crédito', 'Factura'),
(64, '2018-10-06', 100, 'Efectivo', 'Factura'),
(65, '2018-10-06', 200, 'Al Crédito', 'Factura'),
(66, '2018-10-07', 513.5, 'Al Crédito', 'Factura'),
(67, '2018-10-07', 200, 'Al Crédito', 'Factura'),
(68, '2018-10-07', 400, 'Efectivo', 'Factura'),
(69, '2018-10-07', 654, 'Efectivo', 'Factura'),
(70, '2018-10-07', 600, 'Efectivo', 'Factura'),
(71, '2018-10-07', 300, 'Efectivo', 'Factura'),
(72, '2018-10-07', 413.5, 'Efectivo', 'Factura'),
(73, '2018-10-07', 713.5, 'Efectivo', 'Factura'),
(74, '2018-10-07', 427, 'Al Crédito', 'Factura'),
(75, '2018-10-07', 613.5, 'Al Crédito', 'Factura'),
(76, '2018-10-07', 313.5, 'Al Crédito', 'Factura'),
(77, '2018-10-07', 613.5, 'Al Crédito', 'Comprobante Fiscal'),
(78, '2018-10-07', 500, 'Efectivo', 'Comprobante Fiscal'),
(79, '2018-10-07', 400, 'Efectivo', 'Comprobante Fiscal'),
(80, '2018-10-07', 1713.5, 'Al Crédito', 'Comprobante Fiscal'),
(81, '2018-10-07', 677, 'Al Crédito', 'Comprobante Fiscal'),
(82, '2018-10-07', 413.5, 'Al Crédito', 'Factura'),
(83, '2018-10-08', 600, 'Al Crédito', 'Factura'),
(84, '2018-10-09', 400, 'Efectivo', 'Factura'),
(85, '2018-10-09', 500, 'Al Crédito', 'Factura'),
(86, '2018-10-09', 117, 'Efectivo', 'Factura'),
(87, '2018-10-09', 100.5, 'Efectivo', 'Factura'),
(88, '2018-10-11', 870.5, 'Al Crédito', 'Comprobante Fiscal'),
(89, '2018-10-11', 327, 'Al Crédito', 'Comprobante Fiscal'),
(90, '2018-10-11', 327, 'Efectivo', 'Factura'),
(91, '2018-10-12', 1500, 'Al Crédito', 'Factura'),
(92, '2018-10-13', 313.5, 'Al Crédito', 'Factura'),
(93, '2018-10-13', 313.5, 'Al Crédito', 'Factura'),
(94, '2018-10-15', 430.5, 'Efectivo', 'Factura'),
(95, '2018-10-15', 669, 'Al Crédito', 'Factura'),
(96, '2018-10-15', 213.5, 'Efectivo', 'Factura'),
(97, '2018-10-15', 130, 'Al Crédito', 'Factura'),
(98, '2018-10-15', 400, 'Al Crédito', 'Factura'),
(99, '2018-10-17', 40, 'Efectivo', 'Factura'),
(100, '2018-10-17', 52, 'Efectivo', 'Factura'),
(101, '2018-10-17', 700, 'Efectivo', 'Factura'),
(102, '2018-10-19', 56.2, 'Efectivo', 'Factura'),
(103, '2018-10-19', 88, 'Efectivo', 'Factura'),
(104, '2018-10-24', 137.2, 'Al Crédito', 'Factura'),
(105, '2018-10-25', 995.8, 'Efectivo', 'Factura'),
(106, '2018-10-25', 160, 'Efectivo', 'Factura'),
(107, '2018-10-25', 60, 'Efectivo', 'Factura'),
(108, '2018-10-25', 1200, 'Efectivo', 'Factura'),
(109, '2018-10-26', 390.4, 'Al Crédito', 'Factura'),
(110, '2018-10-26', 240.2, 'Al Crédito', 'Factura'),
(111, '2018-10-26', 697.2, 'Efectivo', 'Factura'),
(112, '2018-10-26', 450, 'Efectivo', 'Factura'),
(113, '2018-10-26', 1235.6, 'Efectivo', 'Factura'),
(114, '2018-10-26', 3619.8, 'Efectivo', 'Factura'),
(115, '2018-10-26', 5300, 'Efectivo', 'Factura'),
(116, '2018-10-26', 2059.5999999999995, 'Efectivo', 'Factura'),
(117, '2018-10-26', 3601.2, 'Efectivo', 'Factura'),
(118, '2018-10-26', 1031.4, 'Efectivo', 'Factura'),
(119, '2018-10-26', 250, 'Efectivo', 'Factura'),
(120, '2018-10-27', 300, 'Efectivo', 'Factura'),
(121, '2018-10-27', 400.2, 'Al Crédito', 'Factura'),
(122, '2018-10-27', 150.2, 'Efectivo', 'Factura'),
(123, '2018-10-28', 23, 'Efectivo', 'Factura'),
(124, '2018-10-28', 69, 'Efectivo', 'Factura'),
(125, '2018-10-28', 1424.1, 'Efectivo', 'Factura'),
(126, '2018-10-28', 500, 'Efectivo', 'Factura'),
(127, '2018-10-28', 106.1, 'Al Crédito', 'Factura'),
(128, '2018-10-28', 33.2, 'Al Crédito', 'Factura'),
(129, '2018-10-28', 387.2, 'Efectivo', 'Factura'),
(130, '2018-10-28', 914, 'Efectivo', 'Factura'),
(131, '2018-10-28', 250, 'Efectivo', 'Factura'),
(132, '2018-10-28', 321, 'Efectivo', 'Factura'),
(133, '2018-10-28', 467.4, 'Efectivo', 'Factura'),
(134, '2018-10-28', 170.4, 'Efectivo', 'Factura'),
(135, '2018-10-28', 1250, 'Efectivo', 'Factura'),
(136, '2018-10-28', 1600, 'Efectivo', 'Factura'),
(137, '2018-10-28', 12.2, 'Al Crédito', 'Factura'),
(138, '2018-10-28', 567.2, 'Al Crédito', 'Factura'),
(139, '2018-10-29', 33.2, 'Al Crédito', 'Factura');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `creditos`
--
ALTER TABLE `creditos`
  ADD CONSTRAINT `fkcredito_venta` FOREIGN KEY (`idventa`) REFERENCES `ventas` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkcredito_venta_cliente` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_credito`
--
ALTER TABLE `detalle_credito`
  ADD CONSTRAINT `fkdetallecredito_credito` FOREIGN KEY (`idcredito`) REFERENCES `creditos` (`idcredito`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `fkdetalleventa_producto` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkdetalle_venta_ventas` FOREIGN KEY (`idventa`) REFERENCES `ventas` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
