package school.service;

import org.springframework.stereotype.Service;
import school.mapper.OrderMapper;
import school.pojo.Order;
import school.util.PageSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    public int updateStatus(String orderNum, int status) {
        Map map = new HashMap();
        map.put("orderNum",orderNum);
        map.put("status",status);
        return orderMapper.updateStatus(map);
    }

    public PageSupport<Order> buyOrder(Order order,PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("buyId",order.getBuyId());
        List<Order> orderList = orderMapper.buyOrder(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Order order1 : orderList){
            String date = simpleDateFormat.format(order1.getTime());
            order1.setDate(date);
        }
        pageSupport.setList(orderList);
        return pageSupport;
    }
    public int buyCount(Order order) {
        return orderMapper.buyCount(order);
    }

    public PageSupport<Order> sellerOrder(Order order, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("sellerId",order.getSellerId());
        List<Order> orderList = orderMapper.sellerOrder(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Order order1 : orderList){
            String date = simpleDateFormat.format(order1.getTime());
            order1.setDate(date);
        }
        pageSupport.setList(orderList);
        return pageSupport;
    }

    public int sellerCount(Order order) {
        return orderMapper.sellerCount(order);
    }

}
