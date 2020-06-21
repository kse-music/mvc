package cn.hiboot.mvc.controller;

import cn.hiboot.mvc.bean.MyData;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * description about this class
 *
 * @author DingHao
 * @since 2020/6/21 19:49
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EnhanceController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @GetMapping("initBinderAdvice")
    public String initBinderAdvice(Date date){
        return date.toString();
    }

    @PostMapping("myDataRequestAdvice")
    public String myDataRequestAdvice(@RequestBody MyData myData){
        return myData.toString();
    }

    @GetMapping("myDataResponseAdvice")
    public MyData myDataResponseAdvice(){
        MyData myData = new MyData();
        myData.setName("d");
        myData.setAge(30);
        return myData;
    }




}
