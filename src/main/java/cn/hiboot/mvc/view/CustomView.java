package cn.hiboot.mvc.view;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * describe about this class
 *
 * @author DingHao
 * @since 2020/6/18 1:02
 */
@Component("beanNameViewBean")
public class CustomView implements View {

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object name = model.get("name");
        response.getWriter().append("name is " + name);
    }
}
