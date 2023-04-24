-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2023 at 06:16 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `location_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `location_uuid` varchar(255) DEFAULT NULL,
  `text` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `location_uuid`, `text`, `created_at`) VALUES
(1, 28, 'dhdkjskknjs', 'fdfdff', '2023-04-23 03:32:23'),
(2, 28, 'dhdkjskknjs', 'fdfdff', '2023-04-23 03:33:00');

-- --------------------------------------------------------

--
-- Table structure for table `image_comments`
--

CREATE TABLE `image_comments` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `location_uuid` varchar(255) DEFAULT NULL,
  `blobc` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `password`, `rol`, `username`) VALUES
(1, 'user6@gmail.com', b'1', 'user6', 'Admin', 'user6'),
(2, 'user75@gmail.com', b'1', 'user75', 'Admin', 'user75'),
(3, 'user36@gmail.com', b'1', 'user36', 'Admin', 'user36'),
(4, 'user43@gmail.com', b'1', 'user43', 'Admin', 'user43'),
(5, 'user77@gmail.com', b'1', 'user77', 'Admin', 'user77'),
(6, 'user50@gmail.com', b'1', 'user50', 'Admin', 'user50'),
(7, 'user48@gmail.com', b'1', 'user48', 'Admin', 'user48');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isEmailVerified` tinyint(1) NOT NULL DEFAULT 0,
  `emailVerificationCode` varchar(225) DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email_id`, `username`, `password`, `isEmailVerified`, `emailVerificationCode`, `profile_picture`, `created_at`) VALUES
(28, NULL, 'mayank3@gmail.com', 'nawaz', '$2a$10$FDJLBf.wXtpXPOZ7ACXjJuwqA7qYV1tOBJUBUF1vyMpiyaA5hnOrO', 0, NULL, NULL, '2023-03-26 05:00:53'),
(29, NULL, 'string', 'string', '$2a$10$aAJcaWUv4kHZ94JTp4LTYuMFNlor4i0bDcmYbZ7m/9/1BxunmxCMW', 0, NULL, NULL, '2023-04-19 18:49:37'),
(32, 'k j', 'k@g.com', 'k2@g.com', '$2a$10$s0UTAnnBsG8nmr.BXmYte.C9bq0B.3/pASriPkxzbw1FbdrtHrUnW', 0, NULL, NULL, '2023-04-19 19:14:57'),
(38, NULL, 'mayank@abc.com', 'mp', '$2a$10$LNXGbL2hD8bzjS826aYXd.cfNfGZv77kV1NGkHWJdvYINXl.tCtJ2', 1, 'eMYRlCYeOtoKlgvmFqPFqsliWAPetE1M6TWukpdq3uFR6A20IT', NULL, '2023-04-20 16:55:06'),
(39, NULL, 'ab@gmail.com', 'ab', '$2a$10$wL/VIHTGK/Im2EIBOqicQe9SREOtFBhsWqDUtvXgP8r.8ljawO2gW', 0, '7S9kGH7nqMArSAe5I4TVIdPrYMvCBERI9BCWgLKhbUtJReCZ27', NULL, '2023-04-20 17:39:38'),
(40, NULL, 'abc@gmail.com', 'abc', '$2a$10$t9rx5PDQ5wK0e8LW1TD6Le9lXmz1KwIRbmFI8ctuMUtyN3FQdM.n2', 1, 'UnBuplqRWeqfT5ERbh377cS51cmaQ5ajrDQM68GtWQN5gZJWNS', NULL, '2023-04-20 17:40:51'),
(41, NULL, 'testuser@abc.com', 'testuser1', '$2a$10$aKQQrrcJ0vUVroKcnXH4Ie4zCZRvNwBqXu8p0oOxIl/Q1IyJ2CHdS', 0, '5MXmArpYeX9Wdc2dpaPXZpeTA8hTmPOZHDL0dkcFaDXp9YJqkH', NULL, '2023-04-21 06:52:31'),
(42, NULL, 'testuser2@abc.com', 'testuser2', '$2a$10$ZjlfF4o2ie4WnMuo8UhM6u2VQeqnZdkHcgMGLGkkhquJl/e0JqwsS', 0, 'jKtf2so4Q7TJ4oPcT6dbcGMAQBFZfTBKeXWIgvU9kpJpMAK8Bd', NULL, '2023-04-21 06:52:58'),
(43, 'Test user', 'testuser3@abc.com', 'testuser3', '$2a$10$Oezv6GCB75CFSckxCUGveunbU2enZ3iF2V9FlKBAUX/QXctEz1ZUC', 0, 'S1LAbB7J8Aig455e7QGPtInTI5mgECg2HJp59us3a1jpXg3Z5l', NULL, '2023-04-21 07:01:11');

-- --------------------------------------------------------

--
-- Table structure for table `user_locations`
--

CREATE TABLE `user_locations` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `location_uuid` varchar(225) NOT NULL,
  `name` varchar(255) NOT NULL,
  `body` text NOT NULL,
  `primaryContactNo` varchar(255) NOT NULL,
  `openTime` varchar(255) NOT NULL,
  `closeTime` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `location_id` (`location_uuid`);

--
-- Indexes for table `image_comments`
--
ALTER TABLE `image_comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `location_id` (`location_uuid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_id` (`email_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `user_locations`
--
ALTER TABLE `user_locations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `image_comments`
--
ALTER TABLE `image_comments`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `user_locations`
--
ALTER TABLE `user_locations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `image_comments`
--
ALTER TABLE `image_comments`
  ADD CONSTRAINT `image_comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `user_locations`
--
ALTER TABLE `user_locations`
  ADD CONSTRAINT `user_locations_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
