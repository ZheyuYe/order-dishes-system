-- 菜谱分类表
create table tb_type 
(
    type_id int auto_increment primary key,  -- 分类 id 
    type_name varchar(20) not null, -- 分类名称
    type_parent_id int -- 父分类 id 
);

-- 菜谱表
create table tb_menu
(
    menu_id int auto_increment primary key,  -- 菜谱 ID
    menu_name varchar(30) not null, -- 菜谱名称
    menu_introduce varchar(200), -- 菜谱介绍
    menu_address varchar(200), -- 菜谱产地
    menu_price double, -- 真实价格
    menu_cutprice double, -- 优惠后价格
    menu_discount double, -- 打折率
    menu_is_discount boolean, -- 是否打折
    menu_is_decommend boolean, -- 是否厨师推荐
    menu_is_order boolean, -- 是否可点
    menu_pic_url varchar(100), -- 图片路径(不是存图片)
    menu_order_count int, -- 点单次数
    menu_create_date varchar(30), -- 菜谱创建时间
    menu_status boolean, -- 菜谱状态
    sort_id int -- 菜系 id(外键)
);

-- 菜谱类型中间表
create table tb_menu_type(
    menu_type_id int auto_increment primary key,
    menu_id int, -- 菜谱 id(外键)
    type_id int  -- 类型 id(外键)
);


insert into tb_type (type_id,type_name,type_parent_id) values (1,'主食',null);
insert into tb_type (type_id,type_name,type_parent_id) values (2,'热菜',null);
insert into tb_type (type_id,type_name,type_parent_id) values (3,'凉菜',null);
insert into tb_type (type_id,type_name,type_parent_id) values (4,'汤羹',null);
insert into tb_type (type_id,type_name,type_parent_id) values (5,'小吃',null);
insert into tb_type (type_id,type_name,type_parent_id) values (6,'饮品',null);


insert into tb_menu values (1,'红烧肉',
'是热菜菜谱之一。以五花肉为制作主料，最好选用肥瘦相间的三层肉来做。红烧肉的烹饪技巧以砂锅为主，肥瘦相间，香甜松软，入口即化。红烧肉在我国各地流传甚广，是一道著名的大众菜肴。',
null,40,32,0.8,true,true,true,'menu01.jpg',20,'2017-6-19',true,null);

insert into tb_menu values (2,'腐竹焖肉',
'是热菜菜谱之一。以五花肉为制作主料，最好选用肥瘦相间的三层肉来做。红烧肉的烹饪技巧以砂锅为主，肥瘦相间，香甜松软，入口即化。红烧肉在我国各地流传甚广，是一道著名的大众菜肴。',
null,26,26,1,false,true,true,'menu02.jpg',20,'2017-6-19',true,null);

insert into tb_menu values (3,'双椒回锅肉',
'是热菜菜谱之一。以五花肉为制作主料，最好选用肥瘦相间的三层肉来做。红烧肉的烹饪技巧以砂锅为主，肥瘦相间，香甜松软，入口即化。红烧肉在我国各地流传甚广，是一道著名的大众菜肴。',
null,30,21,0.7,true,true,true,'menu03.jpg',20,'2017-6-19',true,null);

insert into tb_menu values (4,'水煮肉片',
'是热菜菜谱之一。以五花肉为制作主料，最好选用肥瘦相间的三层肉来做。红烧肉的烹饪技巧以砂锅为主，肥瘦相间，香甜松软，入口即化。红烧肉在我国各地流传甚广，是一道著名的大众菜肴。',
null,30,30,1,false,true,true,'menu04.jpg',20,'2017-6-19',true,null);

insert into tb_menu values (5,'三明治',
'原料：起司、火腿肠、生菜、胡萝卜、紫甘蓝、熟鸡蛋、沙拉。',
null,10,10,1,false,true,true,'menu05.jpg',100,'2017-5-19',true,null);

insert into tb_menu values (6,'粗粮多馅包（豆浆余渣变身秀）',
'原料：面粉、肉馅、白菜、香菇、虾仁、鸡蛋、豆浆余渣、葱、盐、姜、酱油、胡椒粉、香油、菜籽油、水、酵母。',
null,8,8,1,false,true,true,'menu06.jpg',300,'2017-5-19',true,null);

insert into tb_menu values (7,'缤纷水果木瓜船糯米饭',
'原料：木瓜、苹果、小台芒、梨子、糯米、银耳、冰糖、枇杷膏、枸杞',
null,10,10,1,false,true,true,'menu07.jpg',100,'2017-5-19',true,null);

insert into tb_menu values (8,'海带排骨汤',
'原料：排骨、生姜、牛肉丸、海带、料酒',
null,8,8,1,false,true,true,'menu08.jpg',100,'2017-5-19',true,null);

insert into tb_menu values (9,'肉末鸡蛋蒸豆腐',
'原料：內脂豆腐、鸡蛋、肉末、盐、料酒、鸡粉、姜末、辣椒酱、食用油、葱花',
null,20,16,0.8,true,true,true,'menu09.jpg',80,'2017-5-19',true,null);

insert into tb_menu values (10,'红萝卜玉米猪骨汤',
'原料：姜、猪大骨、红萝卜、玉米、清水、食盐。',
null,10,10,1,false,true,true,'menu10.jpg',100,'2017-5-19',true,null);

-- 中间表
insert into tb_menu_type(menu_id,type_id) values (1,2);
insert into tb_menu_type(menu_id,type_id) values (2,2);
insert into tb_menu_type(menu_id,type_id) values (3,2);
insert into tb_menu_type(menu_id,type_id) values (4,2);
insert into tb_menu_type(menu_id,type_id) values (5,2);
insert into tb_menu_type(menu_id,type_id) values (6,1);
insert into tb_menu_type(menu_id,type_id) values (7,1);
insert into tb_menu_type(menu_id,type_id) values (8,4);
insert into tb_menu_type(menu_id,type_id) values (9,4);
insert into tb_menu_type(menu_id,type_id) values (10,4);


select distinct tb_menu.menu_name from tb_menu,tb_menu_type
where tb_menu.menu_id = tb_menu_type.menu_id
and tb_menu_type.type_id = 2;