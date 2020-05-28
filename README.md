# 百度小程序-第三方、工具类

提供百度小程序调用-各类工具

## Demo

demo地址-----https://github.com/Barcke/BaiduAppLetSdk-dmeo

## 使用方式 1
现已将项目部署发布到Maven中央仓库 直接引入即可

      <dependency>
          <groupId>com.barcke.y</groupId>
          <artifactId>baidu-applet-spring-boot-start</artifactId>
          <version>0.0.1</version>
      </dependency>

## 使用方式 2
先将两个模块install到本地项目中后 ----
引入下方依赖即可 ----

  

    <dependency>
          <groupId>com.barcke.y</groupId>
          <artifactId>baidu-applet-spring-boot-start</artifactId>
          <version>0.0.1</version>
      </dependency>

在application.yml中添加对应到配置项:
```yaml
baidu:
  applet:
    enabled: true #是否开启工具类
    info:
      app-key: XXXXXXXXXX  #小程序key
      app-secret: XXXXXXXXXX #小程序密钥
      app-id: XXXXXXXXXX  #小程序appId
      third-part-app-key: XXXXXXXXXX  #第三方key
      third-part-app-secret: XXXXXXXXXX  #第三方密钥
      aes-decrypt-secret-key: XXXXXXXXXX  #申请第三方平台时填写到43为加密密钥
```
### core
```java
	//该类为核心类 从该类中get出各类服务进行对应的工具操作即可
    @Autowired
    private BaiduServiceFactory baiduServiceFactory;

	//工具上下文类  从该类中可获取到存储在localCache中到数据 如:MiniToken(小程序凭证)、AccessToken(第三方凭证)等信息  
    @Autowired
    private BaiduApplicationContext baiduApplicationContext;
```
