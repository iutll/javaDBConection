-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-11-2019 a las 01:30:49
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
-- Base de datos: `miniproyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagina`
--

CREATE TABLE `pagina` (
  `id` int(20) NOT NULL,
  `footer_pagina` text NOT NULL,
  `enlace_facebook` varchar(150) NOT NULL,
  `enlace_instagram` varchar(150) NOT NULL,
  `enlace_twitter` varchar(150) NOT NULL,
  `parrafo_pagina` text NOT NULL,
  `archivo_encabezado` varchar(1000) DEFAULT NULL,
  `titulo_encabezado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pagina`
--

INSERT INTO `pagina` (`id`, `footer_pagina`, `enlace_facebook`, `enlace_instagram`, `enlace_twitter`, `parrafo_pagina`, `archivo_encabezado`, `titulo_encabezado`) VALUES
(1, 'hola12                                                                                                                                                                         ', 'http://www.facebook.com/sneikerendogeno', 'http://www.twitter.com', 'http://www.instagram.com', '                                                    <p>                                                                                                        <span style=\"font-weight: bold; font-size: 24px;\">Bienvenidos a Chocomics!</span></p><p>Esta es la pagina del local Chocomics, ubicado en un centro comercial de nombre extravagante, donde podras disfrutar de las peliculas de superheroes mas taquilleras, junto con unas buenas malteadas a un buen precio!<span style=\"font-weight: bold; font-size: 24px;\"><br></span></p>                                                ', './archivos/contenido/imagen-386734.jpg', 'El cruce entre batidos y comics en valle de la pascua'),
(2, 'hola                                                                                                                                                 <p> Ignacio es marico </p>                        ', 'http://www.facebook.com/sneikerendogeno', 'http://www.instagram.com', 'http://www.twitter.com', '                                                    <p>                                                                                                        <span style=\"font-weight: bold; font-size: 24px;\">Bienvenidos a Chocomics!</span></p><p>Esta es la pagina del local Chocomics, ubicado en un centro comercial de nombre extravagante, donde podras disfrutar de las peliculas de superheroes mas taquilleras, junto con unas buenas malteadas a un buen precio!<span style=\"font-weight: bold; font-size: 24px;\"><br></span></p>                                                ', './archivos/contenido/imagen-386734.jpg', 'El cruce entre batidos y comics en valle de la pascua');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE `publicacion` (
  `id` int(20) NOT NULL,
  `publicacion_titulo` varchar(80) NOT NULL,
  `publicacion_texto` text NOT NULL,
  `publicacion_fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `publicacion`
--

INSERT INTO `publicacion` (`id`, `publicacion_titulo`, `publicacion_texto`, `publicacion_fecha`) VALUES
(5, 'Rafael es marico', '<p><span style=\"text-decoration: underline;\"><span style=\"font-style: italic;\"><span style=\"font-weight: bold;\">ZA WARUDO xdddddddddddddddddddd</span></span></span><br></p>', '2016-02-11'),
(6, 'Malteadas endogenas!', '<p><span style=\"font-weight: bold;\">JAJA ASI ES! :D</span></p><p><span style=\"font-weight: bold;\"><br></span></p><p>Chocomics presenta su nueva coleccion de malteadas artesanales hecha con celulas de hashirama y polvo cosmico, una celestial combinacion que esta de muerte! (Literal y figurativamente xd)</p><p>Igualmente queremos notificar que el local pasara por una asombrosa remodelacion, os quedareis sorprendidos!<br></p><p><br></p><p><br></p>', '2016-02-11'),
(7, 'Otra noticia de prueba', '<p>Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico Rafael es marico </p>', '2016-02-11'),
(8, 'noticia dank', '<p><span style=\"background-color: yellow; font-size: 24px;\">UWU UWU UWU UWU UWU UWU UWU</span></p><p><span style=\"background-color: yellow; font-size: 24px;\">UWU UWU UWU UWU UWU UWU UWU</span></p><p><span style=\"background-color: yellow; font-size: 24px;\">UWU UWU UWU UWU UWU UWU UWU</span></p><p><span style=\"background-color: yellow; font-size: 24px;\">UWU UWU UWU UWU UWU UWU UWU</span></p><p><span style=\"background-color: yellow; font-size: 24px;\">UWU UWU UWU UWU UWU UWU UWU</span><span style=\"background-color: yellow; font-size: 24px;\"><br></span><span style=\"background-color: yellow; font-size: 24px;\"><br></span><span style=\"background-color: yellow; font-size: 24px;\"><br></span><span style=\"background-color: yellow; font-size: 24px;\"><br></span><br></p>', '2019-09-16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(20) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `clave_usuario` varchar(15) NOT NULL,
  `nivel_usuario` int(2) NOT NULL,
  `email` varchar(50) NOT NULL,
  `clave_recuperacion` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre_usuario`, `clave_usuario`, `nivel_usuario`, `email`, `clave_recuperacion`) VALUES
(1, 'admin2', 'admin2', 4, 'admin21@gmail2.com', NULL),
(3, 'prueba', 'we', 2, 'zawarudo@elmundo.com', NULL),
(4, 'usuario_nuevo', '12345', 1, 'usuariowe@we.com', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pagina`
--
ALTER TABLE `pagina`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pagina`
--
ALTER TABLE `pagina`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
