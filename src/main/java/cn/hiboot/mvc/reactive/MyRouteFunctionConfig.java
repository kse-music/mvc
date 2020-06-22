package cn.hiboot.mvc.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * description about this class
 *
 * @author DingHao
 * @since 2020/6/22 23:55
 */
@Configuration
public class MyRouteFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        MyFunctionalHandler handler = new MyFunctionalHandler();

        RouterFunction<ServerResponse> router = RouterFunctions.route(RequestPredicates.POST("/echo"),handler::echo)
                .andRoute(RequestPredicates.GET("/get").and(RequestPredicates.queryParam("key",value -> true)),handler::get)
                .andRoute(RequestPredicates.GET("/list"),handler::list);
        return router;
    }

}
