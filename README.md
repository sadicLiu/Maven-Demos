# Maven学习笔记

## Maven安装

- 安装及配置

  1. 下载Maven
  2. 设置环境变量：M2_HOME
  3. 在Path中加入maven的bin目录
  4. 在cmd中，输入mvn –v，出现版本信息则配置成功

- Maven本地仓库

  1. 是什么：Maven本地仓库是用来存放从网络上下载的jar包的地方
  2. Maven本地仓库默认存放在c盘用户目录下的.m2文件夹中
  3. 修改本地仓库位置：<br>
    找到Maven安装目录下的`conf\settings.xml`,在其中加入`<localRepository>/path/to/local/repo</localRepository>`
  4. 为了以后更新maven不用重复配置settings文件，将这个文件拷贝到新添加的目录一份

## Maven文件结构

```
project
    |--src
        |--main                // 存放源文件和资源
            |--java
            |--resources
        |--test                // 存放测试文件
            |--java
            |--resources
    |--target                // class文件、报告等信息存储的地方
    |--pom.xml                // Maven描述文件
```

## Intellij idea中创建Maven项目

- 关于创建Maven Web项目，请参考res目录下第三篇文章
- 关于创建多模块的Maven项目，请参考res目录下第四篇文章

## Maven核心概念

### Maven坐标

- groupId：写组织名称.项目名（如:`com.baidu.hellomaven`）
- artifactId：写项目名（`HelloMaven`）
- version：定义当前项目的当前版本

### Maven依赖管理

- scope取值

依赖范围（Scope） | 对主代码classpath有效 | 对测试代码classpath有效 | 被打包，对于运行时classpath有效 | 例子
----------- | --------------- | ---------------- | -------------------- | --------------------------
compile     | Y               | Y                | Y                    | log4j
test        | -               | Y                | -                    | junit
provided    | Y               | Y                | -                    | servlet-api
runtime     | -               | -                | Y                    | JDBC Driver Implementation

- 排除依赖

```
<exclusions>
    <exclusion>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
    </exclusion>
</exclusions>
```

## Maven继承

- 用途：创建多模块项目，在父工程的pom中管理所有jar包的版本，子模块直接引用即可，不会产生冗余
- 步骤：
  1. 创建父工程，这个工程中不需要写代码，删除src目录即可。父工程的pom文件中，打包方式是pom，即`<packaging>pom</packaging>`
  2. 父工程管理jar包版本的方式：
	```
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>4.12</version>
				<scope>test</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
	```
  3. 这样指定每一个jar包的版本，子工程在引入jar包时，只需指定GA坐标即可：
	```
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
		</dependency>
	</dependencies>
	```
- 当父工程中管理的jar包很多时，如果要更新某个jar包的版本，找起来十分费事，我们可以用`<properties>`标签将版本号统一管理起来
  ```
  <properties>
  	  <!-- 在这里定义Junit版本号-->
	  <junit.version>4.12</junit.version>
  </properties>

  <dependencyManagement>
	  <dependencies>
		  <dependency>
			  <groupId>junit</groupId>
			  <artifactId>junit</artifactId>
			  <!-- 在这里直接引用上面的定义-->
			  <version>${junit.version}</version>
			  <scope>test</scope>
		  </dependency>
	  </dependencies>
  </dependencyManagement>
  ```
