package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.invoice.Invoice;
import entity.media.Media;
import entity.order.Order;
import entity.order.OrderMedia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

public class PlaceOrderController extends BaseController {
<<<<<<< HEAD

=======
    // common coupling
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    /**
     * This method checks the avalibility of product when user click PlaceOrder
<<<<<<< HEAD
     * button
     *
     * @throws SQLException
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public void placeOrder() throws SQLException {
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
<<<<<<< HEAD
     *
     * @return Order
     * @throws SQLException
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public Order createOrder() throws SQLException {
        Order order = new Order();
        for (Object object : Cart.getCart().getListMedia()) {
            CartMedia cartMedia = (CartMedia) object;
            OrderMedia orderMedia = new OrderMedia(cartMedia.getMedia(),
                    cartMedia.getQuantity(),
                    cartMedia.getPrice());
            order.getlstOrderMedia().add(orderMedia);
        }
        return order;
    }

    /**
     * This method creates the new Invoice based on order
<<<<<<< HEAD
     *
     * @param order
     * @return Invoice
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public Invoice createInvoice(Order order) {

        order.createOrderEntity();
        return new Invoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
<<<<<<< HEAD
     *
     * @param info
     * @throws InterruptedException
     * @throws IOException
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public void processDeliveryInfo(HashMap info) throws InterruptedException, IOException {
        validateDeliveryInfo(info);
    }

    /**
     * The method validates the info
<<<<<<< HEAD
     *
     * @param info
     * @throws InterruptedException
     * @throws IOException
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException {

    }

<<<<<<< HEAD

    /**
     * @param phoneNumber
     * @return boolean
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10)
            return false;
        if (Character.compare(phoneNumber.charAt(0), '0') != 0)
            return false;
        try {
            Long.parseUnsignedLong(phoneNumber);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

<<<<<<< HEAD

    /**
     * @param name
     * @return boolean
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public boolean validateContainLetterAndNoEmpty(String name) {
        // Check name is not null
        if (name == null)
            return false;
        // Check if contain leter space only
        if (name.trim().length() == 0)
            return false;
        // Check if contain only leter and space
        if (name.matches("^[a-zA-Z ]*$") == false)
            return false;
        return true;
    }


    /**
     * This method calculates the shipping fees of order
<<<<<<< HEAD
     *
     * @param order
     * @return shippingFee
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public int calculateShippingFee(int amount) {
        Random rand = new Random();
        int fees = (int) (((rand.nextFloat() * 10) / 100) * amount);
        return fees;
    }

    /**
     * This method get product available place rush order media
<<<<<<< HEAD
     *
     * @param order
     * @return media
     * @throws SQLException
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public Media getProductAvailablePlaceRush(Order order) throws SQLException {
        Media media = new Media();
        for (OrderMedia pd : order.getlstOrderMedia()) {
            // CartMedia cartMedia = (CartMedia) object;
            if( validateMediaPlaceRushorder()){
                media = pd.getMedia();
            }
        }
        return media;
    }


    /**
     * @param province
     * @param address
     * @return boolean
     */
    public boolean validateAddressPlaceRushOrder(String province, String address) {
        if (!validateContainLetterAndNoEmpty(address))
            return false;
        if (!province.equals("Hà Nội"))
            return false;
        return true;
    }


    /**
     * @return boolean
     */
    public boolean validateMediaPlaceRushorder() {
        if (Media.getIsSupportedPlaceRushOrder())
            return true;
        return false;
    }
}
