package cn.hiboot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * describe about this class
 *
 * @author DingHao
 * @since 2020/6/18 0:08
 */
@Controller
public class MyRequestMapping {

    @GetMapping("/myRequestMapping")
    public String requestMappingGet(String name, Map<String,Object> model){
        model.put("name",name);
        return "defaultView";
    }

    @RequestMapping("/modelModel")
    public String modelModelBinding(Model model){
        model.addAttribute("name","Model 类型的Model");
        return "defaultView";
    }

    @RequestMapping("/modelMapModel")
    public String modelMapModelBinding(ModelMap modelMap){
        modelMap.addAttribute("name","ModelMap 类型的Model");
        modelMap.put("date",new Date());
        return "modelView";
    }

    @RequestMapping("/defaultView")
    public Map<String,Object> defaultView(){
        Map<String,Object> model = new HashMap<>(2);
        model.put("name","自行创建Model");
        return model;
    }

    @RequestMapping("/modelAndViewModel")
    public ModelAndView modelAndViewModelBinding() {
        Map<String,Object> model = new HashMap<>(2);
        model.put("name","ModelAndView类型");
        return new ModelAndView("defaultView",model);
    }

    @RequestMapping(value = "/forwardView",method = RequestMethod.GET)
    public String forwardView(Model model) {
        model.addAttribute("info","转发前属性");
        return "forward:forwardTargetView";
    }

    @RequestMapping(value = "/forwardTargetView",method = RequestMethod.GET)
    public String forwardTargetView(HttpServletRequest request,Model model) {
        Object first = request.getAttribute("info");
        model.addAttribute("first",first);
        model.addAttribute("second","转发后属性");
        return "viewView";
    }

    @RequestMapping(value = "/redirectView",method = RequestMethod.GET)
    public String redirectView(RedirectAttributes model) {
        model.addFlashAttribute("first","重定向前属性");
        return "redirect:redirectTargetView";
    }

    @RequestMapping(value = "/redirectTargetView",method = RequestMethod.GET)
    public String redirectTargetView(Model model) {
        model.addAttribute("second","重定向后属性");
        return "viewView";
    }

    @GetMapping("locale")
    public String locale() {
        return "localeView";
    }

    @GetMapping("theme")
    public String theme() {
        return "themeView";
    }

    @GetMapping("changeTheme")
    public String changeTheme(HttpServletRequest request, HttpServletResponse response) {
        RequestContextUtils.getThemeResolver(request).setThemeName(request,response,"other");
        return "themeView";
    }

}
