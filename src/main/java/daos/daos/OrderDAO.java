package daos.daos;

import daos.entities.Orders.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders();
    Order getOrderByCode (int OrderNumber);
boolean addOrder(Order order);
List<Order> getOrdersByUser(int UserID);
}
