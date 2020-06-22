package cn.hiboot.mvc.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * describe about this class
 *
 * @author DingHao
 * @since 2020/6/18 0:23
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/myComplexCors").allowedOrigins("https://www.baidu.com").allowedHeaders("X-Custom-Header","X-Other-Header").allowCredentials(true);
    }
}
