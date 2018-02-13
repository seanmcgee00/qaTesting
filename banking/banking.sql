-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2018 at 02:39 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banking`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `accountNo` varchar(5) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`accountNo`, `name`, `address`) VALUES
('CF001', 'Alice', 'Dundalk'),
('CM002', 'Brendan', 'Kildare'),
('CM003', 'Tony', 'belfast'),
('CM004', 'Conor', 'Offaly'),
('SM001', 'Sean', 'Dundalk'),
('SM002', 'Niall', 'Dublin'),
('SM003', 'Ian', 'Dublin'),
('SM004', 'Nicky', 'Dublin'),
('SM005', 'Dec', 'Laois'),
('SM006', 'Jack', 'Man');

-- --------------------------------------------------------

--
-- Table structure for table `transactionlog`
--

CREATE TABLE `transactionlog` (
  `logID` int(11) NOT NULL,
  `actionTaken` varchar(1) DEFAULT NULL,
  `accountNo` varchar(5) DEFAULT NULL,
  `amount` double(7,2) DEFAULT NULL,
  `transactionDate` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactionlog`
--

INSERT INTO `transactionlog` (`logID`, `actionTaken`, `accountNo`, `amount`, `transactionDate`) VALUES
(1, 'D', 'CF001', 999.99, '2018-02-01 00:00:00'),
(2, 'D', 'CF001', 500.00, '2018-02-09 00:00:00'),
(3, 'W', 'CF001', 255.50, '2018-02-09 00:00:00'),
(4, 'D', 'cf001', 500.00, '2018-02-12 00:00:00'),
(5, 'D', 'cf001', 125.00, '2018-02-09 00:00:00'),
(6, 'W', 'cf001', 125.00, '2018-02-11 00:00:00'),
(7, 'W', 'cf001', 100.00, '2018-02-02 00:00:00'),
(8, 'D', 'cf001', 100.00, '2018-02-03 00:00:00'),
(9, 'D', 'cf001', 200.00, '2018-02-13 00:00:00'),
(10, 'D', 'cf001', 100.00, '2018-02-14 00:00:00'),
(11, 'D', 'CF001', 100.00, '2018-02-07 00:00:00'),
(12, 'D', 'cf001', 100.00, '2018-02-02 00:00:00'),
(13, 'W', 'CF001', 220.00, '2018-02-04 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`accountNo`);

--
-- Indexes for table `transactionlog`
--
ALTER TABLE `transactionlog`
  ADD PRIMARY KEY (`logID`),
  ADD KEY `accountNo` (`accountNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactionlog`
--
ALTER TABLE `transactionlog`
  MODIFY `logID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transactionlog`
--
ALTER TABLE `transactionlog`
  ADD CONSTRAINT `transactionlog_ibfk_1` FOREIGN KEY (`accountNo`) REFERENCES `accounts` (`accountNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
