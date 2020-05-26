package com.barcke.y.baidu.config;

import com.barcke.y.baidu.component.LocalCache;
import com.barcke.y.baidu.config.properties.BaiduServiceProperties;
import com.barcke.y.baidu.core.BaiduServiceFactory;
import com.barcke.y.baidu.service.BaiduMiniAuthService;
import com.barcke.y.baidu.service.BaiduTemplateService;
import com.barcke.y.baidu.service.BaiduThirdPartAuthService;
import com.barcke.y.baidu.service.impl.BaiduMiniAuthServiceImpl;
import com.barcke.y.baidu.service.impl.BaiduTemplateServiceImpl;
import com.barcke.y.baidu.service.impl.BaiduThirdPartAuthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
  *                  ,;,,;
  *                ,;;'(    社
  *      __      ,;;' ' \   会
  *   /'  '\'~~'~' \ /'\.)  主
  * ,;(      )    /  |.     义
  *,;' \    /-.,,(   ) \    码
  *     ) /       ) / )|    农
  *     ||        ||  \)     
  *     (_\       (_\
  *
  * @ProjectName BaiduAppLetSdk
  * @ClassName BaiduAutoConfigure
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 1:55 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 
  **/
@Configuration
@ConditionalOnClass(BaiduThirdPartAuthService.class)
@EnableConfigurationProperties(BaiduServiceProperties.class)
@Slf4j
public class BaiduAutoConfigure {

    @Autowired
    private BaiduServiceProperties baiduServiceProperties;

    @Bean
    @ConditionalOnMissingBean(BaiduThirdPartAuthService.class)
    @Primary
    public BaiduThirdPartAuthService baiduThirdPartAuthService(){
        return new BaiduThirdPartAuthServiceImpl(baiduServiceProperties.getThirdPartAppKey(),
                baiduServiceProperties.getThirdPartAppSecret(),baiduServiceProperties.getAesDecryptSecretKey()
        );
    }

    @Bean
    @ConditionalOnMissingBean(BaiduMiniAuthService.class)
    @Primary
    public BaiduMiniAuthService baiduMiniAuthService(){
        return new BaiduMiniAuthServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(BaiduServiceFactory.class)
//    @ConditionalOnProperty(prefix = "baidu.applet.info",value = "enabled", havingValue = "true")
    public BaiduServiceFactory baiduServiceFactory(BaiduThirdPartAuthService baiduThirdPartAuthService,
                                                   BaiduMiniAuthService baiduMiniAuthService){
        return new BaiduServiceFactory() {

            @Override
            public BaiduThirdPartAuthService getBaiduAuthService() {
                return baiduThirdPartAuthService;
            }

            @Override
            public BaiduTemplateService getBaiduTemplateService() {
                return new BaiduTemplateServiceImpl();
            }

            @Override
            public BaiduMiniAuthService getBaiduMiniAuthService() {
                return baiduMiniAuthService;
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean(LocalCache.class)
    public LocalCache localCache(){
        return new LocalCache();
    }

}
