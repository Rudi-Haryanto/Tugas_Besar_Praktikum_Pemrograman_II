-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2024 at 01:11 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pp2_sorum_tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `mermo`
--

CREATE TABLE `mermo` (
  `id` varchar(255) NOT NULL,
  `merekmobil` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mermo`
--

INSERT INTO `mermo` (`id`, `merekmobil`) VALUES
('3a1b3b33-352b-47e4-b7ec-b811e6971f08', 'Suzuki'),
('4d95dc5b-89fa-40b6-b101-7f3b7ceaa3c8', 'Toyota'),
('73e0d352-c49b-49c6-9c9c-228ce6746060', 'Daihatsu'),
('ab7ee05a-99be-4f03-866a-d74c29946369', 'Isuzu'),
('c2c3f304-9e61-4da6-a86a-6cf38a129c95', 'Hyundai'),
('e791a5da-d0c5-424b-95ba-0fce6932dbb4', 'Honda');

-- --------------------------------------------------------

--
-- Table structure for table `namot`
--

CREATE TABLE `namot` (
  `id` varchar(255) NOT NULL,
  `namamobil` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `namot`
--

INSERT INTO `namot` (`id`, `namamobil`) VALUES
('343134b6-e8fa-4f69-b4d0-a5b175be4a8d', 'Xenia'),
('720de09f-6e45-4cbf-89c5-49b5e0ce4be1', 'Avanza'),
('770e067f-83b3-4ea6-b23b-33e0b485e915', 'CR-V');

-- --------------------------------------------------------

--
-- Table structure for table `sorum`
--

CREATE TABLE `sorum` (
  `id` varchar(255) NOT NULL,
  `namot_id` varchar(255) DEFAULT NULL,
  `mermo_id` varchar(255) DEFAULT NULL,
  `namapem` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `jenismot` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sorum`
--

INSERT INTO `sorum` (`id`, `namot_id`, `mermo_id`, `namapem`, `alamat`, `jenismot`) VALUES
('31c725c0-15bf-4f3e-bb7d-905848773bfa', '720de09f-6e45-4cbf-89c5-49b5e0ce4be1', '4d95dc5b-89fa-40b6-b101-7f3b7ceaa3c8', 'Caprio', 'Tanggerang', 'MVP'),
('40e249bd-9fde-44ac-8738-5b66a7e85832', '770e067f-83b3-4ea6-b23b-33e0b485e915', '3a1b3b33-352b-47e4-b7ec-b811e6971f08', 'predd', 'karwa', 'SUV'),
('ae8203f5-726e-4345-84fb-7deab722806e', '770e067f-83b3-4ea6-b23b-33e0b485e915', '4d95dc5b-89fa-40b6-b101-7f3b7ceaa3c8', 'Rudi Haryanto', 'Bandung', 'MVP');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mermo`
--
ALTER TABLE `mermo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `namot`
--
ALTER TABLE `namot`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sorum`
--
ALTER TABLE `sorum`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
