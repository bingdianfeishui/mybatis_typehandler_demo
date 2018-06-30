# Springboot + Mybatis-handler Demo Project

本demo基于springboot快速搭建mybatis运行环境，测试Mybatis中的自定义原生类型(Date类)typeHandler及Enum枚举类型处理器typeHandler。


Mybatis默认提供的枚举处理器为EnumTypeHandler，其将Java枚举值映射为枚举名称字符串；同时也提供另一种处理器EnumOrdinalTypeHandler，其将Java枚举值映射为该枚举类型中的序号(从0开始，比如例子中Gender类，就是采用了Ordinal映射)。而对于自定义带参数的枚举值，Mybatis并未提供对应的TypeHandler，此时就需要我们自定义TypeHandler了。


本Demo提出了对带单个参数、两个参数的枚举类型的映射方式，并采用泛型提高其通用性。

## 项目结构

* mybatis-handler-annotation 基于注解自动配置方式
* mybatis-handler-javaconfig 基于Java代码Config方式
* mybatis-handler-xml 基于传统xml配置方式
* mybatis-handler-common 通用类库

## 效果

```sql
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
```
通过自定义的TypeHandler，我们可以将枚举映射为tinyint, int, char, varchar，将Date日期映射为bigint。
