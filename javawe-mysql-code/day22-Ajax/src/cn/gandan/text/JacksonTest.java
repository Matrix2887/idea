package cn.gandan.text;

import cn.gandan.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JacksonTest {

    @Test
    public void test1() throws Exception {
        Person p = new Person("盛利",12,"仙女",new Date());

        ObjectMapper mapper = new ObjectMapper();

        String string = mapper.writeValueAsString(p);

        // 要想展示特定的样式要在javabean中属性上加一个注解@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        System.out.println(string);// {"name":"盛利","age":12,"gender":"仙女","date":1539605230143}
    }



    @Test
    public void test2() throws Exception{
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("盛利",12,"仙女",new Date()));
        people.add(new Person("爆米花",16,"仙女",new Date()));
        people.add(new Person("盛利利",10,"仙女",new Date()));

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(people);
        // list集合封装的结果是一个数组
        // [{"name":"盛利","age":12,"gender":"仙女","date":1539605467521},{...}.{...}]
        System.out.println(string);
    }

    @Test
    public void test3() throws Exception {
        String json = "{\"name\":\"盛利\",\"age\":12,\"gender\":\"仙女\",\"date\":1539605230143}";

        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.readValue(json, Person.class);
        // 转成javabean对象
        // Person{name='盛利', age=12, gender='仙女', date=Mon Oct 15 20:07:10 CST 2018}
        System.out.println(person);
    }


    @Test
    public void test4() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name","盛利利");
        map.put("age",16);
        map.put("gender","仙女");

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(map);
        //{"gender":"仙女","name":"盛利利","age":16}  Map集合封装的样式与对象封装的样式一致
        System.out.println(string);
    }



}
