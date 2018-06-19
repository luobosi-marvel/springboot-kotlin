create database estore_db;

use estore_db;

drop table if exists `user`;
create table `user` (
  `id` int(11) not null auto_increment comment '用户ID',
  `username` varchar(32) default null comment '用户名',
  `password` char(32) default null comment '密码',
  `nickname` varchar(10) default null comment '昵称',
  `email` varchar(50) default null comment '邮箱',
  `code` char(32) default null comment '邮箱激活码',
  `status` int(11) default null comment '激活状态，1：已激活，0：未激活',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='用户表';

drop table if exists `category`;

create table `category` (
  `cid` int(11) not null auto_increment comment '分类ID',
  `cname` varchar(20) default null comment '分类名称',
  primary key (`cid`)
) engine=innodb auto_increment=7 default charset=utf8;

insert  into `category`(`cid`,`cname`) values (1,'手机数码'),(2,'电脑办公'),(3,'家用电器'),(4,'美妆个护'),(5,'技术丛书'),(6,'鞋包服饰');



drop table if exists `product`;
create table `product` (
  `pid` int(11) not null auto_increment comment '商品ID',
  `cid` int(11) default null comment '分类ID',
  `pname` varchar(50) default null comment '商品名称',
  `marketprice` double(10,2) default null comment '市场价',
  `estoreprice` double(10,2) default null comment '商城价',
  `num` int(11) default null comment '库存数量',
  `imgurl` varchar(500) default null comment '图片路径',
  `ishot` int(11) default null comment '是否热卖，1：热卖 0：非热卖',
  `status` int(11) default null comment '上架状态：1：上架 0：下架',
  `createtime` datetime default null comment '创建时间',
  `description` varchar(500) default null comment '商品描述',
  primary key (`pid`),
  key `cid` (`cid`),
  constraint `product_ibfk_1` foreign key (`cid`) references `category` (`cid`)
) engine=innodb auto_increment=52 default charset=utf8 comment='商品表';

insert  into `product`(`pid`,`cid`,`pname`,`marketprice`,`estoreprice`,`num`,`imgurl`,`ishot`,`status`,`createtime`,`description`) values (1,1,'小米 M1',555.00,500.00,999,'images/product/c_0001.jpg',0,1,'2015-11-02 00:00:00','2GB内存+8GB容量！双卡双待,4核 1.6GHz 处理器！'),(2,1,'中兴 AXON',2899.00,2699.00,999,'images/product/c_0002.jpg',1,1,'2015-11-05 00:00:00','中兴 AXON 天机 mini 压力屏版 B2015 华尔金 移动联通电信4G 双卡双待'),(3,1,'华为荣耀6',1599.00,1499.00,999,'images/product/c_0003.jpg',0,1,'2015-11-02 00:00:00','荣耀 6 (H60-L01) 3GB内存标准版 黑色 移动4G手机'),(4,1,'联想 P1',2199.00,1999.00,999,'images/product/c_0004.jpg',0,1,'2015-11-02 00:00:00','联想 P1 16G 伯爵金 移动联通4G手机充电5分钟，通话3小时！科技源于超越！品质源于沉淀！5000mAh大电池！高端商务佳配！'),(5,1,'摩托罗拉 moto x（x+1）',1799.00,1699.00,999,'images/product/c_0005.jpg',0,1,'2015-11-01 00:00:00','摩托罗拉 moto x（x+1）(XT1085) 32GB 天然竹 全网通4G手机11月11天！MOTO X震撼特惠来袭！1699元！带你玩转黑科技！天然材质，原生流畅系统！'),(6,1,'魅族 MX5 16GB 银黑色',1899.00,1799.00,999,'images/product/c_0006.jpg',0,1,'2015-11-02 00:00:00','魅族 MX5 16GB 银黑色 移动联通双4G手机 双卡双待送原厂钢化膜+保护壳+耳机！5.5英寸大屏幕，3G运行内存，2070万+500万像素摄像头！长期省才是真的省！'),(7,1,'三星 Galaxy On7',1499.00,1398.00,999,'images/product/c_0007.jpg',0,1,'2015-11-14 00:00:00','三星 Galaxy On7（G6000）昂小七 金色 全网通4G手机 双卡双待新品火爆抢购中！京东尊享千元良机！5.5英寸高清大屏！1300+500W像素！评价赢30元话费券！'),(8,1,'NUU NU5',1288.00,1190.00,999,'images/product/c_0008.jpg',0,1,'2015-11-02 00:00:00','NUU NU5 16GB 移动联通双4G智能手机 双卡双待 晒单有礼 晨光金香港品牌 2.5D弧度前后钢化玻璃 随机附赠手机套+钢化贴膜 晒单送移动电源+蓝牙耳机'),(9,1,'乐视（Letv）乐1pro（X800）',2399.00,2299.00,999,'images/product/c_0009.jpg',0,1,'2015-11-02 00:00:00','乐视（Letv）乐1pro（X800）64GB 金色 移动联通4G手机 双卡双待乐视生态UI+5.5英寸2K屏+高通8核处理器+4GB运行内存+64GB存储+1300万摄像头！'),(10,1,'华为 Ascend Mate7',2699.00,2599.00,999,'images/product/c_0010.jpg',1,1,'2015-11-02 00:00:00','华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！!选择下方“移动老用户4G飞享合约”，无需换号，还有话费每月返还！'),(11,1,'vivo X5M',1899.00,1799.00,999,'images/product/c_0011.jpg',0,1,'2015-11-02 00:00:00','vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV'),(12,1,'华为 麦芒4',2599.00,2499.00,999,'images/product/c_0012.jpg',1,1,'2015-11-02 00:00:00','华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖'),(13,1,'努比亚（nubia）My 布拉格',1899.00,1799.00,999,'images/product/c_0013.jpg',0,1,'2015-11-02 00:00:00','努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！'),(14,1,'vivo X5Pro',2399.00,2298.00,999,'images/product/c_0014.jpg',1,1,'2015-11-02 00:00:00','移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术'),(15,1,'Apple iPhone 6 (A1586)',4399.00,4288.00,999,'images/product/c_0015.jpg',1,1,'2015-11-02 00:00:00','Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！'),(16,1,'华为 HUAWEI Mate S 臻享版',4200.00,4087.00,999,'images/product/c_0016.jpg',0,1,'2015-11-03 00:00:00','华为 HUAWEI Mate S 臻享版 手机 极昼金 移动联通双4G(高配)满星评价即返30元话费啦；买就送电源+清水套+创意手机支架；优雅弧屏，mate7升级版'),(17,1,'索尼(SONY) E6533 Z3+',4099.00,3999.00,999,'images/product/c_0017.jpg',0,1,'2015-11-02 00:00:00','索尼(SONY) E6533 Z3+ 双卡双4G手机 防水防尘 涧湖绿索尼z3专业防水 2070万像素 移动联通双4G'),(18,1,'HTC One M9+',3599.00,3499.00,999,'images/product/c_0018.jpg',0,1,'2015-11-02 00:00:00','HTC One M9+（M9pw） 金银汇 移动联通双4G手机5.2英寸，8核CPU，指纹识别，UltraPixel超像素前置相机+2000万/200万后置双镜头相机！降价特卖，惊喜不断！'),(19,1,'小米 红米2A 增强版 白色',649.00,549.00,999,'images/product/c_0019.jpg',0,1,'2015-11-02 00:00:00','新增至2GB 内存+16GB容量！4G双卡双待，联芯 4 核 1.5GHz 处理器！'),(20,1,'HTC Desire 826d 32G 臻珠白',1599.00,1469.00,999,'images/product/c_0020.jpg',1,1,'2015-11-02 00:00:00','后置1300万+UltraPixel超像素前置摄像头+【双】前置扬声器+5.5英寸【1080p】大屏！'),(21,1,'魅族 魅蓝note2 16GB 白色',1099.00,999.00,999,'images/product/c_0021.jpg',0,1,'2015-11-02 00:00:00','现货速抢，抢完即止！5.5英寸1080P分辨率屏幕，64位八核1.3GHz处理器，1300万像素摄像头，双色温双闪光灯！'),(22,1,'三星 Galaxy S5 (G9008W) 闪耀白',2099.00,1999.00,999,'images/product/c_0022.jpg',1,1,'2015-11-02 00:00:00','5.1英寸全高清炫丽屏，2.5GHz四核处理器，1600万像素'),(23,1,'sonim XP7700 4G手机',1799.00,1699.00,999,'images/product/c_0023.jpg',1,1,'2015-11-09 00:00:00','三防智能手机 移动/联通双4G 安全 黑黄色 双4G美国军工IP69 30天长待机 3米防水防摔 北斗'),(24,1,'努比亚（nubia）Z9精英版 金色',3988.00,3888.00,999,'images/product/c_0024.jpg',1,1,'2015-11-02 00:00:00','移动联通电信4G手机 双卡双待真正的无边框！金色尊贵版！4GB+64GB大内存！'),(25,1,'Apple iPhone 6 Plus (A1524) 16GB 金色',5188.00,4988.00,999,'images/product/c_0025.jpg',0,1,'2015-11-02 00:00:00','Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力'),(26,1,'Apple iPhone 6s (A1700) 64G 玫瑰金色',6388.00,6088.00,999,'images/product/c_0026.jpg',0,1,'2015-11-02 00:00:00','Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力'),(27,1,'三星 Galaxy Note5（N9200）32G版',5588.00,5388.00,999,'images/product/c_0027.jpg',0,1,'2015-11-02 00:00:00','旗舰机型！5.7英寸大屏，4+32G内存！不一样的SPen更优化的浮窗指令！赠无线充电板！'),(28,1,'三星 Galaxy S6 Edge+（G9280）32G版 铂光金',5999.00,5888.00,999,'images/product/c_0028.jpg',0,1,'2015-11-02 00:00:00','赠移动电源+自拍杆+三星OTG金属U盘+无线充电器+透明保护壳'),(29,1,'LG G4（H818）陶瓷白 国际版',3018.00,2978.00,999,'images/product/c_0029.jpg',0,1,'2015-11-02 00:00:00','李敏镐代言，F1.8大光圈1600万后置摄像头，5.5英寸2K屏，3G+32G内存，LG年度旗舰机！'),(30,1,'微软(Microsoft) Lumia 640 LTE DS (RM-1113)',1099.00,999.00,999,'images/product/c_0030.jpg',0,1,'2015-11-02 00:00:00','微软首款双网双卡双4G手机，5.0英寸高清大屏，双网双卡双4G！'),(31,2,'宏碁（acer）ATC705-N50 台式电脑',2399.00,2299.00,999,'images/product/c_0031.jpg',0,1,'2015-11-02 00:00:00','爆款直降，满千减百，品质宏碁，特惠来袭，何必苦等11.11，早买早便宜！'),(32,2,'Apple MacBook Air MJVE2CH/A 13.3英寸',6788.00,6688.00,999,'images/product/c_0032.jpg',0,1,'2015-11-02 00:00:00','宽屏笔记本电脑 128GB 闪存'),(33,2,'联想（ThinkPad） 轻薄系列E450C(20EH0001CD)',4399.00,4199.00,999,'images/product/c_0033.jpg',0,1,'2015-11-02 00:00:00','联想（ThinkPad） 轻薄系列E450C(20EH0001CD)14英寸笔记本电脑(i5-4210U 4G 500G 2G独显 Win8.1)'),(34,2,'联想（Lenovo）小新V3000经典版',4599.00,4499.00,999,'images/product/c_0034.jpg',0,1,'2015-11-02 00:00:00','14英寸超薄笔记本电脑（i7-5500U 4G 500G+8G SSHD 2G独显 全高清屏）黑色满1000減100，狂减！火力全开，横扫3天！'),(35,2,'华硕（ASUS）经典系列R557LI',3799.00,3699.00,999,'images/product/c_0035.jpg',0,1,'2015-11-02 00:00:00','15.6英寸笔记本电脑（i5-5200U 4G 7200转500G 2G独显 D刻 蓝牙 Win8.1 黑色）'),(36,2,'华硕（ASUS）X450J',4599.00,4399.00,999,'images/product/c_0036.jpg',0,1,'2015-11-02 00:00:00','14英寸笔记本电脑 （i5-4200H 4G 1TB GT940M 2G独显 蓝牙4.0 D刻 Win8.1 黑色）'),(37,2,'戴尔（DELL）灵越 飞匣3000系列',3399.00,3299.00,999,'images/product/c_0037.jpg',0,1,'2015-11-03 00:00:00',' Ins14C-4528B 14英寸笔记本（i5-5200U 4G 500G GT820M 2G独显 Win8）黑'),(38,2,'惠普(HP)WASD 暗影精灵',5699.00,5499.00,999,'images/product/c_0038.jpg',0,1,'2015-11-02 00:00:00','15.6英寸游戏笔记本电脑(i5-6300HQ 4G 1TB+128G SSD GTX950M 4G独显 Win10)'),(39,2,'Apple 配备 Retina 显示屏的 MacBook',11299.00,10288.00,999,'images/product/c_0039.jpg',0,1,'2015-11-02 00:00:00','Pro MF840CH/A 13.3英寸宽屏笔记本电脑 256GB 闪存'),(40,2,'机械革命（MECHREVO）MR X6S-M',6799.00,6599.00,999,'images/product/c_0040.jpg',0,1,'2015-11-02 00:00:00','15.6英寸游戏本(I7-4710MQ 8G 64GSSD+1T GTX960M 2G独显 IPS屏 WIN7)黑色'),(41,2,'神舟（HASEE） 战神K660D-i7D2',5699.00,5499.00,999,'images/product/c_0041.jpg',0,1,'2015-11-02 00:00:00','15.6英寸游戏本(i7-4710MQ 8G 1TB GTX960M 2G独显 1080P)黑色'),(42,2,'微星（MSI）GE62 2QC-264XCN',6199.00,5999.00,999,'images/product/c_0042.jpg',0,1,'2015-11-02 00:00:00','15.6英寸游戏笔记本电脑（i5-4210H 8G 1T GTX960MG DDR5 2G 背光键盘）黑色'),(43,2,'雷神（ThundeRobot）G150S',5699.00,5499.00,999,'images/product/c_0043.jpg',0,1,'2015-11-02 00:00:00','15.6英寸游戏本 ( i7-4710MQ 4G 500G GTX950M 2G独显 包无亮点全高清屏) 金'),(44,2,'惠普（HP）轻薄系列 HP',3199.00,3099.00,999,'images/product/c_0044.jpg',0,1,'2015-11-02 00:00:00','15-r239TX 15.6英寸笔记本电脑（i5-5200U 4G 500G GT820M 2G独显 win8.1）金属灰'),(45,2,'未来人类（Terrans Force）T5',10999.00,9899.00,999,'images/product/c_0045.jpg',0,1,'2015-11-02 00:00:00','15.6英寸游戏本（i7-5700HQ 16G 120G固态+1TB GTX970M 3G GDDR5独显）黑'),(46,2,'戴尔（DELL）Vostro 3800-R6308 台式电脑',3299.00,3199.00,999,'images/product/c_0046.jpg',0,1,'2015-11-02 00:00:00','（i3-4170 4G 500G DVD 三年上门服务 Win7）黑'),(47,2,'联想（Lenovo）H3050 台式电脑',5099.00,4899.00,999,'images/product/c_0047.jpg',0,1,'2015-11-11 00:00:00','（i5-4460 4G 500G GT720 1G独显 DVD 千兆网卡 Win10）23英寸'),(48,2,'Apple iPad mini 2 ME279CH/A',2088.00,1888.00,999,'images/product/c_0048.jpg',0,1,'2015-11-02 00:00:00','（配备 Retina 显示屏 7.9英寸 16G WLAN 机型 银色）'),(49,2,'小米（MI）7.9英寸平板',1399.00,1299.00,999,'images/product/c_0049.jpg',0,1,'2015-11-02 00:00:00','WIFI 64GB（NVIDIA Tegra K1 2.2GHz 2G 64G 2048*1536视网膜屏 800W）白色'),(50,2,'Apple iPad Air 2 MGLW2CH/A',2399.00,2299.00,999,'images/product/c_0050.jpg',0,1,'2015-11-12 00:00:00','（9.7英寸 16G WLAN 机型 银色）');

drop table if exists `cart`;
create table `cart` (
  `uid` int(11) not null comment '用户ID',
  `pid` int(11) not null comment '商品ID',
  `buynum` int(11) default null comment '商品购买数量',
  primary key (`uid`,`pid`),
  key `FK_Reference_2` (`pid`),
  constraint `FK_Reference_1` foreign key (`uid`) references `user` (`id`),
  constraint `FK_Reference_2` foreign key (`pid`) references `product` (`pid`)
) engine=innodb default charset=utf8 comment='购物车表';

drop table if exists `orders`;
create table `orders` (
  `id` char(32) not null comment '订单ID',
  `uid` int(11) default null comment '用户ID',
  `totalprice` double(10,2) default null comment '订单总金额',
  `address` varchar(200) default null comment '收货地址，包括收货人信息',
  `status` int(11) default null comment '1：待付款，2：已付款3：已过期',
  `createtime` datetime default null comment '创建时间',
  primary key (`id`),
  key `FK_Reference_3` (`uid`),
  constraint `FK_Reference_3` foreign key (`uid`) references `user` (`id`)
) engine=innodb default charset=utf8 comment='订单表';


drop table if exists `orderitem`;
create table `orderitem` (
  `oid` char(32) not null comment '订单ID',
  `pid` int(11) not null comment '商品ID',
  `buynum` int(11) default null comment '购买数量',
  primary key (`oid`,`pid`),
  key `FK_Reference_4` (`pid`),
  constraint `FK_Reference_4` foreign key (`pid`) references `product` (`pid`),
  constraint `FK_Reference_5` foreign key (`oid`) references `orders` (`id`)
) engine=innodb default charset=utf8 comment='订单明细表';








