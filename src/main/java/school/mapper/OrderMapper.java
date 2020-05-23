package school.mapper;

import school.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    public int addOrder(Order order);
    public int updateStatus(Map map);
    public List<Order> buyOrder(Map map);
    public int buyCount(Order order);
    public int sellerCount(Order order);
    public List<Order> sellerOrder(Map map);
}
