package controller;

import entity.cart.Cart;

import java.sql.SQLException;

/**
 * This class controls the flow of events when users view the Cart
<<<<<<< HEAD
 *
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
 */
public class ViewCartController extends BaseController {

    /**
     * This method checks the available products in Cart
<<<<<<< HEAD
     *
     * @throws SQLException
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public void checkAvailabilityOfProduct() throws SQLException {
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
<<<<<<< HEAD
     *
     * @return subtotal
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public int getCartSubtotal() {
        int subtotal = Cart.getCart().calSubtotal();
        return subtotal;
    }

}
