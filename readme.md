客户端demo: https://github.com/queal/camunda-process.git

1. 安装jdk1.8
2. 安装camunda平台

	2.1 下载地址: https://camunda.com/download/

	2.2 创建mysql数据库, 开发库camunda, 生产库camunda-prod

	2.3 依次执行初始化脚本, 目录camunda-bpm-run-7.17.0\configuration\sql\create下
		mysql_engine_7.17.0.sql
		mysql_identity_7.17.0.sql		

	2.4 修改default.yml数据库信息
		spring.datasource:
		  url: jdbc:mysql://192.168.99.110:3306/camunda?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8
		  driver-class-name: com.mysql.cj.jdbc.Driver
		  username: root
		  password: root4IAMW@2021
		
	2.5 修改product.yml数据库信息
		spring.datasource:
		  url: jdbc:mysql://192.168.99.110:3306/camunda-prod?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8
		  driver-class-name: com.mysql.cj.jdbc.Driver
		  username: root
		  password: root4IAMW@2021
		  		
	2.6 把 mysql-connector-java-8.0.21.jar 放入 camunda-bpm-run-7.17.0\configuration\userlib目录下
	
	2.5 启动 
		开发环境: start.sh / start.bat
			默认用户 demo, demo
		生产环境: start.sh --production
			访问: https://localhost:8443/	
	
	启动后 welcome页面: 
		http://localhost:8080/camunda-welcome/index.html
3. 安装Camunda Modeler
	下载地址: https://camunda.com/download/modeler
