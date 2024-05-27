Ctrl+F : Create
Database Sales_Manager -MYSQL
Create DataBase myweb_new

CREATE TABLE `theloai` (
	`matheloai` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`tentheloai` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`matheloai`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `tacgia` (
	`matacgia` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`hovaten` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`ngaysinh` DATE NULL DEFAULT NULL,
	`tieusu` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`matacgia`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `sanpham` (
	`masanpham` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`tensanpham` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`matacgia` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`namxuatban` INT(11) NULL DEFAULT NULL,
	`gianhap` DOUBLE NULL DEFAULT NULL,
	`giagoc` DOUBLE NULL DEFAULT NULL,
	`giaban` DOUBLE NULL DEFAULT NULL,
	`soluong` DOUBLE NULL DEFAULT NULL,
	`matheloai` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`ngonngu` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`mota` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`masanpham`) USING BTREE,
	INDEX `FK_sanpham_tacgia` (`matacgia`) USING BTREE,
	INDEX `FK_sanpham_theloai` (`matheloai`) USING BTREE,
	CONSTRAINT `FK_sanpham_tacgia` FOREIGN KEY (`matacgia`) REFERENCES `tacgia` (`matacgia`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_sanpham_theloai` FOREIGN KEY (`matheloai`) REFERENCES `theloai` (`matheloai`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `khachhang` (
	`makhachhang` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`tendangnhap` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`matkhau` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`hovaten` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`gioitinh` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`diachi` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`diachinhanhang` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`diachimuahang` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`ngaysinh` DATE NULL DEFAULT NULL,
	`sodienthoai` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`email` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`dangkynhanemail` TINYINT(4) NULL DEFAULT '0',
	`maxacthuc` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`thoigianhieuluccuamaxacthuc` DATETIME NULL DEFAULT NULL,
	`trangthaixacthuc` TINYINT(4) NULL DEFAULT '0',
	`duongdananh` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci'
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `donhang` (
	`madonhang` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`makhachhang` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`diachinguoimua` VARCHAR(512) NOT NULL COLLATE 'utf8mb4_general_ci',
	`diachinhanhang` VARCHAR(512) NOT NULL COLLATE 'utf8mb4_general_ci',
	`trangthai` VARCHAR(512) NOT NULL COLLATE 'utf8mb4_general_ci',
	`hinhthucthanhtoan` VARCHAR(512) NOT NULL COLLATE 'utf8mb4_general_ci',
	`sotienthanhtoan` DOUBLE NULL DEFAULT NULL,
	`sotienconthieu` DOUBLE NOT NULL,
	`ngaydathang` DATE NOT NULL,
	`ngaygiaohang` DATE NOT NULL,
	PRIMARY KEY (`madonhang`) USING BTREE,
	INDEX `FK_donhang_khachhang` (`makhachhang`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `chitietdonhang` (
	`machitietdonhang` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`madonhang` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`masanpham` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`soluong` DOUBLE NULL DEFAULT NULL,
	`giabia` DOUBLE NULL DEFAULT NULL,
	`giagiam` DOUBLE NULL DEFAULT NULL,
	`giaban` DOUBLE NULL DEFAULT NULL,
	`vat` DOUBLE NULL DEFAULT NULL,
	`tongthanhtien` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`machitietdonhang`) USING BTREE,
	INDEX `FK_chitietdonhang_donhang` (`madonhang`) USING BTREE,
	INDEX `FK_chitietdonhang_sanpham` (`masanpham`) USING BTREE,
	CONSTRAINT `FK_chitietdonhang_donhang` FOREIGN KEY (`madonhang`) REFERENCES `donhang` (`madonhang`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_chitietdonhang_sanpham` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

