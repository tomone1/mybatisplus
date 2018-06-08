/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : config

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-08 19:14:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for crm_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `crm_sys_menu`;
CREATE TABLE `crm_sys_menu` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `p_id` int(11) DEFAULT '0',
  `href` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT '1',
  `description` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `create_date` char(8) DEFAULT NULL,
  `create_time` char(6) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `update_date` char(8) DEFAULT NULL,
  `update_time` char(6) DEFAULT NULL,
  `version` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for temp_id
-- ----------------------------
DROP TABLE IF EXISTS `temp_id`;
CREATE TABLE `temp_id` (
  `id` varchar(40) NOT NULL COMMENT 'id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgj_api_sys_params
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_api_sys_params`;
CREATE TABLE `wdgj_api_sys_params` (
  `appkey` varchar(16) NOT NULL COMMENT '创建应用接入时申请的appkey',
  `format` varchar(4) NOT NULL COMMENT '数据返回值格式xml/json（默认xml）',
  `versions` varchar(4) NOT NULL COMMENT '协议版本号（1.1）',
  `appsecret` varchar(40) NOT NULL COMMENT '由管家后台审核应用生成，在应用详情查看，签名秘钥用于生成Sign',
  `method` varchar(40) DEFAULT NULL,
  `status` varchar(2) DEFAULT '0' COMMENT '0 订单执行完成(已经进member表了) 1 订单执行中  '
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网店api系统参数表';

-- ----------------------------
-- Table structure for wdgj_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_customer_info`;
CREATE TABLE `wdgj_customer_info` (
  `id` int(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tradenick` varchar(100) NOT NULL COMMENT '网名/id(旺旺)',
  `sndto` varchar(50) DEFAULT NULL COMMENT '姓名',
  `tel` varchar(1000) DEFAULT NULL COMMENT '电话',
  `province` varchar(20) DEFAULT NULL COMMENT '州省',
  `city` varchar(50) DEFAULT NULL COMMENT '区市',
  `town` varchar(40) DEFAULT NULL COMMENT '区县',
  `adr` varchar(120) DEFAULT NULL COMMENT '地址',
  `zip` varchar(10) DEFAULT NULL COMMENT '邮编',
  `buynum` int(11) DEFAULT '0' COMMENT '购物次数',
  `sumAmount` int(11) DEFAULT NULL COMMENT '购物金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1671501 DEFAULT CHARSET=utf8 COMMENT='网店管家客户信息';

-- ----------------------------
-- Table structure for wdgj_customer_info_temp
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_customer_info_temp`;
CREATE TABLE `wdgj_customer_info_temp` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `shopid` varchar(40) NOT NULL COMMENT '店铺id',
  `trade_no` varchar(400) NOT NULL COMMENT '订单编号（店铺订单）',
  `tradeno2` varchar(400) DEFAULT NULL COMMENT '原始单号(淘宝订单)',
  `tradestatus` varchar(40) NOT NULL COMMENT '订单状态0 被取消 1 等待单 2 待审核 3 预订单 4 待结算 5 打单出库 6 生产等待 7 待发货 8 发货在途 9 代销发货 10 委外发货 11 已完成',
  `sndto` varchar(40) NOT NULL COMMENT '收货人',
  `province` varchar(40) NOT NULL COMMENT '（收货人）州省',
  `city` varchar(40) NOT NULL COMMENT '（收货人）区市',
  `town` varchar(40) NOT NULL COMMENT '（收货人）区县',
  `adr` varchar(120) NOT NULL COMMENT '（收货人）地址',
  `tel` varchar(100) DEFAULT NULL COMMENT '（收货人）电话',
  `remark` varchar(1000) DEFAULT NULL COMMENT '客服备注',
  `logisticlistno` varchar(40) DEFAULT NULL COMMENT '物流单号',
  `logisticname` varchar(40) DEFAULT NULL COMMENT '物流方式(快递公司)',
  `tradetime` varchar(40) NOT NULL COMMENT '订单交易时间',
  `shopname` varchar(255) DEFAULT NULL,
  `goodstotal` varchar(255) DEFAULT NULL COMMENT '贷款合计',
  `tradenick` varchar(255) DEFAULT NULL COMMENT '网名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgj_page_log
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_page_log`;
CREATE TABLE `wdgj_page_log` (
  `method` varchar(40) NOT NULL COMMENT '相关的业务接口名称编码',
  `pageno` int(11) DEFAULT NULL COMMENT '页码',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `begintime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `searchtype` char(2) DEFAULT NULL,
  `project_code` varchar(25) DEFAULT NULL COMMENT '工程代码',
  `project_name` varchar(25) DEFAULT NULL COMMENT '工程名',
  `accesstoken` varchar(64) DEFAULT NULL COMMENT 'Apptoken',
  `shopIds` varchar(255) DEFAULT NULL COMMENT '对应的店铺id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页数记录信息';

-- ----------------------------
-- Table structure for wdgj_trade_error_log
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_trade_error_log`;
CREATE TABLE `wdgj_trade_error_log` (
  `project_name` varchar(50) DEFAULT NULL COMMENT '工程名',
  `searchtype` char(2) DEFAULT NULL,
  `pageNo` varchar(20) DEFAULT NULL COMMENT '页码',
  `error_info` varchar(255) DEFAULT '' COMMENT '错误信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgj_trade_info
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_trade_info`;
CREATE TABLE `wdgj_trade_info` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `shopid` varchar(40) NOT NULL COMMENT '店铺id',
  `trade_no` varchar(400) NOT NULL COMMENT '订单编号（店铺订单）',
  `tradeno2` varchar(400) DEFAULT NULL COMMENT '原始单号(淘宝订单)',
  `tradestatus` varchar(40) NOT NULL COMMENT '订单状态0 被取消 1 等待单 2 待审核 3 预订单 4 待结算 5 打单出库 6 生产等待 7 待发货 8 发货在途 9 代销发货 10 委外发货 11 已完成',
  `sndto` varchar(40) NOT NULL COMMENT '收货人',
  `province` varchar(40) NOT NULL COMMENT '（收货人）州省',
  `city` varchar(40) NOT NULL COMMENT '（收货人）区市',
  `town` varchar(40) NOT NULL COMMENT '（收货人）区县',
  `adr` varchar(120) NOT NULL COMMENT '（收货人）地址',
  `tel` varchar(100) DEFAULT NULL COMMENT '（收货人）电话',
  `remark` varchar(1000) DEFAULT NULL COMMENT '客服备注',
  `logisticlistno` varchar(40) DEFAULT NULL COMMENT '物流单号',
  `logisticname` varchar(40) DEFAULT NULL COMMENT '物流方式(快递公司)',
  `tradetime` varchar(40) NOT NULL COMMENT '订单交易时间',
  `shopname` varchar(255) DEFAULT NULL,
  `goodstotal` varchar(255) DEFAULT NULL COMMENT '贷款合计',
  `tradenick` varchar(255) DEFAULT NULL COMMENT '网名',
  `zip` varchar(255) DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网店管家交易信息';

-- ----------------------------
-- Table structure for wdgj_trade_info_temp
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_trade_info_temp`;
CREATE TABLE `wdgj_trade_info_temp` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `shopid` varchar(40) NOT NULL COMMENT '店铺id',
  `trade_no` varchar(400) NOT NULL COMMENT '订单编号（店铺订单）',
  `tradeno2` varchar(400) DEFAULT NULL COMMENT '原始单号(淘宝订单)',
  `tradestatus` varchar(40) NOT NULL COMMENT '订单状态0 被取消 1 等待单 2 待审核 3 预订单 4 待结算 5 打单出库 6 生产等待 7 待发货 8 发货在途 9 代销发货 10 委外发货 11 已完成',
  `sndto` varchar(40) NOT NULL COMMENT '收货人',
  `province` varchar(40) NOT NULL COMMENT '（收货人）州省',
  `city` varchar(40) NOT NULL COMMENT '（收货人）区市',
  `town` varchar(40) NOT NULL COMMENT '（收货人）区县',
  `adr` varchar(120) NOT NULL COMMENT '（收货人）地址',
  `tel` varchar(100) DEFAULT NULL COMMENT '（收货人）电话',
  `remark` varchar(1000) DEFAULT NULL COMMENT '客服备注',
  `logisticlistno` varchar(40) DEFAULT NULL COMMENT '物流单号',
  `logisticname` varchar(40) DEFAULT NULL COMMENT '物流方式(快递公司)',
  `tradetime` varchar(40) NOT NULL COMMENT '订单交易时间',
  `shopname` varchar(255) DEFAULT NULL,
  `goodstotal` varchar(255) DEFAULT NULL COMMENT '贷款合计',
  `tradenick` varchar(255) DEFAULT NULL COMMENT '网名',
  `zip` varchar(25) DEFAULT NULL COMMENT '邮编'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgj_trade_item_info
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_trade_item_info`;
CREATE TABLE `wdgj_trade_item_info` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `goodsno` varchar(40) NOT NULL COMMENT '货品编号',
  `goodsname` varchar(100) NOT NULL COMMENT '品名',
  `goodscount` varchar(40) NOT NULL COMMENT '数量',
  `price` varchar(40) NOT NULL COMMENT '价格',
  `goodsmoney` varchar(40) NOT NULL COMMENT '价格合计',
  `order_id` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网店管家交易详情信息';

-- ----------------------------
-- Table structure for wdgj_trade_item_info_temp
-- ----------------------------
DROP TABLE IF EXISTS `wdgj_trade_item_info_temp`;
CREATE TABLE `wdgj_trade_item_info_temp` (
  `id` varchar(40) NOT NULL COMMENT 'id',
  `goodsno` varchar(40) NOT NULL COMMENT '货品编号',
  `goodsname` varchar(100) NOT NULL COMMENT '品名',
  `goodscount` varchar(40) NOT NULL COMMENT '数量',
  `price` varchar(40) NOT NULL COMMENT '价格',
  `goodsmoney` varchar(40) NOT NULL COMMENT '价格合计',
  `order_id` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
