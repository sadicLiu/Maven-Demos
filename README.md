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
		|--main				// 存放源文件和资源
		    |--java
		    |--resources
		|--test				// 存放测试文件
		    |--java
		    |--resources
	|--target				// class文件、报告等信息存储的地方
	|--pom.xml				// Maven描述文件
```

## Maven坐标

- groupId：写组织名称.项目名（如:`com.baidu.hellomaven`）
- artifactId：写项目名（`HelloMaven`）
- version：定义当前项目的当前版本

## Intellij idea中创建Maven项目

- 关于创建Maven Web项目，请参考res目录下第三篇文章
- 关于创建多模块的Maven项目，请参考res目录下第四篇文章
