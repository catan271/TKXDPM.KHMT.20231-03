package entity.invoice;

import entity.order.Order;

public class Invoice {

    private Order order;
    private int amount;

    public Invoice() {

    }

    public Invoice(Order order) {
        this.order = order;
    }
<<<<<<< HEAD


    /**
     * @return Order
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Order getOrder() {
        return order;
    }
    
    public int getAmount() {
        return amount;
    }

<<<<<<< HEAD
    /**
     * @return int
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void saveInvoice() {

=======
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void saveInvoice() {

>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    }
}
