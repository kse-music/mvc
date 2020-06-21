package cn.hiboot.mvc.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Collections;

/**
 * describe about this class
 *
 * @author DingHao
 * @since 2020/6/17 23:46
 */
@Configuration(proxyBeanMethods = false)
public class HandlerMappingConfig {

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
        return new SimpleUrlHandlerMapping(Collections.singletonMap("simpleUrl",new MyHttpRequestHandler()),Ordered.HIGHEST_PRECEDENCE);
    }

}
