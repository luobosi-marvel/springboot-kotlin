# 用户表
CREATE TABLE `account` (
  `id` BIGINT(19) NOT NULL COMMENT '主键id',
  `username` VARCHAR(30) NOT NULL COMMENT '用户名',
  `mobile` VARCHAR(11) NOT NULL COMMENT '手机号',
  `password` VARCHAR(32) COMMENT '密码',
  `mailbox` VARCHAR(30) COMMENT '邮箱',
  `real_name` VARCHAR(30) COMMENT '真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '用户表';

