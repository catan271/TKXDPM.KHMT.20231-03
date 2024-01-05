package controller;

import entity.order.Order;
import entity.payment.PaymentTransaction;

import java.sql.SQLException;
import java.util.List;

public class ManageOrderController extends  BaseController {
    public List getAllOrder() throws SQLException {
        return new Order().getAllOrder();
    }

    public Order getOrderById(int id) {
        return new Order().getOrderById(id);
    }

    public int checkPaid(int orderId) throws SQLException {
        return new PaymentTransaction().checkPaymentByOrderId(orderId);
    }

    public void updateOrderStatus(int id, String status) {
        new Order().updateOrderStatus(id, status);
    }
}
