CREATE DATABASE CONGNGHE123456
GO 
USE CONGNGHE123456
GO
CREATE TABLE NHANVIEN (
	MANV NVARCHAR (50) NOT NULL PRIMARY KEY,
	TENNV NVARCHAR (50) NOT NULL,
	NGAYSINH DATE NOT NULL, 
	GIOITINH BIT NOT NULL,
	EMAIL NVARCHAR(50) NOT NULL,
	DIACHI NVARCHAR (50) NOT NULL,
	SDT VARCHAR(15) NOT NULL,
	MATKHAU NVARCHAR(50) NOT NULL,
	VAITRO BIT NOT NULL,
)
GO
CREATE TABLE KHACHHANG(
	MAKH NVARCHAR (50) NOT NULL PRIMARY KEY,
	TENKH NVARCHAR (50) NOT NULL,
	NGAYSINH DATE NOT NULL,
	DIACHI NVARCHAR (50) NOT NULL,
	SDT VARCHAR(15) NOT NULL,
)
GO 
CREATE TABLE VOUCHERCT(
 	MAKM NVARCHAR (50) NOT NULL PRIMARY KEY,
	SOLUONG INT NOT NULL,
	TENKHUYENMAI NVARCHAR (50) NOT NULL,
	NGAYBATDAU DATE NOT NULL,
	NGAYKETTHUC DATE NOT NULL,
	LOAISP NVARCHAR (50) NOT NULL,
	GIAMGIA INT NOT NULL,
	TRANGTHAI BIT NOT NULL,
	IDHOADON INT NOT NULL,
)
GO
CREATE TABLE HOADON (
	IDHOADON INT PRIMARY KEY NOT NULL,
	MAHD NVARCHAR (50) NOT NULL,
	MANV NVARCHAR (50) NOT NULL,
	MAKH NVARCHAR (50) NOT NULL,
	TRANGTHAI BIT NOT NULL,	
	TONGTIEN MONEY NOT NULL,
	MAGIAMGIA NVARCHAR (50) NOT NULL, 
	NGAYTAO DATE NOT NULL,

) 
GO 
CREATE TABLE HOADONCHITIET (
	MAHD NVARCHAR (50) PRIMARY KEY NOT NULL, 
	IDHOADON INT,
	MASP NVARCHAR (50) NOT NULL,
	TENSP NVARCHAR (50) NOT NULL,
	HOADON NVARCHAR (50),
	SOLUONG INT NOT NULL, 
	GIA MONEY NOT NULL,
	IDSANPHAM NVARCHAR (50),
)
GO 
CREATE TABLE SANPHAM (
	MASP NVARCHAR (50) NOT NULL PRIMARY KEY,
	TENSP NVARCHAR (50) NOT NULL,
	GIA MONEY NOT NULL,
	TRINGTHAI BIT,
	LOAISP NVARCHAR (50) NOT NULL,
	SOLUONG INT NOT NULL, 
)
GO 
CREATE TABLE LOAISP(
	LOAISP NVARCHAR (50) PRIMARY KEY NOT NULL,
	TRANGTHAI BIT NOT NULL,
)
go
-- NHAN VIEN VOI HOA DON 
ALTER TABLE HOADON ADD FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
--KHACHHANG VOI HOA DON 
ALTER TABLE HOADON ADD FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH)
--VOUCHER VOI VOUCHERCT 
ALTER TABLE VOUCHERCT ADD FOREIGN KEY (IDHOADON) REFERENCES HOADON (IDHOADON)
--HOADON VOI HOADONCHITIET
ALTER TABLE HOADONCHITIET ADD FOREIGN KEY (IDHOADON) REFERENCES  HOADON (IDHOADON)
--SAN PHAM VOI HOA DON CHI TIET
ALTER TABLE HOADONCHITIET ADD FOREIGN KEY (MASP) REFERENCES  SANPHAM (MASP)
-- SAN PHAM VOI LOAISP
ALTER TABLE SANPHAM ADD FOREIGN KEY (LOAISP) REFERENCES LOAISP (LOAISP)

GO
INSERT INTO NHANVIEN(MANV,TENNV,NGAYSINH,GIOITINH,EMAIL,DIACHI,SDT,MATKHAU,VAITRO) VALUES 
(N'001',N'NGUYEN VAN TUNG LAM','2004-02-13',0,N'nguyenlam13022004@gmail.com',N'Ha Noi','0342793369',N'11221212345',0),
(N'002',N'NGUYEN DUY KHANH','2004-02-14',0,N'nguyenkhanh14022004@gmail.com',N'Nam Dinh','0342793388',N'11331212345',0),
(N'003',N'NGUYEN NGOC QUANG','2004-02-15',0,N'nguyenquang15022004@gmail.com',N'Binh duong','0231193369',N'11288736345',0),
(N'004',N'LE HONG QUYEN','2004-02-16',0,N'hongquyen16022004@gmail.com',N'Vung Tau','034278828229',N'1876441212345',0),
(N'005',N'BUI VAN HAI','2004-02-17',0,N'vanhai17022004@gmail.com',N'Sa Pa','03475342513369',N'7733552212345',0),
(N'006',N'DOAN GIA HUY','2004-02-18',0,N'huydoan18022004@gmail.com',N'Ha Noi','0342752437369',N'3663521212345',0)
go

INSERT INTO KHACHHANG(MAKH,TENKH,NGAYSINH,DIACHI,SDT) VALUES
(N'KH01',N'NGUYEN VAN TEO','1998-09-07',N'HA NOI','0998877665'),
(N'KH02',N'BUI MANH ME','1999-08-06',N'HA NOI','08575775755'),
(N'KH03',N'CHU QUANG BA','2000-06-05',N'HA NOI','07475757575'),
(N'KH04',N'DO DUY NAM','1989-09-04',N'HA NOI','08479377455'),
(N'KH05',N'PHAN MANH QUYNH','1994-02-03',N'HA NOI','0984747445'),
(N'KH06',N'DAO DUY TAI','2004-01-02',N'HA NOI','0985848484'),
(N'KH07',N'HO NGOC HA','2003-03-01',N'HA NOI','0953729473'),
(N'KH08',N'TRAN HA LINH','1998-08-08',N'HA NOI','0985857575')
GO
INSERT INTO VOUCHERCT(MAKM,SOLUONG,TENKHUYENMAI,NGAYBATDAU,NGAYKETTHUC,LOAISP,GIAMGIA,TRANGTHAI,IDHOADON) VALUES
(N'KM01',2 ,N'KHUYEN MAI 15%',N'2023-1-1',N'2023-2-2',N'OPPO',15,1,1),
(N'KM02',1 ,N'KHUYEN MAI 5%',N'2023-1-2',N'2023-2-3',N'SAMSUNG',5,0,2),
(N'KM03',1 ,N'KHUYEN MAI 9%',N'2023-1-3',N'2023-2-4',N'REDMI',9,1,3),
(N'KM04',4,N'KHUYEN MAI 14%',N'2023-1-4',N'2023-2-5',N'DELL',14,0,4),
(N'KM05',3,N'KHUYEN MAI 3%',N'2023-1-5',N'2023-2-6',N'ASUS',3,1,5),
(N'KM06',7,N'KHUYEN MAI 8%',N'2023-1-6',N'2023-2-7',N'ACER',8,0,6),
(N'KM07',1,N'KHUYEN MAI 7%',N'2023-1-7',N'2023-2-8',N'MSI',7,1,7),
(N'KM08',2,N'KHUYEN MAI 10%',N'2023-1-8',N'2023-2-9',N'IPHON',10,0,8)
GO
INSERT INTO HOADON(IDHOADON,MAHD,MANV,MAKH,TRANGTHAI,TONGTIEN,MAGIAMGIA,NGAYTAO) VALUES
(1,N'1',N'001',N'KH01',1,1500000,N'KM15%',N'2023-2-2'),
(2,N'2',N'002',N'KH02',0,5500000,N'KM5%',N'2023-2-3'),
(3,N'3',N'003',N'KH03',1,5000000,N'KM9%',N'2023-2-4'),
(4,N'4',N'004',N'KH04',0,5500000,N'KM14%',N'2023-2-5'),
(5,N'5',N'005',N'KH05',1,1950000,N'KM3%',N'2023-2-6'),
(6,N'6',N'006',N'KH06',0,3000000,N'KM8%',N'2023-2-7'),
(7,N'7',N'001',N'KH07',1,3700000,N'KM7%',N'2023-2-8'),
(8,N'8',N'002',N'KH08',0,5000000,N'KM10%',N'2023-2-9')
GO
INSERT INTO HOADONCHITIET(MAHD,IDHOADON,MASP,TENSP,HOADON,SOLUONG,GIA,IDSANPHAM) VALUES
(N'1',1,N'1886661',N'OPPO RENO3',N'1',71,30000000,140001),
(N'2',2,N'1886672',N'SAMSUNG S22ULTRA',N'1',81,5500000,140002),
(N'3',3,N'1886687',N'POCO X3',N'3',1,5000,140003),
(N'4',4,N'1886697',N'DELL VOSTRO',N'4',4,212000,140004),
(N'5',5,N'1886617',N'ASUS TUF GAMING',N'5',3,585000,140005),
(N'6',6,N'1886626',N'ACER NITRO5',N'6',7,210000,140006),
(N'7',7,N'1886667',N'MSI GAMING',N'7',1,37000,140007),
(N'8',8,N'1886668',N'IPHON 15PRO',N'8',2,100000,140008)
GO
INSERT INTO SANPHAM(MASP,TENSP,GIA,TRINGTHAI,LOAISP,SOLUONG) VALUES
(N'1886661',N'OPPO RENO3',30000000,1,N'OPPO',88),
(N'1886671',N'OPPO PIX3',20000000,1,N'OPPO',78),
(N'1886681',N'OPPO FIND N3',15000000,1,N'OPPO',68),
(N'1886691',N'OPPO RENO10 5G',50000000,1,N'OPPO',58),
(N'1886611',N'OPPO RENO10 PRO 5G',60000000,1,N'OPPO',48),
(N'1886621',N'OPPO A78',7000000,1,N'OPPO',38),
(N'1886672',N'SAMSUNG S21ULTRA',55000000,1,N'SAMSUNG',21),
(N'1886673',N'SAMSUNG GALAXY Z FILP 5G',25000000,1,N'SAMSUNG',22),
(N'1886674',N'SAMSUNG GALAXY Z FOLD4 5G',35000000,1,N'SAMSUNG',23),
(N'1886675',N'SAMSUNG GALAXY 522 ULTRA',20000000,1,N'SAMSUNG',24),
(N'1886676',N'SAMSUNG GALAXY A05S',5000000,1,N'SAMSUNG',25),
(N'1886677',N'SAMSUNG GALAXY M54 5G',10000000,1,N'SAMSUNG',26),
(N'1886687',N'REDMI POCO X3',5490000,1,N'REDMI',34),
(N'1886682',N'REDMI 12',6490000,1,N'REDMI',37),
(N'1886683',N'REDMI  NOTE 12',3490000,1,N'REDMI',30),
(N'1886684',N'REDMI POCO X5',6000000,1,N'REDMI',39),
(N'1886685',N'REDMI  A2',2190000,1,N'REDMI',30),
(N'1886686',N'REDMI 12C',2000000,1,N'REDMI',29),
(N'1886697',N'DELL VOSTRO',22000000,0,N'DELL',39),
(N'1886692',N'DELL INSPIRON',18000000,1,N'DELL',29),
(N'1886693',N'DELL VOSTRO 15',25000000,1,N'DELL',49),
(N'1886694',N'DELL GAMING G15',36000000,1,N'DELL',19),
(N'1886695',N'DELL XPS15',70000000,1,N'DELL',9),
(N'1886696',N'DELL XPS13',60000000,1,N'DELL',9),
(N'1886617',N'ASUS TUF GAMING',12000000,1,N'ASUS',20),
(N'1886612',N'ASUS TUF F15',15000000,1,N'ASUS',21),
(N'1886613',N'ASUS TUF F17',20000000,1,N'ASUS',19),
(N'1886614',N'ASUS TUF A15',28000000,1,N'ASUS',28),
(N'1886615',N'ASUS VIVOBOOK',9000000,1,N'ASUS',20),
(N'1886616',N'ASUS ZENBOOK 14 FLIP',24000000,1,N'ASUS',16),
(N'1886627',N'ACER NITRO 5',25000000,1,N'ACER',22),
(N'1886622',N'ACER ASPIRE 7',20000000,1,N'ACER',12),
(N'1886623',N'ACER ASPIRE 3',10000000,1,N'ACER',26),
(N'1886624',N'ACER ASPIRE 5',12000000,1,N'ACER',24),
(N'1886625',N'ACER TRAVEMATE P4',15000000,1,N'ACER',22),
(N'1886626',N'ACER GAMING NITRO 5',25000000,1,N'ACER',27),
(N'1886667',N'MSI GAMING',24000000,1,N'MSI',23),
(N'1886117',N'MSI GAMING GF63',14000000,1,N'MSI',19),
(N'1886127',N'MSI GAMING BRAVO 15',26000000,1,N'MSI',28),
(N'1886137',N'MSI GAMING KATANA',16000000,1,N'MSI',25),
(N'1886147',N'MSI MODERN 15',34000000,1,N'MSI',22),
(N'1886157',N'MSI MODERN 13',23000000,1,N'MSI',29),
(N'1886668',N'IPHON 15PRO MAX 1T',47600000,1,N'IPHON',32),
(N'1886328',N'IPHON 14PRO MAX 1T',42600000,1,N'IPHON',21),
(N'1886338',N'IPHON 13PRO MAX ',17600000,1,N'IPHON',22),
(N'1886348',N'IPHON 12PRO MAX ',16600000,1,N'IPHON',33),
(N'1886358',N'IPHON 11PRO MAX 1T',15600000,1,N'IPHON',18),
(N'1886368',N'IPHON 10PRO MAX 1T',11600000,1,N'IPHON',28)
GO
INSERT INTO LOAISP (LOAISP,TRANGTHAI) VALUES
(N'OPPO',1),
(N'SAMSUNG',0),
(N'REDMI',1),
(N'DELL',0),
(N'ASUS',1),
(N'ACER',0),
(N'MSI',1),
(N'IPHON',0)
GO
SELECT * FROM NHANVIEN
SELECT * FROM KHACHHANG
SELECT * FROM VOUCHERCT
SELECT * FROM HOADON
SELECT * FROM HOADONCHITIET
SELECT * FROM SANPHAM
SELECT * FROM LOAISP

Select MASP,TENSP,GIA,LOAISP,SOLUONG from  SANPHAM where LOAISP like ?