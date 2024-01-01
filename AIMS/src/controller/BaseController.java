package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;

import java.util.List;


/**
 * This class is the base controller for our AIMS project.
<<<<<<< HEAD
 *
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
 */
public class BaseController {

    /**
     * The method checks whether the Media in Cart, if it were in, we will return
     * the CartMedia else return null.
<<<<<<< HEAD
     *
     * @param media media object
     * @return CartMedia or null
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public CartMedia checkMediaInCart(Media media) {
        return Cart.getCart().checkMediaInCart(media);
    }

    /**
     * This method gets the list of items in cart.
<<<<<<< HEAD
     *
     * @return List[CartMedia]
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public List getListCartMedia() {
        return Cart.getCart().getListMedia();
    }
}
