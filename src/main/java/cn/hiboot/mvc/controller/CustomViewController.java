package cn.hiboot.mvc.controller;

import cn.hiboot.mvc.view.CustomView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

/**
 * describe about this class
 *
 * @author DingHao
 * @since 2020/6/18 1:05
 */
@Controller
public class CustomViewController {

    @RequestMapping("/beanNameView")
    public String beanNameView(Model model){
        model.addAttribute("name","beanNameView");
        return "beanNameViewBean";
    }


    @RequestMapping("/returnView")
    public View returnView(Model model){
        model.addAttribute("name","returnView");
        return new CustomView();
    }

}
