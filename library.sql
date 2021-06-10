-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 15, 2020 at 05:43 AM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `ISBN` varchar(20) NOT NULL,
  `title` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `publication_year` varchar(20) NOT NULL,
  `flag` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `ISBN`, `title`, `author`, `publication_year`, `flag`) VALUES
(1, '', '', '', '', '2');

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `id` int(11) NOT NULL,
  `borrow_name` varchar(50) DEFAULT NULL,
  `borrow_type` varchar(50) DEFAULT NULL,
  `book_name` varchar(50) NOT NULL,
  `flag` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`id`, `borrow_name`, `borrow_type`, `book_name`, `flag`) VALUES
(1, 'sadiq', 'student', 'aa', '0'),
(3, 'hala', 'Professor', 'bb', '1');

-- --------------------------------------------------------

--
-- Table structure for table `professors`
--

CREATE TABLE `professors` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `faculty` varchar(20) NOT NULL,
  `ProfNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professors`
--

INSERT INTO `professors` (`id`, `name`, `faculty`, `ProfNumber`) VALUES
(1, 'hjk', 'huh', '56'),
(2, 'hala', 'it', '114'),
(3, 'ali', 'it', '117'),
(4, 'sadiq', 'basrah', '1997'),
(5, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `stNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `sname`, `stNumber`) VALUES
(1, 'sadiq', '1502201'),
(2, 'sadiq', '666'),
(4, 'sadiq2', '6662');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`borrow_name`),
  ADD KEY `prof_id` (`borrow_type`),
  ADD KEY `book_id` (`book_name`);

--
-- Indexes for table `professors`
--
ALTER TABLE `professors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `borrow`
--
ALTER TABLE `borrow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `professors`
--
ALTER TABLE `professors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
