-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2019 a las 21:09:30
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Mini-Gestor`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE `publicacion` (
  `id_publicacion` int(2) NOT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `cedulauser` varchar(12) DEFAULT NULL,
  `contenido` varchar(200) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `usuario` varchar(30) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `nivel` int(10) NOT NULL,
  `red_publicada` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(2) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `clave` varchar(8) NOT NULL,
  `cedula` varchar(12) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `nivel` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Estructura de tabla para la tabla `redessociales`
--

CREATE TABLE `redessociales` (
  `id_redes` int(2) NOT NULL,
  `Nombre_red` varchar(100) NOT NULL,
  `Url` varchar(50) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `cedula` varchar(12) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `nivel_user` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD PRIMARY KEY (`id_publicacion`),
  ADD KEY `cedulacliente` (`cedulauser`),
  ADD KEY `usuario` (`usuario`),
  ADD KEY `correo` (`correo`),
  ADD KEY `nivel` (`nivel`),
  ADD KEY `red_publicada` (`red_publicada`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `cedula` (`cedula`),
  ADD KEY `correo` (`correo`),
  ADD KEY `usuario` (`usuario`),
  ADD KEY `nivel` (`nivel`);


--
-- Indices de la tabla `redessociales`
--
ALTER TABLE `redessociales`
  ADD PRIMARY KEY (`id_redes`),
  ADD KEY `Nombre_red` (`Nombre_red`),
  ADD KEY `usuario` (`usuario`),
  ADD KEY `cedula` (`cedula`),
  ADD KEY `correo` (`correo`),
  ADD KEY `nivel_user` (`nivel_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  MODIFY `id_publicacion` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `redessociales`
--
ALTER TABLE `redessociales`
  MODIFY `id_redes` int(2) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD CONSTRAINT `publicacion_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `redessociales` (`usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `publicacion_ibfk_2` FOREIGN KEY (`red_publicada`) REFERENCES `redessociales` (`Nombre_red`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `publicacion_ibfk_3` FOREIGN KEY (`cedulauser`) REFERENCES `redessociales` (`cedula`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `publicacion_ibfk_4` FOREIGN KEY (`correo`) REFERENCES `redessociales` (`correo`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `publicacion_ibfk_5` FOREIGN KEY (`nivel`) REFERENCES `redessociales` (`nivel_user`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

--
-- Filtros para la tabla `redessociales`
--
ALTER TABLE `redessociales`
  ADD CONSTRAINT `redessociales_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `redessociales_ibfk_2` FOREIGN KEY (`cedula`) REFERENCES `usuario` (`cedula`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `redessociales_ibfk_3` FOREIGN KEY (`correo`) REFERENCES `usuario` (`correo`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
