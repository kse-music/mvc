package cn.hiboot.mvc.reactive;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * description about this class
 *
 * @author DingHao
 * @since 2020/6/22 23:58
 */
public class MyFunctionalHandler {

    public Mono<ServerResponse> echo(ServerRequest request){
        return ServerResponse.ok().body(request.bodyToMono(String.class),String.class);
    }

    public Mono<ServerResponse> get(ServerRequest request){
        return ServerResponse.ok().body(BodyInserters.fromValue(request.queryParam("key")));
    }

    public Mono<ServerResponse> list(ServerRequest request){
        return ServerResponse.ok().body(BodyInserters.fromValue(request.headers().asHttpHeaders().keySet()));
    }

}
