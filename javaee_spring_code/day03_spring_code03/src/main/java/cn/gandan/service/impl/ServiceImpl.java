package cn.gandan.service.impl;

import cn.gandan.service.Servicer;
import org.springframework.stereotype.Service;

@Service("serviceImpl")
public class ServiceImpl implements Servicer {

    public void star() {
//            int i = 1/0;
        System.out.println("盛利");
    }

    public void bao(String name) {
        System.out.println("永远爱" + name);
    }
}
