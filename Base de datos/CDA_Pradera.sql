-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-09-2021 a las 17:34:36
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cda`
--
CREATE DATABASE IF NOT EXISTS `cda` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cda`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disponibilidad`
--

CREATE TABLE `disponibilidad` (
  `ID` int(11) NOT NULL,
  `FECHA` date NOT NULL,
  `HORA` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `CEDULA` varchar(20) NOT NULL,
  `NOMBRE` varchar(400) NOT NULL,
  `TELEFONO` varchar(12) NOT NULL,
  `EMAIL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `ID` int(11) NOT NULL,
  `PERSONA` varchar(20) NOT NULL,
  `VEHICULO` int(11) NOT NULL,
  `DISPONIBILIDAD` int(11) NOT NULL,
  `PLACA` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL,
  `CEDULA` varchar(20) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `ID` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`ID`, `DESCRIPCION`) VALUES
(1, 'Moto'),
(2, 'Carro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `disponibilidad`
--
ALTER TABLE `disponibilidad`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`CEDULA`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PERSONA` (`PERSONA`),
  ADD KEY `VEHICULO` (`VEHICULO`),
  ADD KEY `DISPONIBILIDAD` (`DISPONIBILIDAD`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CEDULA` (`CEDULA`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `disponibilidad`
--
ALTER TABLE `disponibilidad`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`PERSONA`) REFERENCES `persona` (`CEDULA`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`VEHICULO`) REFERENCES `vehiculo` (`ID`),
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`DISPONIBILIDAD`) REFERENCES `disponibilidad` (`ID`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`CEDULA`) REFERENCES `persona` (`CEDULA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
