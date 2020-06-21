package cn.hiboot.mvc.controller;

import cn.hiboot.mvc.bean.MyData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * description about this class
 *
 * @author DingHao
 * @since 2020/6/21 19:18
 */
@Controller
@SessionAttributes("from")
public class RequestParamController {

    @GetMapping("sessionAttributeFrom")
    public String sessionAttributes(Model model){
        MyData myData = new MyData();
        myData.setName("d");
        myData.setAge(30);
        model.addAttribute("from",myData);
        return "defaultView";
    }

    @GetMapping("sessionAttributes")
    public String sessionAttributes(@ModelAttribute("from") MyData myData,@SessionAttribute MyData from, SessionStatus sessionStatus){
        System.out.println(myData);
        sessionStatus.setComplete();
        return "defaultView";
    }

}
