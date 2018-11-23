package cn.gandan.service;

import cn.gandan.domain.Product;

import java.util.List;

public interface ProductService {

    abstract String test();

    abstract List<Product> findAll() throws Exception;

    abstract void save(Product product) throws Exception;

}
