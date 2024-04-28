package com.yichen.chenapiclientsdk;

import com.yichen.chenapiclientsdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// 　用@Conﬁguration注释类表明其主要目的是作为bean定义的源
@Configuration
// 可以读取application的配置 把读到的配置加到属性中
@ConfigurationProperties("api.client")
@Data
//扫包用的
@ComponentScan
public class ApiClientConfig {
    private String accessKey;
    private String secretKey;
    // Bean注解用于定义一个产生bean对象的方法 产生一个Bean对象 然后这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
    // SpringIOC 容器管理一个或者多个bean，这些bean都需要在@Configuration注解下进行创建，在一个方法上使用@Bean注解就表明这个方法需要交给Spring进行管理。
    @Bean
    public ApiClient apiClient() {
        // 其中ak和sk是通过读取配置文件来进行初始化的
        ApiClient apiClient = new ApiClient(accessKey, secretKey);
        return apiClient;
    }
}
