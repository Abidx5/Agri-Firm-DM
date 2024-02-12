-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2022 at 07:43 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agrifarm`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Id` int(11) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Age` varchar(11) NOT NULL,
  `Mobile` varchar(20) NOT NULL,
  `Password` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Id`, `FullName`, `UserName`, `Gender`, `Age`, `Mobile`, `Password`) VALUES
(1, 'shuvon', 'shuvon', 'Male', '21', '017', '29'),
(3, 'Abid', 'abid', 'Male', '21', '015', '27');

-- --------------------------------------------------------

--
-- Table structure for table `billhistory`
--

CREATE TABLE `billhistory` (
  `Pid` varchar(100) NOT NULL,
  `PName` varchar(50) NOT NULL,
  `PCat` varchar(100) NOT NULL,
  `Quan` int(100) NOT NULL,
  `TotalPrice` int(100) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `CustomerName` varchar(20) NOT NULL,
  `CustomerMobile` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billhistory`
--

INSERT INTO `billhistory` (`Pid`, `PName`, `PCat`, `Quan`, `TotalPrice`, `Date`, `CustomerName`, `CustomerMobile`) VALUES
('2', 'Fish', 'Fish', 5, 500, '16/09/2022', 'Ruhan', '0123'),
('4', 'Mango', 'fruits', 5, 400, '16/09/2022', 'Meem', '01234'),
('6', 'Apple', 'Fruit', 2, 240, '16/09/2022', 'Meem', '01234'),
('5', 'Rice', 'Crop', 5, 100, '16/09/2022', 'Meem', '01234');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CName` varchar(20) NOT NULL,
  `CMobile` varchar(15) NOT NULL,
  `CAddress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CName`, `CMobile`, `CAddress`) VALUES
('Ruhan', '0123', 'Dhaka'),
('Meem', '01234', 'Rangpur');

-- --------------------------------------------------------

--
-- Table structure for table `managerlist`
--

CREATE TABLE `managerlist` (
  `MID` int(11) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Age` varchar(20) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Mobile` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `managerlist`
--

INSERT INTO `managerlist` (`MID`, `FullName`, `UserName`, `Gender`, `Age`, `Address`, `Mobile`, `Password`) VALUES
(1, 'sagor', 'sagor', 'Male', '25', 'Raj', '016', '04'),
(3, 'EFTI', 'SMEFTI70', 'Male', '21', 'Dhaka', '01967205926', 'Password');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `PID` int(11) NOT NULL,
  `PName` varchar(50) NOT NULL,
  `PCategory` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `TotalCost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`PID`, `PName`, `PCategory`, `Quantity`, `Price`, `TotalCost`) VALUES
(2, 'Fish', 'Fish', 60, 100, 500),
(4, 'Mango', 'fruits', 35, 80, 3200),
(5, 'Rice', 'Crop', 85, 20, 2000),
(6, 'Apple', 'Fruit', 18, 120, 2400);

-- --------------------------------------------------------

--
-- Table structure for table `productanddate`
--

CREATE TABLE `productanddate` (
  `PName` varchar(20) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Date` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productanddate`
--

INSERT INTO `productanddate` (`PName`, `Quantity`, `Date`) VALUES
('Fish', 10, '22-09-2022'),
('Mango', 10, '10-09-2022'),
('Rice', 20, '15-09-2022'),
('Apple', 5, '15-09-2022');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `managerlist`
--
ALTER TABLE `managerlist`
  ADD PRIMARY KEY (`MID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`PID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `managerlist`
--
ALTER TABLE `managerlist`
  MODIFY `MID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
