package cn.gandan.service.impl;

import cn.gandan.dao.AccountDao;
import cn.gandan.factory.BeanFactory;
import cn.gandan.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;
import java.util.Map;

public class AccountServiceImpl implements AccountService {

    private String name;

    private List<String> strings;

    private Map<String, String> maps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void show() {
        System.out.println(name);
        System.out.println(strings);
        System.out.println(maps);
    }
}
