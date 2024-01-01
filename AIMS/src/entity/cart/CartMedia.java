package entity.cart;

import entity.media.Media;

public class CartMedia {
<<<<<<< HEAD

=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    private Media media;
    private int quantity;
    private int price;

    public CartMedia() {

    }

    public CartMedia(Media media, Cart cart, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }


    /**
     * @return Media
     */
    public Media getMedia() {
        return this.media;
    }


    /**
     * @param media
     */
    public void setMedia(Media media) {
        this.media = media;
    }


    /**
     * @return int
     */
    public int getQuantity() {
        return this.quantity;
    }
<<<<<<< HEAD


    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * @return int
     */
=======
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public int getPrice() {
        return this.price;
    }


    /**
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @Override
    public String toString() {
        return "{"
                + " media='" + media + "'"
                + ", quantity='" + quantity + "'"
                + "}";
    }

}
