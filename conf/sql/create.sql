SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `name` varchar(120) default NULL,
  `contactway` varchar(255) default '',
  `username` varchar(48) default '',
  `password` varchar(48) default '',
  `enabled` tinyint(1) default '0' COMMENT '1 for YES or 0 for NO',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
ALTER TABLE `system_user` ADD INDEX  system_user_index_name(`name`);
INSERT INTO `system_user` VALUES (1, '2015-07-01 00:00:00', '系统管理员', '', 'hbyladmin', 'hbyl123456', 1);


SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `ad_update_file`;
CREATE TABLE `ad_update_file` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `upload_filename` varchar(240) default '',
  `actual_filename` varchar(12) default '',
  `upload_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `open_advertisement`;
CREATE TABLE `open_advertisement` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `sequence` int(11) NOT NULL,
  `advertisememt_title` varchar(120) default NULL,
  `ad_update_file_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`ad_update_file_id`) REFERENCES ad_update_file (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS=1;