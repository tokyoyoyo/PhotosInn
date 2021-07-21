

CREATE TABLE `photosinn`.`Untitled`  (
  `uuid` varchar(50) NOT NULL COMMENT '图片的唯一标识',
  `owner` varchar(20) NULL COMMENT '上传者',
  `date` datetime NULL COMMENT '上传日期',
  `path` varchar(255) NULL COMMENT '存储路径',
  `name` varchar(255) NULL COMMENT '图片名称',
  `size` double NULL COMMENT '图片大小',
  PRIMARY KEY (`uuid`)
);