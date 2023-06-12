package com.lyl;

import com.lyl.config.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/12 0012
 */

@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(App.class, args);
    }

}
