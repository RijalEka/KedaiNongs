-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Nov 2024 pada 14.40
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kedai_nongs`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_kasir`
--

CREATE TABLE `tabel_kasir` (
  `id_Kasir` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `nama_kasir` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `jenis_kel` varchar(50) NOT NULL,
  `umur` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tabel_kasir`
--

INSERT INTO `tabel_kasir` (`id_Kasir`, `Username`, `Password`, `nama_kasir`, `alamat`, `jenis_kel`, `umur`) VALUES
(2, 'a', 'a', 'a', 'a', 'Perempuan', '12');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_menu`
--

CREATE TABLE `tabel_menu` (
  `id_Menu` int(11) NOT NULL,
  `Nama_Menu` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tabel_menu`
--

INSERT INTO `tabel_menu` (`id_Menu`, `Nama_Menu`, `harga`) VALUES
(1, 'Nasi Uduk', '10000'),
(2, 'Mie Ayam', '13000'),
(3, 'Nasi Goreng', '15000'),
(4, 'Bakso', '13000'),
(5, 'Seblak', '15000'),
(6, 'Geprek', '15000'),
(7, 'Lemon Tea', '5000'),
(8, 'Iced Coffee', '7000'),
(9, 'Squeeze Orange', '5000'),
(10, 'Hot Coffee', '7000'),
(11, 'Milkshake', '10000'),
(12, 'Lemon Squash', '15000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_order`
--

CREATE TABLE `tabel_order` (
  `id_Pesanan` int(11) NOT NULL,
  `id_Menu` int(11) DEFAULT NULL,
  `id_Kasir` int(11) DEFAULT NULL,
  `Jumlah_Pesanan` int(11) NOT NULL,
  `Tanggal_Pesanan` date NOT NULL,
  `Total_Harga` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_riwayat`
--

CREATE TABLE `tabel_riwayat` (
  `id_History` int(11) NOT NULL,
  `id_Transaksi` int(11) NOT NULL,
  `Tanggal_Aktivitas` datetime NOT NULL,
  `Aktivitas` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_transaksi`
--

CREATE TABLE `tabel_transaksi` (
  `id_Transaksi` int(11) NOT NULL,
  `id_Kasir` int(11) DEFAULT NULL,
  `Metode_Pembayaran` varchar(50) DEFAULT NULL,
  `Tanggal_Transaksi` datetime DEFAULT current_timestamp(),
  `Jumlah_Uang` int(11) DEFAULT NULL,
  `Kembalian` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tabel_kasir`
--
ALTER TABLE `tabel_kasir`
  ADD PRIMARY KEY (`id_Kasir`);

--
-- Indeks untuk tabel `tabel_menu`
--
ALTER TABLE `tabel_menu`
  ADD PRIMARY KEY (`id_Menu`);

--
-- Indeks untuk tabel `tabel_order`
--
ALTER TABLE `tabel_order`
  ADD PRIMARY KEY (`id_Pesanan`),
  ADD KEY `id_Menu` (`id_Menu`),
  ADD KEY `id_Kasir` (`id_Kasir`);

--
-- Indeks untuk tabel `tabel_riwayat`
--
ALTER TABLE `tabel_riwayat`
  ADD PRIMARY KEY (`id_History`),
  ADD KEY `id_Transaksi` (`id_Transaksi`);

--
-- Indeks untuk tabel `tabel_transaksi`
--
ALTER TABLE `tabel_transaksi`
  ADD PRIMARY KEY (`id_Transaksi`),
  ADD KEY `id_Kasir` (`id_Kasir`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tabel_kasir`
--
ALTER TABLE `tabel_kasir`
  MODIFY `id_Kasir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tabel_menu`
--
ALTER TABLE `tabel_menu`
  MODIFY `id_Menu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `tabel_order`
--
ALTER TABLE `tabel_order`
  MODIFY `id_Pesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT untuk tabel `tabel_riwayat`
--
ALTER TABLE `tabel_riwayat`
  MODIFY `id_History` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `tabel_transaksi`
--
ALTER TABLE `tabel_transaksi`
  MODIFY `id_Transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tabel_order`
--
ALTER TABLE `tabel_order`
  ADD CONSTRAINT `tabel_order_ibfk_1` FOREIGN KEY (`id_Menu`) REFERENCES `tabel_menu` (`id_Menu`),
  ADD CONSTRAINT `tabel_order_ibfk_2` FOREIGN KEY (`id_Kasir`) REFERENCES `tabel_kasir` (`id_Kasir`);

--
-- Ketidakleluasaan untuk tabel `tabel_riwayat`
--
ALTER TABLE `tabel_riwayat`
  ADD CONSTRAINT `tabel_riwayat_ibfk_1` FOREIGN KEY (`id_Transaksi`) REFERENCES `tabel_transaksi` (`id_Transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tabel_transaksi`
--
ALTER TABLE `tabel_transaksi`
  ADD CONSTRAINT `tabel_transaksi_ibfk_1` FOREIGN KEY (`id_Kasir`) REFERENCES `tabel_kasir` (`id_Kasir`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
