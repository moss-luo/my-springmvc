CREATE TABLE persons(
  id INTEGER IDENTITY PRIMARY KEY,
  name CHAR(25)  COMMENT '姓名',
  hometown CHAR(255)  COMMENT '家乡',
  curr_address CHAR(255)  COMMENT '当前居住地',
  company_name CHAR(255)  COMMENT '公司名称',
  card_id CHAR(25)  COMMENT '门禁卡id',
  identity_card_num CHAR(25)  COMMENT '身份证',
  phone CHAR(25)  COMMENT '电话号码',
  guarantee_id INTEGER  COMMENT '父母（保证人）id号',
  is_native INTEGER  COMMENT '是否为本地人',
  remarks CHAR(255)  COMMENT '备注',
  hourse_id INTEGER  COMMENT '房屋Id',
  age INTEGER  COMMENT '年龄',
  sex INTEGER  COMMENT '性别'
);


