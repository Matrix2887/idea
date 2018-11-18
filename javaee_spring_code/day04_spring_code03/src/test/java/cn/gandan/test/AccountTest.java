package cn.gandan.test;

import cn.gandan.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = cn.gandan.config.SpringConfigUtils.class)
public class AccountTest {

    @Autowired
    private  AccountService as;


    @Test
    public void transfer() {

       as.transfer("bbb","ccc",100F);

    }

}
