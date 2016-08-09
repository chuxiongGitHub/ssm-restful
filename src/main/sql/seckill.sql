--存储过程
delimiter $$  --console;转化为$$
--in：输入参数 out:输出参数
--row_count();返回上一条修改类型的SQL（delete,insert,update）的影响行数
--row_count();0:未修改数据；>0表示修改的行数；<0 sql错误或者是未执行
CREATE PROCEDURE 'seckill'.'execute_seckill'
(in v_seckill_id bigint,int v_phone bigint,
in v_kill_time timestamp,out r_result int)
BEGIN
DECLARE insert_count int DEFAULT 0;
start TRANSACTION ;
INSERT ignore into success_killed(seckill_id,user_phone,create_time)
VALUES (v_seckill_id,v_phone,v_kill_time);
SELECT  ROW_COUNT INTO insert_count;
  (insert_count=0) THEN
ROLLBACK ;
set r_result=-1;
IF(insert_count=0) THEN
ROLLBACK;
SET r_result=-1;
ELSEIF(insert_count<0) THEN
ROLLBACK;
SET r_result=-2;
ELSE
UPDATE seckill SET number=number-1
where seckill_id=v_seckill_id
and end_time >v_kill_time
and start_time <v_kill_time
and number>0;
SELECT  ROW_COUNT INTO insert_count;
IF(insert_count=0) THEN
ROLLBACK;
set r_result=0;
ELSEIF(insert_count<0) THEN
ROLLBACK;
set r_result=-2;
ELSE
COMMIT;
set r_result=1;
END IF;
end BEGIN;
$$
--存储过程结束
delimiter;
SET @r_result=-3;
--执行存储过程
call execute_seckill(1003,13698740791,now(),@r_result);
SELECT @r_result;

