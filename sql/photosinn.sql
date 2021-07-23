

drop table if exists `photo`;

CREATE TABLE `photosinn`.`photo`  (
  `uuid` int(0) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `owner` varchar(255) NOT NULL COMMENT '上传者',
  `date` datetime NOT NULL COMMENT '上传日期',
  `path` varchar(255) NOT NULL COMMENT '存储路径',
  `name` varchar(255) NULL COMMENT '图片名称',
  PRIMARY KEY (`uuid`)
);