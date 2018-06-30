
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL COMMENT 'UNKNOW-0, MALE-1, FEMALE-2, SECRET-3',
  `registry_type` int(11) DEFAULT NULL COMMENT 'QQ(101), WEIBO(102),WEIXIN(103),PHONE(104)',
  `status` char(1) DEFAULT NULL COMMENT 'LOCKED("L"), ENABLE("E"), DISABLE("D")',
  `player_grade` varchar(10) DEFAULT NULL COMMENT 'IRON("1001", "玄铁"), BRONZE("1002", "青铜"), SILVER("1003", "白银"), GOLD("1004", "黄金")',
  `register_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', 'tom', '1', '103', 'E', '1004', '1530326834041');
