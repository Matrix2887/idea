package cn.gandan.service;

import cn.gandan.domain.Orders;

import java.util.List;

public interface OrdersService {

    abstract List<Orders> findAll(int page, int size) throws Exception;

    abstract Orders findById(String ordersId) throws Exception;

}
