CREATE TABLE  IF NOT EXISTS `shenghui`(
`id` INT UNSIGNED AUTO_INCREMENT,
`shengming` CHAR(40) COMMENT '省名',
`huiming`  CHAR(40) COMMENT '会名',
`meishi` TEXT COMMENT '美食名',
`jingdian` TEXT COMMENT '景点名',
`gaoxiao` TEXT COMMENT '高校名',
PRIMARY KEY (`id`)	
);ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (1, '河北省', '石家庄', '赵州雪花梨/赵府酥鱼/宫面/', '赵州桥/清凉山/世纪公园/', '河北师范大学/石家庄学院/河北科技大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (2, '辽宁省', '沈阳', '锅包肉/羊肝羹/不老林/', '张氏帅府/太清宫/般若寺/', '东北大学/辽宁大学/沈阳大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (3, '黑龙江省', '哈尔滨', '冰糖葫芦/哈尔滨红肠/冻柿子/', '中央大街/龙塔/太阳岛风景名胜区/', '哈尔滨工业大学/哈尔滨工程大学/黑龙江大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (4, '浙江省', '杭州市', '东坡肉/小笼包/酒酿圆子/', '西湖/苏堤/苏东坡纪念馆/', '浙江大学/浙江工商大学/杭州电子科技大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (5, '福建省', '福州市', '鱼丸/荔枝肉/红烧肉/', '林则徐纪念馆/文庙/华林寺/', '福建工程学院/福建师范大学/福州大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (6, '山东省', '济南', '糖醋鲤鱼/坛子肉/油旋/', '九如山瀑布群风景区/趵突泉/大明湖/', '山东大学/山东师范大学/暨南大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (7, '广东省', '广州市', '双皮奶/钵仔糕/云吞面/', '广州塔/珠江/白云山/', '中山大学/华南理工大学/华南师范大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (8, '湖北省', '武汉', '热干面/武昌鱼/三鲜豆皮/', '黄鹤楼/中山公园/武汉长江大桥/', '武汉音乐学院/武汉理工大学/武汉大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (9, '四川省', '成都市', '串串香/麻婆豆腐/担担面/', '武侯祠/天台山/青城山/', '四川大学/西南交通大学/电子科技大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (10, '云南省', '昆明市', '过桥米线/小锅米线/玫瑰花饼/', '翠湖/昆明世博园/西山/', '昆明医科大学/云南泛亚学院/昆明大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (11, '甘肃省', '兰州市', '手抓羊肉/牛肉面/擀面皮/', '黄河母亲/中山桥/白塔山/', '兰州大学/西北师范大学/西北民族大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (12, '台湾省', '台北', '小笼包/卤肉饭/珍珠奶茶/', '国父纪念馆/台北故宫博物院/台北101/', '台湾大学/台湾交通大学/国立台湾大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (13, '广西壮族自治区', '南宁', '肠粉/老友粉/肉粽/', '青秀山/南宁大桥/芦圩古镇/', '广西大学/广西民族大学/广西医科大学/ ');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (14, '宁夏回族自治区', '银川', '酿皮/油香/清蒸羊肉糕/', '水洞沟/沙湖/西夏王陵/', '北方民族大学/宁夏大学/宁夏医科大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (15, '山西省', '太远', '羊杂割/六味斋肉/锅灰/', '晋祠/蒙山大佛/龙山石窟/', '山西财经大学/太原科技大学/太原理工大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (16, '吉林省', '长春', '雪衣豆沙/打糕/酱骨头/', '般若寺/南湖公园/净月潭/', '吉林大学/东北师范大学/吉林体育学院/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (17, '江苏省', '南京市', '鸭血粉丝汤/口味虾/梅花糕/', '秦淮河/鼓楼/中山陵/', '南京大学/东南大学/南京航空航天大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (18, '安徽省', '合肥市', '曹操鸡/三河米饺/麻饼/', '包公祠/渡江战役纪念馆/巢湖', '中山科学技术大学/合肥学院/合肥工业大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (19, '江西省', '南昌市', '南昌米粉/瓦罐汤/藜蒿炒腊肉/', '潘阳湖/滕王阁/南昌之星/', '南昌大学/江西财经大学/江西科技师范大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (20, '河南省', '郑州市', '胡辣汤/烩面/羊肉汤/', '少林寺/中原福塔/蒿山/', '河南大学/河南财经政法大学/河南工业大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (21, '湖南省', '长沙市', '辣椒炒肉/糖油粑粑/长沙臭豆腐/', '岳麓山/橘子洲/湘江', '中南大学/湖南大学/国防科学技术大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (22, '海南省', '海口', '清补凉/椰子饭/海南粉/', '苏公祠/五公祠/琼山区/', '海南大学/海南师范大学/海口经济学院/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (23, '贵州省', '贵州市', '丝娃娃/酸汤鱼/米豆腐/', '青岩古镇/甲秀楼/南江大峡谷/', '贵州大学/贵州师范大学/贵州财经大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (24, '陕西省', '西安市', '锅盔/臊子面/腊汁肉夹馍/', '大雁塔/西安城墙/陕西历史博物馆/', '西安交通大学/长安大学/西安邮电大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (25, '青海省', '南宁市', '酸奶/酿皮/油茶/', '南禅寺/塔尔寺/小峡/', '青海大学/青海民族大学/青海师范大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (26, '内蒙古自治区', '呼和浩特', '烤全羊/莜面/焖面/', '清真大寺/内蒙古博物院/昭君墓/', '内蒙古工业大学/内蒙古大学/内蒙古农业大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (27, '西藏自治区', '拉萨', '耗牛肉/酥油茶/青稞酒/', '布达拉宫/纳木错/大昭寺/', '西藏大学/西藏藏医学院/西藏农业学院/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (28, '新疆省', '乌鲁木齐', '烤羊肉串/拉条子/丸子汤/', '天山/南山牧场/博格达峰/', '新疆大学/新疆医科大学/新疆财经大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (29, '中国香港特别行政区', '香港', '港式甜品/荔枝甘露/鱼蛋/', '维多利亚港/黄大仙/香港海洋公园/', '香港大学/香港浸会大学/香港中文大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (30, '中国澳门特别行政区', '澳门', '葡式蛋挞/猪扒包/木糠布甸/', '国父纪念馆/大三巴牌坊/澳门旅游塔/', '澳门大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (31, '北京', '北京', '北京烤鸭/老北京刷羊肉/老北京炸酱面/', '北京故宫/颐和园/八达岭长城/', '清华大学/中国人民大学/北京大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (32, '上海', '上海', '南翔小笼/生煎/蟹壳黄/', '外滩/杜莎夫人蜡像馆/老城隍庙/', '上海交通大学/复旦大学/同济大学/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (33, '天津', '天津', '煎饼果子/津味嘎巴菜/狗不理包子/', '鼓楼/五大道/梁启超故居/', '天津大学/南开大学/天津美术学院/');
INSERT INTO `shenghui`(`id`, `shengming`, `huiming`, `meishi`, `jingdian`, `gaoxiao`) VALUES (34, '重庆', '重庆', '酸菜鱼/棒棒鸡/水煮鱼/', '长江三峡/朝天门/解放碑/', '重庆理工大学/重庆大学/西南大学/');
