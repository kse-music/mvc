package cn.hiboot.mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * describe about this class
 *
 * @author DingHao
 * @since 2020/6/17 23:57
 */
@Component("/myController")
public class MyController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String,Object> model = new HashMap<>(2);
        model.put("name","ding hao");

        return new ModelAndView("defaultView",model);
    }
}
