# jiro-rpc-framework

### 项目架构图

![rpc](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9jbi1ndW96aXlhbmcuZ2l0aHViLmlvL015LVJQQy1GcmFtZXdvcmsvaW1nL1JQQyVFNiVBMSU4NiVFNiU5RSVCNiVFNiU4MCU5RCVFOCVCNyVBRi5qcGVn?x-oss-process=image/format,png)

### 开发日志

| 版本号 | 开发日期 | 实现功能 
| ----  | ----  | ---- |
| v1.0.0 | 2020.9.16 | 实现Socket + 原始Serializable + BIO + 默认JDK代理模式 |
| v1.0.1 | 2020.10.18 | 实现可注册多个服务 |
| v1.1.0 | 2020.10.19 | Netty传输和通用序列化接口 |
| v1.2.0 | 2020.10.20 | Kryo序列化 |
| v2.0.0 | 2020.10.21 | 基于 Nacos 的服务注册与发现 |
| v2.1.0 | 2020.10.22 | 实现自动注销服务和负载均衡策略 |
| v2.1.1 | 2020.10.22 | 服务端自动注册服务 |


### 开发环境

* JDK：1.8及以上
* IDE：JetBrains IDEA
