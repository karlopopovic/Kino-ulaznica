-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2019 at 07:56 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kino`
--

-- --------------------------------------------------------

--
-- Table structure for table `dvorana`
--

CREATE TABLE `dvorana` (
  `id` int(11) NOT NULL,
  `broj_sjedala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_croatian_ci;

--
-- Dumping data for table `dvorana`
--

INSERT INTO `dvorana` (`id`, `broj_sjedala`) VALUES
(1, 200),
(2, 200),
(3, 240);

-- --------------------------------------------------------

--
-- Table structure for table `filmovi`
--

CREATE TABLE `filmovi` (
  `naziv` varchar(50) COLLATE utf16_croatian_ci NOT NULL,
  `trajanje` varchar(11) COLLATE utf16_croatian_ci NOT NULL,
  `zarn` varchar(50) COLLATE utf16_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_croatian_ci;

--
-- Dumping data for table `filmovi`
--

INSERT INTO `filmovi` (`naziv`, `trajanje`, `zarn`) VALUES
('gospodar prstenova 3', '190', 'akcija,fantazija'),
('osvetnici 3', '190', 'akcija'),
('plaćenici 3', '120', 'akcija'),
('sherlock holmes', '140', 'akcija'),
('sonja i bik', '140', 'komedija');

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `id` varchar(25) COLLATE utf16_croatian_ci NOT NULL,
  `lozinka` varchar(50) COLLATE utf16_croatian_ci NOT NULL,
  `id_uloga_dozvola` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_croatian_ci;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`id`, `lozinka`, `id_uloga_dozvola`) VALUES
('ant_headadmin', 'antonio', 1),
('ivo_gost', 'ivo', 1),
('kar_headadmin', 'karlo', 1),
('mar_gost', 'marko', 2),
('nik_headadmin', 'nikola', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id_prikazivanja` varchar(50) COLLATE utf16_croatian_ci NOT NULL,
  `id_rez_sjed` varchar(11) COLLATE utf16_croatian_ci NOT NULL,
  `vrijeme_prikazivanja` varchar(10) COLLATE utf16_croatian_ci NOT NULL,
  `dvorana` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_croatian_ci;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id_prikazivanja`, `id_rez_sjed`, `vrijeme_prikazivanja`, `dvorana`) VALUES
('gospodar prstenova 3', 'a8', '20:30', 1),
('osvetnici 3', 'b2', '21:00', 1),
('\0p\0l\0a\0e\0n\0i\0c\0i\0 \03', '\0a\08', '\01\09\0:\00\00', 1),
('sherlock holmes', 'c6', '17:30', 2),
('sonja i bik', 'd4', '19:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `rezervirana_sjedala`
--

CREATE TABLE `rezervirana_sjedala` (
  `id` varchar(11) COLLATE utf16_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_croatian_ci;

--
-- Dumping data for table `rezervirana_sjedala`
--

INSERT INTO `rezervirana_sjedala` (`id`) VALUES
('a1'),
('a8'),
('b2'),
('c6'),
('d4');

-- --------------------------------------------------------

--
-- Table structure for table `sjedala`
--

CREATE TABLE `sjedala` (
  `id` varchar(11) COLLATE utf16_croatian_ci NOT NULL,
  `id_dvorane` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_croatian_ci;

--
-- Dumping data for table `sjedala`
--

INSERT INTO `sjedala` (`id`, `id_dvorane`) VALUES
('a1', 1),
('b2', 1),
('c6', 2),
('a8', 3),
('d4', 3);

-- --------------------------------------------------------

--
-- Table structure for table `termin`
--

CREATE TABLE `termin` (
  `termin` varchar(10) COLLATE utf16_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_croatian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dvorana`
--
ALTER TABLE `dvorana`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `filmovi`
--
ALTER TABLE `filmovi`
  ADD PRIMARY KEY (`naziv`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_uloga_dozvola` (`id_uloga_dozvola`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id_prikazivanja`),
  ADD KEY `id_prikazivanja` (`id_prikazivanja`),
  ADD KEY `id_rez_sjed` (`id_rez_sjed`),
  ADD KEY `vrijeme_prikazivanja` (`vrijeme_prikazivanja`),
  ADD KEY `id_prikazivanja_2` (`id_prikazivanja`);

--
-- Indexes for table `rezervirana_sjedala`
--
ALTER TABLE `rezervirana_sjedala`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `sjedala`
--
ALTER TABLE `sjedala`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_dvorane` (`id_dvorane`);

--
-- Indexes for table `termin`
--
ALTER TABLE `termin`
  ADD PRIMARY KEY (`termin`),
  ADD UNIQUE KEY `termin` (`termin`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rezervirana_sjedala`
--
ALTER TABLE `rezervirana_sjedala`
  ADD CONSTRAINT `rezervirana_sjedala_ibfk_1` FOREIGN KEY (`id`) REFERENCES `sjedala` (`id`);

--
-- Constraints for table `sjedala`
--
ALTER TABLE `sjedala`
  ADD CONSTRAINT `sjedala_ibfk_1` FOREIGN KEY (`id_dvorane`) REFERENCES `dvorana` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
