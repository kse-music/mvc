package cn.hiboot.mvc.interceptor;

import cn.hiboot.mvc.bean.MyData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * description about this class
 *
 * @author DingHao
 * @since 2020/6/21 20:43
 */
@ControllerAdvice
@Component
public class MyResponseBodyAdvice implements ResponseBodyAdvice<MyData> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType() == MyData.class;
    }

    @Override
    public MyData beforeBodyWrite(MyData body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        assert body != null;
        body.setAll(body.getName()+body.getAge());
        return body;
    }
}
