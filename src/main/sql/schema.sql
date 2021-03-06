--数据库初始化脚本
--创建数据库
CREATE dataBase seckill;
--使用数据库
use seckill;
--创建秒杀库存表
CREATE TABLE seckill(
seckill_id bigint NOT  NULL Auto_increment comment '商品库存ID',
name VARCHAR(120) NOT  NULL comment '商品名称',
number int NOT NULL comment '库存数量',
start_time datetime NOT NULL comment '秒杀开始时间',
end_time datetime NOT NULL comment '秒杀结束时间',
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_ent_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB Auto_increment=1000 DEFAULT Charset=utf8 comment='秒杀库存表'
--初始化数据
INSERT  INTO seckill(name,number,start_time,end_time)
VALUES
('1000元秒杀华为p8',100,'2016-08-02 00:00:00','2016-08-08 00:00:00'),
('100元秒杀红米note2',100,'2016-08-02 00:00:00','2016-08-08 00:00:00'),
('200元秒杀红米3',10,'2016-08-02 00:00:00','2016-08-08 00:00:00'),
('80000元秒杀比亚迪s7',10,'2016-08-02 00:00:00','2016-08-08 00:00:00');
--秒杀成功明细表
--用户登录相关的认证信息
create table success_killed(
'seckill_id' bigint NOT NULL comment  '秒杀商品的ID',
'user_phone' bigint NOT NULL comment  '用户手机号码',
'status' tinyint NOT NULL DEFAULT -1 comment '状态表示：-1：无效，0：成功，1：已付款',
'create_time' TIMESTAMP NOT NULL comment '创建时间',
PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
key idx_create_time(create_time)
)ENGINE=InnoDB Auto_increment=1000 DEFAULT Charset=utf8 comment='秒杀成功明细表'
--用户信息表
create table user(
user_id int not null auto_increment COMMENT '用户id',
username varchar(100) not null COMMENT '用户名',
password VARCHAR(50) not null COMMENT '密码',
age int not null COMMENT '年龄',
createTime  TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY(user_id),
key idx_username(username)
)ENGINE=INNODB auto_increment=1 DEFAULT charset=utf8 COMMENT '用户表';
--链接数据库控台
