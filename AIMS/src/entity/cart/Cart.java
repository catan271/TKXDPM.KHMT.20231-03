package entity.cart;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cart {
<<<<<<< HEAD

=======
    // common coupling
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    private static Cart cartInstance;
    private List<CartMedia> lstCartMedia;


    private Cart() {
        lstCartMedia = new ArrayList<>();
    }

<<<<<<< HEAD
    /**
     * @return Cart
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public static Cart getCart() {
        if (cartInstance == null) cartInstance = new Cart();
        return cartInstance;
    }

<<<<<<< HEAD
    /**
     * @param cm
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public void addCartMedia(CartMedia cm) {
        lstCartMedia.add(cm);
    }

<<<<<<< HEAD

    /**
     * @param cm
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public void removeCartMedia(CartMedia cm) {
        lstCartMedia.remove(cm);
    }

<<<<<<< HEAD

    /**
     * @return List
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public List getListMedia() {
        return lstCartMedia;
    }

    public void emptyCart() {
        lstCartMedia.clear();
    }

<<<<<<< HEAD

    /**
     * @return int
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public int getTotalMedia() {
        int total = 0;
        for (Object obj : lstCartMedia) {
            CartMedia cm = (CartMedia) obj;
            total += cm.getQuantity();
        }
        return total;
    }

<<<<<<< HEAD

    /**
     * @return int
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public int calSubtotal() {
        int total = 0;
        for (Object obj : lstCartMedia) {
            CartMedia cm = (CartMedia) obj;
            total += cm.getPrice() * cm.getQuantity();
        }
        return total;
    }

<<<<<<< HEAD

    /**
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException {
=======
    public void checkAvailabilityOfProduct() throws SQLException {
        // control coupling
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
        boolean allAvai = true;
        for (Object object : lstCartMedia) {
            CartMedia cartMedia = (CartMedia) object;
            int requiredQuantity = cartMedia.getQuantity();
            int availQuantity = cartMedia.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvai = false;
        }
        if (!allAvai) throw new MediaNotAvailableException("Some media not available");
    }

<<<<<<< HEAD

    /**
     * @param media
     * @return CartMedia
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public CartMedia checkMediaInCart(Media media) {
        for (CartMedia cartMedia : lstCartMedia) {
            if (cartMedia.getMedia().getId() == media.getId()) return cartMedia;
        }
        return null;
    }

}
