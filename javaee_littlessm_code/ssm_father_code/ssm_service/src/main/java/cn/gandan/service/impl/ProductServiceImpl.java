package cn.gandan.service.impl;

import cn.gandan.dao.ProductDao;
import cn.gandan.domain.Product;
import cn.gandan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public String test() {
        System.out.println("测试中");
        return "测试成功";
    }

    @Override
    public List<Product> findAll() throws Exception {
        System.out.println("查询所有执行了");
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
