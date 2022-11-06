CREATE TABLE users
(
    `id`        INT AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(45) NOT NULL,
    password    VARCHAR(45) NOT NULL,
    email       VARCHAR(255),
    phone       VARCHAR(255),
    description VARCHAR(255),
    address     VARCHAR(255)
);

CREATE TABLE roles
(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE user_role
(
    `user_id` INT,
    `role_id` INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);


CREATE TABLE tblNguyenLieu
(
    `id`                INT AUTO_INCREMENT PRIMARY KEY,
    `ten`               VARCHAR(255) NOT NULL,
    `ten_hang_san_xuat` VARCHAR(255) NOT NULL,
    `mo_ta`             VARCHAR(255),
    `created_date`      DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3),
    `updated_date`      DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3),
    `created_by`        VARCHAR(100),
    `last_modified_by`  VARCHAR(100),
    `user_id`           INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE tblNhaCungCap
(
    `id`      INT AUTO_INCREMENT PRIMARY KEY,
    `ten`     VARCHAR(255) NOT NULL,
    `mo_ta`   VARCHAR(255),
    `dia_chi` VARCHAR(255),
    `user_id` INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE tblLanNhap
(
    `id`               INT AUTO_INCREMENT PRIMARY KEY,
    `mo_ta`            VARCHAR(255),
    `created_date`     DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3),
    `updated_date`     DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3),
    `created_by`       VARCHAR(100),
    `last_modified_by` VARCHAR(100),
    `user_id`          INT,
    `tbl_nha_cung_cap_id`  INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (tbl_nha_cung_cap_id) REFERENCES tblNhaCungCap (id)
);

CREATE TABLE tblNguyenLieuTrongLanNhap
(
    `id`              INT AUTO_INCREMENT PRIMARY KEY,
    `so_luong`        INT    NOT NULL,
    `don_gia`         double NOT NULL,
    `han_su_dung`     VARCHAR(10),
    `xuat_su`         VARCHAR(255),
    `tbl_nguyen_lieu_id` INT,
    `tbl_lan_nhap_id`    INT,
    FOREIGN KEY (tbl_nguyen_lieu_id) REFERENCES tblNguyenLieu (id),
    FOREIGN KEY (tbl_lan_nhap_id) REFERENCES tblLanNhap (id)
);



