package cn.hiboot.mvc.controller;

import cn.hiboot.mvc.bean.MyData;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

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

    @CrossOrigin(origins = "https://www.baidu.com")
    @GetMapping("myCors")
    public String myCors(){
        return "CORS TEST";
    }

    @CrossOrigin(origins = "https://www.baidu.com",allowCredentials = "true",allowedHeaders = {"X-Custom-Header","X-Other-Header"})
    @PutMapping("myComplexCors")
    public String myComplexCors(){
        return "CORS TEST";
    }

    @RequestMapping("myCallableAsync")
    public Callable<String> myCallableAsync(){
        return () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
            return "defaultView";
        };
    }

    @RequestMapping("myDeferredAsync")
    public DeferredResult<String> myDeferredAsync(){
        DeferredResult<String> result = new DeferredResult<>();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.setResult("defaultView");
        }).start();
        return result;
    }


}
