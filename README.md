# jiro-rpc-framework

### 开发日志

| 版本号 | 开发日期 | 实现功能 
| ----  | ----  | ---- |
| v1.0 | 2020.9.16 | 实现Socket + 原始Serializable + BIO + 默认JDK代理模式 |
| v2.0 | 2020.10.18 | 实现可注册多个服务 |
| v3.0 | 2020.10.19 | Netty传输和通用序列化接口 |
| v4.0 | 2020.10.20 | Kryo序列化 |
| v5.0 | 2020.10.21 | 基于 Nacos 的服务注册与发现 |


### 开发环境

* JDK：1.8及以上
* IDE：JetBrains IDEA

### jar包环境

```java
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.12</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.7.30</version>
</dependency>
```