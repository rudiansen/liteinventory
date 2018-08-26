CREATE TABLE perusahaan (
  id_perusahaan VARCHAR(12) PRIMARY KEY NOT NULL,
  nama  VARCHAR(50) NOT NULL,
  status  CHAR(1)
);

CREATE TABLE user (
  id_user INT PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  username VARCHAR(20) NOT NULL,
  password VARCHAR(50),
  nama VARCHAR(30),
  email VARCHAR(50),
  status CHAR(1)
);

CREATE TABLE kategori_barang (
  kd_kategori VARCHAR(5) PRIMARY KEY NOT NULL,
  nama  VARCHAR(60)
);

CREATE TABLE barang (
  kd_barang VARCHAR(6) PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  nama  VARCHAR(60) NOT NULL,
  kd_kategori VARCHAR(5),
  merk  VARCHAR(20),
  tipe VARCHAR(20),
  ukuran  VARCHAR(20),
  satuan  VARCHAR(3)
);

CREATE TABLE wilayah (
  kd_wilayah  VARCHAR(5) PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  nama  VARCHAR(60)
);

CREATE TABLE kegiatan (
  kd_kegiatan VARCHAR(5) PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  nama  VARCHAR(60)
);

CREATE TABLE balai (
  kd_balai  VARCHAR(5) PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  nama  VARCHAR(60)
);

CREATE TABLE satuan (
  kd_satuan VARCHAR(3) PRIMARY KEY NOT NULL,
  nama  VARCHAR(20)
);

CREATE TABLE provinsi (
  kd_provinsi VARCHAR(2) PRIMARY KEY NOT NULL,
  nama  VARCHAR(30)
);

CREATE TABLE rkb (
  id_rkb  BIGINT PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  opd VARCHAR(50),
  cabang  VARCHAR(50),
  balai   VARCHAR(50),
  unit  VARCHAR(50),
  kd_provinsi  VARCHAR(2),
  tahun_anggaran_1  VARCHAR(4),
  tahun_anggaran_2  VARCHAR(4),
  server_datetime TIMESTAMP
);

CREATE TABLE rkb_detil (
  id_rkb  BIGINT NOT NULL,
  no_item INT NOT NULL,
  kd_barang VARCHAR(6) NOT NULL,
  nama_barang VARCHAR(60),
  merk  VARCHAR(20),
  tipe  VARCHAR(20),
  ukuran  VARCHAR(20),
  jumlah  DOUBLE,
  harga_satuan  DOUBLE,
  mata_uang VARCHAR(3),
  satuan VARCHAR(3),
  total_biaya DECIMAL(10,2),
  kd_rekening VARCHAR(20),
  keterangan  VARCHAR(255),
  PRIMARY KEY (id_rkb, no_item)
);

ALTER TABLE rkb_detil ADD CONSTRAINT rkb_fk FOREIGN KEY (id_rkb) REFERENCES rkb(id_rkb);

CREATE TABLE rkpb (
  id_rkpb  BIGINT PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  opd VARCHAR(50),
  cabang  VARCHAR(50),
  balai   VARCHAR(50),
  unit  VARCHAR(50),
  kd_provinsi  VARCHAR(2),
  tahun_anggaran_1  VARCHAR(4),
  tahun_anggaran_2  VARCHAR(4),
  server_datetime TIMESTAMP
);

CREATE TABLE rkpb_detil (
  id_rkpb BIGINT NOT NULL,
  no_item INT NOT NULL,
  kd_barang VARCHAR(6) NOT NULL,
  nama_barang VARCHAR(60),
  merk  VARCHAR(20),
  tipe  VARCHAR(20),
  ukuran  VARCHAR(20),
  jumlah  DOUBLE,
  harga_satuan  DOUBLE,
  mata_uang VARCHAR(3),
  satuan VARCHAR(3),
  total_biaya DECIMAL(10,2),
  kd_rekening VARCHAR(20),
  keterangan  VARCHAR(255),
  PRIMARY KEY (id_rkpb, no_item)
);

ALTER TABLE rkpb_detil ADD CONSTRAINT rkpb_fk FOREIGN KEY (id_rkpb) REFERENCES rkpb(id_rkpb);

CREATE TABLE kb (
  id_kb BIGINT PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  opd VARCHAR(50),
  balai VARCHAR(50),
  kd_provinsi VARCHAR(2),
  kd_barang VARCHAR(6),
  nama_barang VARCHAR(60),
  satuan VARCHAR(3),
  server_datetime TIMESTAMP
);

CREATE TABLE kb_detil (
  id_kb BIGINT NOT NULL,
  no_item INT NOT NULL,
  tanggal DATE,
  jumlah_masuk DOUBLE,
  jumlah_keluar DOUBLE,
  sisa  DOUBLE,
  keterangan VARCHAR(255),
  PRIMARY KEY (id_kb, no_item)
);

ALTER TABLE kb_detil ADD CONSTRAINT kb_fk FOREIGN KEY (id_kb) REFERENCES kb(id_kb);

CREATE TABLE kpb (
  id_kpb BIGINT PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  opd VARCHAR(50),
  balai VARCHAR(50),
  kd_provinsi VARCHAR(2),
  kd_barang VARCHAR(6),
  nama_barang VARCHAR(60),
  satuan VARCHAR(3),
  server_datetime TIMESTAMP
);

CREATE TABLE kpb_detil (
  id_kpb BIGINT NOT NULL,
  no_item INT NOT NULL,
  tanggal DATE,
  no_surat VARCHAR(30),
  tanggal_surat DATE,
  uraian  VARCHAR(60),
  jumlah_masuk DOUBLE,
  jumlah_keluar DOUBLE,
  sisa  DOUBLE,
  harga_satuan DOUBLE,
  mata_uang VARCHAR(3),
  jumlah_bertambah DOUBLE,
  jumlah_berkurang DOUBLE,
  jumlah_sisa DOUBLE,
  keterangan VARCHAR(255),
  PRIMARY KEY (id_kpb, no_item)
);

ALTER TABLE kpb_detil ADD CONSTRAINT kpb_fk FOREIGN KEY (id_kpb) REFERENCES kpb(id_kpb);

CREATE TABLE daftar_masuk (
  id_masuk BIGINT PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  tanggal DATE,
  dari VARCHAR(30),
  no_faktur VARCHAR(50),
  tanggal_faktur DATE,
  server_datetime TIMESTAMP
);

CREATE TABLE daftar_masuk_detil (
  id_masuk BIGINT NOT NULL,
  no_item INT NOT NULL,
  kd_barang VARCHAR(6),
  nama_barang VARCHAR(60),
  kd_kategori VARCHAR(5),
  satuan VARCHAR(3),
  jumlah DOUBLE,
  harga_satuan DOUBLE,
  mata_uang VARCHAR(3),
  total_harga DECIMAL(10,2),
  no_bukti_terima VARCHAR(50),
  tanggal_bukti_terima DATE,
  keterangan VARCHAR(255),
  spk_perjanjian VARCHAR(50),
  merk VARCHAR(20),
  ukuran VARCHAR(20),
  tahun_pembuatan VARCHAR(4),
  PRIMARY KEY (id_masuk, no_item)
);

ALTER TABLE daftar_masuk_detil ADD CONSTRAINT daftar_masuk_detil_fk FOREIGN KEY (id_masuk) REFERENCES daftar_masuk(id_masuk);

CREATE TABLE daftar_keluar (
  id_keluar BIGINT PRIMARY KEY NOT NULL,
  id_perusahaan VARCHAR(12),
  opd VARCHAR(50),
  cabang  VARCHAR(50),
  balai   VARCHAR(50),
  unit  VARCHAR(50),
  kd_provinsi  VARCHAR(2),
  no_dasar_keluar VARCHAR(50),
  tanggal_dasar_keluar DATE,
  server_datetime TIMESTAMP
);

CREATE TABLE daftar_keluar_detil (
  id_keluar BIGINT NOT NULL,
  no_item INT NOT NULL,
  kd_barang VARCHAR(6),
  nama_barang VARCHAR(60),
  kd_kategori VARCHAR(5),
  satuan VARCHAR(3),
  jumlah DOUBLE,
  harga_satuan DOUBLE,
  mata_uang VARCHAR(3),
  total_harga DECIMAL(10,2),
  untuk VARCHAR(50),
  tanggal_penyerahan DATE,
  keterangan VARCHAR(255),
  PRIMARY KEY (id_keluar, no_item)
);

ALTER TABLE daftar_keluar_detil ADD CONSTRAINT daftar_keluar_detil_fk FOREIGN KEY (id_keluar) REFERENCES daftar_keluar(id_keluar);

CREATE SEQUENCE doc_id_seq  START WITH 1 INCREMENT BY 1;
