package school.service;

import school.pojo.Order;
import school.util.PageSupport;


public interface OrderService {
    public int addOrder(Order order);
    public int updateStatus(String orderNum,int status);
    public PageSupport<Order> buyOrder(Order order,PageSupport pageSupport);
    public int buyCount(Order order);
    public PageSupport<Order> sellerOrder(Order order,PageSupport pageSupport);
    public int sellerCount(Order order);
}
