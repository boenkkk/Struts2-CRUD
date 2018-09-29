-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2018 at 01:37 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `websparrow`
--

-- --------------------------------------------------------

--
-- Table structure for table `struts2crud`
--

CREATE TABLE IF NOT EXISTS `struts2crud` (
  `uname` varchar(25) DEFAULT NULL,
  `uemail` varchar(50) NOT NULL,
  `upass` varchar(25) DEFAULT NULL,
  `udeg` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `struts2crud`
--

INSERT INTO `struts2crud` (`uname`, `uemail`, `upass`, `udeg`) VALUES
('budi', 'b@b.b', 'bbb', 'bbb'),
('boenk', 'k@k.k', 'kkk', 'kkk');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `struts2crud`
--
ALTER TABLE `struts2crud`
 ADD PRIMARY KEY (`uemail`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
