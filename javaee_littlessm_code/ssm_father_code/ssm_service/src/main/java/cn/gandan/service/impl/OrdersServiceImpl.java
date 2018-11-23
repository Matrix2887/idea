package cn.gandan.service.impl;

import cn.gandan.dao.OrdersDao;
import cn.gandan.domain.Orders;
import cn.gandan.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }
}
