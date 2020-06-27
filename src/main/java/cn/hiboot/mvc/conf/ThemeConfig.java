package cn.hiboot.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.theme.SessionThemeResolver;

/**
 * description about this class
 *
 * @author DingHao
 * @since 2020/6/28 6:20
 */
@Configuration(proxyBeanMethods = false)
public class ThemeConfig {

    @Bean
    public ThemeResolver themeResolver(){
        return new SessionThemeResolver();
    }

}
