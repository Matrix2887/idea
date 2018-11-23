package cn.gandan.dao;

import cn.gandan.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    @Select("select * from product")
    abstract List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) " +
            "values(#{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    abstract void save(Product product) throws Exception;

    @Select("select * from product where id = #{id}")
    abstract Product findById(String id) throws Exception;

}
