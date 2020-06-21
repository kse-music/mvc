package cn.hiboot.mvc.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * describe about this class
 *
 * @author DingHao
 * @since 2020/5/27 10:20
 */
@Setter
@Getter
@ToString
@XmlRootElement
public class MyData {
    private String name;
    private Integer age;
    private String all;
}
