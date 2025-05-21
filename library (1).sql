-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 04:07 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
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
  `BookID` int(11) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Author` varchar(255) NOT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `PublishedYear` int(11) DEFAULT NULL,
  `Genre` varchar(100) DEFAULT NULL,
  `CopiesAvailable` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`BookID`, `Title`, `Author`, `ISBN`, `PublishedYear`, `Genre`, `CopiesAvailable`) VALUES
(1, 'Book ni Jack', 'Jack', '9781984702166', 2025, 'Horror', 6),
(2, 'To Kill a Mockingbird', 'Harper Lee', '9780061120084', 1960, 'Fiction', 5),
(3, '1984', 'George Orwell', '9780451524935', 1949, 'Dystopian', 6),
(4, 'Pride and Prejudice', 'Jane Austen', '9780141040349', 1813, 'Romance', 5),
(5, 'The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 1925, 'Fiction', 4),
(6, 'Moby Dick', 'Herman Melville', '9781503280786', 1851, 'Adventure', 2),
(7, 'War and Peace', 'Leo Tolstoy', '9781420953203', 1869, 'Historical Fiction', 2),
(8, 'The Catcher in the Rye', 'J.D. Salinger', '9780316769488', 1951, 'Fiction', 4),
(9, 'The Hobbit', 'J.R.R. Tolkien', '9780345339683', 1937, 'Fantasy', 8),
(10, 'Fahrenheit 451', 'Ray Bradbury', '9781451673319', 1953, 'Dystopian', 5),
(11, 'Brave New World', 'Aldous Huxley', '9780060850524', 1932, 'Dystopian', 3),
(12, 'The Picture of Dorian Gray', 'Oscar Wilde', '9780141439570', 1890, 'Philosophical Fiction', 2),
(13, 'Anna Karenina', 'Leo Tolstoy', '9781853262507', 1877, 'Fiction', 3),
(14, 'The Chronicles of Narnia', 'C.S. Lewis', '9780066238500', 1950, 'Fantasy', 7),
(15, 'The Alchemist', 'Paulo Coelho', '9780061122415', 1988, 'Fiction', 4),
(16, 'Les Misérables', 'Victor Hugo', '9780451419439', 1862, 'Historical Fiction', 1);

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `BorrowID` int(11) NOT NULL,
  `BookID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `BorrowDate` date DEFAULT curdate(),
  `ReturnDate` date DEFAULT NULL,
  `Status` enum('Pending','Active','Returned') DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`BorrowID`, `BookID`, `UserID`, `BorrowDate`, `ReturnDate`, `Status`) VALUES
(1, 1, 1, '2025-05-20', '2025-10-20', 'Returned'),
(2, 1, 1, '2025-05-20', '2025-10-20', 'Pending'),
(3, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(4, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(5, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(6, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(7, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(8, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(9, 6, 1, '2025-05-20', '2025-06-03', 'Pending'),
(10, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(11, 1, 1, '2025-05-20', '2025-06-03', 'Pending'),
(12, 4, 1, '2025-05-20', '2025-06-03', 'Pending'),
(13, 3, 2, '2025-05-20', '2025-06-03', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `user_id`, `action`, `date_time`) VALUES
(1, 1, 'User logged in', '2025-05-20 16:07:53'),
(2, 1, 'Admin Logged Out.', '2025-05-20 16:07:59'),
(3, 1, 'User logged in', '2025-05-20 16:08:02');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `RegistrationDate` date DEFAULT curdate(),
  `Role` enum('Admin','User') DEFAULT 'User',
  `Status` enum('Pending','Active') DEFAULT 'Pending',
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `secretanswer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `FirstName`, `LastName`, `Email`, `Phone`, `Address`, `RegistrationDate`, `Role`, `Status`, `Username`, `Password`, `image`, `secretanswer`) VALUES
(1, 'Jack', 'Cuerpo', 'jackcuerpo@gmail.com', '9876543210', 'Inayagan', '2025-05-20', 'Admin', 'Active', 'jack', '9poByOVgcgAb4RKPISEsnVKV1gmq6mcZGK/u3lPLx88=', 'usericon.png', 'secret'),
(2, 'user', 'test', 'usertest@gmail.com', '9876543321', 'Inayagan', '2025-05-20', 'User', 'Active', 'user', 'gxwjeSjmISvtqkRRpRSs4xdFYvZ2H2oVei/lCCs24vs=', 'src/images/Background.png', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`BookID`),
  ADD UNIQUE KEY `ISBN` (`ISBN`);

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`BorrowID`),
  ADD KEY `fk_borrow_book` (`BookID`),
  ADD KEY `fk_borrow_user` (`UserID`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `BookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `borrow`
--
ALTER TABLE `borrow`
  MODIFY `BorrowID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrow`
--
ALTER TABLE `borrow`
  ADD CONSTRAINT `fk_borrow_book` FOREIGN KEY (`BookID`) REFERENCES `book` (`BookID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_borrow_user` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
