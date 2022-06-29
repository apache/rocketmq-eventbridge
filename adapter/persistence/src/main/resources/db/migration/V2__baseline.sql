CREATE TABLE IF NOT EXISTS `event_connection` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) NOT NULL COMMENT 'event_connection account id',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '名称',
  `authorization_type` varchar(128) NOT NULL DEFAULT '' COMMENT '授权类型',
  `auth_parameters` text NOT NULL COMMENT '',
  `network_type` varchar(128) NOT NULL DEFAULT '' COMMENT '网络类型',
  `network_parameters` text DEFAULT NULL COMMENT '网络配置',
  `description` varchar(255) DEFAULT NULL COMMENT 'a description about the event_connection',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='event connection meta'
;


CREATE TABLE IF NOT EXISTS `event_api_destination` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) NOT NULL COMMENT 'event_api_destination account id',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '名称',
  `protocol` varchar(128) NOT NULL DEFAULT '' COMMENT '类型',
  `api_params` text NOT NULL COMMENT 'API 参数',
  `connection_name` varchar(128) DEFAULT NULL COMMENT '连接信息',
  `invocation_rate_limit_per_second` int(11) COMMENT '每秒推送速率',
  `description` varchar(255) DEFAULT NULL COMMENT 'a description about the event_api_destination',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='event api destination meta'
;
