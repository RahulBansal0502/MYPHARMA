-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 24, 2021 at 05:33 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mypharma`
--

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
CREATE TABLE IF NOT EXISTS `medicine` (
  `medicineid` varchar(40) NOT NULL,
  `medicine_name` varchar(80) DEFAULT NULL,
  `cost` int NOT NULL,
  PRIMARY KEY (`medicineid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`medicineid`, `medicine_name`, `cost`) VALUES
('PCM', 'Paracetamol', 10),
('COV', 'Covaxin', 450),
('DP525', 'Disprin', 15);

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
CREATE TABLE IF NOT EXISTS `owner` (
  `ownerid` varchar(40) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ownerid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`ownerid`, `password`, `name`) VALUES
('srk_52', 'srk@52', 'SRK Kaushik'),
('kms52', 'kms@52', 'SM Pharmacy'),
('rk52', 'rk@52', 'RK Pharmacy');

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
CREATE TABLE IF NOT EXISTS `shop` (
  `shopid` varchar(40) NOT NULL,
  `ownerid` varchar(40) DEFAULT NULL,
  `shop_name` varchar(40) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  `contact_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`shopid`),
  KEY `ownerid_fk` (`ownerid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `shop`
--

INSERT INTO `shop` (`shopid`, `ownerid`, `shop_name`, `address`, `pincode`, `contact_no`) VALUES
('kp_52', 'srk_52', 'Kaushik Pharmacy', 'Palwal', '121102', '9354277658'),
('smpham52', 'kms52', 'SM Pharmacy', 'Faridabad', '121103', '9354200000'),
('rkpham52', 'rk52', 'RK Pharmacy', 'Noida', '110022', '9813544444');

-- --------------------------------------------------------

--
-- Table structure for table `shop_has_medicine`
--

DROP TABLE IF EXISTS `shop_has_medicine`;
CREATE TABLE IF NOT EXISTS `shop_has_medicine` (
  `medicineid` varchar(40) NOT NULL,
  `shopid` varchar(40) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`medicineid`,`shopid`),
  KEY `shopid_fk` (`shopid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `shop_has_medicine`
--

INSERT INTO `shop_has_medicine` (`medicineid`, `shopid`, `quantity`) VALUES
('PCM', 'kp_52', 1000),
('COV', 'smpham52', 10),
('DP525', 'rkpham52', 5000);

-- --------------------------------------------------------

--
-- Stand-in structure for view `temp_table`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `temp_table`;
CREATE TABLE IF NOT EXISTS `temp_table` (
`quantity` int
,`shop_name` varchar(40)
,`address` varchar(80)
,`contact_no` varchar(20)
,`pincode` varchar(10)
,`medicineid` varchar(40)
,`shopid` varchar(40)
);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userid` varchar(40) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `contact_no` varchar(15) DEFAULT NULL,
  `email_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `password`, `name`, `contact_no`, `email_id`) VALUES
('rahul_52', 'R1234', 'Rahul_bansal', '935018344', 'rahul@gmail.com'),
('mahi_48', 'mahi@123', 'Kshittiz', NULL, NULL),
('Abj_48', 'abj@123', 'Abhijeet', NULL, NULL),
('Sam_48', 'sam@123', 'Samarth', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure for view `temp_table`
--
DROP TABLE IF EXISTS `temp_table`;

DROP VIEW IF EXISTS `temp_table`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `temp_table`  AS  select `shop_has_medicine`.`quantity` AS `quantity`,`shop`.`shop_name` AS `shop_name`,`shop`.`address` AS `address`,`shop`.`contact_no` AS `contact_no`,`shop`.`pincode` AS `pincode`,`shop_has_medicine`.`medicineid` AS `medicineid`,`shop`.`shopid` AS `shopid` from (`shop` join `shop_has_medicine`) where ((`shop`.`shopid` = `shop_has_medicine`.`shopid`) and (`shop_has_medicine`.`quantity` > 0)) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
