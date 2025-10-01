package daos.entities;

public class Order {

    private int orderNumber;
    private String orderDate;
    private String orderStatus;
    private int orderAmount;
    private int orderPrice;
    private int orderQuantity;
    private int orderTotal;
    private int orderId;

    public Order() {
    }

    public Order(String orderDate, int orderNumber, String orderStatus, int orderAmount, int orderPrice, int orderQuantity, int orderTotal, int orderId) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
        this.orderTotal = orderTotal;
        this.orderId = orderId;

    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate='" + orderDate + '\'' +
                ", orderNumber=" + orderNumber +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

}
