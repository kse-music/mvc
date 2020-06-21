package cn.hiboot.mvc.controller;

import cn.hiboot.mvc.bean.MyData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description about this class
 *
 * @author DingHao
 * @since 2020/6/21 10:33
 */
@Controller
public class ContentTypeController {

    @RequestMapping(path = "myProduces",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MyData returnJsonValue(){
        return getData();
    }

    @RequestMapping(path = "myProduces",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public MyData returnXmlValue(){
        return getData();
    }

    @RequestMapping(path = "myAcceptAll",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MyData acceptAll(){
        return getData();
    }

    public MyData getData(){
        MyData myData = new MyData();
        myData.setName("d");
        myData.setAge(30);
        return myData;
    }

}
