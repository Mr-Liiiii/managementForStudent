# 留学项目-MySQL工具类文档

[MySQL-Connection](%E7%95%99%E5%AD%A6%E9%A1%B9%E7%9B%AE-MySQL%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%96%87%E6%A1%A3%207668a96fcfe345b7ad6af9d74005e4ec/MySQL-Connection%207adebcf56c664445acbaf6cd39f715c2.md)

Mysql表结构分析

![Untitled](%E7%95%99%E5%AD%A6%E9%A1%B9%E7%9B%AE-MySQL%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%96%87%E6%A1%A3%207668a96fcfe345b7ad6af9d74005e4ec/Untitled.png)

## [USER表](%E7%95%99%E5%AD%A6%E9%A1%B9%E7%9B%AE-MySQL%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%96%87%E6%A1%A3%207668a96fcfe345b7ad6af9d74005e4ec/USER%E8%A1%A8%20e1e36d9d518f41a5b29db725d886ade0.md)

# 1.注册页面

```java
user{ 

	int `id`；

	String `username`

	String `password`

	int `power`

}
```

选择注册的属性 ：**POWER =**

注册的id： **id=**

注册的账号： **username=**

注册的密码 :**password=**

## [Student表](%E7%95%99%E5%AD%A6%E9%A1%B9%E7%9B%AE-MySQL%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%96%87%E6%A1%A3%207668a96fcfe345b7ad6af9d74005e4ec/Student%E8%A1%A8%204236ff8ee58f49889290bea3a0ac471e.md)

## ***mySQL方法：***

## 

## 

## ***3.将student表中的每一行数据都封装成一个对象以集合的形式返回***

```java
getStudentsALL()返回一个student集合

```

[](%E7%95%99%E5%AD%A6%E9%A1%B9%E7%9B%AE-MySQL%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%96%87%E6%A1%A3%207668a96fcfe345b7ad6af9d74005e4ec/Untitled%200c3d76a44a8649619a4d4e1ebc9d051f.md)

[USER表](%E7%95%99%E5%AD%A6%E9%A1%B9%E7%9B%AE-MySQL%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%96%87%E6%A1%A3%207668a96fcfe345b7ad6af9d74005e4ec/USER%E8%A1%A8%20e1e36d9d518f41a5b29db725d886ade0.md)

[Student表](%E7%95%99%E5%AD%A6%E9%A1%B9%E7%9B%AE-MySQL%E5%B7%A5%E5%85%B7%E7%B1%BB%E6%96%87%E6%A1%A3%207668a96fcfe345b7ad6af9d74005e4ec/Student%E8%A1%A8%204236ff8ee58f49889290bea3a0ac471e.md)